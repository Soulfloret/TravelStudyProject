package com.accp.yipeng.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.discussiongroup;
import com.accp.domain.sendrequest;
import com.accp.domain.users;
import com.accp.mapper.discussiongroupMapper;
import com.accp.mapper.imagesMapper;
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
	@Autowired
	imagesMapper imgmapper;
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
		//list1.add(list3);
		//list1.add(list4);
		List<Object> list2=new ArrayList<Object>();
		//请求发送人为当前登录用户
		List<sendrequest> list5=mapper.selectBydid(2, uid);
		for (sendrequest sendrequest : list5) {
			discussiongroup dis=dmapper.selectByPrimaryKey(sendrequest.getUid());
			dis.setImg(imgmapper.queryimg(dis.getId(), 8));
			sendrequest.setDis(dis);
		}
		List<sendrequest> list6=mapper.selectDisByuid(2, uid);
		for (sendrequest sendrequest : list6) {
			sendrequest.setUse(umapper.selectByPrimaryKey(sendrequest.getDid()));
			sendrequest.getDis().setImg(imgmapper.queryimg(sendrequest.getDis().getId(), 8));
		}
		List<sendrequest> list7=mapper.selectDisByTypeIdAnduid(uid);
		for (sendrequest sendrequest : list7) {
			sendrequest.setUse(umapper.selectByPrimaryKey(sendrequest.getUid()));
			sendrequest.getDis().setImg(imgmapper.queryimg(sendrequest.getDis().getId(), 8));
		}
		List<sendrequest> list8=mapper.selectByuid(3, uid);
		for (sendrequest sendrequest : list8) {
			sendrequest.setUse(umapper.selectByPrimaryKey(sendrequest.getUid()));
			discussiongroup dis=dmapper.selectByPrimaryKey(sendrequest.getDid());
			dis.setImg(imgmapper.queryimg(dis.getId(), 8));
			sendrequest.setDis(dis);
		}
		list2.add(list5);
		list2.add(list6);
		list2.add(list7);
		list2.add(list8);
		list.add(list1);
		list.add(list2);
		return list;
	}
	@Override
	public int updateStatusById(String status, Integer id) {
		// TODO Auto-generated method stub
		return mapper.updateStatusById(status, id);
	}
	@Override
	public int insert(sendrequest record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}
	

	
}
