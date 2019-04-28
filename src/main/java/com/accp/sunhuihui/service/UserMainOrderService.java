package com.accp.sunhuihui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.accp.domain.room;
import com.accp.domain.roomdestine;
import com.accp.domain.roomorder;
import com.accp.domain.staff;
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
import com.accp.mapper.roomMapper;
import com.accp.mapper.roomdestineMapper;
import com.accp.mapper.roomorderMapper;
import com.accp.mapper.staffMapper;
import com.accp.mapper.teamMapper;
import com.accp.mapper.usersMapper;
import com.alibaba.fastjson.JSON;
@Service
@Transactional
public class UserMainOrderService {
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
	roomdestineMapper mapper19;
	@Autowired
	roomMapper mapper20;
	
	
	
	public List<Usermainorder> query(Integer id,Integer uid) {
		// TODO Auto-generated method stub
		List<Usermainorder> list=mapper.query(id);
		List<Usermainorder> listss=new ArrayList<Usermainorder>();
		for (Usermainorder umo : list) {
			umo.setStaff(mapper2.queryById(umo.getOrderuser()));
			umo.setPrice(0.0);
			if(umo.getName2().equals("个人")&&umo.getOrdercustomer()==uid) {
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
								for (orderproductwork opw : p.getList()) {
									umo.setPrice(umo.getPrice()+opw.getProject().getPrice());
								}
							}
							if(orderson.getTypeid()==2) {
								menu m=new menu();
								m.setId(orderson.getIid());
								m=mapper7.QueryMenu(m).get(0);
								orderson.setIx(m);
								umo.setPrice(umo.getPrice()+m.getPrice());
							}
							if(orderson.getTypeid()==3) {
								roomdestine ro=new roomdestine();
								ro=mapper19.selectByPrimaryKey(orderson.getIid());
								room r=new room();
								r.setId(ro.getRoomid());
								ro.setRoom(mapper20.queryByroom(r).get(0));
								ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
								orderson.setIx(ro);
								umo.setPrice(umo.getPrice()+ro.getRoom().getPrice());
							}
							if(orderson.getTypeid()==4) {
								bind b=new bind();
								b.setId(orderson.getIid());
								b=mapper10.querybind(b).get(0);
								orderson.setIx(b);
								umo.setPrice(umo.getPrice()+b.getPrice());
							}
							if(orderson.getTypeid()==7) {
								Meal m=new Meal();
								m=mapper9.query(orderson.getIid()).get(0);
								for (Mealix mx : m.getList()) {
									if(mx.getTypeid()==1) {
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
										mx.setIx(p);

									}
									if(mx.getTypeid()==2) {
										menu mu=new menu();
										mu.setId(mx.getIid());
										mu=mapper7.QueryMenu(mu).get(0);
										mx.setIx(mu);
										umo.setPrice(umo.getPrice()+mu.getPrice());
									}
									if(mx.getTypeid()==3) {
										roomdestine ro=new roomdestine();
										ro=mapper19.selectByPrimaryKey(orderson.getIid());
										room r=new room();
										r.setId(ro.getRoomid());
										ro.setRoom(mapper20.queryByroom(r).get(0));
										ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
										orderson.setIx(ro);
										mx.setIx(ro);
										umo.setPrice(umo.getPrice()+ro.getRoom().getPrice());
									}
									if(mx.getTypeid()==4) {
										bind b=new bind();
										b.setId(mx.getIid());
										mx.setIx(mapper10.querybind(b).get(0));
										umo.setPrice(umo.getPrice()+m.getPrice());
									}
								}
							}
						}
				}
				listss.add(umo);
			}else {
				umo.setList(mapper1.queryByMainOrderId(umo.getId(),null));
				umo.setUser(mapper1.selectByPrimaryKey(mapper12.selectByPrimaryKey(umo.getOrdercustomer()).getMainiuserid()));
				umo.setStaff(mapper2.selectByPrimaryKey(umo.getOrderuser()));
				umo.getStaff().setUser(mapper1.selectByPrimaryKey(umo.getStaff().getUserid()));
				for (users u : umo.getList()) {
					if(u.getId()==uid) {
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
									for (orderproductwork opw : p.getList()) {
										umo.setPrice(umo.getPrice()+opw.getProject().getPrice());
									}
								}
								if(orderson.getTypeid()==2) {
									menu m=new menu();
									m.setId(orderson.getIid());
									m=mapper7.QueryMenu(m).get(0);
									orderson.setIx(m);
									umo.setPrice(umo.getPrice()+m.getPrice());
								}
								if(orderson.getTypeid()==3) {
									roomdestine ro=new roomdestine();
									ro=mapper19.selectByPrimaryKey(orderson.getIid());
									room r=new room();
									r.setId(ro.getRoomid());
									ro.setRoom(mapper20.queryByroom(r).get(0));
									ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
									orderson.setIx(ro);
									umo.setPrice(umo.getPrice()+ro.getRoom().getPrice());
								}
								if(orderson.getTypeid()==4) {
									bind b=new bind();
									b.setId(orderson.getIid());
									b=mapper10.querybind(b).get(0);
									orderson.setIx(b);
									umo.setPrice(umo.getPrice()+b.getPrice());
								}
								if(orderson.getTypeid()==7) {
									Meal m=new Meal();
									m=mapper9.query(orderson.getIid()).get(0);
									for (Mealix mx : m.getList()) {
										if(mx.getTypeid()==1) {
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
											mx.setIx(p);

										}
										if(mx.getTypeid()==2) {
											menu mu=new menu();
											mu.setId(mx.getIid());
											mu=mapper7.QueryMenu(mu).get(0);
											mx.setIx(mu);
											umo.setPrice(umo.getPrice()+mu.getPrice());
										}
										if(mx.getTypeid()==3) {
											roomdestine ro=new roomdestine();
											ro=mapper19.selectByPrimaryKey(orderson.getIid());
											room r=new room();
											r.setId(ro.getRoomid());
											ro.setRoom(mapper20.queryByroom(r).get(0));
											ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
											orderson.setIx(ro);
											mx.setIx(ro);
											umo.setPrice(umo.getPrice()+ro.getRoom().getPrice());
										}
										if(mx.getTypeid()==4) {
											bind b=new bind();
											b.setId(mx.getIid());
											mx.setIx(mapper10.querybind(b).get(0));
											umo.setPrice(umo.getPrice()+m.getPrice());
										}
									}
								}
							}
						}
						listss.add(umo);
					}
				}
			}
			
		}
		list=listss;
		return list;
	}

}