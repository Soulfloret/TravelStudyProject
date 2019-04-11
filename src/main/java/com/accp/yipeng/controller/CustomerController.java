package com.accp.yipeng.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.accp.domain.team;
import com.accp.domain.users;
import com.accp.yipeng.service.TeamService;
import com.accp.yipeng.service.TeammemberService;
import com.accp.yipeng.service.UserTypeService;
import com.accp.yipeng.service.UsersService;

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
	
	@RequestMapping("queryByIdCard")
	@ResponseBody
	public users queryByIdCard(String IdCardNo) {
		return Use.queryByIdCard(IdCardNo);
	}
	/**
	 * 客户新增
	 */
	@RequestMapping("addCustomer")
	public String addCustomer(users user,MultipartFile file,String team,HttpServletResponse resp) {
		user.setTypeid(Integer.parseInt(team));
		String id= user.getIdcardno();
		String idone=id.substring(14, id.length());
		user.setUname(idone+"yx");
		user.setUpassword(idone+"yx");
		users us=Use.queryByIdCard(id);
		if(team.equals("1")) {
			if(us!=null) {
				return "redirect:/customer/toCustomer";
			}else {
				Use.insert(user);
			}
		}else if(team.equals("2")){
			team t=new team();
			if(us!=null) {
				Use.updateTypeIdById(us.getId(),Integer.parseInt(team));
				t.setMainiuserid(us.getId());
			}else {
				Use.insert(user);
				t.setMainiuserid(user.getId());
			}
			TeamService.insert(t);
			try {
				XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
				Sheet sheet=workbook.getSheetAt(0);
				//获取所有行
				int rows=sheet.getPhysicalNumberOfRows();
				List<Integer> list=new ArrayList<Integer>();
				for (int i = 1; i < rows; i++) {
					Row row=sheet.getRow(i);
					Cell name=row.getCell(0);
					name.setCellType(CellType.STRING);
					String phone=name.getStringCellValue();
					Cell sex=row.getCell(1);
					String sex1=sex.getStringCellValue();
					Cell height=row.getCell(2);
					Double height1=height.getNumericCellValue();
					Cell width=row.getCell(3);
					Double width1=width.getNumericCellValue();
					Cell address=row.getCell(4);
					String address1=address.getStringCellValue();
					Cell idCard=row.getCell(5);
					String idCard1=idCard.getStringCellValue();
					String upassword=idCard1.substring(14, idCard1.length());
					users  uses=Use.queryByIdCard(idCard1);
					if(uses!=null) {
						System.out.println("ExCel表示此用户已存在");
						list.add(uses.getId());
					}else {
						users u=new users(upassword+"yx",idCard1,phone,address1,height1,width1,1,sex1,upassword+"yx");
						Use.insert(u);
						list.add(u.getId());
					}
					
					
				}
				TeammberService.insertBylist(t.getId(), list);
				
			} catch (IOException e) {
				e.printStackTrace();
				return "001";
			}
		}
		
		return "redirect:/customer/toCustomer";
	}
	
	/**
	 * 导入模版
	 * @return
	 */
	@RequestMapping("downloadTemple")
	public ResponseEntity<byte []> downloadTemple() {
		
		try {
			//模版位置
			FileInputStream fis=new FileInputStream("C:/Users/Administrator/Downloads/客户导入.xlsx");
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
		Calendar cal = Calendar.getInstance();
		if (cal.before(briday)) { //出生日期晚于当前时间，无法计算
	            throw new IllegalArgumentException(
	                    "The birthDay is before Now.It's unbelievable!");
	    }
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH)+1;  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        int yearBirth =briday;
        int monthBirth =Integer.parseInt(use.getIdcardno().substring(10, 12));
        int dayOfMonthBirth =Integer.parseInt(use.getIdcardno().substring(12, 14));
        int age = yearNow - yearBirth;  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) {
                	age--;
                }
            }else{  
                age--;  
            }  
        }  
        use.setAge(age);
		model.addAttribute("user", use);
		return "CustomerCare";
	}
}
