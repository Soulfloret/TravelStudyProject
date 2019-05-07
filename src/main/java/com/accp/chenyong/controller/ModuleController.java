package com.accp.chenyong.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.chenyong.service.ModuleService;
import com.accp.chenyong.service.RoleService;
import com.accp.chenyong.service.UserRoleService;
import com.accp.domain.module;
import com.accp.domain.role;
import com.accp.domain.staff;
import com.accp.domain.userrole;
import com.accp.wujiajun.service.staffService;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	ModuleService service;
	@Autowired
	RoleService service1;
	@Autowired
	staffService service2;
	@Autowired
	UserRoleService service3;
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
	@ResponseBody
	@RequestMapping("queryAll")
	public List<module> queryAll(){
		List<module> list=service.queryAll(0);
		return list;
	}
	@ResponseBody
	@RequestMapping("queryByRid")
	public List<module>queryByRid(Integer rid){
		List<module> list=service.queryByridAll(rid);
		return list;
	}
	@RequestMapping("qxmenager")
	public String query(Model mo,HttpServletRequest req){
		List<role> list=service1.selectByExample(null);
		List<staff> list1=service2.query(null);
		for (staff staff : list1) {
			userrole ur=service3.queryByUserId(staff.getUserid());
			if(ur!=null) {
				staff.setUr(ur);
			}
		}
		mo.addAttribute("list1",list1);
		mo.addAttribute("list",list);
		return "access";
	}
	@RequestMapping("roleModuleUpdate")
	public String update(role r,int typeid) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(typeid==0) {
			r.setName1(sdf.format(new Date()));
			r.setName2(sdf.format(new Date()));
			service1.insert(r);			
		}else {
			r.setId(typeid);
			r.setName2(sdf.format(new Date()));
			service1.updateByPrimaryKeySelective(r);			
		}
		return "redirect:qxmenager";
	}
	@RequestMapping("delRole")
	public String delRole(Integer id) {
		service1.deleteByPrimaryKey(id);
		return "redirect:qxmenager";
	}
	@RequestMapping("userroleAdd")
	public String userroleAdd(userrole ur) {
		service3.insert(ur);
		return "redirect:qxmenager";
	}
}
