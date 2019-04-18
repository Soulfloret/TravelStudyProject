package com.accp.yipeng.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.discussiongroup;
import com.accp.domain.users;
import com.accp.mapper.discussiongroupMapper;
import com.accp.mapper.usersMapper;
import com.accp.yipeng.service.DiscussiongroupService;
import com.accp.yipeng.util.AgeUtil;

@Transactional
@Service
public class DiscussiongroupServiceImpl implements DiscussiongroupService{
	@Autowired
	usersMapper umapper;
	@Autowired
	discussiongroupMapper dismapper;
	
	@Override
	public List<Object> query(String name) {
		List<Object> list=new ArrayList<Object>();
		List<users> list1=umapper.selectByUname(name);
		for (users users : list1) {
			users.setAge(AgeUtil.getage(users));
		}
		List<discussiongroup> list2=dismapper.selectByname(name);
		list.add(list1);
		list.add(list2);
		return list;
	}
}
