package com.accp.mapper;

import com.accp.domain.projectpl;
import com.accp.domain.projectplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface projectplMapper {
    int countByExample(projectplExample example);

    int deleteByExample(projectplExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(projectpl record);

    int insertSelective(projectpl record);

    List<projectpl> selectByExample(projectplExample example);

    projectpl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") projectpl record, @Param("example") projectplExample example);

    int updateByExample(@Param("record") projectpl record, @Param("example") projectplExample example);

    int updateByPrimaryKeySelective(projectpl record);

    int updateByPrimaryKey(projectpl record);
}