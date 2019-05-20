package com.accp.renyuxuan.service;

import java.util.List;

import com.accp.domain.bind;

public interface bindservice {
	
	List<bind> selectByQtTj();
	
	List<bind> querybindQt(bind bi);
	
	List<bind> selectbindByid(Integer id);
	
	List<bind> querybind(bind bi);
	
	int updateByPrimaryKeySelective(bind record);
	
	int insertmenubind(bind bi);
	
	int insert(bind record);
	
}
