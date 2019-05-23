package com.accp.chenyong.controller;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.chenyong.service.CountService;
import com.accp.domain.menu;
import com.accp.domain.project;
import com.accp.domain.room;

@Controller
@RequestMapping("/count")
public class CountController {
	@Autowired
	CountService service;
	@RequestMapping("godaychart")
	public String daychart(Model mo){
		Date date = new Date();
		Calendar ca1 = Calendar.getInstance();
		ca1.setTime(date);//设置起时间
		ca1.set(Calendar.HOUR, 0);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);//设置起时间
		cal.set(Calendar.HOUR, 0);
		cal.add(Calendar.DATE, 1);//增加一天
		List<project> listp=service.querycountproject(ca1.getTime(),cal.getTime());
		mo.addAttribute("listp",listp);
		List<menu> listm=service.querycountmenu(ca1.getTime(),cal.getTime());
		mo.addAttribute("listm",listm);
		List<room> listr=service.querycountroom(ca1.getTime(), cal.getTime());
		mo.addAttribute("listr",listr);
		return "dayChart";
	}
	@RequestMapping("goweekendchart")
	public String weekendchart(Model mo) {
		return "weekendChart";
	}
	@RequestMapping("gomonthchart")
	public String monthchart(Model mo) {
		return "monthChart";
	}
}