package com.accp.chenyong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("qs")
public class controller {
	@RequestMapping("query")
	public String query() {
		return "productList";
	}
}
