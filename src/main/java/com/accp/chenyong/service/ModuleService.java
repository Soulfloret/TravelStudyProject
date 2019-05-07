package com.accp.chenyong.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.module;
import com.accp.domain.moduleExample;

public interface ModuleService {
	int deleteByPrimaryKey(Integer id);

    int insert(module record);

    int insertSelective(module record);

    List<module> selectByExample(moduleExample example);

    module selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(module record);
    
    Map<String,module> queryModuleByUidToMap(@Param("uid")Integer uid);
    
    List<module> queryModuleByUid(@Param("uid")Integer uid,@Param("id") Integer id);
    
    List<module> queryByridAll( Integer uid);
    
    List<module> queryAll(Integer mid);


}
