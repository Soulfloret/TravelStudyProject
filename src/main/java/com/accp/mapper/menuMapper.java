package com.accp.mapper;

import com.accp.domain.menu;
import com.accp.domain.menuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menuMapper {
    int countByExample(menuExample example);

    int deleteByExample(menuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(menu record);

    int insertSelective(menu record);

    List<menu> selectByExample(menuExample example);

    menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") menu record, @Param("example") menuExample example);

    int updateByExample(@Param("record") menu record, @Param("example") menuExample example);

    int updateByPrimaryKeySelective(menu record);

    int updateByPrimaryKey(menu record);
}