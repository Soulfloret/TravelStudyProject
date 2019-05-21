package com.accp.sunhuihui.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.Shopcart;
import com.accp.domain.productproject;
import com.accp.domain.recommend;
import com.accp.mapper.ShopcartMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.productprojectMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.roomMapper;

@Service
public class ShopCartService {

	@Autowired
	ShopcartMapper mapper;
	@Autowired
	productprojectMapper pdmapper;
	@Autowired
	projectMapper pmapper;
	@Autowired
	imagesMapper imapper;
	@Autowired
	productMapper pdmapper1;
	@Autowired
	menuMapper mmapper;
	@Autowired
	roomMapper rmapper;
	
	
	public int insertList(Shopcart shop) {
		return mapper.insertList(shop);
	}
	
	public Shopcart QueryIidUserid(Integer iid,Integer typeid,Integer userid) {
		return mapper.QueryIidUserid(iid,typeid,userid);
	}
	
	public  int deleteIidUserid(Integer iid,Integer typeid,Integer userid){
		return mapper.deleteIidUserid(iid,typeid,userid);
	}
	
	public int updateByPrimaryKeySelective(Shopcart record) {
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	public int deleteUserid(@Param("userid")Integer userid) {
		return mapper.deleteUserid(userid);
	}
	
	public List<Shopcart> queryAll(Integer userid){
		List<Shopcart> shop=mapper.queryAll(userid);
		return shop;
	}
	
	public List<productproject> queryByProdId(Integer productid){
		return pdmapper.queryByProdId(productid);
	}
	
	public recommend WholeRecommend(Integer iid,Integer typeid) {
		if(typeid==1) {
			recommend r= pmapper.recommendByidproject(iid);
			r.setTid(1);
			return r;
		}else if(typeid==2) {
			recommend r= mmapper.recommendByidmenu(iid);
			r.setTid(2);
			return r;
		}else if(typeid==3) {
			recommend r= rmapper.recommendByidroom(iid);
			r.setTid(3);
			return r;
		}else if(typeid==5) {
			recommend r= pdmapper1.recommendByidproduct(iid);
			r.setTid(5);
			return r;
		}
		
		return null;
		
	}
}
