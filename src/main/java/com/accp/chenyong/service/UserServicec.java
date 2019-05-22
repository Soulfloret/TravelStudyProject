package com.accp.chenyong.service;

import java.util.List;

import com.accp.domain.team;
import com.accp.domain.users;

public interface UserServicec {
	 
	 users queryByIdCard(String idCardNo);
	
	 List<users> selectBymainiUserId(Integer id,Integer sid);
}
