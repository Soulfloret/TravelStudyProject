package com.accp.chenyong.controller;

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
		return service.query(id).get(0);
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
			if(startTime==null) {
				startTime=new Date();
			}
			if(endTime==null) {
				endTime=new Date();
			}
			return service1.query(list,startTime,endTime);
	}
}
