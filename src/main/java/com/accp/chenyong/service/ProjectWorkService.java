package com.accp.chenyong.service;

import java.util.List;

import com.accp.domain.project;
import com.accp.domain.projectExample;

public interface ProjectWorkService {

    int deleteByPrimaryKey(Integer id);

    int insert(project record);

    int insertSelective(project record);

    List<project> selectByExample(projectExample example);

    project selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(project record);
    
    /*查询所有*/
    List<project> queryAll(project pro);
    
}
