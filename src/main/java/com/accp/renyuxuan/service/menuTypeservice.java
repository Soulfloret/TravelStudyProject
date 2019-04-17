package com.accp.renyuxuan.service;

import java.util.List;

import com.accp.domain.menutype;
import com.accp.domain.menutypeExample;

public interface menuTypeservice {
	List<menutype> selectByExample(menutypeExample example);
	
	List<menutype> selectqueryTypemenu(menutype m);
}
