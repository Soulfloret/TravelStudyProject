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
import com.accp.domain.images;
import com.accp.domain.positions;
import com.accp.domain.staff;
import com.accp.mapper.positionsMapper;
import com.accp.wujiajun.service.impl.imagesserviceimpl;
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
	
	@Autowired
	imagesserviceimpl service3;

	@RequestMapping("/query")
	public String query(Model model, staff staff) {
		List<Notice> list = service.noticeQuery(3);
		List<staff> sta = service1.staffquery(staff);
		List<positions> pos = service2.selectByExample(null);
		model.addAttribute("list", list);
		model.addAttribute("sta", sta);
		model.addAttribute("pos", pos);
		return "message";
	}

	@RequestMapping("/addmessage") /*
									 * @ResponseBody
									 */
	public String addmessage(MultipartFile[] files, images imgs, Notice noti, HttpServletRequest request) {
		String path = "e:/fileupload/";
		Date date = new Date();
		noti.setTime(date);
		noti.setFid(3);
		noti.setNwid(0);
		noti.setGid(1);
		service.noticeInsert(noti);
		for (int i = 0; i < files.length; i++) {
			// �ж��ļ��Ƿ�Ϊ��
			if (files[i].isEmpty()) {
				return "��" + (i + 1) + "���ļ�Ϊ��";
			}
			String fileName = files[i].getOriginalFilename();
			String fileNameSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			// �����ļ�����
			String Suffix = "png/jpg/txt";
			if (Suffix.indexOf(fileNameSuffix) < 0) {
				return "��" + (i + 1) + "�ļ����Ͳ���ȷ";
			}
			int size = (int) files[i].getSize();
			System.out.println("size:" + size);
			if (size > 1024 * 1024) {
				return "��" + (i + 1) + "�ϴ��ļ��������ϴ�С��1MB��С���ļ�";
			}
			String fileNamePrefix = fileName.substring(0, fileName.lastIndexOf("."));
			// ��ȡ�ϴ��ļ���
			fileName = fileNamePrefix + "-" + System.currentTimeMillis() + "." + fileNameSuffix;
			
			
			images imas=new images();
			imas.setIid(noti.getId());
			imas.setTypeid(10);
			imas.setUrl(fileName);
			service3.insertSelective(imas);
			File targetFile = new File(path + "/" + fileName);
			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			try {
				files[i].transferTo(targetFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:query";
	}
}
