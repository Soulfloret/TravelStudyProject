package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.usertype;
import com.accp.domain.usertypeExample;
import com.accp.mapper.usertypeMapper;
import com.accp.yipeng.service.UserTypeService;

@Service
@Transactional
public class UserTypeServiceImpl implements UserTypeService{

	@Autowired
	usertypeMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(usertype record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<usertype> selectByExample(usertypeExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public usertype selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(usertype record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}
	
}
