package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.menuorder;
import com.accp.mapper.menuorderMapper;
import com.accp.renyuxuan.service.menuorderservice;

@Service
@Transactional
public class menuorderserviceimpl implements menuorderservice{

	@Autowired
	menuorderMapper m;
	
	@Override
	public int insertSelective(menuorder record) {
		// TODO Auto-generated method stub
		return m.insertSelective(record);
	}

}
