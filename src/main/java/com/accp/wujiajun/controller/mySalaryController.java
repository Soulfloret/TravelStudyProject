package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.positions;
import com.accp.domain.staff;
import com.accp.wujiajun.service.positionsService;
import com.accp.wujiajun.service.impl.staffServiceImpl;

@RequestMapping("/mySalary")
@Controller
public class mySalaryController {


	@Autowired
	staffServiceImpl serivce;
	
	@Autowired
	positionsService positions;
	
	@RequestMapping("/query")
	public String query() {
		return "salary";
	}
	
	@RequestMapping("/queryById")
	@ResponseBody
	public List<staff> queryById(Integer id) {
		List<staff> list=serivce.mySalary(id);
		return list;
	}
}
