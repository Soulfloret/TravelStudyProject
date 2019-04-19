package com.accp.chenyong.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Meal;
import com.accp.domain.Mealix;
import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;
import com.accp.domain.bind;
import com.accp.domain.menu;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.project;
import com.accp.domain.roomorder;
import com.accp.domain.staff;
import com.accp.domain.team;
import com.accp.domain.teammember;
import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.domain.worduser;
import com.accp.mapper.MealMapper;
import com.accp.mapper.UsermainorderMapper;
import com.accp.mapper.bindMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.orderworkMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.projecttypeMapper;
import com.accp.mapper.roomorderMapper;
import com.accp.mapper.staffMapper;
import com.accp.mapper.teamMapper;
import com.accp.mapper.teammemberMapper;
import com.accp.mapper.userorderMapper;
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
	@Autowired
	projecttypeMapper mapper5;
	@Autowired
	imagesMapper mapper6;
	@Autowired
	menuMapper mapper7;
	@Autowired
	roomorderMapper mapper8;
	@Autowired
	MealMapper mapper9;
	@Autowired
	bindMapper mapper10;
	@Autowired
	productMapper mapper11;
	@Autowired
	teamMapper mapper12;
	@Autowired
	teammemberMapper mapper13;
	@Autowired
	userorderMapper mapper14;
	
	public int countByExample(UsermainorderExample example) {
		// TODO Auto-generated method stub
		return mapper.countByExample(example);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}
