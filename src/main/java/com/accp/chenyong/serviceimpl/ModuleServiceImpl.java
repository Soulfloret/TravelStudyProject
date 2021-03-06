package com.accp.chenyong.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.ModuleService;
import com.accp.domain.module;
import com.accp.domain.moduleExample;
import com.accp.mapper.moduleMapper;
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	moduleMapper mapper;
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(module record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	public int insertSelective(module record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	public List<module> selectByExample(moduleExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

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
