package com.accp.yipeng.serviceImpl;



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
import com.accp.mapper.dynamicsMapper;
import com.accp.mapper.sendrequestMapper;
import com.accp.mapper.usersMapper;
import com.accp.yipeng.service.DiscussiongroupSonService;

@Transactional
@Service
public class DiscussiongroupSonServiceImpl implements  DiscussiongroupSonService{
	@Autowired
	discussiongroupsonMapper mapper;
	@Autowired
	discussiongroupMapper dmapper;
	@Autowired
	usersMapper umapper;
	@Autowired
	dynamicsMapper dynamapper;
	@Autowired
	sendrequestMapper sendmapper;
	
	@Override
	public int insert(discussiongroupson record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int selectCountBydid(Integer did) {
		// TODO Auto-generated method stub
		return mapper.selectCountBydid(did);
	}

	@Override
	public List<discussiongroupson> selectAllusersBydid(Integer did) {
		List<discussiongroupson> list=mapper.selectAllusersBydid(did);
		for (discussiongroupson discussiongroupson : list) {
			users use=umapper.selectByPrimaryKey(discussiongroupson.getUserid());
			use.setDynamic(dynamapper.queryLastById(use.getId()));
			discussiongroupson.setUse(use);
		}
		return list;
	}

	@Override
	public int delByarray(Integer did, Integer[] ids) {
		int i=mapper.delByarray(did, ids);
		for (int j = 0; j < ids.length; j++) {
			i=sendmapper.delBytypeIdAnduidAnddid(3, did, ids[j]);
		}
		return i;
	}

	@Override
	public int insertByarray(Integer did, Integer[] ids) {
		int i=0;
		 discussiongroup record=dmapper.selectByPrimaryKey(did);
		for (int j = 0; j < ids.length; j++) {
			users use=umapper.selectByPrimaryKey(ids[j]);
			i=sendmapper.insert(new sendrequest(ids[j], did, 3, "等待同意", "邀请"+use.getUname()+"加入"+record.getGroupname()));
		}
		return i;
	}

	@Override
	public int delByuidAndDid(Integer did, Integer uid) {
		// TODO Auto-generated method stub
		return mapper.delByuidAndDid(did, uid);
	}

	
}
