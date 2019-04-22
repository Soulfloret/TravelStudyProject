package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Shopcart;
import com.accp.mapper.ShopcartMapper;
import com.accp.renyuxuan.service.Shopcartservice;

@Service
@Transactional
public class Shopcartserviceimpl implements Shopcartservice{

	@Autowired
	ShopcartMapper ss;
	
	
	@Override
	public int insertSelective(Shopcart record) {
		// TODO Auto-generated method stub
		return ss.insertSelective(record);
	}


	@Override
	public Shopcart selectshopcartByid(Shopcart s) {
		// TODO Auto-generated method stub
		return ss.selectshopcartByid(s);
	}


	@Override
	public int updateByPrimaryKeySelective(Shopcart record) {
		// TODO Auto-generated method stub
		return ss.updateByPrimaryKeySelective(record);
	}

}
