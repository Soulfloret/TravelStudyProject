package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.menutype;
import com.accp.domain.menutypeExample;
import com.accp.mapper.menutypeMapper;
import com.accp.renyuxuan.service.menuTypeservice;

@Service
@Transactional
public class menuTypeserviceimpl implements menuTypeservice{

	@Autowired
	menutypeMapper m;
	
	@Override
	public List<menutype> selectByExample(menutypeExample example) {
		// TODO Auto-generated method stub
		return m.selectByExample(example);
	}

	@Override
	public List<menutype> selectqueryTypemenu(menutype ms) {
		// TODO Auto-generated method stub
		return m.selectqueryTypemenu(ms);
	}
	
}
