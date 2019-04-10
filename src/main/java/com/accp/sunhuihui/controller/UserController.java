package com.accp.sunhuihui.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.users;
import com.accp.sunhuihui.service.UserService;

@Controller
@RestController
@RequestMapping("user")
public class UserController {

		@Autowired
		UserService service;
		
		@RequestMapping("queryByName")
		public users queryByName(String uname,String upassword) {
			 users u=service.queryByName(uname, upassword);
			 return u;
		}
}
