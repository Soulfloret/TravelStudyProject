package com.accp.wujiajun.service.impl;

import java.util.List;

import com.accp.domain.staff;
import com.accp.domain.staffExample;

public interface staffServiceImpl {
	public List<staff> query(staff sta);
	
	public staff queryById(Integer id);

}
