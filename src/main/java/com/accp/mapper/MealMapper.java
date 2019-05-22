package com.accp.mapper;

import com.accp.domain.Meal;
import com.accp.domain.MealExample;
import com.accp.domain.recommend;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MealMapper {
    int countByExample(MealExample example);

    int deleteByExample(MealExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Meal record);

    int insertSelective(Meal record);

    List<Meal> selectByExample(MealExample example);

    Meal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Meal record, @Param("example") MealExample example);

    int updateByExample(@Param("record") Meal record, @Param("example") MealExample example);

    int updateByPrimaryKeySelective(Meal record);

    int updateByPrimaryKey(Meal record);
    
    List<Meal> query(@Param("id")Integer id);
    
    List<Meal> queryMeal(@Param("id")Integer id);
    
    recommend recommendMealAll(@Param("id")Integer id);
}