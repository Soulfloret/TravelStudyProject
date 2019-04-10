package com.accp.renyuxuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.bind;
import com.accp.domain.menu;
import com.accp.renyuxuan.service.impl.bindserviceimpl;
import com.alibaba.fastjson.JSON;

@Controller
public class bindcontroller {

	@Autowired
	bindserviceimpl b;
	
	@RequestMapping("/toQuerybind")
	public String toQuerybind(Model model,bind bi) {
		List<bind> list=b.querybind(bi);
		model.addAttribute("list",list);
		model.addAttribute("binds",bi);
		return "GoodContact";
	}
	
	//菜单套餐上架下架
		@RequestMapping("/tcsjxj")
		@ResponseBody
		public String sjxj(String type,Integer id) {
			if("上架".equals(type)) {
				bind binds=new bind();
				binds.setId(id);
				binds.setState("2");
				b.updateByPrimaryKeySelective(binds);
				return "下架成功！";
			}else if("下架".equals(type)) {
				bind binds=new bind();
				binds.setId(id);
				binds.setState("1");
				b.updateByPrimaryKeySelective(binds);
				return "上架成功！";
			}
			return "";
		}
		
		
}
