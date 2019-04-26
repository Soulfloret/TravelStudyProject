package com.accp.yipeng.controller;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.accp.domain.users;
import com.accp.sunhuihui.service.UserService;
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
	
	@RequestMapping("tologin")
	public String tologin() {
		return "login-page";
	}
	@RequestMapping("back")
	public String back(HttpSession session) {
		session.removeAttribute("use");
		return "login-page";
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
		Use.addcustomer(user, file, team);
		return "redirect:/Login/tologin";
	}}
