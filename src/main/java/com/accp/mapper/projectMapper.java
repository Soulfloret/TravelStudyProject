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
    
    List<project> queryAll(project pro);
    
    List<project> queryByProjectId(Integer id);
    
    List<project> queryprojectAll(project project);
    
    recommend recommendByidproject(@Param("id")Integer id);
}