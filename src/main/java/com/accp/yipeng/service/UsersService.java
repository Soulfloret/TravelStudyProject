package com.accp.yipeng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.users;
import com.accp.domain.usersExample;

public interface UsersService {
    int deleteByPrimaryKey(Integer id);
	public users queryByIdCard(String idCardNo);
	public int updateTypeIdById( Integer id,  Integer typeId);

 
	public List<users> selectAllUsers( String uname, Integer typeId);

    int insert(users record);
    
    List<users> selectByExample(usersExample example);

    users query(Integer id);
    
    int updateByPrimaryKey(users record);

}
