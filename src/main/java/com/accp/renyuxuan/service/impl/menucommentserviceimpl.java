package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.menucomment;
import com.accp.mapper.menucommentMapper;
import com.accp.renyuxuan.service.menucommentservice;

@Service
@Transactional
public class menucommentserviceimpl implements menucommentservice{

	@Autowired
	menucommentMapper me;
	
	@Override
	public List<menucomment> selectmenucommentByid(menucomment m) {
		// TODO Auto-generated method stub
		return me.selectmenucommentByid(m);
	}

}
