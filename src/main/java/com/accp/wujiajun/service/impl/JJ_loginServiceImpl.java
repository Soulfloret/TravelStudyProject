package com.accp.wujiajun.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.users;
import com.accp.domain.usersExample;

public interface JJ_loginServiceImpl {

	users queryByName(@Param("uname")String uname,@Param("upassword")String upassword);
}
