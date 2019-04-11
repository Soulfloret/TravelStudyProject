package com.accp.sunhuihui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.comments;
import com.accp.domain.dynamics;
import com.accp.domain.images;
import com.accp.domain.reply;
import com.accp.domain.users;
import com.accp.mapper.commentsMapper;
import com.accp.mapper.dynamicsMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.replyMapper;
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
		@Autowired
		replyMapper rmapper;
		
		/**
		 * 查询全部动态
		 * @param currentPage
		 * @param pageSize
		 * @param typeid
		 * @return
		 */
		public PageInfo<dynamics> query(Integer currentPage,Integer pageSize,Integer typeid){
			PageHelper.startPage(currentPage, pageSize, true);
				List<dynamics> list=mapper.selectByExample(null);
				PageInfo<dynamics> page=new PageInfo<dynamics>(list);
				for (dynamics d : list) {
					List<images> img=imapper.queryimg(d.getId(), typeid);
					users u=umapper.selectByPrimaryKey(d.getUid());
					d.setUser(u);
					d.setImg(img);
				}
			return page;
		}
		/**
		 * 根据id查询单个动态
		 * @param id
		 * @return
		 */
		public dynamics queryByid(Integer id){
			dynamics dynamic=mapper.queryByid(id);
			List<comments> comme=cmapper.query(dynamic.getId());
			dynamic.setImg(imapper.queryimg(dynamic.getId(),3));
			users u=umapper.selectByPrimaryKey(dynamic.getUid());
			dynamic.setComment(comme);
			dynamic.setUser(u);
			return dynamic;
		}
		
		/**
		 *新增评论
		 */
		public int commentadd(comments comm) {
			
			return cmapper.insertSelective(comm);
		}
		
		/**
		 * 新增回复
		 * @param reply
		 * @return
		 */
		public int replyadd(reply reply) {
			return rmapper.insertSelective(reply);
		}
}
