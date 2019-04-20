package com.accp.sunhuihui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.images;
import com.accp.domain.menu;
import com.accp.domain.product;
import com.accp.domain.project;
import com.accp.domain.projecttype;
import com.accp.domain.recommend;
import com.accp.domain.room;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.projecttypeMapper;
import com.accp.mapper.roomMapper;

@Service
public class ProjectServiceshh {

	@Autowired
	projectMapper mapper;
	@Autowired
	imagesMapper imapper;
	@Autowired
	projecttypeMapper ptmapper;
	@Autowired
	roomMapper rmapper;
	@Autowired
	menuMapper mmapper;
	@Autowired
	productMapper pdmapper; 
	
	
	public  List<project> queryprojectAll(project project){
		List<project> list=mapper.queryprojectAll(project);
		for (project p : list) {
			List<images>  img=imapper.queryimg(p.getId(), 1);
			p.setRecommend(mapper.recommendByidproject(p.getId()));
			p.setIlist(img);
		}
		return list;
	}
	
	/**
	 * 住宿查询全部
	 * @param room
	 * @return
	 */
	public  List<room> queryRoomAll(room room){
		List<room> list=rmapper.queryRoomAll(room);
		for (room p : list) {
			List<images>  img=imapper.queryimg(p.getId(), 3);
			p.setRecommend(rmapper.recommendByidroom(p.getId()));
			p.setImgs(img);
		}
		return list;
	}
	
	/**
	 * 餐饮查询全部
	 * @param room
	 * @return
	 */
	public  List<menu> queryMenuAll(menu menu){
		List<menu> list=mmapper.queryMenuAll(menu);
		for (menu p : list) {
			List<images>  img=imapper.queryimg(p.getId(), 2);
			p.setRecommend(mmapper.recommendByidmenu(p.getId()));
			p.setImgs(img);
		}
		return list;
	}
	
	/**
	 * 活动查询全部
	 * @param room
	 * @return
	 */
	public  List<product> queryproductAll(product pro){
		List<product> list=pdmapper.queryAll();
		for (product p : list) {
			List<images>  img=imapper.queryimg(p.getId(), 2);
			String pname="";
			double price=0.0;
			recommend rec=pdmapper.recommendByidproduct(p.getId());
			List<project> project=mapper.queryprojectproductproject(p.getId());
			for (project proj : project) {
				pname+=proj.getPname()+",";
				price+=proj.getPrice();
			}
			pname=pname.substring(0, pname.length()-1);
			rec.setImgs(img);
			rec.setPname(pname);
			rec.setPrice(price);
			p.setRecommend(rec);
			
		}
		return list;
	}
	
	public List<projecttype> projecttypequery(){
		return ptmapper.selectByExample(null);
	}
	
	public project projectXq_queryById(Integer id) {
		return mapper.projectXq_queryById(id);
	}
	
}
