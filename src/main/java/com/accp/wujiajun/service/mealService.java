package com.accp.wujiajun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Meal;
import com.accp.domain.Mealix;
import com.accp.mapper.MealMapper;
import com.accp.mapper.MealixMapper;
import com.accp.wujiajun.service.impl.mealServiceImpl;

@Service
@Transactional
public class mealService implements mealServiceImpl {

	@Autowired
	MealMapper mapper;

	@Override
	public List<Meal> mealQuery(Meal record) {
		// TODO Auto-generated method stub
		return mapper.mealQuery(record);
	}

	@Override
	public List<Meal> mealProjectQueryById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.mealProjectQueryById(id);
	}

	@Override
	public List<Meal> mealRoomQueryById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.mealRoomQueryById(id);
	}

	@Override
	public List<Meal> mealMenuQueryById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.mealMenuQueryById(id);
	}

	@Override
	public List<Meal> projectAjaxQuery(Integer id) {
		// TODO Auto-generated method stub
		return mapper.projectAjaxQuery(id);
	}

	@Override
	public List<Meal> menuAjaxQuery(Integer id) {
		// TODO Auto-generated method stub
		return mapper.menuAjaxQuery(id);
	}

}
