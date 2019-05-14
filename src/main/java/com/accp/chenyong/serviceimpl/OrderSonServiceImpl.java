package com.accp.chenyong.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.OrderSonService;
import com.accp.chenyong.service.ProductAreaService;
import com.accp.domain.Meal;
import com.accp.domain.Mealix;
import com.accp.domain.orderson;
import com.accp.domain.productarea;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.mapper.MealMapper;
import com.accp.mapper.productareaMapper;
import com.accp.mapper.productprojectMapper;
import com.accp.mapper.projectMapper;

@Service
@Transactional
public class OrderSonServiceImpl implements OrderSonService{
	@Autowired
	productareaMapper mapper;
	@Autowired
	productprojectMapper mapper1;
	@Autowired
	MealMapper mapper2;
	@Autowired
	ProductAreaService service;
	@Autowired
	projectMapper mapper3;
	@Override
	public List<orderson> query(List<orderson> o,Date startTime,Date endTime) {
		for (orderson orderson : o) {
			if(orderson.getTypeid()==1) {
				project p=mapper3.selectByPrimaryKey(orderson.getIid());
				p=service.queryByArearId(p, startTime, endTime);
				orderson.setIx(p);
			}
			if(orderson.getTypeid()==5) {
				List<productproject> p=mapper1.queryByProdId(orderson.getIid());
				List<project> list1=new ArrayList<project>();
				for (productproject productproject : p) {
					project p1=new project();
					p1.setId(productproject.getProjectid());
					p1=mapper3.queryByProjectId(p1.getId()).get(0);
					list1.add(service.queryByArearId(p1, startTime, endTime));
				}
				orderson.setIx(list1);
			}
			if(orderson.getTypeid()==7) {
				Meal m=mapper2.query(orderson.getIid()).get(0);
				List<project> list1=new ArrayList<project>();
				for (Mealix mx : m.getList()) {
					if(mx.getTypeid()==1) {
						project p=mapper3.selectByPrimaryKey(mx.getIid());
						p=service.queryByArearId(p, startTime, endTime);
						mx.setIx(p);
						list1.add(p);
					}
				}
				orderson.setIx(list1);
			}
		}
		return o;
	}
}
