package com.accp.chenyong.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.RoleService;
import com.accp.domain.role;
import com.accp.domain.roleExample;
import com.accp.domain.rolemodule;
import com.accp.mapper.roleMapper;
import com.accp.mapper.rolemoduleMapper;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	roleMapper mapper;
	@Autowired
	rolemoduleMapper mapper1;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int num=mapper.deleteByPrimaryKey(id);
		num=mapper1.delByRoleId(id);
		return num;
	}

	@Override
	public int insert(role record) {
		int num=mapper.insert(record);
		for (rolemodule rolemodule : record.getList()) {
			rolemodule.setRoleid(record.getId());
			num=mapper1.insert(rolemodule);
		}
		return num;
	}

	@Override
	public int insertSelective(role record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public List<role> selectByExample(roleExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public role selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(role record){
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(role record) {
		// TODO Auto-generated method stub
		int num=mapper.updateByPrimaryKeySelective(record);
		num=mapper1.delByRoleId(record.getId());
		for (rolemodule rolemodule : record.getList()) {
			if(rolemodule.getModuleid()!=null) {
			rolemodule.setRoleid(record.getId());
			num=mapper1.insert(rolemodule);
			}
		}
		return num;

	}

}
