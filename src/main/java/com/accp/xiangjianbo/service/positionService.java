package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.positions;
import com.accp.mapper.positionsMapper;

@Service
@Transactional
public class positionService {
	
	@Autowired
	positionsMapper posmapper;
	
	public List<positions> project_queryById(Integer id){
		return posmapper.project_queryById(id);
	}
}
