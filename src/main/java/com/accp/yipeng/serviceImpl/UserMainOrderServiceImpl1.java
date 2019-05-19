package com.accp.yipeng.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.OrderSonService;
import com.accp.domain.Meal;
import com.accp.domain.Mealix;
import com.accp.domain.Shopcart;
import com.accp.domain.Usermainorder;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
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
	
	public int addUserMainOrder(Usermainorder o) {
		int num=0;
		for (orderson ods : o.getOlist()) {
			Shopcart shop=new Shopcart(ods.getId(),ods.getIid(), ods.getTypeid(), ods.getName1(),ods.getName2());
			mapper22.updateByPrimaryKeySelective(shop);
		}
		if(o.getName2().equals("团队")) {
			List<users> list1= new ArrayList<users>();
			List<teammember> list= mapper13.queryBytid(o.getOrdercustomer());
			for (teammember teammember : list) {
				list1.add(mapper1.selectByPrimaryKey(teammember.getMemberid()));
			}
			o.setList(list1);
		}
		o=QueryCunzai(o);
		return num;
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
						teammember tm=new teammember();
						tm.setMemberid(u.getId());
						tm.setTeamid(o.getOrdercustomer());
						mapper13.insert(tm);
						userorder uo=new userorder();
						uo.setOrderno(sdf.format(date)+"yxlx");
						uo.setOrdertime(new Date());
						uo.setOrderuser(o.getOrderuser());
						uo.setOrdercustomer(o.getOrdercustomer());
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
}
