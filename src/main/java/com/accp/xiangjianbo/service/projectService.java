package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.project;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.productareaMapper;
import com.accp.mapper.projectMapper;

@Service
public class projectService {

	@Autowired
	projectMapper prom;
	
	@Autowired
	imagesMapper ima;
	
	@Autowired
	productareaMapper pa;
	
	//新增活动查询项目
	public List<project> query(){
		return prom.selectByExample(null);
	}
	
	//新增项目
	public int insert(project pro) {
		int i=prom.insert(pro);
		ima.insert_project(pro);
		pa.project_areas(pro);
		return 0;
	}
	
	//查询项目
	public List<project> queryAll(project pro){
		return prom.queryAll(pro);
	}
}
