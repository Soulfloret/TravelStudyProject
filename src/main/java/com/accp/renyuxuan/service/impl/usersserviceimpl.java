package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.users;
import com.accp.mapper.usersMapper;
import com.accp.renyuxuan.service.usersservice;

@Service
@Transactional
public class usersserviceimpl implements usersservice{

	@Autowired
	usersMapper mapper;
	
	@Override
	public List<users> selectByteamsUser(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByteamsUser(id);
	}

}
