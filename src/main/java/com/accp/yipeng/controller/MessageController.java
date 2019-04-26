package com.accp.yipeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.config.WebSocketHandler;
import com.accp.yipeng.service.UsersService;

@Controller
@RequestMapping("/msg")
public class MessageController {
	@Autowired
	UsersService useService;
	@Autowired
	WebSocketHandler webso;
	
	@RequestMapping("query")
	public String query(Model model){
		return "index";
	}
	@RequestMapping("sendMsg")
	@ResponseBody
	public String sendMsg(String sendmsg,String [] uid){
		 webso.sendMsg(sendmsg, uid);
		 return "001";
	}
	
}
