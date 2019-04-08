package com.accp.sunhuihui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.comments;
import com.accp.domain.dynamics;
import com.accp.domain.images;
import com.accp.domain.users;
import com.accp.mapper.commentsMapper;
import com.accp.mapper.dynamicsMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.usersMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DynamicService {
	
		@Autowired
		dynamicsMapper mapper;
		@Autowired
		imagesMapper imapper;
		@Autowired
		usersMapper umapper;
		@Autowired
		commentsMapper cmapper;
	
		public PageInfo<dynamics> query(Integer currentPage,Integer pageSize,Integer typeid){
			PageHelper.startPage(currentPage, pageSize, true);
				List<dynamics> list=mapper.selectByExample(null);
				PageInfo<dynamics> page=new PageInfo<dynamics>(list);
				for (dynamics d : list) {
					List<images> img=imapper.queryimg(d.getId(), typeid);
					users u=umapper.query(d.getUid());
					d.setUser(u);
					d.setImg(img);
				}
			return page;
		}
		
		public dynamics queryByid(Integer id){
			dynamics dynamic=mapper.queryByid(id);
			List<comments> comme=cmapper.query(dynamic.getId());
			users u=umapper.query(dynamic.getUid());
			dynamic.setComment(comme);
			dynamic.setUser(u);
			return dynamic;
		}
	
}
