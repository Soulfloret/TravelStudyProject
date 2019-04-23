package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.team;
import com.accp.mapper.teamMapper;
import com.accp.renyuxuan.service.teamservice;

@Service
@Transactional
public class teamserviceimpl implements teamservice{

	@Autowired
	teamMapper t;
	
	@Override
	public team selectBymainiUserId(Integer id) {
		// TODO Auto-generated method stub
		return t.selectBymainiUserId(id);
	}

}
