package com.accp.renyuxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.bind;
import com.accp.domain.images;
import com.accp.domain.menu;
import com.accp.domain.room;
import com.accp.mapper.imagesMapper;
import com.accp.renyuxuan.service.imagesservice;

@Service
@Transactional
public class imagesserviceimpl implements imagesservice{

	@Autowired
	imagesMapper i;
	
	
	@Override
	public int insertmenuimglist(menu m) {
		// TODO Auto-generated method stub
		return i.insertmenuimglist(m);
	}


	@Override
	public int deleteByiid(Integer id) {
		// TODO Auto-generated method stub
		return i.deleteByiid(id);
	}


	@Override
	public int insertroomimglist(room r) {
		// TODO Auto-generated method stub
		return i.insertroomimglist(r);
	}


	@Override
	public List<images> queryimg(Integer iid, Integer typeid) {
		// TODO Auto-generated method stub
		return i.queryimg(iid, typeid);
	}


	@Override
	public int insertbingimglist(bind b) {
		// TODO Auto-generated method stub
		return i.insertbingimglist(b);
	}


	@Override
	public int delByiidAndTypeId(Integer iid, Integer typeid) {
		// TODO Auto-generated method stub
		return i.delByiidAndTypeId(iid, typeid);
	}

}
