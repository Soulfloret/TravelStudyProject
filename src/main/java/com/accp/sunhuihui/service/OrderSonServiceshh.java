package com.accp.sunhuihui.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.orderson;
import com.accp.domain.recommend;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.ordersonMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.roomMapper;

@Service
public class OrderSonServiceshh {

		@Autowired
		ordersonMapper mapper;
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
		
		public List<Object> recommdstatic(@Param("typeid")Integer typeid){
			/**
			 * 项目
			 */
			List<orderson> typeid1= mapper.recommdstatic(1);
			for (orderson type : typeid1) { 
				recommend com=pmapper.recommendByidproject(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 1));
				type.setRecommend(com);
			}
			
			/**
			 * 活动
			 */
			List<orderson> typeid5= mapper.recommdstatic(5);
			for (orderson type : typeid5) { 
				recommend com=pdmapper.recommendByidproduct(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 5));
				type.setRecommend(com);
			}
			
			/**
			 * 餐饮
			 */
			List<orderson> type2=mapper.recommdstaticmenu(2);
			for (orderson type : type2) { 
				recommend com=mmapper.recommendByidmenu(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 2));
				type.setRecommend(com);
			}
			
			/**
			 * 住宿
			 */
			List<orderson> type3=mapper.recommdstatic(3);
			for (orderson type : type3) { 
				recommend com=rmapper.recommendByidroom(type.getIid());
					com.setTid(type.getTypeid());
					com.setImgs(imapper.queryimg(com.getId(), 3));
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
	        
	        Iterator it4 = type3.iterator() ;
	        while(it4.hasNext()) {
	            list.add(it4.next()) ;
	        }
	        Collections.shuffle(list);
			return list;
		}
		
	}
