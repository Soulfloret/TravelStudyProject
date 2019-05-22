package com.accp.renyuxuan.service;

import java.util.Date;
import java.util.List;

import com.accp.domain.roomdestine;

public interface roomdestineservice {
	
	int insert(roomdestine record);
	
	int insertSelective(roomdestine record);
	
	int updateByPrimaryKeySelective(roomdestine record);
	
	List<roomdestine> selectByroomid(Integer id);
	
	List<roomdestine> selectByrdId(Integer id,Date time);
	
	int deleteByPrimaryKey(Integer id);
}
