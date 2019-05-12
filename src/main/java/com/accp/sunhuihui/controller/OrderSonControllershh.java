package com.accp.sunhuihui.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.orderson;
import com.accp.sunhuihui.service.OrderSonServiceshh;
import com.alibaba.fastjson.JSON;


@Controller
@RestController
@RequestMapping("orderson")
public class OrderSonControllershh {

	@Autowired
	OrderSonServiceshh service;
	
	@RequestMapping("recommdstatic")
	public List<Object> recommdstatic(Integer typeid){
		List<Object> list=service.recommdstatic(1);
		String json=JSON.toJSONString(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("queryPaiban")
	public List<orderson> queryPaiban(){
			List<orderson> list=new ArrayList<orderson>();
			orderson o=new orderson();
			o.setIid(1);
			o.setTypeid(1);
			list.add(o);
			orderson o1=new orderson();
			o1.setTypeid(5);
			o1.setIid(1);
			list.add(o1);
			return service.query(list);
	}
	
	
}
