package com.accp.xiangjianbo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.positions;
import com.accp.domain.project;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.positionsMapper;
import com.accp.mapper.productareaMapper;
import com.accp.mapper.projectMapper;
import com.alibaba.fastjson.JSON;

@Service
public class projectService {

	@Autowired
	projectMapper prom;
	
	@Autowired
	imagesMapper ima;
	
	@Autowired
	productareaMapper pa;
	
	@Autowired
	positionsMapper posmapper;
	
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
	
	/*查询项目详情*/
	public project projectXq_queryById(Integer id) {
		project list=prom.projectXq_queryById(id);
		/*List<positions> pos=new ArrayList<positions>();
		List<String> str=new ArrayList<String>();
		if(list.getName1()!=null) {
			String a=list.getName1();
			String s=(String) a.substring(3);
			String [] pid=s.split(",");
			for (int i = 0; i < pid.length; i++) {
				pos=posmapper.project_queryById(Integer.parseInt(pid[i]));
				list.setPoslist(pos);
			}
		}
		System.out.println(JSON.toJSONString(list));*/
		return list;
	}
	
	/*删除项目*/
	public int deleteByPrimaryKey(Integer id) {
		return prom.deleteByPrimaryKey(id);
	}
	
	
}
