package com.accp.mapper;

import com.accp.domain.orderproductwork;
import com.accp.domain.orderwork;
import com.accp.domain.worduser;
import com.accp.domain.worduserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface worduserMapper {
    int countByExample(worduserExample example);

    int deleteByExample(worduserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(worduser record);

    int insertSelective(worduser record);

    List<worduser> selectByExample(worduserExample example);

    worduser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") worduser record, @Param("example") worduserExample example);

    int updateByExample(@Param("record") worduser record, @Param("example") worduserExample example);

    int updateByPrimaryKeySelective(worduser record);

    int updateByPrimaryKey(worduser record);
    
    int project_staff_insert(orderproductwork opw);
}