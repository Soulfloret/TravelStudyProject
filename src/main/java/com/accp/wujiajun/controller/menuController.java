package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.bind;
import com.accp.renyuxuan.service.bindservice;

@Controller
@RequestMapping("/menu")
public class menuController {
	
	@Autowired
	bindservice service;
	
	@RequestMapping("/menuQuery")
	public String menuQuery(bind bi,Model model) {
		List<bind> list=service.querybind(bi);
		model.addAttribute("list",list);
		return "JJ_set meal";
	}
}
