package com.accp.yipeng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
/*
import com.accp.handler.WebSocketHandler;
import com.accp.interceptor.WebSocketInterceptor;*/

/**
 * 注册websocket
 * @author tangyong
 *
 */
@Configuration
public class WebSocketConfig implements WebSocketConfigurer{

	/**
	 * 
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	/*	registry.addHandler(new WebSocketHandler(), "/mywebsocket")
		.setAllowedOrigins("*")
		.addInterceptors(new WebSocketInterceptor());*/
	}

}
