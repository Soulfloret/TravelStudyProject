package com.accp.xiangjianbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.product;
import com.accp.domain.productstaff;
import com.accp.domain.project;
import com.accp.xiangjianbo.service.productService;
import com.accp.xiangjianbo.service.projectService;
import com.accp.xiangjianbo.service.projectStaffService;

@Controller
@RequestMapping("xjb_projectOrderController")
public class projectOrderController {

	@Autowired
	productService prod;
	
	@Autowired
	projectService pros;
	
	@Autowired
	projectStaffService pss;
	
	@RequestMapping("/toProjectOrder")
	public String toProjectOrder() {
		return "order";
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
}
