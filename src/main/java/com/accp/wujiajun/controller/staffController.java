package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.positions;
import com.accp.domain.staff;
import com.accp.wujiajun.service.positionsService;
import com.accp.wujiajun.service.staffService;

@Controller
@RequestMapping("/staff")
public class staffController {

	@Autowired
	staffService service;
	
	@Autowired
	positionsService positions;
	
	@RequestMapping("/queryLike")
	public String queryLike(staff sta) {
		List<staff> list=service.queryLike(sta);
		
		return "JJ_customer";
	}
	
	@RequestMapping("/query")
	public String query(staff sta,Model model) {
		List<staff> list=service.query(sta);
		List<positions> lists=positions.selectByExample(null);
		model.addAttribute("list", list);
		model.addAttribute("lists",lists);
		for (positions positions : lists) {
			System.out.println(positions.getPostion());
		}
		return "JJ_customer";
	}
	
	@RequestMapping("/queryById")
	@ResponseBody
	public staff queryById(Integer id,Model model) {
		staff lists=service.queryById(id);
		/*model.addAttribute(lists);*/
		return lists;
	}
}
