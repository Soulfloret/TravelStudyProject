package com.accp.sunhuihui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.sunhuihui.service.UserMainOrderService;



@RestController
@Controller
@RequestMapping("usermainordershh")
public class UserMainOrderControllershh {

		@Autowired
		UserMainOrderService service;
}
