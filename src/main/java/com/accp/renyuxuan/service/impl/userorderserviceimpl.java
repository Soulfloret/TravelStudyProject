package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.userorder;
import com.accp.mapper.userorderMapper;
import com.accp.renyuxuan.service.userorderservice;

@Service
@Transactional
public class userorderserviceimpl implements userorderservice{

	
	@Autowired
	userorderMapper u;
	
	@Override
	public userorder selectByuid(Integer id) {
		// TODO Auto-generated method stub
		return u.selectByuid(id);
	}

	@Override
	public List<userorder> selectByuidinlist(Integer id) {
		// TODO Auto-generated method stub
		return u.selectByuidinlist(id);
	}

}
