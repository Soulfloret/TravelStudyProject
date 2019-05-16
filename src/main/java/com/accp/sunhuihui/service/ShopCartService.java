package com.accp.sunhuihui.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.Shopcart;
import com.accp.domain.productproject;
import com.accp.mapper.ShopcartMapper;
import com.accp.mapper.productprojectMapper;

@Service
public class ShopCartService {

	@Autowired
	ShopcartMapper mapper;
	@Autowired
	productprojectMapper pdmapper;
	
	
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
}
