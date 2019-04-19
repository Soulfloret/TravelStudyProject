package com.accp.mapper;

import com.accp.domain.project;
import com.accp.domain.projectExample;
import com.accp.domain.recommend;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface projectMapper {
    int countByExample(projectExample example);

    int deleteByExample(projectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(project record);

    int insertSelective(project record);

    List<project> selectByExample(projectExample example);

    project selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") project record, @Param("example") projectExample example);

    int updateByExample(@Param("record") project record, @Param("example") projectExample example);

    int updateByPrimaryKeySelective(project record);

    int updateByPrimaryKey(project record);
    
    /*查询所有*/
    List<project> queryAll(project pro);
    
    /*活动查询项目*/
    List<project> queryByProjectId(Integer id);
    
    /*查询项目详情*/
    project projectXq_queryById(Integer id);
    
    recommend recommendByidproject(@Param("id")Integer id);
    
    List<project> queryprojectAll(project project);
    
    List<project> queryprojectproductproject(@Param("id")Integer id);
}