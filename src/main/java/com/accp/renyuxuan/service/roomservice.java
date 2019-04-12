package com.accp.renyuxuan.service;

import java.util.List;

import com.accp.domain.room;

public interface roomservice {
	
	List<room> queryByroom(room r);
	
	int insertSelective(room record);
	
	int updateByPrimaryKeySelective(room record);

}
