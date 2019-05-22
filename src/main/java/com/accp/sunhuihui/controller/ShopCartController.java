package com.accp.sunhuihui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.chenyong.serviceimpl.OrderSonServiceImpl;
import com.accp.domain.Shopcart;
import com.accp.domain.orderson;
import com.accp.domain.productproject;
import com.accp.domain.recommend;
import com.accp.renyuxuan.service.ordersonservice;
import com.accp.sunhuihui.service.OrderSonServiceshh;
import com.accp.sunhuihui.service.ShopCartService;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RestController
@RequestMapping("shopcartshh")
public class ShopCartController {

	@Autowired
	ShopCartService service;
	@Autowired
	OrderSonServiceshh oservice;
	@Autowired
	OrderSonServiceImpl service1;

	@RequestMapping("insertList")
	public int insertList(Shopcart shopcart) {
		int i = service.insertList(shopcart);
		return i;
	}

	@RequestMapping("QueryIidUserid")
	public int QueryIidUserid(Integer iid, Integer typeid, Integer userid) {
		Shopcart s = service.QueryIidUserid(iid, typeid, userid);
		double dj = Double.parseDouble(s.getName1()) / Integer.parseInt(s.getName2());
		s.setName1(dj * (Integer.parseInt(s.getName2()) + 1) + "");
		s.setName2(Integer.parseInt(s.getName2()) + 1 + "");
		int i = service.updateByPrimaryKeySelective(s);
		return 0;
	}

	@RequestMapping("deleteIidUserid")
	public int deleteIidUserid(Integer iid, Integer typeid, Integer userid) {
		Shopcart s = service.QueryIidUserid(iid, typeid, userid);
		if (Integer.parseInt(s.getName2()) > 1) {
			double dj = Double.parseDouble(s.getName1()) / Integer.parseInt(s.getName2());
			s.setName1(dj * (Integer.parseInt(s.getName2()) - 1) + "");
			s.setName2(Integer.parseInt(s.getName2()) - 1 + "");
			int i = service.updateByPrimaryKeySelective(s);
			return i;
		} else {
			int i = service.deleteIidUserid(iid, typeid, userid);
			return i;
		}
	}

	@RequestMapping("deleteUserid")
	public int deleteUserid(Integer userid) {
		return service.deleteUserid(userid);
	}

	@RequestMapping("queryAll")
	public List<Shopcart> queryAll(Integer userid) {
		List<Shopcart> shop = service.queryAll(userid);
		return shop;
	}

	@RequestMapping("pdqueryShopCart")
	public List<Shopcart> pdqueryShopCart(@RequestBody Shopcart shopcart) {
		List<Shopcart> list = new ArrayList<Shopcart>();
		for (int i = 0; i < shopcart.getShop().size(); i++) {
			Shopcart s = service.QueryIidUserid(shopcart.getShop().get(i).getIid(),
					shopcart.getShop().get(i).getTypeid(), shopcart.getShop().get(i).getUserid());
			list.add(s);
		}
		return list;
	}

	@RequestMapping("query")
	public List<orderson> query(String orderson, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, orderson.class);
		List<orderson> list = mapper.readValue(orderson, jt);
		System.out.println(startTime);
		System.out.println(endTime);
		if (startTime == null) {
			startTime = new Date();
		}
		if (endTime == null) {
			endTime = new Date();
		}
		List<orderson> o = service1.query(list, startTime, endTime);
		return o;
	}

	@RequestMapping("Activeiid")
	public List<productproject> Activeiid(Integer productid) {
		return service.queryByProdId(productid);
	}
	
	@RequestMapping("WholeRecommend")
	public recommend WholeRecommend(Integer iid,Integer typeid) {
		recommend r =service.WholeRecommend(iid, typeid);
		System.out.println(JSON.toJSONString(r));
		return r;
	}
}
