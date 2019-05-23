package com.accp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
@SpringBootApplication
@MapperScan("com.accp.mapper")
@EnableWebSocket
@EnableScheduling
public class TravelStudyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelStudyProjectApplication.class, args);
	}

}
