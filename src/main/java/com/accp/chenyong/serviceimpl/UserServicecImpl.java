package com.accp.chenyong.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.UserServicec;
import com.accp.domain.Usermainorder;
import com.accp.domain.team;
import com.accp.domain.teammember;
import com.accp.domain.users;
import com.accp.mapper.UsermainorderMapper;
import com.accp.mapper.teamMapper;
import com.accp.mapper.teammemberMapper;
import com.accp.mapper.usersMapper;

@Service
@Transactional
public class UserServicecImpl implements UserServicec{
	@Autowired
	usersMapper mapper; 
	@Autowired
	teamMapper mapper1;
	@Autowired
	teammemberMapper mapper2;
	@Autowired
	UsermainorderMapper mapper3;
	@Override
	public users queryByIdCard(String idCardNo) {
		return mapper.queryByIdCard(idCardNo);
	}
	@Override
	public List<users> selectBymainiUserId(Integer id) {
		// TODO Auto-generated method stub
		List<team> t=mapper1.queryByuid(id);
		team ts=new team();
		for (team team : t) {
			Usermainorder uo=new Usermainorder();
			uo.setOrdercustomer(team.getId());
			uo.setName1("正在进行中");
			uo.setName2("团队");
			uo=mapper3.QueryCunzai(uo);
			if(uo!=null){
				ts=team;
			}
		}
		List<users> list=new ArrayList<users>();
		for(teammember tm:mapper2.queryBytid(ts.getId())) {
			users s=mapper.selectByPrimaryKey(tm.getMemberid());
			list.add(s);
			s.setMuid(ts.getId());
		}
		return list;
	}
	
}
