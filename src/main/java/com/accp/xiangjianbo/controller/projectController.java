package com.accp.xiangjianbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.projecttype;
import com.accp.xiangjianbo.service.areasService;
import com.accp.xiangjianbo.service.projectTypeService;
import com.accp.domain.areas;

@Controller
@RequestMapping("xjb_projectController")
public class projectController {

	@Autowired
	projectTypeService ptype;
	
	@Autowired
	areasService areas;
	
	@RequestMapping("query")
	public String query() {
		return "project";
	}
	
	@RequestMapping("toinsert")
	public String toinsert(Model model,areas area) {
		List<projecttype> list=ptype.query();
		List<areas> alist=areas.selectByExample(area);
		model.addAttribute("list", list);
		return "insert_project";
	}
}
