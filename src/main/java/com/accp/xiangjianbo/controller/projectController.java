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
import com.accp.xiangjianbo.service.productareasService;
import com.accp.xiangjianbo.service.projectService;
import com.accp.xiangjianbo.service.projectTypeService;
import com.accp.xiangjianbo.service.usersService;
import com.alibaba.fastjson.JSON;
import com.accp.domain.areas;
import com.accp.domain.images;
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
	
	@RequestMapping("query")
	public String query(Model model,project pro) {
		List<project> list=pros.queryAll(pro);
		System.out.println(JSON.toJSONString(list));
		model.addAttribute("list", list);
		return "project";
	}
	
	@RequestMapping("toinsert")
	public String toinsert(Model model,areas area,String name) {
		List<projecttype> typelist=ptype.query();
		List<areas> alist=areas.selectByExample(area);
		model.addAttribute("typelist", typelist);
		model.addAttribute("alist", alist);
		return "insert_project";
	}
	
	
	
	@RequestMapping("/queryName")
	@ResponseBody
	public users queryName(String name) {
		users project_user=user.queryByName(name);
		return project_user;
	}
	
	@RequestMapping("toproject_xq")
	public String toproject_xq() {
		return "edit-project";
	}
	
	@RequestMapping("file")
	@ResponseBody
	public String file(MultipartFile [] file,project pro) {
		String url="d:/fileupload/";
		File filepath=new File(url);
		if (!filepath.exists()) {//判断文件夹中是否有如果没有就添加
			filepath.mkdirs();
		}
		List<images> ilist=new ArrayList<images>(); 
		try {
			for (MultipartFile f : file) {			
				String uuid=UUID.randomUUID().toString();//随机生成文件路径
				String name=f.getOriginalFilename();//获取到文件的名字
				String suffix=name.substring(name.lastIndexOf("."),name.length());//获取到文件的后缀名
				File fileImg=new File(url+uuid+suffix);//整个文件路径
				f.transferTo(fileImg);//放入文件
				String img_json=JSON.toJSONString(fileImg);
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
		pro.setIlist(ilist);
		pro.setPstatus("1");
		int i=pros.insert(pro);
		return "redirect:query";
	}
	
	@RequestMapping("queryJd")
	@ResponseBody
	public List<productarea> queryJd(Integer pid){
		List<productarea> list=pas.queryByPid(pid);
		return list;
	}
	
	
}
