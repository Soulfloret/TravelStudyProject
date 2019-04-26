package com.accp.wujiajun.service.impl;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.staff;

public interface accountsServiceImpl {

	staff accountsQuery(Integer id);
	
	int accountsUpdate(@Param("id") Integer id, @Param("name2") String name2);
}
