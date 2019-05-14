package com.accp.sunhuihui.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Shopcart;
import com.accp.domain.orderson;
import com.accp.renyuxuan.service.ordersonservice;
import com.accp.sunhuihui.service.OrderSonServiceshh;
import com.accp.sunhuihui.service.ShopCartService;
import com.alibaba.fastjson.JSON;

@Controller
@RestController
@RequestMapping("shopcartshh")
public class ShopCartController {
		
	@Autowired
	ShopCartService service;
	@Autowired
	OrderSonServiceshh oservice;
	
	@RequestMapping("insertList")
	public int insertList(Shopcart  shopcart) {
		System.out.println(JSON.toJSONString(shopcart));
		int i=service.insertList(shopcart);
		return i;
	}
	
	@RequestMapping("QueryIidUserid")
	public int QueryIidUserid(Integer iid,Integer typeid,Integer userid) {
		Shopcart s= service.QueryIidUserid(iid,typeid,userid);
		double dj=Double.parseDouble(s.getName1())/Integer.parseInt(s.getName2());
		s.setName1(dj*(Integer.parseInt(s.getName2())+1)+"");
		s.setName2(Integer.parseInt(s.getName2())+1+"");
		int i=service.updateByPrimaryKeySelective(s);
		return 0;
	}
	
	@RequestMapping("deleteIidUserid")
	public  int deleteIidUserid(Integer iid,Integer typeid,Integer userid){
		Shopcart s= service.QueryIidUserid(iid,typeid,userid);
		if(Integer.parseInt(s.getName2())>1) {
			double dj=Double.parseDouble(s.getName1())/Integer.parseInt(s.getName2());
			s.setName1(dj*(Integer.parseInt(s.getName2())-1)+"");
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
	
	@RequestMapping("pdqueryShopCart")
	public List<Shopcart> pdqueryShopCart(@RequestBody  Shopcart shopcart){
		List<Shopcart> list=new ArrayList<Shopcart>();
			for (int i = 0; i < shopcart.getShop().size(); i++) {
					Shopcart s=service.QueryIidUserid(shopcart.getShop().get(i).getIid(), 
							shopcart.getShop().get(i).getTypeid(), shopcart.getShop().get(i).getUserid());
					list.add(s);
			}
		return list;
	}
	
	@RequestMapping("query")
	public List<orderson> query(@RequestBody List<orderson> orderson,Date startTime,Date endTime){
		if(startTime==null) {
			startTime=new Date();
		}
		if(endTime==null) {
			endTime=new Date();
		}
		List<orderson> o=oservice.query(orderson, startTime, endTime);
		return null;
	}
}
