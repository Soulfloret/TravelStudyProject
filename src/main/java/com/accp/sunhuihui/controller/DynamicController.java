package com.accp.sunhuihui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.dynamics;
import com.accp.sunhuihui.service.DynamicService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Controller
@RestController
@RequestMapping("/dynamic")
public class DynamicController {
		
		@Autowired
		DynamicService service;
		
		@RequestMapping("query")
		public PageInfo<dynamics> query(Integer currentPage,Integer pageSize){
			PageInfo<dynamics> page=service.query(1, 3,3);
			String json=JSON.toJSONString(page);
			return page;
		}
		
		@RequestMapping("queryByid")
		public dynamics queryByid(Integer id) {
			dynamics d=service.queryByid(1);
			String json=JSON.toJSONString(d);
			System.out.println(json);
			return d;
		}
}
