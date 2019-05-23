package com.accp.yipeng.controller;


import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.discussiongroup;
import com.accp.domain.users;
import com.accp.sunhuihui.service.UserService;
import com.accp.yipeng.service.DiscussiongroupService;
import com.accp.yipeng.service.DiscussiongroupSonService;
import com.accp.yipeng.service.UserTypeService;
import com.accp.yipeng.service.UsersService;

@Controller
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	UsersService Use;
	@Autowired
	UserTypeService UsersType;
	@Autowired
	UserService sunService;
	@Autowired 
	DiscussiongroupService disService;
	@Autowired 
	DiscussiongroupSonService disSonService;
	
	@RequestMapping("tologin")
	public String tologin() {
		return "login-page";
	}
	@RequestMapping("back")
	public String back(HttpSession session) {
		session.removeAttribute("use");
		return "login-page";
	}
	
	@RequestMapping("Applogin")
	@ResponseBody
	public users Applogin(String uname,String upassword,HttpSession session) {
		users use=sunService.queryByName(uname, upassword);
		if(use!=null){
			session.setAttribute("user", use);
			return use;
		}else {
			return null;
		}
	}
	
	@RequestMapping("login")
	public String login(String uname,String upassword,HttpSession session) {
		users use=sunService.queryByName(uname, upassword);
		if(use!=null){
			session.setAttribute("use", use);
			return "redirect:/customer/topagehome";
		}else {
			return "redirect/Login/tologin";
		}
	}
	@RequestMapping("toregister")
	public String toregister(Model model) {
		model.addAttribute("list",UsersType.selectByExample(null));
		return "register";
	}
	@RequestMapping("register")
	public String register(users user,MultipartFile file,String team) {
		int num=Use.addcustomer(user, file, team);
		if(num>0) {
			return "redirect:/Login/tologin";
		}
		return "redirect:/Login/toregister";
	}}
