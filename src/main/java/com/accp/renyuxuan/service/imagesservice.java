package com.accp.renyuxuan.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.bind;
import com.accp.domain.images;
import com.accp.domain.menu;
import com.accp.domain.room;

public interface imagesservice {
	
	int insertbingimglist(bind b);
	
	int insertmenuimglist(menu m);
	
	int deleteByiid(Integer id);
	
	int delByiidAndTypeId(Integer iid,Integer typeid);
	
	int insertroomimglist(room r);
	
	List<images> queryimg(Integer iid,Integer typeid);
}
