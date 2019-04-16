package com.accp.renyuxuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.roomorder;
import com.accp.mapper.roomorderMapper;
import com.accp.renyuxuan.service.roomorderservice;

@Service
@Transactional
public class roomorderserviceimpl  implements roomorderservice{

	@Autowired
	roomorderMapper r;
	
	
	@Override
	public int insert(roomorder record) {
		// TODO Auto-generated method stub
		return r.insert(record);
	}


	@Override
	public int insertSelective(roomorder record) {
		// TODO Auto-generated method stub
		return r.insertSelective(record);
	}

}
