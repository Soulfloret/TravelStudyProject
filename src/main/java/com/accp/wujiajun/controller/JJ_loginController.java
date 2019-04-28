package com.accp.wujiajun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.staff;
import com.accp.domain.users;
import com.accp.wujiajun.service.impl.JJ_loginServiceImpl;
import com.accp.wujiajun.service.impl.staffServiceImpl;

@Controller
@RequestMapping("/login")
public class JJ_loginController {

	@Autowired
	JJ_loginServiceImpl service;

	@Autowired
	staffServiceImpl st;

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping("/mode")
	public String mode() {

		return "mode";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/*
	 * 登录
	 */
	@RequestMapping("/loginQuery")
	public String loginQuery(String uname, String upassword, users users, HttpSession session) {
		users user = service.queryByName(uname, upassword);
		if(user!=null) {
			if (user.getTypeid()==3) {
				staff staffid = st.loginByuserid(user.getId());
				session.setAttribute("staff", staffid);
				return "redirect:/login/mode";
			}
		}
		return "redirect:/login/login";			

	}

}
