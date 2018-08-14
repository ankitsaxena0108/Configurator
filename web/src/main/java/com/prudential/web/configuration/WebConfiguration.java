package com.prudential.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.prudential.web" })
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("");
		viewResolver.setSuffix("");
		registry.viewResolver(viewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/app/**").addResourceLocations("/app/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
		registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
		registry.addResourceHandler("/*").addResourceLocations("/");
	}

	// @Override
	// public void configureMessageConverters(List<HttpMessageConverter<?>>
	// converters) {
	// converters.add(new MappingJackson2HttpMessageConverter());
	//
	// super.configureMessageConverters(converters);
	// }

	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addViewController("/login").setViewName("login");
	// registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	// }

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("POST", "GET", "OPTIONS", "PUT", "DELETE").allowedHeaders("*")
				.allowedOrigins("*");
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

}