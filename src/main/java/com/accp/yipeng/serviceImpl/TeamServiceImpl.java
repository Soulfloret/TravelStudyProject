package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.team;
import com.accp.domain.teamExample;
import com.accp.mapper.teamMapper;
import com.accp.yipeng.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	@Autowired
	teamMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(team record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<team> selectByExample(teamExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public team selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(team record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<team> selectAllTeam(String uname, String tname) {
		// TODO Auto-generated method stub
		return mapper.selectAllTeam(uname, tname);
	}
	
}
