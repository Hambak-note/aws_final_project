package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 내가 설정 클래스 파일 (com.example.demo만 componentScan하는 경우)
//default(basePackages="com.example.demo")와 새로운 패키지 모두 추가하는 경우
@ComponentScan
@ComponentScan(basePackages={"upload", "board.spring.mybatis"})
@ComponentScan(basePackages="spring.mybatis")
@ComponentScan(basePackages="websocket")
@ComponentScan(basePackages="dbsecure")
@MapperScan(basePackages={"spring.mybatis", "board.spring.mybatis"})
public class SecnodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecnodApplication.class, args);
	}

}
