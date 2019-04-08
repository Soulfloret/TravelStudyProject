package com.accp.mapper;

import com.accp.domain.interested;
import com.accp.domain.interestedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface interestedMapper {
    int countByExample(interestedExample example);

    int deleteByExample(interestedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(interested record);

    int insertSelective(interested record);

    List<interested> selectByExample(interestedExample example);

    interested selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") interested record, @Param("example") interestedExample example);

    int updateByExample(@Param("record") interested record, @Param("example") interestedExample example);

    int updateByPrimaryKeySelective(interested record);

    int updateByPrimaryKey(interested record);
}