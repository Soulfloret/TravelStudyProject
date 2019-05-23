package com.accp.yipeng.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.staff;
import com.accp.domain.team;
import com.accp.domain.teammember;
import com.accp.domain.users;
import com.accp.renyuxuan.service.teamservice;
import com.accp.yipeng.service.TeamService;
import com.accp.yipeng.service.TeammemberService;
import com.accp.yipeng.service.UsersService;

@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	TeamService TeamService;
	@Autowired
	UserMainOrderService UmoService;
	
	
	@RequestMapping("toteam")
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
	@RequestMapping("toTeamDetails")
	public String toTeamDetails(Integer id,Model model) {
		model.addAttribute("list",UmoService.query(null));
		model.addAttribute("tid",id);
		return "TeamDetails";
	}
	@RequestMapping("toadd")
	public String toadd(Integer id,Integer Mid,Model model) {
		model.addAttribute("Id",id);
		model.addAttribute("Mid",Mid);
		return "TeamAdd";
	}
	@RequestMapping("addteam")
	public String addteam(Integer cid,Integer Mid,users user,String team,HttpSession httpsession) {
		staff staff=(staff)httpsession.getAttribute("staff");
		TeamService.insertTeamUsers(cid, Mid, user,team,staff);
		return "redirect:/team/toteam";
	
	}
	
	@RequestMapping("queryAllteamByuid")
	@ResponseBody
	public List<team> queryAllteamByuid(Integer uid) {
		
		return TeamService.selectBymainiUserId(uid);
	}
	
	
}
