package com.accp.chenyong.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.project;
import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.mapper.UsermainorderMapper;
import com.accp.mapper.orderworkMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.staffMapper;
import com.accp.mapper.usersMapper;
import com.alibaba.fastjson.JSON;
@Service
@Transactional
public class UserMainOrderServiceImpl implements UserMainOrderService {
	@Autowired
	UsermainorderMapper mapper;
	@Autowired
	usersMapper mapper1;
	@Autowired
	staffMapper mapper2;
	@Autowired 
	orderworkMapper  mapper3;
	@Autowired
	projectMapper mapper4;
	public int countByExample(UsermainorderExample example) {
		// TODO Auto-generated method stub
		return mapper.countByExample(example);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}
	@Override
	public int insert(Usermainorder record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Usermainorder record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public List<Usermainorder> selectByExample(UsermainorderExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public Usermainorder selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Usermainorder record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Usermainorder> query(Integer id) {
		// TODO Auto-generated method stub
		List<Usermainorder> list=mapper.query(id);
		for (Usermainorder umo : list) {
			umo.setStaff(mapper2.selectByPrimaryKey(umo.getOrderuser()));
			umo.getStaff().setUser(mapper1.selectByPrimaryKey(umo.getStaff().getUserid()));
			if(umo.getName2().equals("个人")) {
				umo.setUser(mapper1.queryByMainOrderId(umo.getId(),umo.getOrdercustomer()).get(0));
				for (userorder uo : umo.getUser().getOrders()) {
					uo.setUser(mapper1.selectByPrimaryKey(uo.getOrdercustomer()));
					uo.setStaff(mapper2.selectByPrimaryKey(uo.getOrderuser()));
					for (userorder userorder : umo.getUser().getOrders()) {
						for (orderson orderson : userorder.getList()) {
							if(orderson.getTypeid()==1) {
								orderwork p=mapper3.queryByOrderId(orderson.getId());
								for (orderproductwork opw  : p.getList()) {
									opw.setProject(mapper4.queryAll(new project()).get(0));
								}
								orderson.setIx(p);
							}
						}
					}
				}
			}else {
				for (users u : umo.getList()) {
					mapper1.queryByMainOrderId(umo.getId(),u.getId());	
					for (userorder uo : u.getOrders()) {
						uo.setUser(mapper1.selectByPrimaryKey(uo.getOrdercustomer()));
						uo.setStaff(mapper2.selectByPrimaryKey(uo.getOrderuser()));
					}
				}
			}
		}
		return list;
	}

}
