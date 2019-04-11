package com.accp.chenyong.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;
import com.accp.domain.users;
import com.accp.mapper.UsermainorderMapper;
import com.accp.mapper.staffMapper;
import com.accp.mapper.usersMapper;
@Service
@Transactional
public class UserMainOrderServiceImpl implements UserMainOrderService {
	@Autowired
	UsermainorderMapper mapper;
	@Autowired
	usersMapper mapper1;
	@Autowired
	staffMapper mapper2;

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
			}else {
				for (users u : umo.getList()) {
					mapper1.queryByMainOrderId(umo.getId(),u.getId());					
				}
			}
		}
		return list;
	}

}
