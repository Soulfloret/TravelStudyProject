package com.accp.mapper;

import com.accp.domain.module;
import com.accp.domain.moduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface moduleMapper {
    int countByExample(moduleExample example);

    int deleteByExample(moduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(module record);

    int insertSelective(module record);

    List<module> selectByExample(moduleExample example);

    module selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") module record, @Param("example") moduleExample example);

    int updateByExample(@Param("record") module record, @Param("example") moduleExample example);

    int updateByPrimaryKeySelective(module record);

    int updateByPrimaryKey(module record);
}