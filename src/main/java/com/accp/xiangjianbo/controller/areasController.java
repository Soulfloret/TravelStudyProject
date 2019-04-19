package com.accp.xiangjianbo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.areas;
import com.accp.domain.areasExample;
import com.accp.xiangjianbo.service.areasService;
import com.alibaba.fastjson.JSON;

@Controller

@RequestMapping("/xjb_areasController")
public class areasController {
	
	@Autowired
	
	areasService areas;   
	
	@RequestMapping("/query")
	public String query(Model model,areas area){
		List<areas> list=areas.selectByExample(area);
		model.addAttribute("list", list);
		return "base";
	}
	
	@RequestMapping("/toinsert")
	public String toinsert() {
		return "insert_base";
	}
	
	@RequestMapping("/insert")
	public String insert(areas area) {
		int i=areas.insert(area);
		return "redirect:query";
	}
}
