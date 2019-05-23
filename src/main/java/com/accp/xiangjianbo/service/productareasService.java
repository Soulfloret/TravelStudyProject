package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.productarea;
import com.accp.mapper.productareaMapper;

@Service
@Transactional
public class productareasService {

	@Autowired
	productareaMapper pa;
	
	public List<productarea> queryByPid(Integer pid){
		return pa.queryByPid(pid);
	}
	
	public int deleteProjectArea(Integer pid) {
		return pa.deleteProjectArea(pid);
	}
 	
}
