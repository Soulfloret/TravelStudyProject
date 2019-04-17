package com.accp.yipeng.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.discussiongroupson;
import com.accp.mapper.discussiongroupsonMapper;
import com.accp.yipeng.service.DiscussiongroupSonService;

@Transactional
@Service
public class DiscussiongroupSonServiceImpl implements  DiscussiongroupSonService{
	@Autowired
	discussiongroupsonMapper mapper;

	@Override
	public int insert(discussiongroupson record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	
}
