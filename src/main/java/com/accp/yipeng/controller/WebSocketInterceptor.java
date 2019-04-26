package com.accp.yipeng.controller;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.accp.domain.users;


@Component
public class WebSocketInterceptor implements HandshakeInterceptor{

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		/**
		 * 匹配用户(获取http session中的用户) 将用户存储在 ws:session 中 
		 *//*
		ServletServerHttpRequest servletreq=(ServletServerHttpRequest)request;
		//从http req 获取session中的用户对象 
		//users use=(users)servletreq.getServletRequest().getSession().getAttribute("use");
		if(use!=null) {
			attributes.put("uid", use.getId());
			return true;
		}
		String use=servletreq.getServletRequest().getParameter("id");
		int useid=Integer.parseInt(use);
		if(useid!=0) {
			attributes.put("uid", useid);
			return true;
		}*/
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}
	
}
