package com.accp.yipeng.service;

import java.util.List;

import com.accp.domain.discussiongroup;
import com.accp.domain.images;

public interface DiscussiongroupService {
    
    //模糊查询 查用户 或讨论组
    discussiongroup selectByPrimaryKey(Integer id);
    List<Object> query(String name,Integer Id);
    int add(discussiongroup record,String  ids,List<images> list);
	public List<discussiongroup> selectAllDiscussionGroup(Integer uid);
	public discussiongroup queryById(Integer did) ;
	public discussiongroup query(Integer did) ;
	public int updateDisName(discussiongroup dis);
    int deleteByPrimaryKey(Integer id);
    int delDis(int did,int uid,int typeId);
}
