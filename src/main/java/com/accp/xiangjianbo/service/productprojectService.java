package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.productproject;
import com.accp.mapper.productprojectMapper;

@Service
public class productprojectService {

	@Autowired
	productprojectMapper prop;
	
	public List<productproject> queryByProdId(Integer productId){
		return prop.queryByProdId(productId);
	}
	
}
