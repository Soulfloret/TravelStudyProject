package com.accp.renyuxuan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.Usermainorder;
import com.accp.domain.orderson;
import com.accp.domain.room;
import com.accp.domain.roomdestine;
import com.accp.domain.users;
import com.accp.domain.roomorder;
import com.accp.domain.roomorderson;
import com.accp.domain.team;
import com.accp.domain.userorder;
import com.accp.renyuxuan.service.impl.Usermainorderserviceimpl;
import com.accp.renyuxuan.service.impl.ordersonserviceimpl;
import com.accp.renyuxuan.service.impl.roomdestineserviceimpl;
import com.accp.renyuxuan.service.impl.roomorderserviceimpl;
import com.accp.renyuxuan.service.impl.roomordersonserviceimpl;
import com.accp.renyuxuan.service.impl.roomserviceimpl;
import com.accp.renyuxuan.service.impl.teamserviceimpl;
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
	@Autowired
	Usermainorderserviceimpl umo;
	@Autowired
	teamserviceimpl te;
	
	
	
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
	public String RoomDestineadd(roomdestine roo,String sfz,Double price,String lx) {
		users us=u.queryByIdCard(sfz);
		Integer uid=us.getId();//数据库没有
		roo.setUserid(uid);
		roo.setName1("1");
		rd.insertSelective(roo);//添加记录
		String lb ="";
		if("1".equals(lx)) {
			//个人
			lb="个人";
			Usermainorder  usermainorder=umo.queryorderCustomer(uid,lb);
			userorder userorder=uo.selectByuid(usermainorder.getId());
			//添加总订单从表
			orderson ordersons=new orderson();
			ordersons.setIid(roo.getId());
			ordersons.setTypeid(3);
			ordersons.setName1(userorder.getId().toString());
			o.insertSelective(ordersons);
		}else{
			//团队
			lb="团队";
			team t=te.selectBymainiUserId(uid);
			Usermainorder  usermainorder=umo.queryorderCustomer(t.getId(),lb);
			List<userorder> list=uo.selectByuidinlist(usermainorder.getId());
			for (userorder userorder : list) {
				//添加总订单从表
				orderson ordersons=new orderson();
				ordersons.setIid(roo.getId());
				ordersons.setTypeid(3);
				ordersons.setName1(userorder.getId().toString());
				o.insertSelective(ordersons);
			}
		}
		
		
		return "redirect:/room/roomorder";
	}
	
	@RequestMapping("/toqueryqtroom")
	public String toqueryqtroom() {
		
		return "index1";
	}
	
	
	
}
