package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.users;
import com.accp.domain.usersExample;
import com.accp.mapper.usersMapper;
import com.accp.yipeng.service.UsersService;

@Service
@Transactional
public class UserServiceImpl implements UsersService {
 
	@Autowired
	usersMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<users> selectAllUsers(String uname, Integer typeId) {
		// TODO Auto-generated method stub
		return mapper.selectAllUsers(uname, typeId);
	}

	@Override
	public int insert(users record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<users> selectByExample(usersExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public users query(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(users record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public users queryByIdCard(String idCardNo) {
		// TODO Auto-generated method stub
		return mapper.queryByIdCard(idCardNo);
	}

	@Override
	public int updateTypeIdById(Integer id, Integer typeId) {
		// TODO Auto-generated method stub
		return mapper.updateTypeIdById(id, typeId);
	}
	
}
