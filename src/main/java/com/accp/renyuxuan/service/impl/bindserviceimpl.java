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
	bindMapper bb;
	
	
	@Override
	public List<bind> querybind(bind bi) {
		// TODO Auto-generated method stub
		return bb.querybind(bi);
	}


	@Override
	public int updateByPrimaryKeySelective(bind record) {
		// TODO Auto-generated method stub
		return bb.updateByPrimaryKeySelective(record);
	}


	@Override
	public int insertmenubind(bind bi) {
		// TODO Auto-generated method stub
		return bb.insertmenubind(bi);
	}


	@Override
	public int insert(bind record) {
		// TODO Auto-generated method stub
		return bb.insert(record);
	}


	@Override
	public List<bind> selectbindByid(Integer id) {
		// TODO Auto-generated method stub
		return bb.selectbindByid(id);
	}


	@Override
	public List<bind> querybindQt(bind bi) {
		// TODO Auto-generated method stub
		return bb.querybindQt(bi);
	}


	
}
