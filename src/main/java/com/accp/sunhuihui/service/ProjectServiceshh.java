package com.accp.sunhuihui.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.Meal;
import com.accp.domain.Mealix;
import com.accp.domain.bind;
import com.accp.domain.images;
import com.accp.domain.menu;
import com.accp.domain.menubind;
import com.accp.domain.product;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.domain.projecttype;
import com.accp.domain.recommend;
import com.accp.domain.room;
import com.accp.mapper.MealMapper;
import com.accp.mapper.MealixMapper;
import com.accp.mapper.bindMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.menubindMapper;
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
	@Autowired
	menucommentMapper mcmapper;
	@Autowired
	MealMapper mealmapper;
	@Autowired
	MealixMapper mealixmapper;
	@Autowired
	bindMapper bindmapper;
	@Autowired
	menubindMapper menubindmapper;
	
	public  List<project> queryprojectAll(project project){
		List<project> list=mapper.queryprojectAll(project);
		for (project p : list) {
			List<images>  img=imapper.queryimg(p.getId(), 1);
			recommend rec=mapper.recommendByidproject(p.getId());
			rec.setTid(1);
			p.setRecommend(rec);
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
			recommend rec=rmapper.recommendByidroom(p.getId());
			rec.setTid(3);
			p.setRecommend(rec);
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
			recommend rec=mmapper.recommendByidmenu(p.getId());
			rec.setTid(2);
			p.setRecommend(rec);
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
			rec.setTid(5);
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
	
	/**
	 * 查询套餐全部
	 */
	
	public  List<Meal> MealQuery(Integer id){
		List<Meal> meal=mealmapper.queryMeal(id);
		for (Meal m1 : meal) {
			m1.setImg(imapper.queryimg(m1.getId(), 7));
			List<Mealix> mealix=mealixmapper.queryTid(m1.getId());
			String name2="";
			for (Mealix m2 : mealix) {
					if(m2.getTypeid()==1) {
						recommend re1=mapper.recommendByidproject(m2.getIid());
						m2.setRecommend(re1);
						name2+=re1.getName()+"、";
					}else if(m2.getTypeid()==3) {
						recommend re1=rmapper.recommendByidroom(m2.getIid());
						m2.setRecommend(re1);
						name2+=re1.getName()+"、";
					}else if(m2.getTypeid()==4) {
						recommend re1=bindmapper.recommendBind(m2.getIid());
						m2.setRecommend(re1);
						name2+=re1.getName()+"、";
					}
			}
			m1.setList(mealix);
			m1.setName5(7+"");
			m1.setName2(name2.substring(0, name2.length()-1));
			recommend r=mealmapper.recommendMealAll(m1.getId());
			r.setTid(7);
			m1.setRecommend(r);
		}
		return meal;
	}
	
	/**
	 * 查询菜单套餐全部以及详情
	 */
	public  List<bind> queryBind(Integer id){
		List<bind> binds=bindmapper.queryBindApp(id);
		for (bind b1 : binds) {
			b1.setImg(imapper.queryimg(b1.getId(), 4));
			List<menubind> menubind=menubindmapper.queryMenuBind(b1.getId());
			String name2="";
			for (menubind b2 : menubind) {
				recommend re=mmapper.recommendByidmenu(b2.getMenuid());
				name2+=re.getName()+"、";
				b2.setRecommend(mmapper.recommendByidmenu(b2.getMenuid()));
			}
			b1.setBlist(menubind);
			b1.setName5(4+"");
			b1.setName2(name2.substring(0, name2.length()-1));
			recommend r=bindmapper.recommendBind(b1.getId());
			r.setTid(4);
			b1.setRecommend(r);
		}
	
		return binds;
	}
}
