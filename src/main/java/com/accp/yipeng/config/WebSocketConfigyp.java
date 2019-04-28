package com.accp.yipeng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.accp.yipeng.controller.WebSocketInterceptor;

@Configuration
public class WebSocketConfigyp implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new WebSocketHandleryp(), "/mywebsocket")
		.setAllowedOrigins("*")
		.addInterceptors(new WebSocketInterceptor());
	}
}
