package com.accp.yipeng.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.OrderSonService;
import com.accp.domain.Mealix;
import com.accp.domain.Usermainorder;
import com.accp.domain.bind;
import com.accp.domain.menu;
import com.accp.domain.menuorder;
import com.accp.domain.orderproductwork;
import com.accp.domain.ordershop;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.product;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.domain.team;
import com.accp.domain.teammember;
import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.domain.worduser;
import com.accp.mapper.MealMapper;
import com.accp.mapper.MealixMapper;
import com.accp.mapper.ShopcartMapper;
import com.accp.mapper.UsermainorderMapper;
import com.accp.mapper.bindMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.menuorderMapper;
import com.accp.mapper.orderproductworkMapper;
import com.accp.mapper.ordershopMapper;
import com.accp.mapper.ordersonMapper;
import com.accp.mapper.orderworkMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.productprojectMapper;
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
import com.accp.yipeng.service.UserMainOrderService1;

@Service
@Transactional
public class UserMainOrderServiceImpl1 implements UserMainOrderService1{
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
	@Autowired
	OrderSonService service;
	@Autowired
	MealixMapper mapper21;
	@Autowired
	ShopcartMapper mapper22;
	@Autowired
	productprojectMapper mapper23;
	@Autowired
	orderworkMapper mapper24;
	@Autowired
	ordershopMapper mapper25;
	
	public Usermainorder addUserMainOrder(Usermainorder o) {
		
		if(o.getName2().equals("个人")) {
			//mapper22.deleteUserid(o.getOrdercustomer());
		}
		if(o.getName2().equals("团队")) {
			team t=mapper12.selectByPrimaryKey(o.getOrdercustomer());
			//mapper22.deleteUserid(t.getMainiuserid());
			List<users> list1= new ArrayList<users>();
			List<teammember> list= mapper13.queryBytid(o.getOrdercustomer());
			for (teammember teammember : list) {
				list1.add(mapper1.selectByPrimaryKey(teammember.getMemberid()));
			}
			o.setList(list1);
		}
		o=QueryCunzai(o);
		return o;
	}
	
