package com.accp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.accp.mapper")
public class TravelStudyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelStudyProjectApplication.class, args);
	}

}
