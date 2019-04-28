package com.accp.chenyong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.ModuleService;
import com.accp.domain.module;
import com.accp.domain.staff;
import com.accp.domain.users;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	ModuleService service;
	@ResponseBody
	@RequestMapping("queryByUid")
	public List<module> query(HttpServletRequest req) {
		staff u=(staff)req.getSession().getAttribute("staff");
		List<module> list=service.queryModuleByUid(u.getUserid(),0);
		return list;
	}
	@ResponseBody
	@RequestMapping("hide")
	public List<String> hide(String []urls,HttpServletRequest req) {
		staff u=(staff)req.getSession().getAttribute("staff");
		Map<String,module>maps=service.queryModuleByUidToMap(u.getUserid());
		List<String>ulist=new ArrayList<String>();
		for (String s : urls) {
			if(maps.get(s)==null) {
				ulist.add(s);
			}
		}
		return ulist;
	}
	@RequestMapping("qxmenager")
	public String query(Model mo,HttpServletRequest req){
		staff u=(staff)req.getSession().getAttribute("staff");
		List<module> list=service.queryModuleByUid(u.getUserid(),0);
		mo.addAttribute("list",list);
		return "access";
	}
}
