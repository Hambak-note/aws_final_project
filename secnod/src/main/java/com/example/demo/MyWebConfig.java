package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
	
	//for linux
	static final public String savepath = "/usr/upload/";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//for linux
		//putty로 서버 접속 후
		//mkdir /usr/upload 실행 후
		registry.addResourceHandler("/upload/**")
				.addResourceLocations("file:/usr/upload/");
		
	}
}
