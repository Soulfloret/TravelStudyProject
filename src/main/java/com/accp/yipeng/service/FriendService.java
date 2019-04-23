package com.accp.yipeng.service;

import java.util.List;

import com.accp.domain.friend;
import com.accp.domain.friendExample;

public interface FriendService {
	
	public List<friend> queryAllFriend(Integer id,Integer did);

	 int deleteByPrimaryKey(Integer id);

	    int insert(friend record);

	    List<friend> selectByExample(friendExample example);

	    friend selectByPrimaryKey(Integer id);
	    int updateByPrimaryKey(friend record);
}
