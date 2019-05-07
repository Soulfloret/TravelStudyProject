package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.users;
import com.accp.mapper.usersMapper;

@Service
@Transactional
public class usersService {

	@Autowired
	usersMapper user;
	
	
	public users queryByName(String name){
		return user.project_queryByName(name);
	}
	
	public users queryByIdCard(String card) {
		return user.queryByIdCard(card);
	}
}
