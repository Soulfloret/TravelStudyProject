package com.accp.chenyong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.chenyong.service.UserMainOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	UserMainOrderService service;
	@RequestMapping("query")
	public String query(Model mo,Integer id) {
		mo.addAttribute("list",service.query(id));
		return "order";
	}
}
