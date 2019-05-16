package com.accp.yipeng.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.staff;
import com.accp.domain.team;
import com.accp.domain.teamExample;
import com.accp.domain.teammember;
import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.domain.worduser;
import com.accp.mapper.orderproductworkMapper;
import com.accp.mapper.ordersonMapper;
import com.accp.mapper.orderworkMapper;
import com.accp.mapper.teamMapper;
import com.accp.mapper.teammemberMapper;
import com.accp.mapper.userorderMapper;
import com.accp.mapper.usersMapper;
import com.accp.mapper.worduserMapper;
import com.accp.yipeng.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	@Autowired
	teamMapper mapper;
	@Autowired
	UserMainOrderService UmoService;
	@Autowired
	usersMapper Use;
	@Autowired
	teammemberMapper TeammbeMapper;
	@Autowired
	userorderMapper usoMapper;
	@Autowired
	ordersonMapper orderSonMapper;
	@Autowired
	orderworkMapper orderworkMapper;
	@Autowired
	orderproductworkMapper orderproductworkMapper;
	@Autowired
	worduserMapper worduserMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(team record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<team> selectByExample(teamExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public team selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(team record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<team> selectAllTeam(String uname, String tname) {
		// TODO Auto-generated method stub
		return mapper.selectAllTeam(uname, tname);
	}

	@Override
	public int insertTeamUsers(Integer cid, Integer Mid, users user,String team,staff staf) {
		user.setTypeid(Integer.parseInt(team));
		String id= user.getIdcardno();
		String idone=id.substring(14, id.length());
		user.setUname(idone+"yx");
		user.setUpassword(idone+"yx");
		int num=Use.insert(user);
		teammember t=new teammember();
		t.setTeamid(cid);
		t.setMemberid(user.getId());
		num=TeammbeMapper.insert(t);
		Usermainorder u=new Usermainorder();
		u.setId(Mid);
		List<Usermainorder> list= UmoService.query(u);
		Usermainorder usermo=list.get(0);
		userorder useror=new userorder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();   
		useror.setOrderno(sdf.format(date)+"yxlx");
		useror.setOrdertime(new Date());
		useror.setOrderuser(staf.getId());
		useror.setOrdercustomer(user.getId());
		useror.setOrdermainid(usermo.getId());
		useror.setOrderstatus("未开始");
		num=usoMapper.insert(useror);
		List<orderson> list1=usermo.getList().get(0).getOrders().get(0).getList();
		for (orderson orderson : list1) {
			orderson orderson1=new orderson();
			orderson1=orderson;
			orderson1.setName1(useror.getId().toString());
			orderson1.setId(null);
			orderSonMapper.insert(orderson1);
			if(orderson1.getTypeid()==1||orderson1.getTypeid()==5) {
				orderwork o=(orderwork)orderson.getIx();
				o.setOrderid(orderson1.getId());
				o.setId(null);
				orderworkMapper.insert(o);
				for (orderproductwork opw : o.getList()) {
					opw.setOrderworkid(o.getId());
					opw.setId(null);
					orderproductworkMapper.insert(opw);
					for (worduser  worduser: opw.getList()) {
						worduser.setId(null);
						worduser.setWorkid(opw.getId());
						worduserMapper.insert(worduser);
					}
				}
				
			}
		}
		
		return num;
	}
	
}
