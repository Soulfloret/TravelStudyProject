package com.accp.mapper;

import com.accp.domain.module;
import com.accp.domain.moduleExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

public interface moduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(module record);

    int insertSelective(module record);

    List<module> selectByExample(moduleExample example);

    module selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(module record);
    
    @MapKey("url")
    Map<String,module> queryMapByUid(@Param("uid")Integer uid);
}