package com.accp.xiangjianbo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.projecttype;
import com.accp.domain.users;

import com.accp.xiangjianbo.service.areasService;
import com.accp.xiangjianbo.service.project_PositionsService;
import com.accp.xiangjianbo.service.productareasService;
import com.accp.xiangjianbo.service.projectService;
import com.accp.xiangjianbo.service.projectTypeService;
import com.accp.xiangjianbo.service.usersService;
import com.alibaba.fastjson.JSON;
import com.accp.domain.areas;
import com.accp.domain.images;
import com.accp.domain.positions;
import com.accp.domain.productarea;
import com.accp.domain.project;

@Controller
@RequestMapping("xjb_projectController")
public class projectController {

	@Autowired
	projectTypeService ptype;
	
	@Autowired
	areasService areas;
	
	@Autowired
	projectService pros;
	
	@Autowired
	usersService user;
	
	@Autowired
	productareasService pas;
	
	@Autowired
	project_PositionsService posservice;
	
	/*查询所有*/
	@RequestMapping("query")
	public String query(Model model,project pro) {
		List<project> list=pros.queryAll(pro);
		
		model.addAttribute("list", list);
		return "project";
	}
	
	/*到项目新增页面*/
	@RequestMapping("toinsert")
	public String toinsert(Model model,areas area,String name) {
		List<projecttype> typelist=ptype.query();
		List<areas> alist=areas.insery_project_query_area();
		List<positions> pslist=posservice.queryPosition();
		model.addAttribute("pslist", pslist);
		model.addAttribute("typelist", typelist);
		model.addAttribute("alist", alist);
		return "insert_project";
	}
	
	
	/*新增项目查询负责人id*/
	@RequestMapping("/queryName")
	@ResponseBody
	public users queryName(String name) {
		users project_user=user.queryByName(name);
		if(project_user!=null) {
			
			return project_user;
		}else {
			return null;
		}
	}
	
	/*查询项目详情*/
	@RequestMapping("toproject_xq")
	public String toproject_xq(Model model,Integer id) {
		project list=pros.projectXq_queryById(id);
		System.out.println(JSON.toJSONString(list));
		model.addAttribute("list",list);
		return "edit-project";
	}
	
	/*新增项目*/
	@RequestMapping("file")
	@ResponseBody
	public String file(MultipartFile [] file,project pro) {
		String url="d:/fileupload/";
		File filepath=new File(url);
		if (!filepath.exists()) {//�ж��ļ������Ƿ������û�о����
			filepath.mkdirs();
		}
		List<images> ilist=new ArrayList<images>(); 
		try {
			for (MultipartFile f : file) {			
				String uuid=UUID.randomUUID().toString();//��������ļ�·��
				String name=f.getOriginalFilename();//��ȡ���ļ�������
				String suffix=name.substring(name.lastIndexOf("."),name.length());//��ȡ���ļ��ĺ�׺��
				File fileImg=new File(url+uuid+suffix);//�����ļ�·��
				f.transferTo(fileImg);//�����ļ�
				String img_json="fileupload/"+fileImg.getName();
				images i=new images();
				System.out.println(img_json);
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
		pro.setIlist(ilist);
		pro.setPstatus("1");
		int i=pros.insert(pro);
		return "redirect:query";
	}
	
	/*项目查询基地*/
	@RequestMapping("queryJd")
	@ResponseBody
	public List<productarea> queryJd(Integer pid){
		List<productarea> list=pas.queryByPid(pid);
		System.out.println(JSON.toJSONString(list));
		return list;
	}
	
	/*跳转前台查询项目*/
	@RequestMapping("query_Qt")
	public String query_Qt(Model model,project pro) {
		List<projecttype> type_list=ptype.query();
		List<project> list=pros.queryAll(pro);
		model.addAttribute("type_list", type_list);
		model.addAttribute("list", list);
		return "productList";
	}
	
	
	
	/*前台查询详情*/
	@RequestMapping("queryBy_Qt_Xq")
	public String queryBy_Qt_Xq(Model model,Integer id) {
		project list=pros.projectXq_queryById(id);
		System.out.println(JSON.toJSONString(list));
		/*for(int i=0;i<list.getIlist().size();i++) {
			project plist=new project();
			if(list.getIlist().get(i)!=null) {
				
			}
		}*/
		model.addAttribute("list",list);
		return "productInfo";
	}
	
}
