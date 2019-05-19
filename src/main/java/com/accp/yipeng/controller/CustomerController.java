package com.accp.yipeng.controller;

import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.Usermainorder;
import com.accp.domain.users;
import com.accp.yipeng.service.ShopCareServcie;
import com.accp.yipeng.service.TeamService;
import com.accp.yipeng.service.TeammemberService;
import com.accp.yipeng.service.UserOrderService;
import com.accp.yipeng.service.UserTypeService;
import com.accp.yipeng.service.UsersService;
import com.accp.yipeng.util.AgeUtil;

/**
 * 
 * @author 客户Controller
 *
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	UsersService Use;
	@Autowired
	UserTypeService UsersType;
	@Autowired
	TeamService TeamService;
	@Autowired
	TeammemberService TeammberService;
	@Autowired
	UserOrderService UseOrderService;
	@Autowired
	ShopCareServcie shopservice;
	//陈勇 
	@Autowired
	UserMainOrderService UmoService;
	
	
	/**
	 * 
	 * @return 客户查询页面
	 */
	@RequestMapping("toCustomer")
	public String toCustomer(Model model,String uname,Integer typeId) {
		String name1=null;
		Integer typeId1=null;
		if(uname!=null) {
			name1=uname;
		}
		if(typeId!=null&& typeId!=-1) {
			typeId1=typeId;
		}
		List<users> list=Use.selectAllUsers(name1, typeId1);
		model.addAttribute("uname", name1);
		model.addAttribute("typeId", typeId1);
		model.addAttribute("list",list);
		model.addAttribute("listUserType", UsersType.selectByExample(null));
		return "customer";
	}
	
	/**
	 * 
	 * @return 去客户新增页面 并查询出可以选择的客户类型
	 */
	@RequestMapping("toadd")
	public String toadd(Model model) {
		model.addAttribute("list",UsersType.selectByExample(null));
		return "addcustomer";
	}
	/**
	 * 
	 * @param IdCardNo  用来判断身份证是否存在
	 * @return
	 */
	@RequestMapping("queryByIdCard")
	@ResponseBody
	public users queryByIdCard(String IdCardNo) {
		return Use.queryByIdCard(IdCardNo);
	}
	/**
	 * 客户新增
	 */
	@RequestMapping("addCustomer")
	public String addCustomer(users user,MultipartFile file,String team) {
		Use.addcustomer(user, file, team);
			return "redirect:/customer/toCustomer";
	}
	
	/**
	 *  查询客户订单
	 */
	@RequestMapping("queryById")
	@ResponseBody
	public Usermainorder queryById(Integer id) {
		return UseOrderService.queryByUserOrderId(id);
	}
	
	
	/**
	 * 导入模版
	 * @return
	 */
	@RequestMapping("downloadTemple")
	public ResponseEntity<byte []> downloadTemple() {
		
		try {
			//模版位置
			FileInputStream fis=new FileInputStream("F:\\y2项目客户导入.xlsx");
			byte [] bytes=new byte[fis.available()];
			fis.read(bytes);
			HttpHeaders headers= new HttpHeaders();
			headers.setContentDispositionFormData("attachment",new String( "客户导入模版.xlsx".getBytes("UTF-8"), "iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(bytes,headers,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *   查看用户详情
	 */
	@RequestMapping("toCustomerDetails")
	public String toCustomerDetails(Integer id,Model model) {
		users use=Use.query(id);
		int briday=Integer.parseInt(use.getIdcardno().substring(6, 10));
		use.setYear(briday);
		use.setMonth(Integer.parseInt(use.getIdcardno().substring(10, 12)));
		use.setDay(Integer.parseInt(use.getIdcardno().substring(12, 14)));
		use.setAge(AgeUtil.getage(use));
		model.addAttribute("user", use);
		List<Usermainorder> list=UmoService.query(null);
		model.addAttribute("list",list);
		return "CustomerCare";
	}
	
	/**
	 * 
	 * @return 去个人中心
	 */
	@RequestMapping("toPerson")
	public  String toPerson(HttpSession session) {
		users uses=(users)session.getAttribute("use");
		if(uses==null) {
			return "redirect:/Login/tologin";
		}
		return "Person";
	}

	/**
	 * 
	 * @return 首页
	 */
	@RequestMapping("topagehome")
	public  String topagehome() {
		return "pagehome";
	}

	
	/**
	 * 
	 * @return 前台订单
	 */
	@RequestMapping("toOrders")
	public  String toOrders(Model model,HttpSession session) {
		users use=(users)session.getAttribute("use");
		model.addAttribute("list",UmoService.query(null));
		model.addAttribute("olist",UseOrderService.selectAllUserOrderById(use.getId()));
		model.addAttribute("user", use);
		return "NewMainOrder";
	}
	
	
	/**
	 * 		个人信息详情查询  
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("toPersonDetails")
	public  String toPersonDetails(Model model,HttpSession session) {
		users uses=(users)session.getAttribute("use");
		users use=Use.query(uses.getId());
		int age=AgeUtil.getage(use);
        use.setAge(age);	
		model.addAttribute("users",use);
		return "info";
	}
	
	/**
	 * 		去修改个人信息详情  
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("updateinfo")
	public  String updateinfo(Model model,HttpSession session) {
		users uses=(users)session.getAttribute("use");
		users use=Use.query(uses.getId());
		int age=AgeUtil.getage(use);
        use.setAge(age);
		model.addAttribute("users",use);
		return "updateinfo";
	}
	
	/**
	 * 	修改客户信息
	 * @param users
	 * @return
	 */
	@RequestMapping("updateUsers")
	public  String updateUsers(users use) {
		Use.updateByPrimaryKey(use);
		return "redirect:/customer/toPersonDetails";
	}
	
	@RequestMapping("look")
	public String look(Model model,HttpSession session){
		users use=(users)session.getAttribute("use");
		if(use==null) {
			return "redirect:/Login/tologin";
		}else {
			model.addAttribute("list",shopservice.queryAll(use.getId()));
			return "cart";
		}
	}
	
	@RequestMapping("delshopCart")
	@ResponseBody 
	public int delshopCart(Integer id) {
		return shopservice.deleteByPrimaryKey(id);
	}
	
}
