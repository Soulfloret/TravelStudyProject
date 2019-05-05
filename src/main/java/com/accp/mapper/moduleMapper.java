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
    
    
    List<module> queryModuleByUid(@Param("uid")Integer uid,@Param("id") Integer id);
    
    @MapKey("url")
    Map<String,module> queryModuleByUidToMap(@Param("uid") Integer uid);
    
    List<module> queryByridAll(@Param("rid") Integer uid);
    
    List<module> queryAll(Integer mid);
}