package com.accp.sunhuihui.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.comments;
import com.accp.domain.dynamics;
import com.accp.domain.reply;
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
			dynamics d=service.queryByid(id);
			return d;
		}
		
		@RequestMapping("commentadd")
		public int commentadd(comments comm) {
			comm.setSharetime(new Date());
			int i=service.commentadd(comm);
			return i;
		}
		
		@RequestMapping("replyadd")
		public int replyadd(reply reply) {
			reply.setSharetime(new Date());
			int i=service.replyadd(reply);
			return i;
		}
}
