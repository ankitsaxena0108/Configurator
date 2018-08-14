package com.prudential.web.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.prudential.core.common.configuration.CoreConfiguration;
import com.prudential.core.common.configuration.SecurityConfig;
import com.prudential.web.configuration.security.WebSecurityConfig;

@Order(1)
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfiguration.class, WebSecurityConfig.class, SecurityConfig.class,
				CoreConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/dynamic/*" };
	}

	@Override
	protected String getServletName() {
		return "mvc";
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(getMultipartConfigElement());
	}

	private MultipartConfigElement getMultipartConfigElement() {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE,
				MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}

	/* Set these variables for your project needs */

	private static final String LOCATION = "C:/mytemp/";

	private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;// 25MB

	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;// 30MB

	private static final int FILE_SIZE_THRESHOLD = 0;

}