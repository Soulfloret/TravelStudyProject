package com.accp.wujiajun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.staff;
import com.accp.mapper.staffMapper;
import com.accp.mapper.usersMapper;
import com.accp.wujiajun.service.impl.accountsServiceImpl;

@Service
@Transactional
public class accountsService implements accountsServiceImpl{

	@Autowired
	staffMapper mapper;

	@Autowired
	usersMapper mapper1;
	
	@Override
	public staff accountsQuery(Integer id) {
		// TODO Auto-generated method stub
		return mapper.accountsQuery(id);
	}

	@Override
	public int accountsUpdate(Integer id, String name2) {
		// TODO Auto-generated method stub
		return mapper1.accountsUpdate(id, name2);
	}
	
	
}
