package com.accp.renyuxuan.service.impl;

import java.util.List;

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

	@Override
	public List<roomdestine> selectByroomid(Integer id) {
		// TODO Auto-generated method stub
		return r.selectByroomid(id);
	}

	@Override
	public List<roomdestine> selectByrdId(Integer id) {
		// TODO Auto-generated method stub
		return r.selectByrdId(id);
	}

	@Override
	public int updateByPrimaryKeySelective(roomdestine record) {
		// TODO Auto-generated method stub
		return r.updateByPrimaryKeySelective(record);
	}

}
