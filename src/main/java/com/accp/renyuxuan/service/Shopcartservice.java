package com.accp.renyuxuan.service;

import com.accp.domain.Shopcart;

public interface Shopcartservice {
	int insertSelective(Shopcart record);
	
	Shopcart selectshopcartByid(Shopcart s);
	
	int updateByPrimaryKeySelective(Shopcart record);
}
