package com.accp.mapper;

import com.accp.domain.actionimages;
import com.accp.domain.actionimagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface actionimagesMapper {
    int countByExample(actionimagesExample example);

    int deleteByExample(actionimagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(actionimages record);

    int insertSelective(actionimages record);

    List<actionimages> selectByExample(actionimagesExample example);

    actionimages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") actionimages record, @Param("example") actionimagesExample example);

    int updateByExample(@Param("record") actionimages record, @Param("example") actionimagesExample example);

    int updateByPrimaryKeySelective(actionimages record);

    int updateByPrimaryKey(actionimages record);
    
    List<actionimages> query();
}