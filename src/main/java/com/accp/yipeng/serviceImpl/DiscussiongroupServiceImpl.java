package com.accp.yipeng.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.discussiongroup;
import com.accp.domain.friend;
import com.accp.domain.users;
import com.accp.mapper.discussiongroupMapper;
import com.accp.mapper.discussiongroupsonMapper;
import com.accp.mapper.friendMapper;
import com.accp.mapper.imagesMapper;
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
	@Autowired
	imagesMapper imgmapper;
	@Autowired
	discussiongroupsonMapper disSonmapper;
	@Autowired
	friendMapper frmapper;
	@Override
	public List<Object> query(String name,Integer Id) {
		List<Object> list=new ArrayList<Object>();
		List<users> list1=umapper.selectByUname(name);
		List<friend> list3=frmapper.queryAllFriend(Id);
		for (int i = 0; i < list1.size(); i++) {
			int index=0;
			users users=list1.get(i);
			users.setAge(AgeUtil.getage(users));
			if(users.getId()==Id) {
				list1.remove(i);
			}else {
				for (friend friend : list3) {
					if (friend.getFid()==users.getId()) {
						index=i;
					}else if(friend.getUid()==users.getId()){
						index=i;
					}
				}
				if(index!=0) {
					list1.remove(index);
				}
			}
		}
		
		
		
		List<discussiongroup> list2=dismapper.selectByname(name);
		for (discussiongroup discussiongroup : list2) {
			discussiongroup.setImg(imgmapper.queryimg(discussiongroup.getId(), 8));
			discussiongroup.setCount(disSonmapper.selectCountBydid(discussiongroup.getId()));
		}
		list.add(list1);
		//list.add(list2);
		return list;
	}
}
