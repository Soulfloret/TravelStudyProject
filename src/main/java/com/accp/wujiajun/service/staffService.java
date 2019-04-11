package com.accp.wujiajun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.staff;
import com.accp.domain.staffExample;
import com.accp.mapper.positionsMapper;
import com.accp.mapper.staffMapper;
import com.accp.wujiajun.service.impl.staffServiceImpl;

@Service
public class staffService implements staffServiceImpl{
	
	@Autowired
	staffMapper mapper;

	
	
	
	@Override
	public List<staff> query(staff sta) {
		// TODO Auto-generated method stub
		return mapper.query(sta);
	}

	@Override
	public staff queryById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.queryById(id);
	}

	@Override
	public List<staff> queryLike(staff sta) {
		// TODO Auto-generated method stub
		return mapper.queryLike(sta);
	}
	
	

}
