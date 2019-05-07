package com.accp.xiangjianbo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.ProductAreaService;
import com.accp.chenyong.service.UserMainOrderService;
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
	
	@RequestMapping("/toProjectOrder")
	public String toProjectOrder() {
		return "projectOrder";
	}
	
	/*新增订单查询活动*/
	@RequestMapping("/query_Product")
	@ResponseBody
	public List<product> query_Product(){
		List<product> list=prod.queryAll();
		return list;
	}
	
	/*新增订单查询项目*/
	@RequestMapping("/query_Project")
	@ResponseBody
	public List<project> query_Project(project pro){
		List<project> list=pros.queryAll(pro);
		return list;
	}
	
	/*新增订单查询安排人员*/
	@RequestMapping("/projectOrder_queryStaff")
	@ResponseBody
	public List<productstaff> projectOrder_queryStaff(){
		List<productstaff> list=pss.projectOrder_queryStaff();
		return list;
	}
	
	/*根基身份证查询是否是负责人*/
	@RequestMapping("/queryByIdCard")
	@ResponseBody
	public users queryByIdCard(String card) {
		users user=uservice.queryByIdCard(card);
		return user;
	} 
	
	/*查询如果是负责人则根据负责人查询userMainOrder*/
	@RequestMapping("/queryByFzr")
	@ResponseBody
	public Usermainorder queryByFzr(Usermainorder o) {
		Usermainorder umo=umoservice.QueryCunzai(o);
		return umo;
	}
	
	/*新增活动项目订单*/
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody Order_workAndOrderSon order_work) {
		
		/*System.out.println(JSON.toJSONString(orders));
		System.out.println(JSON.toJSONString(ok));*/
		int i=opservice.insert_Order(order_work);
		return "";
	}
	
	/*查询排班时间*/
	@RequestMapping("query")
	@ResponseBody
	public String query(Integer areaid,Date starttime,Date endtime) {
		productarea p=new productarea();
		p.setAreaid(areaid);
		System.out.println(starttime);
		System.out.println(endtime);
		orderTimeService.queryByArearId(p, starttime, endtime);
		
		return "";
	}
	
	
	
	
}
