package com.accp.wujiajun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.positions;
import com.accp.domain.staff;
import com.accp.domain.users;
import com.accp.wujiajun.service.positionsService;
import com.accp.wujiajun.service.impl.staffServiceImpl;

@Controller
@RequestMapping("/staff")
public class staffController {

	@Autowired
	staffServiceImpl service;
	
	@Autowired
	positionsService positions;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody staff st) {
		Date date=new Date();
		st.setEntrytime(date);
		st.getUlist().setTypeid(3);
		st.setDepartmentid(0);
		st.setState(0);
		System.out.println(st.getUlist().getIdcardno());
		String account=st.getUlist().getIdcardno().substring(14, st.getUlist().getIdcardno().length());
		st.getUlist().setUname(account+"yx");
		st.getUlist().setUpassword(account+"yx");
		service.insert(st);
		return "JJ_customer";
	}
	
	@RequestMapping("/queryLike")
	public String queryLike(staff sta,Model model) {
		List<staff> list=service.queryLike(sta);
		System.out.println(sta.getPostionid());
		List<positions> lists=positions.selectByExample(null);
		model.addAttribute("list",list);
		model.addAttribute("lists",lists);
		return "JJ_customer";
	}
	
	@RequestMapping("/query")
	public String query(staff sta,Model model) {
		List<staff> list=service.query(sta);
		List<positions> lists=positions.selectByExample(null);
		model.addAttribute("list", list);
		model.addAttribute("lists",lists);
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
