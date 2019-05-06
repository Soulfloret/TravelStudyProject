package com.accp.wujiajun.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.accp.domain.Notice;
import com.accp.domain.positions;
import com.accp.domain.staff;
import com.accp.mapper.positionsMapper;
import com.accp.wujiajun.service.impl.noticeServiceImpl;
import com.accp.wujiajun.service.impl.positionsServiceImpl;
import com.accp.wujiajun.service.impl.staffServiceImpl;

@Controller
@RequestMapping("/notice")
public class noticeController {

	@Autowired
	noticeServiceImpl service;

	@Autowired
	staffServiceImpl service1;

	@Autowired
	positionsServiceImpl service2;

	@RequestMapping("/query")
	public String query(Model model, staff staff) {
		Notice list = service.noticeQuery(2);
		List<staff> sta = service1.staffquery(staff);
		List<positions> pos = service2.selectByExample(null);
		model.addAttribute("list", list);
		model.addAttribute("sta", sta);
		model.addAttribute("pos", pos);
		return "message";
	}

	@RequestMapping("/addmessage")
	@ResponseBody
	public String addmessage(MultipartFile [] file,Notice noti, HttpServletRequest request, String content,String file1,String file2,String file3,String file4) {
		/*List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		String filePath = "e:/fileupload/";
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			if (file.isEmpty()) {
				return "上传第" + (i++) + "个失败";
			}
			String fileName = file.getOriginalFilename();

			File dast = new File(filePath + fileName);
			try {
				file.transferTo(dast);
				System.out.println(dast);
				System.out.println("第" + (i + 1) + "个文件成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "上传第" + (i++) + "个失败";
			}

		}*/
		Date date = new Date();
		noti.setFid(1);
		noti.setTime(date);/*
		noti.setFile1(file1);
		noti.setFile2(file2);
		noti.setFile3(file3);
		noti.setFile4(file4);*/
		noti.setNwid(0);
		noti.setGid(1);
		System.out.println(noti);
		int no = service.noticeInsert(noti);
		System.out.println(no);
		return "上传成功";
	}
}
