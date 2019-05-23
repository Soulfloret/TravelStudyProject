package com.accp.wujiajun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.images;
import com.accp.mapper.imagesMapper;
import com.accp.wujiajun.service.impl.imagesserviceimpl;

@Service
@Transactional
public class imagesService implements imagesserviceimpl{

	@Autowired
	imagesMapper mapper;
	
	@Override
	public int insertSelective(images record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

}
