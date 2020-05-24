package com.dib.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dib.config.RootAppConfig;
import com.dib.config.WebMVCAppConfig;

public class MyWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer::0-param constructor");
		}
	
	@Override
	public Class<?>[] getRootConfigClasses() {
		System.out.println("MyWebAppInitializer.getRootConfigClasses()");
		return new Class[] {RootAppConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		System.out.println("MyWebAppInitializer.getServletConfigClasses()");
		return new Class[] {WebMVCAppConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"*.htm"};
	}
	
	

}