package com.accp.mapper;

import com.accp.domain.itype;
import com.accp.domain.itypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface itypeMapper {
    int countByExample(itypeExample example);

    int deleteByExample(itypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(itype record);

    int insertSelective(itype record);

    List<itype> selectByExample(itypeExample example);

    itype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") itype record, @Param("example") itypeExample example);

    int updateByExample(@Param("record") itype record, @Param("example") itypeExample example);

    int updateByPrimaryKeySelective(itype record);

    int updateByPrimaryKey(itype record);
}