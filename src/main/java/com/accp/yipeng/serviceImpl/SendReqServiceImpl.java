package com.accp.yipeng.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.sendrequest;
import com.accp.domain.users;
import com.accp.mapper.discussiongroupMapper;
import com.accp.mapper.sendrequestMapper;
import com.accp.mapper.usersMapper;
import com.accp.yipeng.service.SendReqService;
import com.accp.yipeng.util.AgeUtil;

@Service
@Transactional
public class SendReqServiceImpl  implements SendReqService{
	@Autowired
	sendrequestMapper mapper;
	@Autowired
	usersMapper umapper;
	@Autowired
	discussiongroupMapper dmapper;
	@Override
	public List<Object> query(Integer uid) {
		List<Object> list=new ArrayList<Object>();
		
		List<sendrequest> list3=mapper.selectBydid(1, uid);
		for (sendrequest sendrequest : list3) {
			users u=umapper.selectByPrimaryKey(sendrequest.getUid());
			u.setAge(AgeUtil.getage(u));
			sendrequest.setUse(u);
		}
		List<sendrequest> list4=mapper.selectByuid(1, uid);
		for (sendrequest sendrequest : list4) {
			users u=umapper.selectByPrimaryKey(sendrequest.getDid());
			u.setAge(AgeUtil.getage(u));
			sendrequest.setUse(u);
		}
		List<Object> list1=new ArrayList<Object>();
		list1.add(list3);
		list1.add(list4);
		List<Object> list2=new ArrayList<Object>();
		List<sendrequest> list5=mapper.selectBydid(2, uid);
		for (sendrequest sendrequest : list5) {
			sendrequest.setDis(dmapper.selectByPrimaryKey(sendrequest.getUid()));
		}
		list2.add(list5);
		list.add(list1);
		//list.add(list2);
		return list;
	}
	
}
