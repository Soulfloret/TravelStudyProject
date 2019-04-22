package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Usermainorder;
import com.accp.mapper.UsermainorderMapper;
import com.accp.renyuxuan.service.Usermainorderservice;

@Service
@Transactional
public class Usermainorderserviceimpl implements Usermainorderservice{
	
	@Autowired
	UsermainorderMapper u;
	
	@Override
	public Usermainorder queryorderCustomer(Integer id,String lb) {
		// TODO Auto-generated method stub
		return u.queryorderCustomer(id ,lb);
	}

}
