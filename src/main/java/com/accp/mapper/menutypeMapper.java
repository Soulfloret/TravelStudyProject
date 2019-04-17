package com.accp.mapper;

import com.accp.domain.menutype;
import com.accp.domain.menutypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menutypeMapper {
	
	List<menutype> selectqueryTypemenu(menutype m);
	
    int countByExample(menutypeExample example);

    int deleteByExample(menutypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(menutype record);

    int insertSelective(menutype record);

    List<menutype> selectByExample(menutypeExample example);

    menutype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") menutype record, @Param("example") menutypeExample example);

    int updateByExample(@Param("record") menutype record, @Param("example") menutypeExample example);

    int updateByPrimaryKeySelective(menutype record);

    int updateByPrimaryKey(menutype record);
}