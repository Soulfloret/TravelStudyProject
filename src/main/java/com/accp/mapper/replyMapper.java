package com.accp.mapper;

import com.accp.domain.reply;
import com.accp.domain.replyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface replyMapper {
    int countByExample(replyExample example);

    int deleteByExample(replyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(reply record);

    int insertSelective(reply record);

    List<reply> selectByExample(replyExample example);

    reply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") reply record, @Param("example") replyExample example);

    int updateByExample(@Param("record") reply record, @Param("example") replyExample example);

    int updateByPrimaryKeySelective(reply record);

    int updateByPrimaryKey(reply record);
}