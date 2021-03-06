package com.accp.mapper;

import com.accp.domain.discussiongroup;
import com.accp.domain.discussiongroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface discussiongroupMapper {
    int countByExample(discussiongroupExample example);

    int deleteByExample(discussiongroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(discussiongroup record);

    int insertSelective(discussiongroup record);

    List<discussiongroup> selectByExample(discussiongroupExample example);

    discussiongroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") discussiongroup record, @Param("example") discussiongroupExample example);

    int updateByExample(@Param("record") discussiongroup record, @Param("example") discussiongroupExample example);

    int updateByPrimaryKeySelective(discussiongroup record);

    int updateByPrimaryKey(discussiongroup record);
}