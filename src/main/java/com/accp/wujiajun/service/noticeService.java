package com.accp.wujiajun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Notice;
import com.accp.domain.images;
import com.accp.mapper.NoticeMapper;
import com.accp.mapper.imagesMapper;
import com.accp.wujiajun.service.impl.noticeServiceImpl;

@Service
@Transactional
public class noticeService implements noticeServiceImpl {

	@Autowired
	NoticeMapper mapper;

	@Autowired
	imagesMapper imapper;

	@Override
	public List<Notice> noticeQuery(Integer postionid) {
		// TODO Auto-generated method stub
		return mapper.noticeQuery(postionid);
	}

	@Override
	public int noticeInsert(Notice noti) {
		// TODO Auto-generated method stub
		return mapper.noticeInsert(noti);
	}
	
	

	@Override
	public int insert(images imgs) {
		// TODO Auto-generated method stub
		int i = mapper.insert(imgs.getNoti());
		imgs.setIid(imgs.getNoti().getId());
		i += imapper.insert(imgs);
		return i;
	}

	@Override
	public int noticeImages(Notice noti) {
		// TODO Auto-generated method stub
		return mapper.noticeImages(noti);
	}

}
