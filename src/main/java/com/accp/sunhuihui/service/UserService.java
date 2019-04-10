package com.accp.sunhuihui.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.users;
import com.accp.mapper.usersMapper;

@Service
public class UserService {

		@Autowired
		usersMapper mapper;
		
	public users queryByName(@Param("uname")String uname,@Param("upassword")String upassword) {
		return mapper.queryByName(uname, upassword);
	}
}
