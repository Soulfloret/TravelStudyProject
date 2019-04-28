package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.friend;
import com.accp.domain.friendExample;
import com.accp.domain.users;
import com.accp.mapper.discussiongroupMapper;
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
	@Autowired
	discussiongroupMapper dismapper;
	
	@Override
	public List<friend> queryAllFriend(Integer id,Integer did) {
		List<friend> list=mapper.queryAllFriend(id);
		for (friend friend : list) {
			if(friend.getUid()==id) {
				users use=usemapper.selectByPrimaryKey(friend.getFid());
				if(did!=null) {
					use.setDis(dismapper.selectDisBysonUidAndDid(use.getId(), did));
				}
				use.setDynamic(dynamapper.queryLastById(use.getId()));
				friend.setUse(use);
			}else {
				users use=usemapper.selectByPrimaryKey(friend.getUid());
				if(did!=null) {
					use.setDis(dismapper.selectDisBysonUidAndDid(use.getId(), did));
				}
				use.setDynamic(dynamapper.queryLastById(use.getId()));
				friend.setUse(use);
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
