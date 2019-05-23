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
	
	/*鍚庡彴鏌ヨ鎵�鏈�*/
	@RequestMapping("query")
	public String query(Model model) {
		List<product> list=prod.queryAll();
	
		model.addAttribute("list", list);
		return "products";
	}		
	
	@RequestMapping("toinsert")
	public String toinsert(Model model,project pro) {
		List<project> list=pros.query();
		model.addAttribute("list",list);
		return "add-product";
	}
	
	@RequestMapping("insert")
	public String insert(@RequestBody product pro) {
		int i=prod.insert(pro);
		return "redirect:query";
	}
	
	/*娲诲姩鏌ヨ椤圭洰*/
	@RequestMapping("queryByProdId")
	@ResponseBody
	public List<productproject> queryByProdId(Integer productId) {
		
		List<productproject> list=prop.queryByProdId(productId);
		return list;
	}
	
	/*娲诲姩鏌ョ湅璇︽儏*/
	@RequestMapping("look_productxq")
	public String look_productxq(Model model,Integer id) {
		product product=prod.queryByXqById(id);
		model.addAttribute("product", product);
		return "edit-product";
	}
	
	/*前台查询活动推荐*/
	@RequestMapping("Queryshouye")
	public List<product> Queryshouye() {
		List<product> list= prod.QueryQtproductByXq();
		return list;
	}
	
	/*前台查询活动详情*/
	@RequestMapping("QueryQtproductByXq")
	public String QueryQtproductByXq(Model model,Integer id) {
		product product=prod.queryByXqById(id);
		System.out.println(JSON.toJSONString(product));
		model.addAttribute("product", product);
		return "Qt_product_Xq";
	}
	
}
