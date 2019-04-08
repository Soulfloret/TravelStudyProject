package com.accp.yipeng.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
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
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.users;
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
	 * @return 客户新增页面
	 */
	@RequestMapping("toadd")
	public String toadd() {
		System.out.println("a");
		return "addcustomer";
	}
	
	

	/**
	 * 导入模版
	 * @return
	 */
	@RequestMapping("downloadTemple")
	public ResponseEntity<byte []> downloadTemple() {
		
		try {
			//模版位置
			FileInputStream fis=new FileInputStream("C:/Users/Administrator/Downloads/导出的学生列表数据.xlsx");
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
	 * 
	 * @param file   导入xls Excel
	 * @return
	 */
	
	@RequestMapping("importExcel")
	public String importExcel(MultipartFile file) {
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
			Sheet sheet=workbook.getSheetAt(0);
			//获取所有行
			int rows=sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rows; i++) {
				Row row=sheet.getRow(i);
				Cell id=row.getCell(0);
				Double Value=id.getNumericCellValue();
				int idValue=Value.intValue();
				Cell name=row.getCell(1);
				String nameValue=name.getStringCellValue();
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "001";
		}
		return "redirect:/stu/query";
	}
}
