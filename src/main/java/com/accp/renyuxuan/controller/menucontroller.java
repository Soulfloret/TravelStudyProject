package com.accp.renyuxuan.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.bind;
import com.accp.domain.menu;
import com.accp.domain.menuorder;
import com.accp.domain.ordershop;
import com.accp.renyuxuan.service.impl.bindserviceimpl;
import com.accp.renyuxuan.service.impl.menuTypeserviceimpl;
import com.accp.renyuxuan.service.impl.menuorderserviceimpl;
import com.accp.renyuxuan.service.impl.menuserviceimpl;
import com.accp.renyuxuan.service.impl.ordershopserviceimpl;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("menu")
public class menucontroller {
	
	//菜单
	@Autowired
	menuserviceimpl m;
	//菜单类型
	@Autowired
	menuTypeserviceimpl me;
	//套餐
	@Autowired
	bindserviceimpl b;
	//套餐订单
	@Autowired
	menuorderserviceimpl mo;
	//套餐订单从表
	@Autowired
	ordershopserviceimpl os;
	
	//查询后台菜单
	@RequestMapping("/toquerymenu")
	public String toquerymenu(Model model,menu men) {
		List<menu> list=m.QueryMenu(men);
		model.addAttribute("list",list);
		System.out.println(JSON.toJSON(list));
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
		return "redirect:/menu/toquerymenu";
	}
	
	//去菜单修改页面
	@RequestMapping("/toupdatemenu")
	public String toupdatemenu(Model model,menu menus) {
		List<menu> list=m.QueryMenu(menus);
		model.addAttribute("list", list);
		model.addAttribute("listtype",me.selectByExample(null));
		return "GoodUpdate";
	}
	
	//菜单修改
	@RequestMapping("/updatemenu")
	public String updatemenu(menu menus) {
		m.updateByPrimaryKeySelective(menus);
		return "redirect:/menu/toquerymenu";
	}
	
	
	//去下订单页面
	@RequestMapping("/tomenuorder")
	public String tomenuorder(Model model,String lx) {
		if(lx==null || lx=="") {
			lx="0";
		}
		if("0".equals(lx)) {
			menu menus=new menu();
			List<menu> mlist=m.QueryMenu(menus);
			bind binds=new bind();
			List<bind> blist=b.querybind(binds);
			model.addAttribute("mlist", mlist);
			model.addAttribute("blist", blist);
			model.addAttribute("lx", lx);
			return "GoodOrderAdd";
		}else if("1".equals(lx)) {
			menu menus=new menu();
			List<menu> mlist=m.QueryMenu(menus);
			model.addAttribute("mlist", mlist);
			model.addAttribute("lx", lx);
			return "GoodOrderAdd";
		}else if("2".equals(lx)) {
			bind binds=new bind();
			List<bind> blist=b.querybind(binds);
			model.addAttribute("blist", blist);
			model.addAttribute("lx", lx);
			return "GoodOrderAdd";
		}
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/orderadd")
	public String orderadd(@RequestBody ordershop [] vps) {
		menuorder m=new menuorder();
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");  
			String datetime = tempDate.format(new Date());
			datetime=datetime+"cy";//订单编号
			m.setOrderrreference(datetime);
			m.setCreatetime(new Date());
			m.setStatuss("1");
			//身份证
			//m.setName1(vps[0].getName3());
			m.setUserid(1);
			m.setPrice(Double.parseDouble(vps[0].getName2()));
			//调方法添加订单
			System.out.println(JSON.toJSON(m));
			mo.insertSelective(m);
			for (int i = 0; i < vps.length; i++) {
				ordershop o =new  ordershop();
				o.setOrderid(m.getId());
				o.setMenuid(vps[i].getMenuid());
				o.setNum(vps[i].getNum());
				o.setName1(vps[i].getName1());
				o.setPrice(vps[i].getPrice());
				os.insertSelective(o);
			}
		return "下单成功！";
	}
	
	
	
	
	
}