	public Usermainorder QueryCunzai(Usermainorder o) {
			 Usermainorder or=mapper.QueryCunzai(o);
			if(or!=null) {
				return or;
			}else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				if(o.getList()!=null && o.getList().size()>0) {
					o.setName1("未付款");
					Date date=new Date();
					o.setOrdertime(new Date());
					o.setOrderno(sdf.format(date)+"yxlx");
					mapper.insert(o);
					for(users u:o.getList()) {
						userorder uo=new userorder();
						uo.setOrderno(sdf.format(date)+"yxlx");
						uo.setOrdertime(new Date());
						uo.setOrderuser(o.getOrderuser());
						uo.setOrdercustomer(u.getId());
						uo.setOrdermainid(o.getId());
						uo.setOrderstatus("未付款");
						mapper14.insert(uo);
					}
				}else {
					o.setName1("未付款");
					Date date = new Date();
					o.setOrdertime(new Date());
					o.setOrderno(sdf.format(date)+"yxlx");
					o.setName2("个人"); 
					o.setOrdercustomer(o.getOrdercustomer());
					mapper.insert(o);
					userorder uo=new userorder();
					uo.setOrderno(sdf.format(date)+"yxlx");
					uo.setOrdertime(new Date());
					uo.setOrderuser(o.getOrderuser());
					uo.setOrdercustomer(o.getOrdercustomer());
					uo.setOrdermainid(o.getId());
					uo.setOrderstatus("未付款");
					mapper14.insert(uo);
				}
			}
			return o;
	}

	@Override
	public List<orderson> queryDetails(List<orderson> list) {
		for (orderson orderson : list) {
			if(orderson.getTypeid()==1) {
				project pro= mapper4.selectByPrimaryKey(orderson.getIid());
				pro.setIlist(mapper6.queryimg(orderson.getIid(), orderson.getTypeid()));
				orderson.setIx(pro);
			}else if(orderson.getTypeid()==2) {
				menu me= mapper7.selectByPrimaryKey(orderson.getIid());
				me.setImgs(mapper6.queryimg(orderson.getIid(), orderson.getTypeid()));
				orderson.setIx(me);
			}else if(orderson.getTypeid()==4) {
				bind bid= mapper10.selectByPrimaryKey(orderson.getIid());
				bid.setImg(mapper6.queryimg(orderson.getIid(), orderson.getTypeid()));
				orderson.setIx(bid);
			}else if(orderson.getTypeid()==5) {
				product pro=mapper11.selectByPrimaryKey(orderson.getIid());
				List<productproject> list1= mapper23.queryByProdId(pro.getId());
				double sum=0;
				for (productproject pje : list1) {
					project p= mapper4.selectByPrimaryKey(pje.getProjectid());
					 sum+=p.getPrice();
				}
				pro.setPrice(sum);
				orderson.setIx(pro);
			}else if(orderson.getTypeid()==7) {
				orderson.setIx(mapper9.selectByPrimaryKey(orderson.getIid()));
			}
		}
		
		return list;
	}

	@Override
	public int insertOrderSonAndWork(Usermainorder o) {
		int num=0;
		if(o.getName2().equals("团队")) {
			List<users> list1= new ArrayList<users>();
			List<teammember> list= mapper13.queryBytid(o.getOrdercustomer());
			for (teammember teammember : list) {
				list1.add(mapper1.selectByPrimaryKey(teammember.getMemberid()));
			}
			o.setList(list1);
		}
		Usermainorder uo=QueryCunzai(o);
		uo.setName1("正在进行中");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmsss");
		num=mapper.updateByPrimaryKeySelective(uo);
		List<userorder> list1=mapper14.selectByuidinlist(uo.getId());
		List<orderson> list2=o.getOlist();
		for (userorder userorder : list1) {
			userorder.setOrderstatus("正在进行中");
			num=mapper14.updateByPrimaryKeySelective(userorder);
			for (orderson orderson : list2) {
				orderson.setId(null);
				orderson.setName1(userorder.getId().toString());
					if(orderson.getTypeid()==1||orderson.getTypeid()==5) {
						mapper15.insertSelective(orderson);
						orderwork ow=orderson.getOw();
						ow.setId(null);
						ow.setOrderid(orderson.getId());
						mapper3.insert(ow);
						for (orderproductwork opw : ow.getList()) {
							opw.setId(null);
							opw.setOrderworkid(ow.getId());
							mapper16.insert(opw);
							for (worduser wu : opw.getList()) {
								wu.setId(null);
								wu.setWorkid(opw.getId());
								mapper17.insert(wu);
							}
						}
					}else if(orderson.getTypeid()==2) {
						mapper15.insertSelective(orderson);
						menuorder mo=new menuorder();
						mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
						mo.setCreatetime(new Date());
						mo.setStatuss("正在进行中");
						menu m=mapper7.selectByPrimaryKey(orderson.getIid());
						mo.setPrice(m.getPrice());
						mo.setUserid(userorder.getOrdercustomer());
						mapper18.insert(mo);
						ordershop oss=new ordershop();
						oss.setMenuid(orderson.getIid());
						oss.setNum(1);
						oss.setOrderid(mo.getId());
						oss.setPrice(m.getPrice());
						mapper25.insert(oss);
					}else if(orderson.getTypeid()==4){
						mapper15.insertSelective(orderson);
						bind b=new bind();
						b.setId(orderson.getIid());
						b=mapper10.querybind(b).get(0);
						for (menu mu : b.getList()) {
							menuorder mo=new menuorder();
							mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
							mo.setCreatetime(new Date());
							mo.setStatuss("正在进行中");
							mo.setPrice(mu.getPrice());
							mo.setUserid(userorder.getOrdercustomer());
							mapper18.insert(mo);
							ordershop oss=new ordershop();
							oss.setMenuid(mu.getId());
							oss.setNum(1);
							oss.setOrderid(mo.getId());
							oss.setPrice(mu.getPrice());
							mapper25.insert(oss);
						}
					}else if(orderson.getTypeid()==7) {
						mapper15.insertSelective(orderson);
						orderwork ow=orderson.getOw();
						ow.setId(null);
						ow.setOrderid(orderson.getId());
						mapper3.insert(ow);
						for (orderproductwork opw : ow.getList()) {
							opw.setId(null);
							opw.setOrderworkid(ow.getId());
							mapper16.insert(opw);
							for (worduser wu : opw.getList()) {
								wu.setWorkid(opw.getId());
								num=mapper17.insert(wu);
							}
						}
						List<Mealix> list3=mapper21.queryTid(orderson.getIid());
						for (Mealix mix : list3) {
							if(mix.getTypeid()==2) {
								menuorder mo=new menuorder();
								mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
								mo.setCreatetime(new Date());
								mo.setStatuss("正在进行中");
								menu mus=mapper7.selectByPrimaryKey(mix.getIid());
								mo.setPrice(mus.getPrice());
								mo.setUserid(userorder.getOrdercustomer());
								num=mapper18.insert(mo);
								ordershop oss=new ordershop();
								oss.setMenuid(mix.getIid());
								oss.setNum(1);
								oss.setOrderid(mo.getId());
								oss.setPrice(mus.getPrice());
								num=mapper25.insertSelective(oss);
							}
						}
					}
				}
			}
		return num;
	}
}
