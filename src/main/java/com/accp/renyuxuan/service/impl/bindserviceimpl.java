package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.bind;
import com.accp.mapper.bindMapper;
import com.accp.renyuxuan.service.bindservice;

@Service
@Transactional
public class bindserviceimpl implements bindservice{

	@Autowired
	bindMapper b;
	
	
	@Override
	public List<bind> querybind(bind bi) {
		// TODO Auto-generated method stub
		return b.querybind(bi);
	}


	@Override
	public int updateByPrimaryKeySelective(bind record) {
		// TODO Auto-generated method stub
		return b.updateByPrimaryKeySelective(record);
	}


	@Override
	public int insertmenubind(bind bi) {
		// TODO Auto-generated method stub
		return b.insertmenubind(bi);
	}


	@Override
	public int insert(bind record) {
		// TODO Auto-generated method stub
		return b.insert(record);
	}


	@Override
	public List<bind> selectbindByid(Integer id) {
		// TODO Auto-generated method stub
		return b.selectbindByid(id);
	}
	
}
