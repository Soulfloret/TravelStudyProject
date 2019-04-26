package com.accp.chenyong.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.ProductAreaService;
import com.accp.domain.productarea;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("qs")
public class controller {
	@Autowired
	ProductAreaService service;
	@RequestMapping("query")
	@ResponseBody
	public String query(Integer areaid) {
		productarea p=new productarea();
		p.setAreaid(areaid);
		return JSON.toJSONString(service.queryByArearId(p, new Date(), new Date()));
	}
}
