package com.accp.xiangjianbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Shopcart;
import com.accp.mapper.ShopcartMapper;

@Service
@Transactional
public class shopcartService {

	@Autowired
	ShopcartMapper shopmapper;
	
	
	public int insert(Shopcart record) {
		return shopmapper.insert(record);
	}
}
