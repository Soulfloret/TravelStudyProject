package com.accp.sunhuihui.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.images;
import com.accp.domain.menu;
import com.accp.domain.product;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.domain.projecttype;
import com.accp.domain.recommend;
import com.accp.domain.room;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.menucommentMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.projectplMapper;
import com.accp.mapper.projecttypeMapper;
import com.accp.mapper.roomMapper;
import com.accp.mapper.usersMapper;

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
	@Autowired
	usersMapper umapper;
	@Autowired
	projectplMapper plmapper;
	@Autowired menucommentMapper mcmapper;
	
	
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
	
	/**
	 * 查询项目详情
	 * @param id
	 * @return
	 */
	public project AppProjectByid(@Param("id")Integer id) {
		project p=mapper.AppProjectByid(id);
		p.setIlist(imapper.queryimg(p.getId(), 1));
		p.setPllistshh(plmapper.project_queryByPl(p.getId()));
		return p;
	}
	
	/**
	 * 查询活动详情
	 */
	public product AppProductByid(@Param("id")Integer id) {
		product pd=pdmapper.AppProductByid(id);
		for (productproject pds : pd.getPplist()) {
			pds.setPro(mapper.AppProjectByid(pds.getProjectid()));
		}
		return pd;
	}
	
	/**
	 * 查询餐饮详情
	 */
	public menu AppMenuByid(Integer id) {
		menu m=mmapper.selectByPrimaryKey(id);
		m.setImgs(imapper.queryimg(m.getId(), 2));
		m.setMenucommend(mcmapper.AppMenuCommend(m.getId()));
		return m;
	}
	
	/**
	 * 查询房间详情
	 */
	public room AppRoomByid(Integer id) {
		room r=rmapper.selectByPrimaryKey(id);
		r.setImgs(imapper.queryimg(r.getId(), 3));
		return r;
	}
}
