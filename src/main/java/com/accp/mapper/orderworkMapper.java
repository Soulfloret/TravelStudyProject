package com.accp.mapper;

import com.accp.domain.orderwork;
import com.accp.domain.orderworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderworkMapper {
    int countByExample(orderworkExample example);

    int deleteByExample(orderworkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(orderwork record);

    int insertSelective(orderwork record);

    List<orderwork> selectByExample(orderworkExample example);

    orderwork selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") orderwork record, @Param("example") orderworkExample example);

    int updateByExample(@Param("record") orderwork record, @Param("example") orderworkExample example);

    int updateByPrimaryKeySelective(orderwork record);

    int updateByPrimaryKey(orderwork record);
    
    orderwork queryByOrderId(@Param("id")Integer id);
}