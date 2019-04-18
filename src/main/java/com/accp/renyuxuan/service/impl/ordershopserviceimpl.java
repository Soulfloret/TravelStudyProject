package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.ordershop;
import com.accp.mapper.ordershopMapper;
import com.accp.renyuxuan.service.ordershopservice;

@Service
@Transactional
public class ordershopserviceimpl implements ordershopservice{

	@Autowired
	ordershopMapper o;
	
	@Override
	public int insertSelective(ordershop record) {
		// TODO Auto-generated method stub
		return o.insertSelective(record);
	}

}
