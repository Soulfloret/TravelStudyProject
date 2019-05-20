package com.accp.chenyong.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.OrderSonService;
import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.orderson;
import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.renyuxuan.service.menuservice;
import com.accp.renyuxuan.service.roomservice;
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
	@RequestMapping("query")
	public String query(Model mo) {
		mo.addAttribute("list",service.query(null));
		mo.addAttribute("productlist",service2.queryAll());
		mo.addAttribute("projectlist",service3.queryAll(null));
		mo.addAttribute("goodlist",service4.QueryMenu(null));
		mo.addAttribute("hotellist",service5.queryByroom(null));
		return "order";
	}
	@RequestMapping("queryById")
	@ResponseBody
	public Usermainorder queryById(Integer id) {
		Usermainorder u=new Usermainorder();
		u.setId(id);
		return service.query(u).get(0);
	}
	@RequestMapping("godaychart")
	public String daychart(Model mo) {
		return "dayChart";
	}
	@RequestMapping("goweekendchart")
	public String weekendchart(Model mo) {
		return "weekendChart";
	}
	@RequestMapping("gomonthchart")
	public String monthchart(Model mo) {
		return "monthChart";
	}
	@ResponseBody
	@RequestMapping("queryPaiban")
	public List<orderson> queryPaiban(@RequestBody List<orderson> list,Date startTime,Date endTime){
		SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
			if(startTime==null) {
				startTime=new Date();
			}
			if(endTime==null) {
				endTime=new Date();
			}
			return service1.query(list,startTime,endTime);
	}
	@RequestMapping("insertOrder")
	public String insertOrder(Usermainorder order) {
		Usermainorder order1=service.QueryCunzaiInsert(order);
		if(order.getUser()!=null) {
				order1.getUser().getOrders().get(0).setList(order.getUser().getOrders().get(0).getList());;
		}else {
			for (users u : order.getList()) {
				for (users u1 : order1.getList()) {
					if(u.getId()==u1.getId()) {
						u1.getOrders().get(0).setList(u.getOrders().get(0).getList());
					}
				}
			}
		}
		return "";
	}
}
