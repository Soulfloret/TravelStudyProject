package com.accp.chenyong.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.accp.chenyong.service.ModuleService;
import com.accp.domain.module;
import com.accp.domain.moduleExample;
import com.accp.mapper.moduleMapper;

public class ModuleServiceImpl implements ModuleService{
	@Autowired
	moduleMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(module record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(module record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public List<module> selectByExample(moduleExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public module selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(module record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Map<String, module> queryMapByUid(Integer uid) {
		// TODO Auto-generated method stub
		return mapper.queryMapByUid(uid);
	}

}
