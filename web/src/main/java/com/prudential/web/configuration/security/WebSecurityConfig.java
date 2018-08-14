package com.prudential.web.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Web Security Configuration for the Application.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory
			.getLogger(WebSecurityConfig.class);

	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Configuring HTTPSecurity");

        http.httpBasic();
		
		http.authorizeRequests()
                .antMatchers("/app/**", "/assets/**", "/fonts/**", "/scripts/**", "/styles/**", "/*.html", "/*.ico","/*.png", "/agentReq/**")
                .permitAll().anyRequest().authenticated();

        http.formLogin()
				.loginPage("/").successForwardUrl("/")
				.failureUrl("/").permitAll();

        http.logout().clearAuthentication(true)
				.deleteCookies("XSRF-TOKEN", "JSESSIONID")
				.invalidateHttpSession(true);

        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        
        http.headers().frameOptions().disable();
//        http.formLogin()
//				.loginPage("/login").successForwardUrl("/")
//				.failureUrl("/login?error").permitAll().and().logout()
//				.clearAuthentication(true)
//				.deleteCookies("XSRF-TOKEN", "JSESSIONID")
//				.invalidateHttpSession(true).and().cors().disable().csrf()
//				.disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//web.ignoring().antMatchers("/ws/**","/dynamic/agentReq/**", "/dynamic/document/view/*");
		web.ignoring().antMatchers("/ws/**","/dynamic/agentReq/**");
	}
}
