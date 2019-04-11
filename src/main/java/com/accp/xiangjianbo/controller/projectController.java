package com.accp.xiangjianbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.projecttype;
import com.accp.xiangjianbo.service.areasService;
import com.accp.xiangjianbo.service.projectService;
import com.accp.xiangjianbo.service.projectTypeService;
import com.alibaba.fastjson.JSON;
import com.accp.domain.areas;
import com.accp.domain.project;

@Controller
@RequestMapping("xjb_projectController")
public class projectController {

	@Autowired
	projectTypeService ptype;
	
	@Autowired
	areasService areas;
	
	@Autowired
	projectService pros;
	
	@RequestMapping("query")
	public String query(Model model,project pro) {
		List<project> list=pros.queryAll(pro);
		System.out.println(JSON.toJSONString(list));
		model.addAttribute("list", list);
		return "project";
	}
	
	@RequestMapping("toinsert")
	public String toinsert(Model model,areas area) {
		List<projecttype> typelist=ptype.query();
		List<areas> alist=areas.selectByExample(area);
		model.addAttribute("typelist", typelist);
		model.addAttribute("alist", alist);
		return "insert_project";
	}
	
	@RequestMapping("toproject_xq")
	public String toproject_xq() {
		return "edit-project";
	}
}
