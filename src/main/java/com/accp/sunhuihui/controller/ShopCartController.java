package com.accp.sunhuihui.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Shopcart;
import com.accp.sunhuihui.service.ShopCartService;
import com.alibaba.fastjson.JSON;

@Controller
@RestController
@RequestMapping("shopcartshh")
public class ShopCartController {
		
	@Autowired
	ShopCartService service;
	
	@RequestMapping("insertList")
	public int insertList(Shopcart  shopcart) {
		System.out.println(JSON.toJSONString(shopcart));
		int i=service.insertList(shopcart);
		return i;
	}
	
	@RequestMapping("QueryIidUserid")
	public int QueryIidUserid(Integer iid,Integer typeid,Integer userid) {
		Shopcart s= service.QueryIidUserid(iid,typeid,userid);
		System.out.println(JSON.toJSONString(s));
		s.setName2(Integer.parseInt(s.getName2())+1+"");
		int i=service.updateByPrimaryKeySelective(s);
		return i;
	}
	
	@RequestMapping("deleteIidUserid")
	public  int deleteIidUserid(Integer iid,Integer typeid,Integer userid){
		Shopcart s= service.QueryIidUserid(iid,typeid,userid);
		if(Integer.parseInt(s.getName2())>1) {
			s.setName2(Integer.parseInt(s.getName2())-1+"");
			int i=service.updateByPrimaryKeySelective(s);
			return i;
		}else {
			int i=	service.deleteIidUserid(iid,typeid,userid);
			return i;
		}
	}
	
	@RequestMapping("deleteUserid")
	public int deleteUserid(Integer userid) {
		return service.deleteUserid(userid);
	}
	
	@RequestMapping("queryAll")
	public List<Shopcart> queryAll(Integer userid){
		List<Shopcart> shop=service.queryAll(userid);
		return shop;
	}
}
