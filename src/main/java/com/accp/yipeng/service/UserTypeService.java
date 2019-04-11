package com.accp.yipeng.service;

import java.util.List;

import com.accp.domain.usertype;
import com.accp.domain.usertypeExample;

public interface UserTypeService {

    int deleteByPrimaryKey(Integer id);

    int insert(usertype record);
    
    List<usertype> selectByExample(usertypeExample example);

    usertype selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(usertype record);

}
