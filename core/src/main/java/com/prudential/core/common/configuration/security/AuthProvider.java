package com.prudential.core.common.configuration.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public interface AuthProvider {
public AuthProviderType type();
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception;
	
	public enum AuthProviderType {
		LDAP,ADS,WS, CUST;
	}
}
