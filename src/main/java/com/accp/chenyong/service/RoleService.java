package com.accp.chenyong.service;

import java.util.List;

import com.accp.domain.role;
import com.accp.domain.roleExample;

public interface RoleService {

    int deleteByPrimaryKey(Integer id);

    int insert(role record);

    int insertSelective(role record);

    List<role> selectByExample(roleExample example);

    role selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(role record);
    
    int updateByPrimaryKeySelective(role record);

}
