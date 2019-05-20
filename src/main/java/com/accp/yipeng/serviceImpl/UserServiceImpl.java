package com.accp.yipeng.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.team;
import com.accp.domain.users;
import com.accp.domain.usersExample;
import com.accp.mapper.teamMapper;
import com.accp.mapper.teammemberMapper;
import com.accp.mapper.usersMapper;
import com.accp.yipeng.service.UsersService;

@Service
@Transactional
public class UserServiceImpl implements UsersService {
 
	@Autowired
	usersMapper mapper;
	@Autowired
	teamMapper TeamMapper;
	@Autowired
	teammemberMapper TeammberMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<users> selectAllUsers(String uname, Integer typeId) {
		// TODO Auto-generated method stub
		return mapper.selectAllUsers(uname, typeId);
	}

	@Override
	public int insert(users record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<users> selectByExample(usersExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public users query(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(users record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public users queryByIdCard(String idCardNo) {
		// TODO Auto-generated method stub
		return mapper.queryByIdCard(idCardNo);
	}

	@Override
	public int updateTypeIdById(Integer id, Integer typeId) {
		// TODO Auto-generated method stub
		return mapper.updateTypeIdById(id, typeId);
	}

	@Override
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
				list.add(t.getMainiuserid());
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
	
}
