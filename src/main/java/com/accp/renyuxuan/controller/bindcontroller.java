package com.accp.renyuxuan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.bind;
import com.accp.domain.menu;
import com.accp.renyuxuan.service.impl.bindserviceimpl;
import com.accp.renyuxuan.service.impl.imagesserviceimpl;
import com.accp.renyuxuan.service.impl.menuTypeserviceimpl;
import com.accp.renyuxuan.service.impl.menubindserviceimpl;
import com.accp.renyuxuan.service.impl.menuserviceimpl;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("bing")
public class bindcontroller {
	
	//套餐
	@Autowired
	bindserviceimpl b;
	//菜单类型
	@Autowired
	menuTypeserviceimpl me;
	//菜单
	@Autowired
	menuserviceimpl m;
	//套餐菜单中间表
	@Autowired
	menubindserviceimpl meb;
	@Autowired
	imagesserviceimpl im;
		
	//去套餐页面
	@RequestMapping("/toQuerybind")
	public String toQuerybind(Model model,bind bi) {
		if(bi.getZdprice()!=null && bi.getZgprice()!=null) {
			Double a=bi.getZdprice();
			Double b=bi.getZgprice();
			if(a>b) {
				bi.setZdprice(b);
				bi.setZgprice(a);
			}
		}
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
		
		
	//去套餐添加页面
	@RequestMapping("/toaddbind")
	public String toaddbind(Model model) {
		model.addAttribute("listtype",me.selectByExample(null));
		return"GoodContactAdd";
	}
	
	
	//根据类型id查询所有商品类型id为0时查询所有
	@RequestMapping("/ajaxquerymenuByid")
	@ResponseBody
	public String ajaxquerymenuByid(menu menus) {
		List<menu> list= m.QueryMenu(menus);
		return JSON.toJSONString(list);
	}
	
	//添加套餐
	@RequestMapping("/addbing")
	public String addbind(bind binds) {
		binds.setLikecount(0);
		binds.setCreatetime(new Date());
		b.insert(binds);
		b.insertmenubind(binds);
		im.insertbingimglist(binds);
		return "redirect:/bing/toQuerybind";
	}
	
	//去修改页面
	@RequestMapping("/toupdatebing")
	public String toupdatebind(Model model,bind binds) {
		model.addAttribute("listtype",me.selectByExample(null));
		List<bind> list=b.querybind(binds);
		model.addAttribute("list",list);
		model.addAttribute("mlist",im.queryimg(binds.getId(), 4));
		return "GoodContactUpdate";
	}
	
	//修改套餐
	@RequestMapping("/updatebing")
	public String updatebing(bind binds) {
		meb.deleteBybindid(binds.getId());
		binds.setLikecount(0);//修改之后点赞清0
		b.updateByPrimaryKeySelective(binds);
		b.insertmenubind(binds);
		im.delByiidAndTypeId(binds.getId(), 4);
		im.insertbingimglist(binds);
		return "redirect:/bing/toQuerybind";
	}
	
	
	
		
}
