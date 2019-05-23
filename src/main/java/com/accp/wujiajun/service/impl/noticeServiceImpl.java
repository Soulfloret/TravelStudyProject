package com.accp.wujiajun.service.impl;

import java.util.List;

import com.accp.domain.Notice;
import com.accp.domain.images;

public interface noticeServiceImpl {

	int noticeInsert(Notice noti);
	
	List<Notice> noticeQuery(Integer postionid);
	
	int insert(images imgs);
	
	int noticeImages(Notice noti);
}
