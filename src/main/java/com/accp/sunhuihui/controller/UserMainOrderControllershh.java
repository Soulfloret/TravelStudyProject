package com.accp.sunhuihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Usermainorder;
import com.accp.sunhuihui.service.UserMainOrderService;



@RestController
@Controller
@RequestMapping("usermainordershh")
public class UserMainOrderControllershh {

		@Autowired
		UserMainOrderService service;
		
		@RequestMapping("query")
		public List<Usermainorder> query(Integer id,Integer uid) {
			
			return service.query(id, uid);
		}
}
