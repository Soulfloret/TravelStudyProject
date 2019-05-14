package com.accp.sunhuihui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.actionimages;
import com.accp.domain.team;
import com.accp.domain.users;
import com.accp.sunhuihui.service.UserService;
import com.alibaba.fastjson.JSON;

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
		
		@RequestMapping("queryimg")
		public List<actionimages> query(){
			List<actionimages> list=service.query();
			return list;
		}
		
		@RequestMapping("userByid")
		public users userByid(Integer id) {
			users user=service.userByid(id);
			return user;
		}
		
		@RequestMapping("addCustomer")
		public List<team> addCustomer(@RequestBody MultipartFile file,String idc,HttpServletRequest req) {
			users user=new users();
			user.setIdcardno(idc);
			int i=service.addcustomer(user, file, 2+"");
			if(i>0) {
				team t=service.NewTid();
				List<team> te=service.QueryTidUsers(t.getId());
				return te;
			}
			return null;
		}
		
		@RequestMapping("addCustomer1")
		public List<users>  addCustomer1(@RequestBody users user) {
			int i=service.addcustomer(user, null, 1+"");
			List<users> user1=service.queryIcarno(user.getIdcardno());
			return user1;
		}
}
