package com.accp.chenyong.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.accp.domain.menuorder;
import com.accp.domain.orderproductwork;
import com.accp.domain.ordershop;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.room;
import com.accp.domain.roomdestine;
import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.domain.worduser;
import com.accp.mapper.MealMapper;
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
	ordershopMapper mapper21;
	
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
		int num=0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmsss");
		if(record.getList()!=null&&record.getList().size()>1) {
				for (users u : record.getList()) {				
					for (userorder uo : u.getOrders()) {
						for (orderson os : uo.getList()) {
							os.setName1(uo.getId()+"");
							os.setId(null);
							os.setName2(1+"");
							if(os.getTypeid()==1||os.getTypeid()==5) {
								mapper15.insert(os);
								orderwork ow=(orderwork)os.getIx();
								ow.setId(null);
								ow.setOrderid(os.getId());
								mapper3.insert(ow);
								for (orderproductwork opw : ow.getList()) {
									opw.setId(null);
									opw.setOrderworkid(ow.getId());
									mapper16.insert(opw);
									for (worduser wu : opw.getList()) {
										wu.setWorkid(opw.getId());
										mapper17.insert(wu);
									}
								}
							}
							if(os.getTypeid()==2) {
								mapper15.insert(os);
								menuorder mo=new menuorder();
								mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
								mo.setCreatetime(new Date());
								mo.setStatuss("正在进行中");
								menu m=mapper7.selectByPrimaryKey(os.getIid());
								mo.setPrice(m.getPrice());
								mo.setUserid(u.getId());
								mapper18.insert(mo);
								ordershop oss=new ordershop();
								oss.setMenuid(os.getIid());
								oss.setNum(1);
								oss.setOrderid(mo.getId());
								oss.setPrice(m.getPrice());
								mapper21.insert(oss);
							}
							if(os.getTypeid()==3) {
								 Calendar ca1 = Calendar.getInstance();
								 ca1.setTime(new Date());//设置起时间
								 ca1.add(Calendar.DATE, 1);
								 roomdestine rd=new roomdestine();
								 rd.setBegintime(new Date());
								 rd.setEndtime(ca1.getTime());
								 rd.setRoomid(os.getIid());
								 rd.setUserid(u.getId());
								 mapper19.insert(rd);
								 os.setIid(rd.getId());
								 mapper15.insert(os);

							}
							if(os.getTypeid()==4) {
								mapper15.insert(os);
								bind b=new bind();
								b.setId(os.getIid());
								b=mapper10.querybind(b).get(0);
								for (menu mu : b.getList()) {
									menuorder mo=new menuorder();
									mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
									mo.setCreatetime(new Date());
									mo.setStatuss("正在进行中");
									mo.setPrice(mu.getPrice());
									mo.setUserid(u.getId());
									mapper18.insert(mo);
									ordershop oss=new ordershop();
									oss.setMenuid(mu.getId());
									oss.setNum(1);
									oss.setOrderid(mo.getId());
									oss.setPrice(mu.getPrice());
									mapper21.insert(oss);
								}
							}
							if(os.getTypeid()==7) {
								Meal m=mapper9.query(os.getIid()).get(0);
								mapper15.insert(os);
								orderwork ow=(orderwork)os.getIx();
								ow.setId(null);
								ow.setOrderid(os.getId());
								mapper3.insert(ow);
								for (orderproductwork opw : ow.getList()) {
									opw.setId(null);
									opw.setOrderworkid(ow.getId());
									mapper16.insert(opw);
									for (worduser wu : opw.getList()) {
										wu.setWorkid(opw.getId());
										mapper17.insert(wu);
									}
								}
								for (Mealix ix  : m.getList()) {
									if(ix.getTypeid()==2) {
										menuorder mo=new menuorder();
										mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
										mo.setCreatetime(new Date());
										mo.setStatuss("正在进行中");
										menu mX=mapper7.selectByPrimaryKey(os.getIid());
										mo.setPrice(mX.getPrice());
										mo.setUserid(u.getId());
										mapper18.insert(mo);
										ordershop oss=new ordershop();
										oss.setMenuid(os.getIid());
										oss.setNum(1);
										oss.setOrderid(mo.getId());
										oss.setPrice(m.getPrice());
										mapper21.insert(oss);
									}
								}
							}
						}
					}
				}
			}else {
					for (orderson os : record.getUser().getOrders().get(0).getList()) {
						os.setName1(record.getUser().getOrders().get(0).getId()+"");
						os.setId(null);
						os.setName2(1+"");
						if(os.getTypeid()==1||os.getTypeid()==5) {
							mapper15.insert(os);
							orderwork ow=(orderwork)os.getIx();
							ow.setOrderid(os.getId());
							ow.setId(null);
							mapper3.insert(ow);
							for (orderproductwork opw : ow.getList()) {
								opw.setId(null);
								opw.setOrderworkid(ow.getId());
								mapper16.insert(opw);
								for (worduser wu : opw.getList()) {
									wu.setWorkid(opw.getId());
									mapper17.insert(wu);
								}
							}
						}
						if(os.getTypeid()==2) {
							mapper15.insert(os);
							menuorder mo=new menuorder();
							mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
							mo.setCreatetime(new Date());
							mo.setStatuss("正在进行中");
							menu m=mapper7.selectByPrimaryKey(os.getIid());
							mo.setPrice(m.getPrice());
							mo.setUserid(record.getOrdercustomer());
							mapper18.insert(mo);
							ordershop oss=new ordershop();
							oss.setMenuid(os.getIid());
							oss.setNum(1);
							oss.setOrderid(mo.getId());
							oss.setPrice(m.getPrice());
							mapper21.insert(oss);
						}
						if(os.getTypeid()==3) {
							Calendar ca1 = Calendar.getInstance();
							 ca1.setTime(new Date());//设置起时间
							 ca1.add(Calendar.DATE, 1);
							 roomdestine rd=new roomdestine();
							 rd.setBegintime(new Date());
							 rd.setEndtime(ca1.getTime());
							 rd.setRoomid(os.getIid());
							 rd.setUserid(record.getUser().getId());
							 mapper19.insert(rd);
							 os.setIid(rd.getId());
							 mapper15.insert(os);
						}
						if(os.getTypeid()==4) {
							mapper15.insert(os);
							bind b=new bind();
							b.setId(os.getIid());
							b=mapper10.querybind(b).get(0);
							for (menu mu : b.getList()) {
								menuorder mo=new menuorder();
								mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
								mo.setCreatetime(new Date());
								mo.setStatuss("正在进行中");
								mo.setPrice(mu.getPrice());
								mo.setUserid(record.getOrdercustomer());
								mapper18.insert(mo);
								ordershop oss=new ordershop();
								oss.setMenuid(mu.getId());
								oss.setNum(1);
								oss.setOrderid(mo.getId());
								oss.setPrice(mu.getPrice());
								mapper21.insert(oss);
							}
						}
						if(os.getTypeid()==7) {
							Meal m=mapper9.query(os.getIid()).get(0);
							mapper15.insert(os);
							orderwork ow=(orderwork)os.getIx();
							ow.setId(null);
							ow.setOrderid(os.getId());
							mapper3.insert(ow);
							for (orderproductwork opw : ow.getList()) {
								opw.setId(null);
								opw.setOrderworkid(ow.getId());
								mapper16.insert(opw);
								for (worduser wu : opw.getList()) {
									wu.setWorkid(opw.getId());
									mapper17.insert(wu);
								}
							}
							for (Mealix ix  : m.getList()) {
								if(ix.getTypeid()==2) {
									menuorder mo=new menuorder();
									mo.setOrderrreference(sdf.format(new Date())+"yxlxcy");
									mo.setCreatetime(new Date());
									mo.setStatuss("正在进行中");
									menu mX=mapper7.selectByPrimaryKey(ix.getIid());
									mo.setPrice(mX.getPrice());
									mo.setUserid(record.getOrdercustomer());
									mapper18.insert(mo);
									ordershop oss=new ordershop();
									oss.setMenuid(ix.getIid());
									oss.setNum(1);
									oss.setOrderid(mo.getId());
									oss.setPrice(m.getPrice());
									mapper21.insert(oss);
								}
							}
						}
					}
			}
		return num;
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
	public List<Usermainorder> query(Usermainorder record) {
		List<Usermainorder> list=mapper.query(record);
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
										orderson.setIx(m);
									}
								}
							}
						}
					}
				}
			}
		return list;
	}
	public Usermainorder QueryCunzai(Usermainorder o) {
		return mapper.QueryCunzai(o);
	}
	@Override
	public Usermainorder QueryCunzaiInsert(Usermainorder o) {
		Usermainorder o1=QueryCunzai(o);
		if(o1!=null) {
			if(o1.getName2().equals("个人")) {
				o1.setUser(mapper1.queryByMainOrderId(o1.getId(),o1.getOrdercustomer()).get(0));
				for (userorder uo : o1.getUser().getOrders()) {
					uo.setList(null);
				}
			}else {
				o1.setList(mapper1.queryByMainOrderId(o1.getId(),null));
				for(users u : o1.getList()) {
					for (userorder uo : u.getOrders()) {
						uo.setList(null);
					}
				}
			}
			return o1;
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
			if(o.getList()!=null&&o.getList().size()>1) {
				o.setName1("正在进行中");
				o.setOrdertime(new Date());
				o.setName2("团队");
				o.setOrderno(sdf.format(new Date())+"yxlx");
				o.setOrdercustomer(o.getOrdercustomer());
				mapper.insert(o);
				for(users u:o.getList()) {
					userorder uo=new userorder();
					uo.setOrderno(sdf.format(new Date())+"yxlx");
					uo.setOrdertime(new Date());
					uo.setOrderuser(o.getOrderuser());
					uo.setOrdercustomer(u.getId());
					uo.setOrdermainid(o.getId());
					uo.setOrderstatus("正在进行中");
					mapper14.insert(uo);
					List<userorder> lisss=new ArrayList<userorder>();
					lisss.add(uo);
					u.setOrders(lisss);
				}
			}else {
				o.setName1("正在进行中");
				o.setOrdertime(new Date());
				o.setOrderno(sdf.format(new Date())+"yxlx");
				o.setName2("个人");
				mapper.insert(o);
				userorder uo=new userorder();
				uo.setOrderno(sdf.format(new Date())+"yxlx");
				uo.setOrdertime(new Date());
				uo.setOrderuser(o.getOrderuser());
				uo.setOrdercustomer(o.getOrdercustomer());
				uo.setOrdermainid(o.getId());
				uo.setOrderstatus("正在进行中");
				mapper14.insert(uo);
				List<userorder> lisss=new ArrayList<userorder>();
				lisss.add(uo);
				o.setUser(mapper1.selectByPrimaryKey(o.getOrdercustomer()));
				o.getUser().setOrders(lisss);
			}
			return o;
		}
	}
	
	public static Date getNextDay(Date date,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +day);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

}
