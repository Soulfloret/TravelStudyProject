package com.accp.renyuxuan.service;

import java.util.List;

import com.accp.domain.roomdestine;

public interface roomdestineservice {
	
	int insert(roomdestine record);
	
	int insertSelective(roomdestine record);
	
	List<roomdestine> selectByroomid(Integer id);
}
