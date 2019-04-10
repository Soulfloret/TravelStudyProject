package com.accp.renyuxuan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.menu;
import com.accp.renyuxuan.service.impl.menuTypeserviceimpl;
import com.accp.renyuxuan.service.impl.menuserviceimpl;
import com.alibaba.fastjson.JSON;

@Controller
public class menucontroller {
	
	//菜单
	@Autowired
	menuserviceimpl m;
	//菜单类型
	@Autowired
	menuTypeserviceimpl me;
	
	//查询后台菜单
	@RequestMapping("/toquerymenu")
	public String toquerymenu(Model model,menu men) {
		List<menu> list=m.QueryMenu(men);
		model.addAttribute("list",list);
		model.addAttribute("listtype",me.selectByExample(null));
		model.addAttribute("menus",men);
		return "GoodManager";
	}
	
	//菜单添加页面
	@RequestMapping("/tomenuadd")
	public String tomenuadd(Model model) {
		model.addAttribute("list",me.selectByExample(null));
		return "GoodAdd";
	}
	
	
	//菜单上架下架
	@RequestMapping("/sjxj")
	@ResponseBody
	public String sjxj(String type,Integer id) {
		if("上架".equals(type)) {
			menu menus=new menu();
			menus.setState("2");
			menus.setId(id);
			m.updateByPrimaryKeySelective(menus);
			return "下架成功！";
		}else if("下架".equals(type)) {
			menu menus=new menu();
			menus.setState("1");
			menus.setId(id);
			m.updateByPrimaryKeySelective(menus);
			return "上架成功！";
		}
		return "";
	}
	
	
	//菜单删除
	@RequestMapping("/delmenu")
	@ResponseBody
	public String delmenu(Integer id) {
		//m.deleteByPrimaryKey(id);
		return "删除成功！";
	}
	
	
	//菜单添加
	@RequestMapping("/addmenu")
	public String addmenu(menu me) {
		me.setLikecount(0);
		me.setPutawaytime(new Date());
		m.insertSelective(me);
		return "redirect:/toquerymenu";
	}
	
	//去菜单修改页面
	@RequestMapping("/toupdatemenu")
	public String toupdatemenu(Model model,menu menus) {
		List<menu> list=m.QueryMenu(menus);
		model.addAttribute("list", list);
		model.addAttribute("listtype",me.selectByExample(null));
		return "GoodUpdate";
	}
	
	
	
	
	
	
}
