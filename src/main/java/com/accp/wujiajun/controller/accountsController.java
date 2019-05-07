package com.accp.wujiajun.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.staff;
import com.accp.wujiajun.service.impl.accountsServiceImpl;

@Controller
@RequestMapping("/accounts")
public class accountsController {

	@Autowired
	accountsServiceImpl service;

	@RequestMapping("/query")
	public String query(HttpSession session, Model model) {
		staff sta = (staff) session.getAttribute("staff");
		staff stas = service.accountsQuery(sta.getId());
		model.addAttribute("list", stas);
		return "accounts";
	}

	@RequestMapping("/update")
	public String update(HttpSession session, MultipartFile file) {
		String url = "e:/fileupload/";
		File filepath = new File(url);
		if (!filepath.exists()) {
			filepath.mkdirs();
		}
		try {
			String uuid = UUID.randomUUID().toString();
			String name = file.getOriginalFilename();
			String suffix = name.substring(name.lastIndexOf("."), name.length());
			File fileImg = new File(url + uuid + suffix);
			file.transferTo(fileImg);
			String img_json = "fileupload/" + fileImg.getName();
			staff sta = (staff) session.getAttribute("staff");
			staff stas = service.accountsQuery(sta.getId());
			System.out.println(stas.getUserid());
			int i = service.accountsUpdate(stas.getUserid(), img_json);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:query";
	}
	
	@RequestMapping("/updateById")
	public 	String updateid(HttpSession session,String uname,String phone,String upassword) {
		staff sta = (staff) session.getAttribute("staff");
		staff stas = service.accountsQuery(sta.getId());
		System.out.println(stas.getUserid()+"."+uname+"."+phone+"."+upassword);
		int i=service.updateById(stas.getUserid(), uname, phone, upassword);
		return "redirect:query";
	}
}
