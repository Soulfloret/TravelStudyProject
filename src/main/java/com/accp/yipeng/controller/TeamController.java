package com.accp.yipeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.yipeng.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	TeamService TeamService;
	
	@RequestMapping("/toteam")
	public String toteam(Model model,String uname,String tname) {
		String name1=null;
		String tname1=null;
		if(uname!=null) {
			name1=uname;
		}
		if(tname!=null) {
			tname1=tname;
		}
		model.addAttribute("uname", name1);
		model.addAttribute("tname", tname);
		model.addAttribute("list",TeamService.selectAllTeam(name1, tname1));
		return "team";
	}
	
	public String toTeamDetails(Integer id) {
		return "";
	}
}
