package com.accp.renyuxuan.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.images;
import com.accp.domain.menu;
import com.accp.domain.orderson;
import com.accp.domain.room;
import com.accp.domain.roomdestine;
import com.accp.domain.users;
import com.accp.domain.roomorder;
import com.accp.domain.roomorderson;
import com.accp.domain.team;
import com.accp.domain.userorder;
import com.accp.renyuxuan.service.impl.Usermainorderserviceimpl;
import com.accp.renyuxuan.service.impl.imagesserviceimpl;
import com.accp.renyuxuan.service.impl.ordersonserviceimpl;
import com.accp.renyuxuan.service.impl.roomdestineserviceimpl;
import com.accp.renyuxuan.service.impl.roomorderserviceimpl;
import com.accp.renyuxuan.service.impl.roomordersonserviceimpl;
import com.accp.renyuxuan.service.impl.roomserviceimpl;
import com.accp.renyuxuan.service.impl.teamserviceimpl;
import com.accp.renyuxuan.service.impl.userorderserviceimpl;
import com.accp.renyuxuan.service.impl.usersserviceimpl;
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
	@Autowired
	imagesserviceimpl im;
	@Autowired
	usersserviceimpl ru;
	@Autowired
	UserMainOrderService cyu;
	
	
	
	//去住宿页面
	@RequestMapping("/toqueryroom")
	public String toqueryroom(Model model ,room ro) {
		List<room> list =r.queryByroom(ro);
		model.addAttribute("list", list);
		model.addAttribute("ro", ro);
		return "/HotelManager";
	}
	
	//去住宿添加页面
	@RequestMapping("/toaddroom")
	public String toaddroom(room ro) {
		return "HotelAdd";
	}
	
	//住宿添加
	@RequestMapping("/addroom")
	public String addroom(room ro) {
		r.insertSelective(ro);
		im.insertroomimglist(ro);
		return "redirect:/room/toqueryroom";
	}
	
	//去住宿修改页面
	@RequestMapping("/toupdateroom")
	public String toupdateroom(Model model,room ro) {
		model.addAttribute("list", r.queryByroom(ro));
		model.addAttribute("mlist",im.queryimg(ro.getId(), 3));
		return "HotelUpdate";
	}
	
	
	@RequestMapping("/updateroom")
	public String updateroom(room ro) {
		r.updateByPrimaryKeySelective(ro);
		im.delByiidAndTypeId(ro.getId(), 3);
		im.insertroomimglist(ro);
		return "redirect:/room/toqueryroom";
	}
	
	
	//查询出可以预订房间  去住宿后台下订单页面
	@RequestMapping("/roomorder")
	public String roomorder(Model model ,room ro,HttpSession session) {
		ro.setState("1");
		List<room> list=r.queryByroomData(ro);
		model.addAttribute("list", list);
		model.addAttribute("ro", ro);
		return "hotelOrder";
	}
	
	
	@RequestMapping("/RoomDestineadd")
	public String RoomDestineadd(roomdestine roo,String sfz,Double price,String lx,HttpSession session) {
		users us=u.queryByIdCard(sfz);
		if(us==null) {
			return "redirect:/customer/toadd";
		}
		users xus= (users) session.getAttribute("staff");
		int xusid=2;
		if(xus!=null) {
			xusid=xus.getId();
		}
		Integer uid=us.getId();//数据库没有
		roo.setUserid(uid);
		roo.setName1("1");
		rd.insertSelective(roo);//添加记录
		if("1".equals(lx)) {
			Usermainorder usermainorders=new Usermainorder();
			usermainorders.setOrdercustomer(uid);
			usermainorders.setOrderuser(xusid);
			usermainorders.setName2("个人");
			Usermainorder Usermainorders =cyu.QueryCunzaiInsert(usermainorders);
			userorder userorder=Usermainorders.getUser().getOrders().get(0);
			//添加总订单从表
			orderson ordersons=new orderson();
			ordersons.setIid(roo.getId());
			ordersons.setTypeid(3);
			ordersons.setName1(userorder.getId().toString());
			o.insertSelective(ordersons);
		}else {
			if(us.getTypeid()!=2) {
				Usermainorder usermainorders=new Usermainorder();
				usermainorders.setOrdercustomer(uid);
				usermainorders.setOrderuser(xusid);
				usermainorders.setName2("个人");
				Usermainorder Usermainorders =cyu.QueryCunzaiInsert(usermainorders);
				userorder userorder=Usermainorders.getUser().getOrders().get(0);
				//添加总订单从表
				orderson ordersons=new orderson();
				ordersons.setIid(roo.getId());
				ordersons.setTypeid(3);
				ordersons.setName1(userorder.getId().toString());
				o.insertSelective(ordersons);
			}else {
				//团队
					team t= te.selectBymainiUserId(uid);
					Usermainorder usermainorders=new Usermainorder();
					usermainorders.setOrdercustomer(t.getId());
					usermainorders.setOrderuser(xus.getId());
					usermainorders.setName2("团队");
					Usermainorder  usermainorderser=cyu.QueryCunzaiInsert(usermainorders);
					for (users u :usermainorderser.getList()) {
						for (userorder userorder : u.getOrders()) {
							//添加总订单从表
							orderson ordersons=new orderson();
							ordersons.setIid(roo.getId());
							ordersons.setTypeid(3);
							ordersons.setName1(userorder.getId().toString());
							o.insertSelective(ordersons);
						}
					}
								
			}
		}
		
		return "redirect:/room/roomorder";
	}
	
	//前台住宿主页
	@RequestMapping("/toqueryqtroom")
	public String toqueryqtroom(Model model ,room ro) {
		ro.setState("1");
		List<room> list=r.queryByroomData(ro);
		List<orderson> olist=o.queryroomtj(null);
		List<room> rlist=r.queryByroomtypeid();
		model.addAttribute("rlist", rlist);
		model.addAttribute("olist", olist);
		model.addAttribute("list", list);
		model.addAttribute("ro", ro);
		return "index1";
	}
	
	//详情
	@RequestMapping("/toqueryqtroomByid")
	public String toqueryqtroomByid(Model model,Integer id) {
		List<orderson> olist=o.queryroomtj(null);
		model.addAttribute("olist", olist);
		room rooms=r.queryByroomid(id);
		model.addAttribute("room", rooms);
		List<roomdestine> dlist=rd.selectByroomid(id);
		model.addAttribute("dlist", dlist);
		return "detail";
	}
	
	@RequestMapping("/AjaxQuerydid")
	@ResponseBody
	public String AjaxQuerydid(Integer id) {
		List<roomdestine> list= rd.selectByroomid(id);		
		return JSON.toJSONString(list);
	}
	
	//前台预订房间
	@RequestMapping("/queryByroomdestineid")
	@ResponseBody
	public String queryByroomdestineid(roomdestine rrr) {
		room rr= r.queryByroomdestineid(rrr);
		if(rr==null) {
			return "该时间段已经被预订";
		}else{
			rrr.setName1("2");
			rrr.setUserid(5);//根据session获取
			rd.insertSelective(rrr);
			return "预订成功，请在10分钟内去付款！";
		}
	}
	
		//住宿上架下架
		@RequestMapping("/sjxj")
		@ResponseBody
		public String sjxj(String type,Integer id) {
			if("可租".equals(type)) {
				room rooms=new room();
				rooms.setId(id);
				rooms.setState("2");
				r.updateByPrimaryKeySelective(rooms);
				return "修改成功！";
			}else if("维修中".equals(type)) {
				room rooms=new room();
				rooms.setId(id);
				rooms.setState("1");
				r.updateByPrimaryKeySelective(rooms);
				return "修改成功！";
			}
			return "";
		}
		
		
		//前台临时订单页面
		@RequestMapping("/querydingdan")
		public String querydingdan(HttpSession session,Model model) {
			//users us=(users) session.getAttribute("use");
			int id=5;
			List<roomdestine> list =rd.selectByrdId(id ,new Date());
			model.addAttribute("list", list);
			return "dingdan";
		}
		
		//临时订单删除
		@RequestMapping("/deletedingdan")
		public String deletedingdan(Integer id) {
			rd.deleteByPrimaryKey(id);
			return "redirect:/room/querydingdan";
		}
		
		@RequestMapping("/roomaddorder")
		public String roomaddorder(Integer [] id,Integer [] rid,String lx) {
			//users us=(users) session.getAttribute("use");
			int uid=1;//session里面的用户id
			for (int i = 0; i < rid.length; i++) {
				roomdestine roomdestines=new roomdestine();
				roomdestines.setId(rid[i]);
				roomdestines.setName1("1");
				rd.updateByPrimaryKeySelective(roomdestines);//修改预订记录表状态
				if("1".equals(lx)) {
					Usermainorder usermainorders=new Usermainorder();
					usermainorders.setOrdercustomer(uid);
					usermainorders.setOrderuser(2);
					usermainorders.setName2("个人");
					Usermainorder Usermainorders =cyu.QueryCunzaiInsert(usermainorders);
					userorder userorder=Usermainorders.getUser().getOrders().get(0);
					orderson ordersons=new orderson();
					ordersons.setIid(id[i]);
					ordersons.setTypeid(3);
					ordersons.setName1(userorder.getId().toString());
					o.insertSelective(ordersons);
				}else {
					team t= te.selectBymainiUserId(uid);
					Usermainorder usermainorders=new Usermainorder();
					usermainorders.setOrdercustomer(t.getId());
					usermainorders.setOrderuser(2);
					usermainorders.setName2("团队");
					Usermainorder  usermainorderser=cyu.QueryCunzaiInsert(usermainorders);
					for (users u :usermainorderser.getList()) {
						for (userorder userorder : u.getOrders()) {
							//添加总订单从表
							orderson ordersons=new orderson();
							ordersons.setIid(id[i]);
							ordersons.setTypeid(3);
							ordersons.setName1(userorder.getId().toString());
							o.insertSelective(ordersons);
						}
					}
					
				}
			}
			return "redirect:/room/querydingdan";
		}
		
		
		
		
	
	
}
