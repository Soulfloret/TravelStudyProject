package com.accp.xiangjianbo.controller;

import java.io.File;
import java.io.IOException;
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

import com.accp.domain.projecttype;
import com.accp.domain.users;

import com.accp.xiangjianbo.service.areasService;
import com.accp.xiangjianbo.service.project_PositionsService;
import com.accp.xiangjianbo.service.shopcartService;
import com.accp.xiangjianbo.service.productareasService;
import com.accp.xiangjianbo.service.projectService;
import com.accp.xiangjianbo.service.projectTypeService;
import com.accp.xiangjianbo.service.usersService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.accp.domain.Shopcart;
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
	
	@Autowired
	shopcartService shopservice;
	
	/*閺屻儴顕楅幍锟介張锟�*/
	@RequestMapping("query")
	public String query(Model model,project pro) {
		List<project> list=pros.queryAll(pro);
		model.addAttribute("list", list);
		return "project";
	}
	
	/*閸掍即銆嶉惄顔芥煀婢х偤銆夐棃锟�*/
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
	
	
	/*閺傛澘顤冩い鍦窗閺屻儴顕楃拹鐔荤煑娴滅d*/
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
	
	/*閺屻儴顕楁い鍦窗鐠囷附鍎�*/
	@RequestMapping("toproject_xq")
	public String toproject_xq(Model model,Integer id) {
		project list=pros.projectXq_queryById(id);
		
		model.addAttribute("list",list);
		return "edit-project";
	}
	
	/*閺傛澘顤冩い鍦窗*/
	@RequestMapping("file")
	@ResponseBody
	public String file(MultipartFile [] file,project pro) {
		String url="d:/fileupload/";
		File filepath=new File(url);
		if (!filepath.exists()) {
			filepath.mkdirs();
		}
		List<images> ilist=new ArrayList<images>(); 
		try {
			for (MultipartFile f : file) {			
				String uuid=UUID.randomUUID().toString();//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鍕熼敓閾板嚖鎷烽敓锟�
				String name=f.getOriginalFilename();//閿熸枻鎷峰彇閿熸枻鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
				String suffix=name.substring(name.lastIndexOf("."),name.length());//閿熸枻鎷峰彇閿熸枻鎷烽敓渚ョ》鎷烽敓渚ョ尨鎷风紑閿熸枻鎷�
				File fileImg=new File(url+uuid+suffix);//閿熸枻鎷烽敓鏂ゆ嫹閿熶茎纭锋嫹璺敓鏂ゆ嫹
				f.transferTo(fileImg);//閿熸枻鎷烽敓鏂ゆ嫹閿熶茎纭锋嫹
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
	
	@RequestMapping("/project_insert")
	@ResponseBody
	public String project_insert(project pro) {
		pro.setPstatus("1");
		int i=pros.insert(pro);
		return "";
	}
	
	/*妞ゅ湱娲伴弻銉嚄閸╁搫婀�*/
	@RequestMapping("queryJd")
	@ResponseBody
	public List<productarea> queryJd(Integer pid){
		List<productarea> list=pas.queryByPid(pid);
		
		return list;
	}
	
	/*鐠哄疇娴嗛崜宥呭酱閺屻儴顕楁い鍦窗*/
	@RequestMapping("query_Qt")
	public String query_Qt(Model model,project pro,Integer currentPage) {
		Integer cPage=1;
		if (currentPage!=null) {
			cPage=currentPage;
		}
		PageHelper.startPage(cPage, 6, true);
		List<projecttype> type_list=ptype.query();
		List<project> list=pros.queryAll(pro);
		PageInfo<project> page=new PageInfo<project>(list);
		model.addAttribute("type_list", type_list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "productList";
	}
	
	
	
	/*閸撳秴褰撮弻銉嚄鐠囷附鍎�*/
	@RequestMapping("queryBy_Qt_Xq")
	public String queryBy_Qt_Xq(Model model,Integer id) {
		project list=pros.projectXq_queryById(id);
		
		/*for(int i=0;i<list.getIlist().size();i++) {
			project plist=new project();
			if(list.getIlist().get(i)!=null) {
				
			}
		}*/
		model.addAttribute("list",list);
		return "productInfo";
	}
	
	/*鐠哄疇娴嗘穱顔芥暭妞ょ敻娼�*/
	@RequestMapping("/to_Update_Project")
	public String to_Update_Project(Model model,Integer id) {
		project list=pros.projectXq_queryById(id);
		model.addAttribute("list",list);
		return "update_project";
	}
	
	/*项目加入购物车*/
	@RequestMapping("/insert_shop")
	@ResponseBody
	public String insert_shop(@RequestBody Shopcart record,HttpSession session) {
		users user=(users) session.getAttribute("use");
		record.setUserid(user.getId());
		record.setTypeid(1);
		int i=shopservice.insert(record);
		return "";
	}

}
