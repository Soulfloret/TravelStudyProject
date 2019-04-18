package com.accp.chenyong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	UserMainOrderService service;
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
	
}
