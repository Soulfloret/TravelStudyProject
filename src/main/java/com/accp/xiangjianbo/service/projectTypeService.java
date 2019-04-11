package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.projecttype;
import com.accp.mapper.projecttypeMapper;

@Service
@Transactional
public class projectTypeService {
	@Autowired
	projecttypeMapper mapper;
	public List<projecttype> query(){
		return mapper.selectByExample(null);
	}
}
