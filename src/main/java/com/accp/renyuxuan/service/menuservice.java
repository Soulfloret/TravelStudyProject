package com.accp.renyuxuan.service;

import java.util.List;

import com.accp.domain.menu;

public interface menuservice {
	List<menu> QueryMenu(menu me);
	
	int updateByPrimaryKeySelective(menu record);
	
	int deleteByPrimaryKey(Integer id);
	
	int insertSelective(menu record);
}
