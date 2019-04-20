package com.accp.renyuxuan.service;

import java.util.List;

import com.accp.domain.orderson;

public interface ordersonservice {
	int insertSelective(orderson record);
	
	List<orderson> querytj(orderson o);
}
