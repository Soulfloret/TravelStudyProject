package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.room;
import com.accp.mapper.roomMapper;
import com.accp.renyuxuan.service.roomservice;

@Service
@Transactional
public class roomserviceimpl implements roomservice{

	
	@Autowired
	roomMapper ro;
	
	@Override
	public List<room> queryByroom(room r) {
		// TODO Auto-generated method stub
		return ro.queryByroom(r);
	}

	@Override
	public int insertSelective(room record) {
		// TODO Auto-generated method stub
		return ro.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(room record) {
		// TODO Auto-generated method stub
		return ro.updateByPrimaryKeySelective(record);
	}

}
