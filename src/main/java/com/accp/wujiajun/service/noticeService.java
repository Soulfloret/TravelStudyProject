package com.accp.wujiajun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Notice;
import com.accp.mapper.NoticeMapper;
import com.accp.wujiajun.service.impl.noticeServiceImpl;

@Service
@Transactional
public class noticeService implements noticeServiceImpl{

	@Autowired
	NoticeMapper mapper;

	@Override
	public Notice noticeQuery(Integer postionid) {
		// TODO Auto-generated method stub
		return mapper.noticeQuery(postionid);
	}

	@Override
	public int noticeInsert(Notice record) {
		// TODO Auto-generated method stub
		return mapper.noticeInsert(record);
	}
	
	
}
