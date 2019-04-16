package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.roomdestine;
import com.accp.mapper.roomdestineMapper;
import com.accp.renyuxuan.service.roomdestineservice;

@Service
@Transactional
public class roomdestineserviceimpl implements roomdestineservice{

	@Autowired
	roomdestineMapper r;
	
	@Override
	public int insert(roomdestine record) {
		// TODO Auto-generated method stub
		return r.insert(record);
	}

	@Override
	public int insertSelective(roomdestine record) {
		// TODO Auto-generated method stub
		return r.insertSelective(record);
	}

}
