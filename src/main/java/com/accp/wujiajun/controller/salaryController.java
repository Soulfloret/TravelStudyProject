package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.signin;
import com.accp.domain.staff;
import com.accp.wujiajun.service.impl.staffServiceImpl;

@Controller
@RequestMapping("/salary")
public class salaryController {

	@Autowired
	staffServiceImpl service;
	
	@RequestMapping("/salaryQuery")
	public String salaryQuery(staff sta,Model model) {
		List<staff> list=service.salaryQuery(sta);
		model.addAttribute("list",list);
		return "JJ_salary";
	}
	
	@RequestMapping("/salaryQueryId")
	@ResponseBody
	public List<staff> salaryQueryId(Integer id) {
		List<staff> lists=service.salaryQueryId(id);
		return lists;
	}
	
	@RequestMapping("/signinQuery")
	@ResponseBody
	public List<signin> signinQuery(Integer id){
		List<signin> list1=service.signinQuery(id);
		return list1;
	}
}
