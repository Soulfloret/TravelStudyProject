package com.accp.mapper;

import com.accp.domain.projecttype;
import com.accp.domain.projecttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface projecttypeMapper {
    int countByExample(projecttypeExample example);

    int deleteByExample(projecttypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(projecttype record);

    int insertSelective(projecttype record);

    List<projecttype> selectByExample(projecttypeExample example);

    projecttype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") projecttype record, @Param("example") projecttypeExample example);

    int updateByExample(@Param("record") projecttype record, @Param("example") projecttypeExample example);

    int updateByPrimaryKeySelective(projecttype record);

    int updateByPrimaryKey(projecttype record);
}