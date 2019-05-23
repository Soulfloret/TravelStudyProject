package com.accp.sunhuihui.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.chenyong.service.ProductAreaService;
import com.accp.domain.Meal;
import com.accp.domain.Mealix;
import com.accp.domain.orderson;
import com.accp.domain.productarea;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.domain.recommend;
import com.accp.mapper.MealMapper;
import com.accp.mapper.bindMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.ordersonMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.productareaMapper;
import com.accp.mapper.productprojectMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.roomMapper;

@Service
public class OrderSonServiceshh {

		@Autowired
		ordersonMapper omapper;
		@Autowired
		projectMapper pmapper;
		@Autowired
		imagesMapper imapper;
		@Autowired
		productMapper pdmapper;
		@Autowired
		menuMapper mmapper;
		@Autowired
		roomMapper rmapper;
		@Autowired
		productareaMapper mapper;
		@Autowired
		productprojectMapper mapper1;
		@Autowired
		MealMapper mapper2;
		@Autowired
		ProductAreaService service;
		@Autowired
		bindMapper bmapper;
		
		public List<Object> recommdstatic(@Param("typeid")Integer typeid){
			/**
			 * 项目
			 */
			List<orderson> typeid1= omapper.recommdstatic(1);
			for (orderson type : typeid1) { 
				recommend com=pmapper.recommendByidproject(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 1));
				type.setRecommend(com);
			}
			
			/**
			 * 活动
			 */
			List<orderson> typeid5= omapper.recommdstatic(5);
			for (orderson type : typeid5) { 
				recommend com=pdmapper.recommendByidproduct(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 5));
				type.setRecommend(com);
			}
			
			/**
			 * 餐饮
			 */
			List<orderson> type2=omapper.recommdstaticmenu(2);
			for (orderson type : type2) { 
				recommend com=mmapper.recommendByidmenu(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 2));
				type.setRecommend(com);
			}
			
			/**
			 * 住宿
			 */
			/*List<orderson> type3=omapper.recommdstatic(3);
			for (orderson type : type3) { 
				recommend com=rmapper.recommendByidroom(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 3));
				type.setRecommend(com);
			}*/
			
			/**
			 * 餐饮套餐
			 */
			List<orderson> type4=omapper.recommdstatic(4);
			for (orderson type : type4) { 
				recommend com=bmapper.recommendBind(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 4));
				type.setRecommend(com);
			}
			
			/**
			 * 总套餐
			 */
			List<orderson> type5=omapper.recommdstatic(7);
			for (orderson type : type5) { 
				recommend com=mapper2.recommendMealAll(type.getIid());
				System.out.println(type.getTypeid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 7));
				type.setRecommend(com);
			}
			
			
			List list = new ArrayList() ;
	        Iterator it1 = typeid1.iterator() ;
	        while(it1.hasNext()) {
	            list.add(it1.next()) ;
	        }
	        Iterator it2 = typeid5.iterator() ;
	        while(it2.hasNext()) {
	            list.add(it2.next()) ;
	        }
	        
	        Iterator it3 = type2.iterator() ;
	        while(it3.hasNext()) {
	            list.add(it3.next()) ;
	        }
	       /* 
	        Iterator it4 = type3.iterator() ;
	        while(it4.hasNext()) {
	            list.add(it4.next()) ;
	        }
	        */
	        Iterator it5 = type4.iterator() ;
	        while(it5.hasNext()) {
	            list.add(it5.next()) ;
	        }
	        
	        Iterator it6 = type5.iterator() ;
	        while(it6.hasNext()) {
	            list.add(it6.next()) ;
	        }
	        
	        Collections.shuffle(list);
			return list;
		}
		
		public List<orderson> query(List<orderson> o,Date startTime,Date endTime) {
			List<orderson> o1=new ArrayList<orderson>();
			for (orderson orderson : o) {
				if(orderson.getTypeid()==1) {
					project p=pmapper.selectByPrimaryKey(orderson.getIid());
					p=service.queryByArearId(p, startTime, endTime);
					orderson.setIx(p);
				}
				if(orderson.getTypeid()==5) {
					List<productproject> p=mapper1.queryByProdId(orderson.getIid());
					List<project> list1=new ArrayList<project>();
					for (productproject productproject : p) {
						project p1=new project();
						p1.setId(productproject.getProjectid());
						p1=pmapper.queryByProjectId(p1.getId()).get(0);
						list1.add(service.queryByArearId(p1, startTime, endTime));
					}
					orderson.setIx(list1);
				}
				if(orderson.getTypeid()==7) {
					Meal m=mapper2.query(orderson.getIid()).get(0);
					List<project> list1=new ArrayList<project>();
					for (Mealix mx : m.getList()) {
						if(mx.getTypeid()==1) {
							project p=pmapper.selectByPrimaryKey(mx.getIid());
							p=service.queryByArearId(p, startTime, endTime);
							mx.setIx(p);
							list1.add(p);
						}
					}
					orderson.setIx(list1);
				}
				o1.add(orderson);
			}
			return o1;
		}
		
	}
