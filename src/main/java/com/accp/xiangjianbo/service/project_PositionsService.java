package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.positions;
import com.accp.mapper.positionsMapper;

@Service
@Transactional
public class project_PositionsService {

	@Autowired
	positionsMapper posmapper;
	
	/*新增项目查询职位*/
	public List<positions> queryPosition(){
		return posmapper.selectByExample(null);
	}
}
