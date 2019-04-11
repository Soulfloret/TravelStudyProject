package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.areas;
import com.accp.domain.areasExample;
import com.accp.mapper.areasMapper;

@Service
public class areasService {
	
	@Autowired
	areasMapper areas;
	
	public List<areas> selectByExample(areas area) {
		return areas.selectByExample(area);
	}
	
	public int insert(areas record) {
		return areas.insert(record);
	}
	
	
}
