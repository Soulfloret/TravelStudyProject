package com.accp.renyuxuan.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Shopcart;
import com.accp.domain.Usermainorder;
import com.accp.domain.bind;
import com.accp.domain.images;
import com.accp.domain.menu;
import com.accp.domain.menucomment;
import com.accp.domain.menuorder;
import com.accp.domain.menutype;
import com.accp.domain.ordershop;
import com.accp.domain.orderson;
import com.accp.domain.team;
import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.renyuxuan.service.impl.Shopcartserviceimpl;
import com.accp.renyuxuan.service.impl.Usermainorderserviceimpl;
import com.accp.renyuxuan.service.impl.bindserviceimpl;
import com.accp.renyuxuan.service.impl.imagesserviceimpl;
import com.accp.renyuxuan.service.impl.menuTypeserviceimpl;
import com.accp.renyuxuan.service.impl.menucommentserviceimpl;
import com.accp.renyuxuan.service.impl.menuorderserviceimpl;
import com.accp.renyuxuan.service.impl.menuserviceimpl;
import com.accp.renyuxuan.service.impl.ordershopserviceimpl;
import com.accp.renyuxuan.service.impl.ordersonserviceimpl;
import com.accp.renyuxuan.service.impl.teamserviceimpl;
import com.accp.renyuxuan.service.impl.userorderserviceimpl;
import com.accp.yipeng.service.UsersService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("menu")
public class menucontroller {
	
	//菜单
	@Autowired
	menuserviceimpl m;
	//菜单类型
	@Autowired
	menuTypeserviceimpl me;
	//套餐
	@Autowired
	bindserviceimpl b;
	//套餐订单
	@Autowired
	menuorderserviceimpl mo;
	//套餐订单从表
	@Autowired
	ordershopserviceimpl os;
	//
	@Autowired
	UsersService u;
	@Autowired
	ordersonserviceimpl oo;
	//餐饮评论表
	@Autowired
	menucommentserviceimpl mm;
	//用户订单
	@Autowired
	userorderserviceimpl uo;
	//购物车
	@Autowired
	Shopcartserviceimpl sc;
	@Autowired
	Usermainorderserviceimpl umo;
	@Autowired
	teamserviceimpl te;
	@Autowired
	imagesserviceimpl im;
	@Autowired
	UserMainOrderService cyu;
	
	
	//查询后台菜单
	@RequestMapping("/toquerymenu")
	public String toquerymenu(Model model,menu men) {
		if(men.getZdprice()!=null &&men.getZgprice()!=null) {
			Double a=men.getZdprice();
			Double b=men.getZgprice();
			if(a>b) {
				men.setZdprice(b);
				men.setZgprice(a);
			}
		}
		List<menu> list=m.QueryMenu(men);
		model.addAttribute("list",list);
		model.addAttribute("listtype",me.selectByExample(null));
		model.addAttribute("menus",men);
		return "GoodManager";
	}
	
	//菜单添加页面
	@RequestMapping("/tomenuadd")
	public String tomenuadd(Model model) {
		model.addAttribute("list",me.selectByExample(null));
		return "GoodAdd";
	}
	
	
	//菜单上架下架
	@RequestMapping("/sjxj")
	@ResponseBody
	public String sjxj(String type,Integer id) {
		if("上架".equals(type)) {
			menu menus=new menu();
			menus.setState("2");
			menus.setId(id);
			m.updateByPrimaryKeySelective(menus);
			return "下架成功！";
		}else if("下架".equals(type)) {
			menu menus=new menu();
			menus.setState("1");
			menus.setId(id);
			m.updateByPrimaryKeySelective(menus);
			return "上架成功！";
		}
		return "";
	}
	
	
	//菜单删除
	@RequestMapping("/delmenu")
	@ResponseBody
	public String delmenu(Integer id) {
		//m.deleteByPrimaryKey(id);
		return "删除成功！";
	}
	
	
	//菜单添加
	@RequestMapping("/addmenu")
	public String addmenu(menu me) {
		me.setLikecount(0);
		me.setPutawaytime(new Date());
		me.setIntorduce("1");
		me.setStock(1);
		m.insertSelective(me);
		im.insertmenuimglist(me);
		return "redirect:/menu/toquerymenu";
		
	}
	
	//去菜单修改页面
	@RequestMapping("/toupdatemenu")
	public String toupdatemenu(Model model,menu menus) {
		List<menu> list=m.selectmenuByid(menus.getId());
		model.addAttribute("list", list);
		model.addAttribute("listtype",me.selectByExample(null));
		return "GoodUpdate";
	}
	
