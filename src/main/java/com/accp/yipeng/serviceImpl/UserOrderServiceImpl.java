package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Meal;
import com.accp.domain.Mealix;
import com.accp.domain.Usermainorder;
import com.accp.domain.bind;
import com.accp.domain.menu;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.room;
import com.accp.domain.roomdestine;
import com.accp.domain.userorder;
import com.accp.domain.worduser;
import com.accp.mapper.MealMapper;
import com.accp.mapper.UsermainorderMapper;
import com.accp.mapper.bindMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.menuorderMapper;
import com.accp.mapper.orderproductworkMapper;
import com.accp.mapper.ordersonMapper;
import com.accp.mapper.orderworkMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.projecttypeMapper;
import com.accp.mapper.roomMapper;
import com.accp.mapper.roomdestineMapper;
import com.accp.mapper.roomorderMapper;
import com.accp.mapper.staffMapper;
import com.accp.mapper.teamMapper;
import com.accp.mapper.teammemberMapper;
import com.accp.mapper.userorderMapper;
import com.accp.mapper.usersMapper;
import com.accp.mapper.worduserMapper;
import com.accp.yipeng.service.UserOrderService;

@Transactional
@Service
public class UserOrderServiceImpl implements UserOrderService{
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
	@Autowired
	ordersonMapper mapper15;
	@Autowired
	orderproductworkMapper mapper16;
	@Autowired
	worduserMapper mapper17;
	@Autowired
	menuorderMapper mapper18;
	@Autowired
	roomdestineMapper mapper19;
	@Autowired
	roomMapper mapper20;
	
	@Override
	public List<userorder> selectAllUserOrderById(Integer uid) {
		List<userorder> list=mapper14.selectAllUserOrderById(uid);
		for (userorder userorder : list) {
			userorder.setUser(mapper1.selectByPrimaryKey(userorder.getOrdercustomer()));
		}
		return list;
	}

	@Override
	public Usermainorder queryByUserOrderId(Integer id) {
		userorder uor= mapper14.selectByPrimaryKey(id);
		Usermainorder umo=mapper.selectByPrimaryKey(uor.getOrdermainid());
		umo.setStaff(mapper2.queryById(umo.getOrderuser()));
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
							if(orderson.getTypeid()==5) {
								p.setName6(mapper11.selectByPrimaryKey(orderson.getIid()).getPname());
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
							roomdestine ro=new roomdestine();
							ro=mapper19.selectByPrimaryKey(orderson.getIid());
							room r=new room();
							r.setId(ro.getRoomid());
							ro.setRoom(mapper20.queryByroom(r).get(0));
							ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
							ro.getRoom().setImg(mapper6.queryimg(ro.getRoomid(),3).get(0));
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
							m.setImg(mapper6.queryimg(m.getId(), 7));
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
									mx.setIx(mapper7.QueryMenu(mu).get(0));
								}
								if(mx.getTypeid()==3) {
									roomdestine ro=new roomdestine();
									ro=mapper19.selectByPrimaryKey(mx.getIid());
									room r=new room();
									r.setId(ro.getRoomid());
									ro.setRoom(mapper20.queryByroom(r).get(0));
									ro.setUser(mapper1.selectByPrimaryKey(ro.getUserid()));
									ro.getRoom().setImg(mapper6.queryimg(ro.getRoomid(),3).get(0));
									mx.setIx(ro);
								}
								if(mx.getTypeid()==4) {
									bind b=new bind();
									b.setId(mx.getIid());
									mx.setIx(mapper10.querybind(b).get(0));
								}
							}
							orderson.setIx(m);
						}
					}
			}
		return umo;
	}
		

}