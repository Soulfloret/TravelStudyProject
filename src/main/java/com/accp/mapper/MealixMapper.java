package com.accp.mapper;

import com.accp.domain.Mealix;
import com.accp.domain.MealixExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MealixMapper {
	
    int countByExample(MealixExample example);

    int deleteByExample(MealixExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mealix record);

    int insertSelective(Mealix record);

    List<Mealix> selectByExample(MealixExample example);

    Mealix selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mealix record, @Param("example") MealixExample example);

    int updateByExample(@Param("record") Mealix record, @Param("example") MealixExample example);

    int updateByPrimaryKeySelective(Mealix record);

    int updateByPrimaryKey(Mealix record);
    
    List<Mealix> queryTid(@Param("tid")Integer tid);
}