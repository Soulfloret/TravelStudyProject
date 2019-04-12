package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.mapper.menubindMapper;
import com.accp.renyuxuan.service.menubindservice;

@Service
@Transactional
public class menubindserviceimpl implements menubindservice{

	@Autowired
	menubindMapper me;
	
	@Override
	public int deleteBybindid(Integer id) {
		// TODO Auto-generated method stub
		return me.deleteBybindid(id);
	}

}
