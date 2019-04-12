package com.accp.yipeng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.team;
import com.accp.domain.users;
import com.accp.sunhuihui.service.UserService;
import com.accp.yipeng.service.TeamService;
import com.accp.yipeng.service.TeammemberService;
import com.accp.yipeng.service.UserTypeService;
import com.accp.yipeng.service.UsersService;

@Controller
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	UsersService Use;
	@Autowired
	UserTypeService UsersType;
	@Autowired
	TeamService TeamService;
	@Autowired
	TeammemberService TeammberService;
	@Autowired
	UserService sunService;
	
	@RequestMapping("tologin")
	public String tologin() {
		return "login-page";
	}
	@RequestMapping("login")
	public String login(String uname,String upassword,HttpSession session) {
		users use=sunService.queryByName(uname, upassword);
		if(use!=null){
			session.setAttribute("use", use);
		}else {
			return "redirect/Login/tologin";
		}
		return "pagehome";
	}
	@RequestMapping("toregister")
	public String toregister(Model model) {
		
		model.addAttribute("list",UsersType.selectByExample(null));
		return "register";
	}
	@RequestMapping("register")
	public String register(users user,MultipartFile file,String team) {
		user.setTypeid(Integer.parseInt(team));
		String id= user.getIdcardno();
		String idone=id.substring(14, id.length());
		user.setUname(idone+"yx");
		user.setUpassword(idone+"yx");
		users us=Use.queryByIdCard(id);
		if(team.equals("1")) {
			if(us!=null) {
				return "redirect:/Login/tologin";
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
		
		return "redirect:/Login/tologin";
	}}
