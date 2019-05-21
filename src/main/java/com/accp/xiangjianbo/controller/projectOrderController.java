package com.accp.xiangjianbo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.OrderSonService;
import com.accp.chenyong.service.ProductAreaService;
import com.accp.chenyong.service.UserMainOrderService;
import com.accp.chenyong.service.UserServicec;
import com.accp.domain.Order_workAndOrderSon;
import com.accp.domain.Usermainorder;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.product;
import com.accp.domain.productarea;
import com.accp.domain.productstaff;
import com.accp.domain.project;
import com.accp.domain.users;
import com.accp.xiangjianbo.service.orderProjecrService;
import com.accp.xiangjianbo.service.productService;
import com.accp.xiangjianbo.service.projectService;
import com.accp.xiangjianbo.service.projectStaffService;
import com.accp.xiangjianbo.service.usersService;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("xjb_projectOrderController")
public class projectOrderController {

	@Autowired
	productService prod;
	
	@Autowired
	projectService pros;
	
	@Autowired
	projectStaffService pss;
	
	@Autowired
	usersService uservice;
	
	@Autowired
	UserMainOrderService umoservice;
	
	@Autowired
	orderProjecrService opservice;
	
	@Autowired
	ProductAreaService orderTimeService;
	
	@Autowired
	OrderSonService cyorderson;
	
	@Autowired
	UserServicec cyuserservice;
	
	@RequestMapping("/toProjectOrder")
	public String toProjectOrder() {
		return "projectOrder";
	}
	
	/*鏂板璁㈠崟鏌ヨ娲诲姩*/
	@RequestMapping("/query_Product")
	@ResponseBody
	public List<product> query_Product(){
		List<product> list=prod.queryAll();
		return list;
	}
	
	/*鏂板璁㈠崟鏌ヨ椤圭洰*/
	@RequestMapping("/query_Project")
	@ResponseBody
	public List<project> query_Project(project pro){
		List<project> list=pros.queryAll(pro);
		return list;
	}
	
	/*鏂板璁㈠崟鏌ヨ瀹夋帓浜哄憳*/
	@RequestMapping("/projectOrder_queryStaff")
	@ResponseBody
	public List<productstaff> projectOrder_queryStaff(){
		List<productstaff> list=pss.projectOrder_queryStaff();
		return list;
	}
	
	/*鏍瑰熀韬唤璇佹煡璇㈡槸鍚︽槸璐熻矗浜�*/
	@RequestMapping("/queryByIdCard")
	@ResponseBody
	public users queryByIdCard(String card) {
		users user=uservice.queryByIdCard(card);
		return user;
	} 
	
	/*鏌ヨ濡傛灉鏄礋璐ｄ汉鍒欐牴鎹礋璐ｄ汉鏌ヨuserMainOrder*/
	@RequestMapping("/queryByFzr")
	@ResponseBody
	public Usermainorder queryByFzr(Usermainorder o) {
		Usermainorder umo=umoservice.QueryCunzai(o);
		return umo;
	}
	
	/*鏂板娲诲姩椤圭洰璁㈠崟*/
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody Order_workAndOrderSon order_work) {
		int i=opservice.insert_Order(order_work);
		return "";
	}
	
	/*鏌ヨ鎺掔彮鏃堕棿*/
	@RequestMapping("query")
	@ResponseBody
	public String query(Integer areaid,Date starttime,Date endtime) {
		productarea p=new productarea();
		p.setAreaid(areaid);
		System.out.println(starttime);
		System.out.println(endtime);
/*		orderTimeService.queryByArearId(p, starttime, endtime);
*/		return "";
	}
	
	/*查询排班*/
	@RequestMapping("queryWork")
	@ResponseBody
	public List<orderson> queryWork(String orderson, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, orderson.class);
		List<orderson> list = mapper.readValue(orderson, jt);
		System.out.println(startTime);
		System.out.println(endTime);
		if (startTime == null) {
			startTime = new Date();
		}
		if (endTime == null) {
			endTime = new Date();
		}
		List<orderson> o = cyorderson.query(list, startTime, endTime);
		return o;
	}
	
	/*根据身份证查询客户*/
	@RequestMapping("queryByCoard")
	@ResponseBody
	public List<users> queryByCoard(String uid,Integer typeId){
		List<users> list=new ArrayList<users>();
		users u=cyuserservice.queryByIdCard(uid);
		if(typeId==1) {
			list.add(u);
		}else {
			list=cyuserservice.selectBymainiUserId(u.getId());
		}
		return list;
	}
	
}
