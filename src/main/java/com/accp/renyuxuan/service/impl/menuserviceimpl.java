package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.menu;
import com.accp.mapper.menuMapper;
import com.accp.renyuxuan.service.menuservice;

@Service
@Transactional
public class menuserviceimpl implements menuservice{

	@Autowired
	menuMapper m;
	
	@Override
	public List<menu> QueryMenu(menu me) {
		return m.QueryMenu(me);
	}

	@Override
	public int updateByPrimaryKeySelective(menu record) {
		// TODO Auto-generated method stub
		return m.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return m.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(menu record) {
		// TODO Auto-generated method stub
		return m.insertSelective(record);
	}

}
