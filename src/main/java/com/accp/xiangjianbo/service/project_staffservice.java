package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.staff;
import com.accp.mapper.staffMapper;

@Service
@Transactional
public class project_staffservice {

	@Autowired
	staffMapper staffmapper;
	
	/*新增项目查询负责人*/
    public List<staff> ByProjectName(){
    	return staffmapper.ByProjectName();
    }
}
