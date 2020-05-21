package com.dib.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.dib")
@EnableWebMvc
public class RootAppConfig {
	
	@Bean
	public InternalResourceViewResolver createIRVR() {
		InternalResourceViewResolver irvr=null;
		irvr=new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/pages");
		irvr.setSuffix("*.jsp");
		return irvr;
	}
	

}
