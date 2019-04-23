package com.accp.yipeng.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.discussiongroupson;
import com.accp.domain.users;
import com.accp.mapper.discussiongroupsonMapper;
import com.accp.mapper.dynamicsMapper;
import com.accp.mapper.usersMapper;
import com.accp.yipeng.service.DiscussiongroupSonService;

@Transactional
@Service
public class DiscussiongroupSonServiceImpl implements  DiscussiongroupSonService{
	@Autowired
	discussiongroupsonMapper mapper;
	@Autowired
	usersMapper umapper;
	@Autowired
	dynamicsMapper dynamapper;
	
	@Override
	public int insert(discussiongroupson record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int selectCountBydid(Integer did) {
		// TODO Auto-generated method stub
		return mapper.selectCountBydid(did);
	}

	@Override
	public List<discussiongroupson> selectAllusersBydid(Integer did) {
		List<discussiongroupson> list=mapper.selectAllusersBydid(did);
		for (discussiongroupson discussiongroupson : list) {
			users use=umapper.selectByPrimaryKey(discussiongroupson.getUserid());
			use.setDynamic(dynamapper.queryLastById(use.getId()));
			discussiongroupson.setUse(use);
		}
		return list;
	}

	@Override
	public int delByarray(Integer did, Integer[] ids) {
		return mapper.delByarray(did, ids);
	}

	@Override
	public int insertByarray(Integer did, Integer[] ids) {
		// TODO Auto-generated method stub
		return mapper.insertByarray(did, ids);
	}

	@Override
	public int delByuidAndDid(Integer did, Integer uid) {
		// TODO Auto-generated method stub
		return mapper.delByuidAndDid(did, uid);
	}

	
}
