package com.accp.sunhuihui.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.actionimages;
import com.accp.domain.stopfcomment;
import com.accp.domain.team;
import com.accp.domain.users;
import com.accp.mapper.actionimagesMapper;
import com.accp.mapper.teamMapper;
import com.accp.mapper.teammemberMapper;
import com.accp.mapper.usersMapper;

@Service
public class UserService {

		@Autowired
		usersMapper mapper;
		@Autowired
		actionimagesMapper amapper;
		@Autowired
		teamMapper TeamMapper;
		@Autowired
		teammemberMapper TeammberMapper;
		
	public users queryByName(@Param("uname")String uname,@Param("upassword")String upassword) {
		return mapper.queryByName(uname, upassword);
	}
	
	public List<actionimages> query(){
		
		return amapper.query();
	}
	
	public users userByid(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	public int addcustomer(users user, MultipartFile file, String team) {
		user.setTypeid(Integer.parseInt(team));
		String id= user.getIdcardno();
		String idone=id.substring(14, id.length());
		user.setUname(idone+"yx");
		user.setUpassword(idone+"yx");
		users us=mapper.queryByIdCard(id);
		int num=0;
		if(team.equals("1")) {
			if(us!=null) {
				return 1;
			}else {
				num=mapper.insert(user);
			}
		}else if(team.equals("2")){
			try {
				XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
				String filename=file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf("."));
				team t=new team();
				if(us!=null) {
					mapper.updateTypeIdById(us.getId(),Integer.parseInt(team));
					t.setMainiuserid(us.getId());
					t.setName1(filename);
				}else {
					mapper.insert(user);
					t.setMainiuserid(user.getId());
					t.setName1(filename);
				}
				TeamMapper.insert(t);
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
					users  uses=mapper.queryByIdCard(idCard1);
					if(uses!=null) {
						System.out.println("ExCel表示此用户已存在");
						list.add(uses.getId());
					}else {
						users u=new users(upassword+"yx",idCard1,phone,address1,height1,width1,1,sex1,upassword+"yx");
						mapper.insert(u);
						list.add(u.getId());
					}
					
					
				}
				num=TeammberMapper.insertBylist(t.getId(), list);
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		return num;
	}
	
	public  team NewTid() {
		return TeamMapper.NewTid();
	}
	
	public List<team> QueryTidUsers(@Param("id")Integer id) {
		return TeamMapper.QueryTidUsers(id);
	}
	
	public List<users> queryIcarno(String idCardNo){
		return mapper.queryIcarno(idCardNo);
	}
}
