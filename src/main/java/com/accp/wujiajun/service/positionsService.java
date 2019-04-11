package com.accp.wujiajun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.positions;
import com.accp.domain.positionsExample;
import com.accp.mapper.positionsMapper;
import com.accp.wujiajun.service.impl.positionsServiceImpl;

@Service
public class positionsService implements positionsServiceImpl{

	@Autowired
	positionsMapper mapper;

	@Override
	public List<positions> selectByExample(positionsExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}
	
	
}
