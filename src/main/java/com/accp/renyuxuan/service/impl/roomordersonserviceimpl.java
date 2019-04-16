package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.roomorderson;
import com.accp.mapper.roomordersonMapper;
import com.accp.renyuxuan.service.roomordersonservice;

@Service
@Transactional
public class roomordersonserviceimpl  implements roomordersonservice{

	@Autowired
	roomordersonMapper r;
	
	@Override
	public int insert(roomorderson record) {
		// TODO Auto-generated method stub
		return r.insert(record);
	}

	@Override
	public int insertSelective(roomorderson record) {
		// TODO Auto-generated method stub
		return r.insertSelective(record);
	}

}
