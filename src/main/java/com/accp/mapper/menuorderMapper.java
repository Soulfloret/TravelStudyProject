package com.accp.mapper;

import com.accp.domain.menuorder;
import com.accp.domain.menuorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menuorderMapper {
    int countByExample(menuorderExample example);

    int deleteByExample(menuorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(menuorder record);

    int insertSelective(menuorder record);

    List<menuorder> selectByExample(menuorderExample example);

    menuorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") menuorder record, @Param("example") menuorderExample example);

    int updateByExample(@Param("record") menuorder record, @Param("example") menuorderExample example);

    int updateByPrimaryKeySelective(menuorder record);

    int updateByPrimaryKey(menuorder record);
}