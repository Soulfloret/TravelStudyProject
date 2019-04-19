package com.accp.wujiajun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.users;
import com.accp.mapper.usersMapper;
import com.accp.wujiajun.service.impl.JJ_loginServiceImpl;

@Service
@Transactional
public class JJ_loginService implements JJ_loginServiceImpl{

	@Autowired
	usersMapper mapper;

	@Override
	public users queryByName(String uname, String upassword) {
		// TODO Auto-generated method stub
		return mapper.queryByName(uname, upassword);
	}

	
	
}
