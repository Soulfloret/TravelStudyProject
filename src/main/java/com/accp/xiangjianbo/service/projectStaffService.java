package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.productstaff;
import com.accp.mapper.productstaffMapper;

@Service
@Transactional
public class projectStaffService {

	@Autowired
	productstaffMapper psmapper;
	
	public List<productstaff> projectOrder_queryStaff(){
		return psmapper.projectOrder_queryStaff();
	}
}
