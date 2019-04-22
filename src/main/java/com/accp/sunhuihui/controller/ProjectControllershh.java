package com.accp.sunhuihui.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.menu;
import com.accp.domain.product;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.domain.projecttype;
import com.accp.domain.room;
import com.accp.domain.users;
import com.accp.sunhuihui.service.ProjectServiceshh;
import com.alibaba.fastjson.JSON;

@Controller
@RestController
@RequestMapping("projectshh")
public class ProjectControllershh {

	@Autowired
	ProjectServiceshh service;
	
	@RequestMapping("queryprojectAll")
	public  List<project> queryprojectAll(project project){
		List<project>	list=service.queryprojectAll(project);
		String json=JSON.toJSONString(list);
		return list; 
	}

	@RequestMapping("projecttypequery")
	public List<projecttype> projecttypequery(){
		return service.projecttypequery();
	}
	
	@RequestMapping("queryroomAll")
	public List<room> queryroomAll(room room){
		return service.queryRoomAll(room);
	}
	
	@RequestMapping("queryproductAll")
	public List<product> queryproductAll(product product){
		return service.queryproductAll(product);
	}
	
	@RequestMapping("querymenuAll")
	public List<menu> querymenuAll(menu menu){
		
		return service.queryMenuAll(menu);
	}
	
	@RequestMapping("projectXq_queryById")
	public project projectXq_queryById(Integer id) {
		return service.projectXq_queryById(id);
	}
	
	
	/**
	 * 查询项目详情
	 * @param id
	 * @return
	 */
	@RequestMapping("AppProjectByid")
	public project AppProjectByid(Integer id) {
		project p=service.AppProjectByid(id);
		return p;
	}
	
	/**
	 * 查询活动详情
	 */
	@RequestMapping("AppProductByid")
	public product AppProductByid(@Param("id")Integer id) {
		product pd=service.AppProductByid(id);
		return pd;
	}
	
	/**
	 * 查询餐饮详情
	 */
	@RequestMapping("AppMenuByid")
	public menu AppMenuByid(Integer id) {
		menu m=service.AppMenuByid(id);
		return m;
	}
	
	/**
	 * 查询房间详情
	 */
	@RequestMapping("AppRoomByid")
	public room AppRoomByid(Integer id) {
		room r=service.AppRoomByid(id);
		return r;
	}
	
}
