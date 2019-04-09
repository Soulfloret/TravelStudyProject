package com.accp.mapper;

import com.accp.domain.Interestedproject;
import com.accp.domain.InterestedprojectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InterestedprojectMapper {
    int countByExample(InterestedprojectExample example);

    int deleteByExample(InterestedprojectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Interestedproject record);

    int insertSelective(Interestedproject record);

    List<Interestedproject> selectByExample(InterestedprojectExample example);

    Interestedproject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Interestedproject record, @Param("example") InterestedprojectExample example);

    int updateByExample(@Param("record") Interestedproject record, @Param("example") InterestedprojectExample example);

    int updateByPrimaryKeySelective(Interestedproject record);

    int updateByPrimaryKey(Interestedproject record);
}