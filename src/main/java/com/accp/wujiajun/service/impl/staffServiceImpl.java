package com.accp.wujiajun.service.impl;

import java.util.List;

import com.accp.domain.staff;
import com.accp.domain.staffExample;

public interface staffServiceImpl {
	List<staff> query(staff sta);
	
	staff queryById(Integer id);
	
	List<staff> queryLike(staff sta);

}