	//菜单修改
	@RequestMapping("/updatemenu")
	public String updatemenu(menu menus) {
		m.updateByPrimaryKeySelective(menus);
		im.delByiidAndTypeId(menus.getId(), 2);
		im.insertmenuimglist(menus);
		return "redirect:/menu/toquerymenu";
	}
	
	
	//去下订单页面
	@RequestMapping("/tomenuorder")
	public String tomenuorder(Model model,String lx,String mname,Double zdprice,Double zgprice) {
		if(lx==null || lx=="") {
			lx="0";
		}
		bind binds=new bind();
		menu menus=new menu();
		if(zdprice!=null && zgprice!=null) {
			if(zdprice>zgprice) {
				binds.setZdprice(zgprice);
				binds.setZgprice(zdprice);
				menus.setZdprice(zgprice);
				menus.setZgprice(zdprice);
			}else {
				binds.setZdprice(zdprice);
				binds.setZgprice(zgprice);
				menus.setZdprice(zdprice);
				menus.setZgprice(zgprice);
			}
		}else {
			binds.setZdprice(zdprice);
			binds.setZgprice(zgprice);
			menus.setZdprice(zdprice);
			menus.setZgprice(zgprice);
		}
		binds.setMname(mname);
		menus.setMname(mname);
		if("0".equals(lx)) {
			List<menu> mlist=m.QueryMenu(menus);
			List<bind> blist=b.querybind(binds);
			model.addAttribute("mlist", mlist);
			model.addAttribute("blist", blist);
			model.addAttribute("lx", lx);
			model.addAttribute("menus", menus);
			model.addAttribute("binds", binds);
			return "GoodOrderAdd";
		}else if("1".equals(lx)) {
			List<menu> mlist=m.QueryMenu(menus);
			model.addAttribute("mlist", mlist);
			model.addAttribute("lx", lx);
			model.addAttribute("menus", menus);
			model.addAttribute("binds", binds);
			return "GoodOrderAdd";
		}else if("2".equals(lx)) {
			List<bind> blist=b.querybind(binds);
			model.addAttribute("blist", blist);
			model.addAttribute("lx", lx);
			model.addAttribute("menus", menus);
			model.addAttribute("binds", binds);
			return "GoodOrderAdd";
		}
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/orderadd")
	public String orderadd(@RequestBody ordershop [] vps,HttpSession session) {
			users us=u.queryByIdCard(vps[0].getName3());	
			if(us==null) {
				return "redirect:/customer/toadd";
			}
			users xus= (users) session.getAttribute("staff");
			int xusid=2;
			if(xus!=null) {
				xusid=xus.getId();
			}
			if("1".equals(vps[0].getName4())) {
				menuorder m=new menuorder();
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");  
				String datetime = tempDate.format(new Date());
				datetime=datetime+"cy";//订单编号
				m.setOrderrreference(datetime);
				m.setCreatetime(new Date());
				m.setStatuss("1");
				m.setUserid(us.getId());
				m.setPrice(Double.parseDouble(vps[0].getName2()));
				//调方法添加订单
				mo.insertSelective(m);
				Usermainorder usermainorders=new Usermainorder();
				usermainorders.setOrdercustomer(us.getId());
				usermainorders.setOrderuser(xusid);
				usermainorders.setName2("个人");
				Usermainorder Usermainorders =cyu.QueryCunzaiInsert(usermainorders);
				userorder userorder=Usermainorders.getUser().getOrders().get(0);
				for (int i = 0; i < vps.length; i++) {
					ordershop o =new  ordershop();
					o.setOrderid(m.getId());
					o.setMenuid(vps[i].getMenuid());
					o.setNum(vps[i].getNum());
					o.setName1(vps[i].getName1());
					o.setPrice(vps[i].getPrice());
					os.insertSelective(o);//添加餐饮订单从表
					orderson ordersons=new orderson();
					ordersons.setTypeid(Integer.parseInt(vps[i].getName1()));//类型id
					ordersons.setIid(vps[i].getMenuid());//餐饮或餐饮套餐id
					ordersons.setName1(userorder.getId().toString());//用户订单从表id
					oo.insertSelective(ordersons);//添加总订单从表
				}
			}else{
				team t= te.selectBymainiUserId(us.getId());
				Usermainorder usermainorders=new Usermainorder();
				usermainorders.setOrdercustomer(t.getId());
				usermainorders.setOrderuser(xusid); 
				usermainorders.setName2("团队");
				Usermainorder  usermainorderser=cyu.QueryCunzaiInsert(usermainorders);
				for (users u :usermainorderser.getList()) {
					for (userorder userorder : u.getOrders()) {
						menuorder m=new menuorder();
						SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");  
						String datetime = tempDate.format(new Date());
						datetime=datetime+"cy";//订单编号
						m.setOrderrreference(datetime);
						m.setCreatetime(new Date());
						m.setStatuss("1");
						m.setUserid(userorder.getOrdercustomer());
						m.setPrice(Double.parseDouble(vps[0].getName2()));
						//调方法添加订单
						mo.insertSelective(m);
						for (int i = 0; i < vps.length; i++) {
							ordershop o =new  ordershop();
							o.setOrderid(m.getId());
							o.setMenuid(vps[i].getMenuid());
							o.setNum(vps[i].getNum());
							o.setName1(vps[i].getName1());
							o.setPrice(vps[i].getPrice());
							os.insertSelective(o);//添加餐饮订单从表
							orderson ordersons=new orderson();
							ordersons.setTypeid(Integer.parseInt(vps[i].getName1()));
							ordersons.setIid(vps[i].getMenuid());
							ordersons.setName1(userorder.getId().toString());
							oo.insertSelective(ordersons);//添加总订单从表
						}
					}
				}
				
				
			}
			
		return "下单成功！";
	}
	
	//前台查询所有餐饮
	@RequestMapping("/toquerymenu1")
	public String toquerymenu1(Model model) {
		List<menutype> list=me.selectqueryTypemenu(null);
		List<bind> blist=b.querybindQt(null);
		model.addAttribute("blist", blist);
		model.addAttribute("list", list);
		return "menu1";
	}
	
	//根据普通餐饮编号或者套餐编号查询
	@RequestMapping("/toquerymenu1Byid")
	public String toquerymenu1Byid(Model model,Integer id,String type) {
		if("2".equals(type)) {
			List<menu> list=m.selectmenuByid(id);
			model.addAttribute("list", list);
			model.addAttribute("typeid", 2);
		}else if("4".equals(type)) {
			List<bind> list=b.selectbindByid(id);
			model.addAttribute("list", list);
			model.addAttribute("typeid", 4);
		}
		menucomment menucomments=new menucomment();
		menucomments.setMenuid(id);
		menucomments.setName1(type);
		List<menucomment> plist=mm.selectmenucommentByid(menucomments);
		model.addAttribute("plist", plist);
		List<orderson> olist= oo.querytj(null);
		model.addAttribute("olist", olist);
		return "single1";
	}
	
	
	//加入购物车
	@RequestMapping("/shopcartadd")
	@ResponseBody
	public String shopcartadd(Integer iid,Integer typeid,String name1,HttpSession session) {
		users use= (users) session.getAttribute("use");
		Shopcart shopcart=new Shopcart();
		shopcart.setIid(iid);
		shopcart.setTypeid(typeid);
		shopcart.setName2(name1);
		shopcart.setUserid(use.getId());//目前没有登录所以暂时用1
		Shopcart  Shopcarts =sc.selectshopcartByid(shopcart);
		if(Shopcarts==null) {
			sc.insertSelective(shopcart);
		}else {
			Shopcart shopcart1=new Shopcart();
			shopcart1.setId(Shopcarts.getId());
			Integer num= Integer.parseInt(Shopcarts.getName2())+Integer.parseInt(name1);
			shopcart1.setName2(num.toString());
			sc.updateByPrimaryKeySelective(shopcart1);
		}
		return "加入成功！";
	}
	
	@RequestMapping("/fileadd")
	@ResponseBody
	public String fileadd(MultipartFile [] file) {
		String url="d:/fileUpload/";
		File filepath=new File(url);
		if (!filepath.exists()) {
			filepath.mkdirs();
		}
		List<images> ilist=new ArrayList<images>(); 
		try {
			for (MultipartFile f : file) {			
				String uuid=UUID.randomUUID().toString();
				String name=f.getOriginalFilename();
				String suffix=name.substring(name.lastIndexOf("."),name.length());
				File fileImg=new File(url+uuid+suffix);
				f.transferTo(fileImg);
				String img_json="fileupload/"+fileImg.getName();
				images i=new images();
				i.setUrl(img_json);
				i.setTypeid(1);
				ilist.add(i);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSON.toJSONString(ilist);
	}
	
	
}
