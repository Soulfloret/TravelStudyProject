package com.accp.wujiajun.service.impl;

import java.util.List;

import com.accp.domain.signin;
import com.accp.domain.staff;
import com.accp.domain.staffExample;

public interface staffServiceImpl {
	//查询员工列表
	List<staff> query(staff sta);
	//根据员工查询员工资料
	staff queryById(Integer id);
	//按条件查询员工列表
	List<staff> queryLike(staff sta);
	//先增加用户 在增加员工
	int insert(staff sta);
	//查询员工薪资列表
	List<staff> salaryQuery(staff sta);
	//根据员工查询员工薪资、打卡次数
	List<staff> salaryQueryId(Integer id);
	//根据员工查询每个员工打卡的条数
	List<signin> signinQuery(Integer id);
	//修改员工在职状态(0,1)
	int staffupdate(staff sta);
	
}
