package com.accp.wujiajun.service.impl;

import com.accp.domain.Notice;

public interface noticeServiceImpl {

	int noticeInsert(Notice record);
	
	Notice noticeQuery(Integer postionid);
}
