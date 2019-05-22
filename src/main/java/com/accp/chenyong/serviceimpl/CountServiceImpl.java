package com.accp.chenyong.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.CountService;
import com.accp.domain.menu;
import com.accp.domain.project;
import com.accp.domain.room;
import com.accp.mapper.menuMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.roomMapper;

@Service
@Transactional
public class CountServiceImpl implements CountService{
	@Autowired
	projectMapper mapper;
	@Autowired
	menuMapper mapper1;
	@Autowired
	roomMapper mapper2;
	@Override
	public List<project> querycountproject(Date starttime, Date endtime) {
		List<project> list=mapper.selectByExample(null);
		for (project project : list) {
			project p1=mapper.querycountproject(starttime, endtime, project.getId());
			if(p1==null)
				project.setCountnum(0);
			else {
				project.setCountnum(p1.getCountnum());
			}
		}
		return list;
	}

	@Override
	public List<menu> querycountmenu(Date starttime, Date endtime) {
		List<menu> list=mapper1.selectByExample(null);
		for (menu menu : list) {
			menu m1=mapper1.querycountmenu(starttime, endtime, menu.getId());
			if(m1==null) {
				menu.setCountnum(0);
			}else {
				menu.setCountnum(m1.getCountnum());				
			}
		}
		 return list;
	}

	@Override
	public List<room> querycountroom(Date starttime, Date endtime) {
		// TODO Auto-generated method stub
		List<room> list=mapper2.selectByExample(null);
		for (room room : list) {
			room r1=mapper2.querycountroom(starttime, endtime, room.getId());
			if(r1==null) {
				room.setCountnum(0);
			}else {
				room.setCountnum(r1.getCountnum());				
			}
		}
		 return list;
	}
}
