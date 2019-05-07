package com.accp.renyuxuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String roomorder(Model model ,room ro) {
		List<room> list=r.queryByroomData(ro);
		model.addAttribute("list", list);
		model.addAttribute("ro", ro);
		return "hotelOrder";
	}
	
	
	@RequestMapping("/RoomDestineadd")
	public String RoomDestineadd(roomdestine roo,String sfz,Double price,String lx) {
		users us=u.queryByIdCard(sfz);
		Integer uid=us.getId();//鏁版嵁搴撴病鏈�
		roo.setUserid(uid);
		roo.setName1("1");
		rd.insertSelective(roo);//娣诲姞璁板綍
		String lb ="";
		if("1".equals(lx)) {
			//涓汉
			lb="涓汉";
			Usermainorder  usermainorder=umo.queryorderCustomer(uid,lb);
			userorder userorder=uo.selectByuid(usermainorder.getId());
			//娣诲姞鎬昏鍗曚粠琛�
			orderson ordersons=new orderson();
			ordersons.setIid(roo.getId());
			ordersons.setTypeid(3);
			ordersons.setName1(userorder.getId().toString());
			o.insertSelective(ordersons);
		}else{
			//鍥㈤槦
			lb="鍥㈤槦";
			team t=te.selectBymainiUserId(uid);
			Usermainorder  usermainorder=umo.queryorderCustomer(t.getId(),lb);
			List<userorder> list=uo.selectByuidinlist(usermainorder.getId());
			for (userorder userorder : list) {
				//娣诲姞鎬昏鍗曚粠琛�
				orderson ordersons=new orderson();
				ordersons.setIid(roo.getId());
				ordersons.setTypeid(3);
				ordersons.setName1(userorder.getId().toString());
				o.insertSelective(ordersons);
			}
		}
		return "redirect:/room/roomorder";
	}
	
	//鍓嶅彴浣忓涓婚〉
	@RequestMapping("/toqueryqtroom")
	public String toqueryqtroom(Model model ,room ro) {
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
		if(rr.getId()==null) {
			return "璇ユ椂闂存宸茬粡琚璁�";
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
			List<roomdestine> list =rd.selectByrdId(id);
			model.addAttribute("list", list);
			return "dingdan";
		}
		
		
		
		
	
	
}
