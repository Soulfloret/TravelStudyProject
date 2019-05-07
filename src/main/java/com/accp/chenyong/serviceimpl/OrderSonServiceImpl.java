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
import com.accp.domain.product;
import com.accp.domain.productarea;
import com.accp.domain.productproject;
import com.accp.mapper.MealMapper;
import com.accp.mapper.productareaMapper;
import com.accp.mapper.productprojectMapper;

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
	@Override
	public List<orderson> query(List<orderson> o) {
		for (orderson orderson : o) {
			if(orderson.getTypeid()==1) {
				List<productarea> list=mapper.queryByPid(orderson.getIid());
				for(productarea p :list) {
					p.setP(service.queryByArearId(p, new Date(), new Date()));
				}
				orderson.setIx(list);
			}
			if(orderson.getTypeid()==5) {
				List<productproject> p=mapper1.queryByProdId(orderson.getIid());
				List<productarea> list1=new ArrayList<productarea>();
				for (productproject productproject : p) {
					List<productarea> list=mapper.queryByPid(productproject.getProjectid());
					for(productarea pa :list) {
						pa.setP(service.queryByArearId(pa, new Date(), new Date()));
						list1.add(pa);
					}
				}
				orderson.setIx(list1);
			}
			if(orderson.getTypeid()==7) {
				Meal m=mapper2.query(orderson.getIid()).get(0);
				List<productarea> list1=new ArrayList<productarea>();
				for (Mealix mx : m.getList()) {
					if(mx.getTypeid()==1) {
						List<productarea> list=mapper.queryByPid(mx.getIid());
						for(productarea p :list) {
							p.setP(service.queryByArearId(p, new Date(), new Date()));
							list1.add(p);
						}
					}
				}
				orderson.setIx(list1);
			}
		}
		return o;
	}
}
