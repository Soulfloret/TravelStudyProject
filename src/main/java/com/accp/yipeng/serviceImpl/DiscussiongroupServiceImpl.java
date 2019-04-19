package com.accp.yipeng.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.discussiongroup;
import com.accp.domain.discussiongroupson;
import com.accp.domain.sendrequest;
import com.accp.domain.users;
import com.accp.mapper.discussiongroupMapper;
import com.accp.mapper.discussiongroupsonMapper;
import com.accp.mapper.friendMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.sendrequestMapper;
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
	@Autowired
	sendrequestMapper sendmapper;
	@Override
	public List<Object> query(String name,Integer Id) {
		List<Object> list=new ArrayList<Object>();
		List<users> list1=umapper.selectByUname(name,Id);
		List<sendrequest> list5=sendmapper.selectBydid(1, Id);
		for (users users : list1) {
			for (sendrequest sendrequest : list5) {
				if(sendrequest.getUid()==users.getId()) {
					users.setSendreq(sendrequest);
				}
			}
			users.setAge(AgeUtil.getage(users));			
		}
		List<discussiongroup> list2=dismapper.selectByname(name);
		List<Integer> list3=new ArrayList<Integer>();
		List<sendrequest> list6=sendmapper.selectBydid(2, Id);
		for (int i=0;i < list2.size();i++) {
			discussiongroup discussiongroup=list2.get(i);
			for (sendrequest sendrequest : list6) {
				if(sendrequest.getUid()==discussiongroup.getId()) {
					discussiongroup.setSendreq(sendrequest);
				}
			}
			discussiongroup.setImg(imgmapper.queryimg(discussiongroup.getId(), 8));
			discussiongroup.setCount(disSonmapper.selectCountBydid(discussiongroup.getId()));
			List<discussiongroupson> list4=disSonmapper.selectAllusersBydid(discussiongroup.getId());
			for (discussiongroupson discussiongroupson : list4) {
				if(discussiongroupson.getUserid()==Id) {
					list3.add(i);
				}
			}
		}
		for (int i = 0; i < list2.size(); i++) {
			for (int j = 0; j < list3.size(); j++) {
				int index=list3.get(j);
				list2.remove(index);
			}
		}
		list.add(list1);
		list.add(list2);
		return list;
	}
}
