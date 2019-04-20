package com.accp.sunhuihui.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.actionimages;
import com.accp.domain.stopfcomment;
import com.accp.domain.users;
import com.accp.mapper.actionimagesMapper;
import com.accp.mapper.usersMapper;

@Service
public class UserService {

		@Autowired
		usersMapper mapper;
		@Autowired
		actionimagesMapper amapper;
		
	public users queryByName(@Param("uname")String uname,@Param("upassword")String upassword) {
		return mapper.queryByName(uname, upassword);
	}
	
	public List<actionimages> query(){
		
		return amapper.query();
	}
	
	public users userByid(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
}
