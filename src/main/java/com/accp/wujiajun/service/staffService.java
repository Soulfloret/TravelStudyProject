package com.accp.wujiajun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.signin;
import com.accp.domain.staff;
import com.accp.domain.staffExample;
import com.accp.mapper.positionsMapper;
import com.accp.mapper.signinMapper;
import com.accp.mapper.staffMapper;
import com.accp.mapper.usersMapper;
import com.accp.wujiajun.service.impl.staffServiceImpl;

@Service
public class staffService implements staffServiceImpl{
	
	@Autowired
	staffMapper mapper;

	@Autowired
	usersMapper umapper;
	
	@Autowired
	signinMapper smapper;
	
	
	@Override
	public List<staff> query(staff sta) {
		// TODO Auto-generated method stub
		return mapper.query(sta);
	}

	@Override
	public staff queryById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.queryById(id);
	}

	@Override
	public List<staff> queryLike(staff sta) {
		// TODO Auto-generated method stub
		return mapper.queryLike(sta);
	}

	@Override
	public int insert(staff sta) {
		// TODO Auto-generated method stub
		int i=umapper.insert(sta.getUlist());
		sta.setUserid(sta.getUlist().getId());
		i+=mapper.insert(sta);
		return i;
	}

	@Override
	public List<staff> salaryQuery(staff sta) {
		// TODO Auto-generated method stub
		return mapper.salaryQuery(sta);
	}

	@Override
	public List<staff> salaryQueryId(Integer id) {
		// TODO Auto-generated method stub
		return mapper.salaryQueryId(id);
	}

	@Override
	public List<signin> signinQuery(Integer id) {
		// TODO Auto-generated method stub
		return smapper.signinQuery(id);
	}

	@Override
	public int staffupdate(staff sta) {
		// TODO Auto-generated method stub
		return mapper.staffupdate(sta);
	}

	@Override
	public staff loginByuserid(Integer userid) {
		staff s=mapper.loginByuserid(userid);
		s.setUser(umapper.selectByPrimaryKey(s.getUserid()));
		return s;
	}

	
	

}
