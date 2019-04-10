package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.staff;
import com.accp.wujiajun.service.staffService;

@Controller
@RequestMapping("/staff")
public class staffController {

	@Autowired
	staffService service;
	
	@RequestMapping("/query")
	public String query(staff sta,Model model) {
		List<staff> list=service.query(sta);
		System.out.println(list);
		for (staff staff : list) {
			System.out.println(staff.getUlist().getUname());
		}
		model.addAttribute("list", list);
		return "JJ_customer";
	}
	
	@RequestMapping("/queryById")
	public String queryById(Integer id,Model model) {
		staff lists=service.queryById(id);
		model.addAttribute(lists);
		return "JJ_customer";
	}
}
