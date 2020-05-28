package com.dib.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dib.config.RootAppConfig;
import com.dib.config.WebMVCAppConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return  new Class[] {WebMVCAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"*.htm"};
	}

}
