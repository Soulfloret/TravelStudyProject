package com.accp.renyuxuan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.orderson;
import com.accp.domain.room;
import com.accp.domain.roomdestine;
import com.accp.domain.users;
import com.accp.domain.roomorder;
import com.accp.domain.roomorderson;
import com.accp.domain.userorder;
import com.accp.renyuxuan.service.impl.ordersonserviceimpl;
import com.accp.renyuxuan.service.impl.roomdestineserviceimpl;
import com.accp.renyuxuan.service.impl.roomorderserviceimpl;
import com.accp.renyuxuan.service.impl.roomordersonserviceimpl;
import com.accp.renyuxuan.service.impl.roomserviceimpl;
import com.accp.renyuxuan.service.impl.userorderserviceimpl;
import com.accp.yipeng.service.UsersService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("room")
public class roomcontroller {
	
	@Autowired
	roomserviceimpl r;
	@Autowired
	roomdestineserviceimpl rd;
	@Autowired
	roomorderserviceimpl ro;
	@Autowired
	roomordersonserviceimpl rs;
	@Autowired
	UsersService u;
	@Autowired
	ordersonserviceimpl o;
	@Autowired
	userorderserviceimpl uo;
	
	
	//去住宿页面
	@RequestMapping("/toqueryroom")
	public String toqueryroom(Model model ,room ro) {
		List<room> list =r.queryByroom(ro);
		model.addAttribute("list", list);
		model.addAttribute("typeid", ro.getTypeid());
		return "/HotelManager";
	}
	
	//去住宿添加页面
	@RequestMapping("/toaddroom")
	public String toaddroom(room ro) {
		return "HotelAdd";
	}
	
	@RequestMapping("/addroom")
	public String addroom(room ro) {
		r.insertSelective(ro);
		return "redirect:/room/toqueryroom";
	}
	
	//去住宿修改页面
	@RequestMapping("/toupdateroom")
	public String toupdateroom(Model model,room ro) {
		model.addAttribute("list", r.queryByroom(ro));
		return "HotelUpdate";
	}
	
	
	@RequestMapping("/updateroom")
	public String updateroom(room ro) {
		r.updateByPrimaryKeySelective(ro);
		return "redirect:/room/toqueryroom";
	}
	
	
	//查询出可以预订房间  去住宿后台下订单页面
	@RequestMapping("/roomorder")
	public String roomorder(Model model ,roomdestine ro) {
		List<room> list=r.queryByroomData(ro.getBegintime(),ro.getEndtime());
		model.addAttribute("list", list);
		model.addAttribute("ro", ro);
		return "hotelOrder";
	}
	
	
	@RequestMapping("/RoomDestineadd")
	public String RoomDestineadd(roomdestine roo,String sfz,Double price) {
		users us=u.queryByIdCard(sfz);
		Integer uid=us.getId();//数据库没有
		roo.setUserid(uid);
		rd.insertSelective(roo);//添加记录
		/*roomorder roomorders=new roomorder();//创建一个房间订单表对象
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");  
		String datetime = tempDate.format(new Date());
		datetime=datetime+"zs";//订单编号
		roomorders.setOrdernumber(datetime);
		roomorders.setState("1");
		roomorders.setPrice(price);
		roomorders.setUserid(uid);*/
		//ro.insertSelective(roomorders);//添加订单
		//roomorderson roomordersons=new roomorderson();//创建一个房间订单从表对象
		//roomordersons.setDestineid(roo.getId());
		//roomordersons.setRoomorderid(roomorders.getId());
		//rs.insertSelective(roomordersons);//添加订单从表
		//添加总订单从表
		orderson ordersons=new orderson();
		ordersons.setIid(roo.getId());
		ordersons.setTypeid(3);
		userorder userorders =uo.selectByuid(us.getId());
		ordersons.setName1(userorders.getOrdermainid().toString());
		o.insertSelective(ordersons);
		return "redirect:/room/roomorder";
	}
	
}
