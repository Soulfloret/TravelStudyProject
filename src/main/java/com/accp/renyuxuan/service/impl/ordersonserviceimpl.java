package com.accp.renyuxuan.service.impl;

import java.util.List;

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
	ordersonMapper oo;
	
	@Override
	public int insertSelective(orderson record) {
		// TODO Auto-generated method stub
		return oo.insertSelective(record);
	}

	@Override
	public List<orderson> querytj(orderson o) {
		// TODO Auto-generated method stub
		return oo.querytj(o);
	}
	
}
