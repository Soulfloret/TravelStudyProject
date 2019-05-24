package com.accp.wujiajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Meal;
import com.accp.wujiajun.service.impl.mealServiceImpl;

@RequestMapping("/meal")
@Controller
public class mealController {

	@Autowired
	mealServiceImpl service;

	@RequestMapping("/query")
	public String query(Model model) {
		List<Meal> list = service.mealQuery(null);
		model.addAttribute("list", list);
		return "JJ_set meal";
	}

	@RequestMapping("/mealProjectQueryById")
	@ResponseBody
	public List<Meal> mealProjectQueryById(Integer id) {
		List<Meal> plist = service.mealProjectQueryById(id);
		return plist;
	}

	@RequestMapping("/mealRoomQueryById")
	@ResponseBody
	public List<Meal> mealRoomQueryById(Integer id) {
		List<Meal> rlist = service.mealRoomQueryById(id);
		return rlist;
	}

	@RequestMapping("/mealMenuQueryById")
	@ResponseBody
	public List<Meal> mealMenuQueryById(Integer id) {
		List<Meal> mlist = service.mealMenuQueryById(id);
		return mlist;
	}
}
