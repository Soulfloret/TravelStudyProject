package com.accp.mapper;

import com.accp.domain.userinterested;
import com.accp.domain.userinterestedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userinterestedMapper {
    int countByExample(userinterestedExample example);

    int deleteByExample(userinterestedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(userinterested record);

    int insertSelective(userinterested record);

    List<userinterested> selectByExample(userinterestedExample example);

    userinterested selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") userinterested record, @Param("example") userinterestedExample example);

    int updateByExample(@Param("record") userinterested record, @Param("example") userinterestedExample example);

    int updateByPrimaryKeySelective(userinterested record);

    int updateByPrimaryKey(userinterested record);
}