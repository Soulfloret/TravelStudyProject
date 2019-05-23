package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Meal;
import com.accp.wujiajun.service.impl.mealServiceImpl;

@Controller
@RequestMapping("/singLe2")
public class single2Controller {

	@Autowired
	mealServiceImpl service;

	@RequestMapping("/query")
	public String query() {
		return "singLe2";
	}

	@RequestMapping("/projectAjaxQuery")
	@ResponseBody
	public List<Meal> projectAjaxQuery(Integer id) {
		List<Meal> plist = service.projectAjaxQuery(id);
		return plist;
	}

	@RequestMapping("/menuAjaxQuery")
	@ResponseBody
	public List<Meal> menuAjaxQuery(Integer id) {
		List<Meal> mlist = service.menuAjaxQuery(id);
		return mlist;
	}
}
