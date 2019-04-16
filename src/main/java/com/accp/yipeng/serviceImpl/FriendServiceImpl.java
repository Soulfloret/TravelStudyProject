package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.dynamics;
import com.accp.domain.friend;
import com.accp.domain.friendExample;
import com.accp.mapper.dynamicsMapper;
import com.accp.mapper.friendMapper;
import com.accp.mapper.usersMapper;
import com.accp.yipeng.service.FriendService;

@Service
@Transactional
public class FriendServiceImpl  implements  FriendService{
	@Autowired
	usersMapper usemapper;
	@Autowired
	friendMapper mapper;
	@Autowired
	dynamicsMapper dynamapper;
	@Override
	public List<friend> queryAllFriend(Integer id) {
		List<friend> list=mapper.queryAllFriend(id);
		for (friend friend : list) {
			if(friend.getUid()==id) {
				friend.setUse(usemapper.selectByPrimaryKey(friend.getFid()));
				friend.setDynamic(dynamapper.queryLastById(friend.getFid()));
			}else {
				friend.setUse(usemapper.selectByPrimaryKey(friend.getUid()));
				friend.setDynamic(dynamapper.queryLastById(friend.getUid()));
			}
		}
		
		return list;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(friend record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<friend> selectByExample(friendExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public friend selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(friend record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}
	
}
