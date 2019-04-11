package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.teammember;
import com.accp.domain.teammemberExample;
import com.accp.mapper.teammemberMapper;
import com.accp.yipeng.service.TeammemberService;

@Service
@Transactional
public class TeammemberServiceImpl implements TeammemberService{
	@Autowired
	teammemberMapper mapper;
	
	@Override
	public int insertBylist(Integer teamId, List<Integer> list) {
		// TODO Auto-generated method stub
		return mapper.insertBylist(teamId, list);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(teammember record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<teammember> selectByExample(teammemberExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public teammember selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(teammember record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}
	
}
