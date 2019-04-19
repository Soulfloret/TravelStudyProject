package com.accp.sunhuihui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.comments;
import com.accp.domain.dynamics;
import com.accp.domain.dynamicstopf;
import com.accp.domain.images;
import com.accp.domain.reply;
import com.accp.domain.stopfcomment;
import com.accp.domain.users;
import com.accp.mapper.commentsMapper;
import com.accp.mapper.dynamicsMapper;
import com.accp.mapper.dynamicstopfMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.replyMapper;
import com.accp.mapper.stopfcommentMapper;
import com.accp.mapper.usersMapper;
import com.alibaba.fastjson.JSON;
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
		@Autowired
		dynamicstopfMapper stmapper;
		@Autowired
		stopfcommentMapper stcmapper;
		
		/**
		 * 查询全部动态
		 * @param currentPage
		 * @param pageSize
		 * @param typeid
		 * @return
		 */
		public PageInfo<dynamics> query(Integer currentPage,Integer pageSize,Integer typeid,Integer uid){
			//PageHelper.startPage(currentPage, pageSize, true);
				List<dynamics> list=mapper.selectByExample(null);
				PageInfo<dynamics> page=new PageInfo<dynamics>(list);
				for (dynamics d : list) {
					List<images> img=imapper.queryimg(d.getId(), 6);
					users u=umapper.selectByPrimaryKey(d.getUid());
					d.setDzcountdt(stmapper.dzcountdt(d.getId(),uid));
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
		public dynamics queryByid(Integer id,Integer uidd){
			dynamics dynamic=mapper.queryByid(id);
			List<comments> comme=cmapper.query(dynamic.getId(),uidd);
			for (comments c : comme) {
				c.setDzcount(cmapper.dzcounts(c.getId(),uidd));
			}
			dynamic.setImg(imapper.queryimg(dynamic.getId(),6));
			users u=umapper.selectByPrimaryKey(dynamic.getUid());	
			dynamic.setDzcountdt(stmapper.dzcountdt(id, uidd));
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
		 * 新增动态点赞
		 * @param reply
		 * @return
		 */
		public int dynamicstopfadd(dynamicstopf dy) {
			dynamicstopf s=stmapper.queryByRid(dy.getRid(), dy.getUid());
			if(s!=null) {
				int i=stmapper.deleteByPrimaryKey(s.getId());
				return 0;
			}else {
				int i=stmapper.insertSelective(dy);
				return i;
			}
		}
		
		/**
		 * 新增评论点赞
		 * @param reply
		 * @return
		 */
		public int stopfcommentadd(stopfcomment stop) {
			stopfcomment s=stcmapper.queryByCid(stop.getCid(), stop.getUidd());
			if(s!=null) {
				int i=stcmapper.deleteByPrimaryKey(s.getId());
				return 0;
			}else {
				int i=stcmapper.insertSelective(stop);
				return i;
			}
			
		}
		
		/**
		 * 新增回复
		 * @param reply
		 * @return
		 */
		public int replyadd(reply reply) {
			return rmapper.insertSelective(reply);
		}
		
		/**
		 * 新增动态图片表
		 * @param dinameics
		 * @return
		 */
		public int insertimglist(dynamics dinameics) {
			int i=mapper.insertSelective(dinameics);
			imapper.insertimglist(dinameics);
			return 0;
		}
		
		/**
		 * 新增动态图片表
		 * @param dinameics
		 * @return
		 */
		public int insertimglist1(dynamics dinameics) {
			int i=mapper.insertSelective(dinameics);
			return i;
		}
}
