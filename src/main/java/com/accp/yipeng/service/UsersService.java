package com.accp.yipeng.service;

import java.util.List;


import com.accp.domain.users;
import com.accp.domain.usersExample;

public interface UsersService {
    int deleteByPrimaryKey(Integer id);
 
	public List<users> selectAllUsers( String uname, Integer typeId);

    int insert(users record);
    
    List<users> selectByExample(usersExample example);

    users query(Integer id);
    
    int updateByPrimaryKey(users record);

}
