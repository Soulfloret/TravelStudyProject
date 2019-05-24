package com.accp.sunhuihui.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.orderproductwork;
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
	public List<orderson> queryPaiban(@RequestBody List<orderson> list,Date startTime,Date endTime){
		if(startTime==null) {
			startTime=new Date();
		}
		if(endTime==null) {
			endTime=new Date();
		}
		return service.query(list,startTime,endTime);
	}
	
	
	@RequestMapping("queryByTimeEWM")
	public orderproductwork queryByTimeEWM() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date("2019-5-24 13:00:0");
		Date d1=new Date("2019-5-24 13:30:0");
		orderproductwork work=new orderproductwork();
		work.setIid(1);
		work.setStarttime(d);
		work.setEndtime(d1);
		orderproductwork o=service.queryByTimeEWM(work);
		return o;
	}
	
}
