package com.accp.chenyong.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.OrderSonService;
import com.accp.chenyong.service.UserMainOrderService;
import com.accp.chenyong.service.UserServicec;
import com.accp.domain.Usermainorder;
import com.accp.domain.interested;
import com.accp.domain.orderson;
import com.accp.domain.staff;
import com.accp.domain.team;
import com.accp.domain.users;
import com.accp.mapper.MealMapper;
import com.accp.mapper.MealixMapper;
import com.accp.renyuxuan.service.bindservice;
import com.accp.renyuxuan.service.menuservice;
import com.accp.renyuxuan.service.roomservice;
import com.accp.sunhuihui.service.UserService;
import com.accp.xiangjianbo.service.productService;
import com.accp.xiangjianbo.service.projectService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	UserMainOrderService service;
	@Autowired
	OrderSonService service1;
	@Autowired
	productService service2;
	@Autowired
	projectService service3;
	@Autowired
	menuservice service4;
	@Autowired
	roomservice service5;
	@Autowired
	UserServicec service6;
	@Autowired
	bindservice service7;
	@Autowired
	MealMapper mapper;
	@Autowired
	UserService shhservice;
	
	@RequestMapping("query")
	public String query(Model mo) {
		mo.addAttribute("list",service.query(null));
		mo.addAttribute("productlist",service2.queryAll());
		mo.addAttribute("projectlist",service3.queryAll(null));
		mo.addAttribute("goodlist",service4.QueryMenu(null));
		mo.addAttribute("hotellist",service5.queryByroom(null));
		mo.addAttribute("bindlist",service7.querybind(null));
		mo.addAttribute("meallist",mapper.selectByExample(null));
		return "order";
	}
	@RequestMapping("queryById")
	@ResponseBody
	public Usermainorder queryById(Integer id) {
		Usermainorder u=new Usermainorder();
		u.setId(id);
		return service.query(u).get(0);
	}
	@ResponseBody
	@RequestMapping("insertOrder")
	public int insertOrder(@RequestBody Usermainorder order,HttpServletRequest req) {
		if(order.getList().size()>1) {
			order.setName2("团队");
			team t=shhservice.queryshh(order.getList().get(0).getId());
			order.setOrdercustomer(t.getId());
			
		}else {
			order.setName2("个人");
			order.setOrdercustomer(order.getList().get(0).getId());
		}
//		staff f=(staff)req.getSession().getAttribute("staff");
		order.setOrderuser(2);
		Usermainorder order1=service.QueryCunzaiInsert(order);
		if(order.getList().size()==1) {
				order1.getUser().getOrders().get(0).setList(order.getOlist());
				for (orderson os : order1.getUser().getOrders().get(0).getList()) {
					os.setIx(os.getOw());
				}
		}else {
			for (users u : order.getList()) {
				for (users u1 : order1.getList()) {
					if(u.getId()==u1.getId()) {
						u1.getOrders().get(0).setList(order.getOlist());
						for (orderson os : u1.getOrders().get(0).getList()) {
							os.setIx(os.getOw());
						}
					}
				}
			}
		}
		service.insert(order1);
		return 1;
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping("queryIdcard")
	public List<users> queryIdcar(String uid,Integer typeId,HttpServletRequest req){
		staff s=(staff)req.getSession().getAttribute("staff");
		List<users> list=new ArrayList<users>();
		users u=service6.queryByIdCard(uid);
		if(typeId==1) {
			u.setMuid(u.getId());
			list.add(u);
		}else {
			list=service6.selectBymainiUserId(u.getId(),s.getId());
		}
		return list;
	}
	
	public static Date getNextDay(Date date,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +day);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }
}
