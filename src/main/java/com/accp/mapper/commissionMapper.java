package com.accp.mapper;

import com.accp.domain.commission;
import com.accp.domain.commissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface commissionMapper {
    int countByExample(commissionExample example);

    int deleteByExample(commissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(commission record);

    int insertSelective(commission record);

    List<commission> selectByExample(commissionExample example);

    commission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") commission record, @Param("example") commissionExample example);

    int updateByExample(@Param("record") commission record, @Param("example") commissionExample example);

    int updateByPrimaryKeySelective(commission record);

    int updateByPrimaryKey(commission record);
}