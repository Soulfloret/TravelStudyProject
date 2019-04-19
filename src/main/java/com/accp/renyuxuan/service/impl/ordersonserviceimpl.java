package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.orderson;
import com.accp.mapper.ordersonMapper;
import com.accp.renyuxuan.service.ordersonservice;

@Service
@Transactional
public class ordersonserviceimpl  implements ordersonservice{

	@Autowired
	ordersonMapper o;
	
	@Override
	public int insertSelective(orderson record) {
		// TODO Auto-generated method stub
		return o.insertSelective(record);
	}
	
}
