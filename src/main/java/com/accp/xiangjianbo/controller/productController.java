package com.accp.xiangjianbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.product;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.xiangjianbo.service.productService;
import com.accp.xiangjianbo.service.productprojectService;
import com.accp.xiangjianbo.service.projectService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("xjb_productController")
public class productController {

	@Autowired
	projectService pros;
	
	@Autowired
	productService prod;
	
	@Autowired
	productprojectService prop;
	
	@RequestMapping("query")
	public String query(Model model) {
		List<product> list=prod.queryAll();
		model.addAttribute("list", list);
		return "products";
	}
	
	@RequestMapping("toinsert")
	public String toinsert(Model model,project pro) {
		List<project> list=pros.query();
		System.out.println(JSON.toJSONString(list));
		model.addAttribute("list",list);
		return "add-product";
	}
	
	@RequestMapping("insert")
	public String insert(@RequestBody product pro) {
		int i=prod.insert(pro);
		return "redirect:query";
	}
	
	/*活动查询项目*/
	@RequestMapping("queryByProdId")
	@ResponseBody
	public List<productproject> queryByProdId(Integer productId) {
		System.out.println(productId);
		List<productproject> list=prop.queryByProdId(productId);
		System.out.println(JSON.toJSONString(list));
		return list;
	}
}
