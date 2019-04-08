package com.accp.mapper;

import com.accp.domain.dynamics;
import com.accp.domain.dynamicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface dynamicsMapper {
    int countByExample(dynamicsExample example);

    int deleteByExample(dynamicsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(dynamics record);

    int insertSelective(dynamics record);

    List<dynamics> selectByExample(dynamicsExample example);

    dynamics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") dynamics record, @Param("example") dynamicsExample example);

    int updateByExample(@Param("record") dynamics record, @Param("example") dynamicsExample example);

    int updateByPrimaryKeySelective(dynamics record);

    int updateByPrimaryKey(dynamics record);
}