package com.prudential.core.common.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;


/**
 * 
 * @author syed.mehdi
 *
 */
public class AuthProivderCustom implements AuthProvider {

	@Autowired
	CustomAuthProvider provider;

	@Override
	public AuthProviderType type() {
		return AuthProviderType.CUST;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(provider);
	}

}
