package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.bind;
import com.accp.domain.product;
import com.accp.renyuxuan.service.bindservice;
import com.accp.renyuxuan.service.impl.bindserviceimpl;
import com.accp.xiangjianbo.service.productService;

@Controller
@RequestMapping("/menu")
public class menuController {
	
	@Autowired
	bindserviceimpl b;
	
	@Autowired
	productService pro;
	
	/*@RequestMapping("/menuQuery")
	public String menuQuery(bind bi,Model model) {
		List<bind> list=b.querybind(bi);
		model.addAttribute("list",list);
		model.addAttribute("binds",bi);
		return "JJ_set meal";
	}
	@RequestMapping("/productQuery")
	@ResponseBody
	public List<product> productQuery(){
		List<product> list1=pro.queryAll();
		return list1;
	}*/
	
}
