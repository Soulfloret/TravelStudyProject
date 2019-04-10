package com.accp.mapper;

import com.accp.domain.dynamicstopf;
import com.accp.domain.dynamicstopfExample;
import com.accp.domain.stopfcomment;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface dynamicstopfMapper {
    int countByExample(dynamicstopfExample example);

    int deleteByExample(dynamicstopfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(dynamicstopf record);

    int insertSelective(dynamicstopf record);

    List<dynamicstopf> selectByExample(dynamicstopfExample example);

    dynamicstopf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") dynamicstopf record, @Param("example") dynamicstopfExample example);

    int updateByExample(@Param("record") dynamicstopf record, @Param("example") dynamicstopfExample example);

    int updateByPrimaryKeySelective(dynamicstopf record);

    int updateByPrimaryKey(dynamicstopf record);
    
    int dzcountdt(@Param("rid")Integer rid,@Param("uid")Integer uid);
    
    dynamicstopf queryByRid(@Param("rid")Integer rid,@Param("uid")Integer uid);
}