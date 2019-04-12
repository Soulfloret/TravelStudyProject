package com.accp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.accp.sunhuihui.controller.WebScoketInteceptor;


@Configuration
public class WebSocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new WebSocketHandler(), "/mywebsocket")
		.setAllowedOrigins("*")
		.addInterceptors(new WebScoketInteceptor());
	}
}
