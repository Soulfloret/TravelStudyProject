package com.accp.chenyong.controller;

import java.util.ArrayList;
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

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	UserMainOrderService service;
	@Autowired
	OrderSonService service1;
	@RequestMapping("query")
	public String query(Model mo) {
		mo.addAttribute("list",service.query(null));
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
	public List<orderson> queryPaiban(){
			List<orderson> list=new ArrayList<orderson>();
			orderson o=new orderson();
			o.setIid(1);
			o.setTypeid(1);
			list.add(o);
			orderson o1=new orderson();
			o1.setTypeid(5);
			o1.setIid(1);
			list.add(o1);
			return service1.query(list);
	}
}
