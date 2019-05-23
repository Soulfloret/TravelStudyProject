package com.accp.renyuxuan.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.orderson;
import com.accp.domain.room;
import com.accp.domain.roomdestine;
import com.accp.domain.users;
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
	
	
	
	//鍘讳綇瀹块〉闈�
	@RequestMapping("/toqueryroom")
	public String toqueryroom(Model model ,room ro) {
		List<room> list =r.queryByroom(ro);
		model.addAttribute("list", list);
		model.addAttribute("ro", ro);
		return "/HotelManager";
	}
	
	//鍘讳綇瀹挎坊鍔犻〉闈�
	@RequestMapping("/toaddroom")
	public String toaddroom(room ro) {
		return "HotelAdd";
	}
	
	//浣忓娣诲姞
	@RequestMapping("/addroom")
	public String addroom(room ro) {
		r.insertSelective(ro);
		im.insertroomimglist(ro);
		return "redirect:/room/toqueryroom";
	}
	
	//鍘讳綇瀹夸慨鏀归〉闈�
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
	
	
	//鏌ヨ鍑哄彲浠ラ璁㈡埧闂�  鍘讳綇瀹垮悗鍙颁笅璁㈠崟椤甸潰
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
	
	//鍓嶅彴浣忓涓婚〉
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
	
	//璇︽儏
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
	
	//鍓嶅彴棰勮鎴块棿
	@RequestMapping("/queryByroomdestineid")
	@ResponseBody
	public String queryByroomdestineid(roomdestine rrr) {
		room rr= r.queryByroomdestineid(rrr);
		if(rr==null) {
			return "该时间段已经被预订";
		}else{
			rrr.setName1("2");
			rrr.setUserid(5);//鏍规嵁session鑾峰彇
			rd.insertSelective(rrr);
			return "棰勮鎴愬姛锛岃鍦�10鍒嗛挓鍐呭幓浠樻锛�";
		}
	}
	
		//浣忓涓婃灦涓嬫灦
		@RequestMapping("/sjxj")
		@ResponseBody
		public String sjxj(String type,Integer id) {
			if("鍙".equals(type)) {
				room rooms=new room();
				rooms.setId(id);
				rooms.setState("2");
				r.updateByPrimaryKeySelective(rooms);
				return "淇敼鎴愬姛锛�";
			}else if("缁翠慨涓�".equals(type)) {
				room rooms=new room();
				rooms.setId(id);
				rooms.setState("1");
				r.updateByPrimaryKeySelective(rooms);
				return "淇敼鎴愬姛锛�";
			}
			return "";
		}
		
		
		//鍓嶅彴涓存椂璁㈠崟椤甸潰
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
