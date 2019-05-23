package com.accp.wujiajun.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Meal;
import com.accp.domain.Mealix;

public interface mealServiceImpl {

	List<Meal> mealQuery(Meal record);

	List<Meal> mealProjectQueryById(@Param("id") Integer id);

	List<Meal> mealRoomQueryById(@Param("id") Integer id);
	
	List<Meal> mealMenuQueryById(@Param("id") Integer id);
	
	List<Meal> projectAjaxQuery(@Param("id") Integer id);
	
	List<Meal> menuAjaxQuery(@Param("id") Integer id);

}
