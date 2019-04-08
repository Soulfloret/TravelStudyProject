package com.accp.mapper;

import com.accp.domain.stopfcomment;
import com.accp.domain.stopfcommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface stopfcommentMapper {
    int countByExample(stopfcommentExample example);

    int deleteByExample(stopfcommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(stopfcomment record);

    int insertSelective(stopfcomment record);

    List<stopfcomment> selectByExample(stopfcommentExample example);

    stopfcomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") stopfcomment record, @Param("example") stopfcommentExample example);

    int updateByExample(@Param("record") stopfcomment record, @Param("example") stopfcommentExample example);

    int updateByPrimaryKeySelective(stopfcomment record);

    int updateByPrimaryKey(stopfcomment record);
}