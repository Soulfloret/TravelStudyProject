package com.accp.chenyong.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.UserRoleService;
import com.accp.domain.userrole;
import com.accp.domain.userroleExample;
import com.accp.mapper.userroleMapper;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	userroleMapper mapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(userrole record) {
		int num=mapper.delByUserId(record.getUserid());
		num=mapper.insert(record);
		return num;
	}

	@Override
	public int insertSelective(userrole record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public List<userrole> selectByExample(userroleExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public userrole selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(userrole record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(userrole record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public userrole queryByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return mapper.queryByUserId(userid);
	}

}