/*	@Override
	public int insert(Usermainorder record) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
		int num;
		record.setName2("个人");
		record.setName1("正在进行");
		String date=new Date().toString();
		record.setOrdertime(new Date());
		record.setOrderno(sdf.parse(date)+"yxlx");
		if(record.getTeam()!=null) {
			mapper12.insert(record.getTeam());
			record.setOrdercustomer(record.getTeam().getId());
			record.setName2("团队");
		}
		num=mapper.insert(record);
		for (teammember t :record.getTeam().getTeams()) {
			t.setTeamid(record.getId());
			mapper13.insert(t);
			userorder uo=new userorder();
			uo.setOrderno();
			mapper14.insert();
		}
		return num;
	}
*/
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
			umo.setStaff(mapper2.queryById(umo.getOrderuser()));
			if(umo.getName2().equals("个人")) {
				umo.setUser(mapper1.queryByMainOrderId(umo.getId(),umo.getOrdercustomer()).get(0));
				umo.setStaff(mapper2.selectByPrimaryKey(umo.getOrderuser()));
				umo.getStaff().setUser(mapper1.selectByPrimaryKey(umo.getStaff().getUserid()));
				for (userorder uo : umo.getUser().getOrders()) {
					uo.setUser(mapper1.selectByPrimaryKey(uo.getOrdercustomer()));
					uo.setStaff(mapper2.selectByPrimaryKey(uo.getOrderuser()));
					uo.getStaff().setUser(mapper1.selectByPrimaryKey(uo.getStaff().getUserid()));
						for (orderson orderson : uo.getList()) {
							if(orderson.getTypeid()==1||orderson.getTypeid()==5) {
								orderwork p=mapper3.queryByOrderId(orderson.getId());
								if(p!=null&&p.getList()!=null&&p.getList().size()>0) {
									for (orderproductwork opw  : p.getList()) {
										opw.setProject(mapper4.selectByPrimaryKey(opw.getIid()));
										opw.getProject().setPt(mapper5.selectByPrimaryKey(opw.getProject().getTid()));
										opw.getProject().setIlist(mapper6.queryimg(opw.getProject().getId(),1));
										for (worduser  wu: opw.getList()) {
											wu.setStaff(mapper2.selectByPrimaryKey(wu.getProductstaffid()));
											wu.getStaff().setUser(mapper1.selectByPrimaryKey(wu.getStaff().getUserid()));
										}
									}
								}
								orderson.setIx(p);
							}
							if(orderson.getTypeid()==2) {
								menu m=new menu();
								m.setId(orderson.getIid());
								m=mapper7.QueryMenu(m).get(0);
								orderson.setIx(m);
							}
							if(orderson.getTypeid()==3) {
								roomorder ro=new roomorder();
								ro=mapper8.query(orderson.getIid()).get(0);
								ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
								orderson.setIx(ro);
							}
							if(orderson.getTypeid()==4) {
								bind b=new bind();
								b.setId(orderson.getIid());
								orderson.setIx(mapper10.querybind(b).get(0));
							}
							if(orderson.getTypeid()==7) {
								Meal m=new Meal();
								m=mapper9.query(orderson.getIid()).get(0);
								for (Mealix mx : m.getList()) {
									if(mx.getTypeid()==1) {
										project p=new project();
										p.setId(mx.getIid());
										mx.setIx(mapper4.queryAll(p).get(0));
									}
									if(mx.getTypeid()==2) {
										menu mu=new menu();
										mu.setId(mx.getIid());
										mx.setIx(mapper7.QueryMenu(mu).get(0));
									}
									if(mx.getTypeid()==3) {
										mx.setIx(mapper8.query(mx.getIid()).get(0));
									}
									if(mx.getTypeid()==4) {
										bind b=new bind();
										b.setId(mx.getIid());
										mx.setIx(mapper10.querybind(b).get(0));
									}
								}
							}
						}
				}
			}else {
				umo.setList(mapper1.queryByMainOrderId(umo.getId(),null));
				umo.setUser(mapper1.selectByPrimaryKey(mapper12.selectByPrimaryKey(umo.getOrdercustomer()).getMainiuserid()));
				umo.setStaff(mapper2.selectByPrimaryKey(umo.getOrderuser()));
				umo.getStaff().setUser(mapper1.selectByPrimaryKey(umo.getStaff().getUserid()));
				for (users u : umo.getList()) {
					for (userorder uo : u.getOrders()) {
						uo.setUser(mapper1.selectByPrimaryKey(uo.getOrdercustomer()));
						uo.setStaff(mapper2.selectByPrimaryKey(uo.getOrderuser()));
						uo.getStaff().setUser(mapper1.selectByPrimaryKey(uo.getStaff().getUserid()));
							for (orderson orderson : uo.getList()) {
								if(orderson.getTypeid()==1||orderson.getTypeid()==5) {
									orderwork p=mapper3.queryByOrderId(orderson.getId());
									if(p!=null&&p.getList()!=null&&p.getList().size()>0) {
										for (orderproductwork opw  : p.getList()) {
											opw.setProject(mapper4.selectByPrimaryKey(opw.getIid()));
											opw.getProject().setPt(mapper5.selectByPrimaryKey(opw.getProject().getTid()));
											opw.getProject().setIlist(mapper6.queryimg(opw.getProject().getId(),1));
											for (worduser  wu: opw.getList()) {
												wu.setStaff(mapper2.selectByPrimaryKey(wu.getProductstaffid()));
												wu.getStaff().setUser(mapper1.selectByPrimaryKey(wu.getStaff().getUserid()));
											}
										}
									}
									orderson.setIx(p);
								}
								if(orderson.getTypeid()==2) {
									menu m=new menu();
									m.setId(orderson.getIid());
									m=mapper7.QueryMenu(m).get(0);
									orderson.setIx(m);
								}
								if(orderson.getTypeid()==3) {
									roomorder ro=new roomorder();
									ro=mapper8.query(orderson.getIid()).get(0);
									ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
									orderson.setIx(ro);
								}
								if(orderson.getTypeid()==4) {
									bind b=new bind();
									b.setId(orderson.getIid());
									orderson.setIx(mapper10.querybind(b).get(0));
								}
								if(orderson.getTypeid()==7) {
									Meal m=new Meal();
									m=mapper9.query(orderson.getIid()).get(0);
									for (Mealix mx : m.getList()) {
										if(mx.getTypeid()==1) {
											project p=new project();
											p.setId(mx.getIid());
											mx.setIx(mapper4.queryAll(p).get(0));
										}
										if(mx.getTypeid()==2) {
											menu mu=new menu();
											mu.setId(mx.getIid());
											mx.setIx(mapper7.QueryMenu(mu).get(0));
										}
										if(mx.getTypeid()==3) {
											mx.setIx(mapper8.query(mx.getIid()).get(0));
										}
										if(mx.getTypeid()==4) {
											bind b=new bind();
											b.setId(mx.getIid());
											mx.setIx(mapper10.querybind(b).get(0));
										}
									}
								}
							}
						}
					}
				}
			}
		return list;
	}
	@Override
	public int insert(Usermainorder record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
