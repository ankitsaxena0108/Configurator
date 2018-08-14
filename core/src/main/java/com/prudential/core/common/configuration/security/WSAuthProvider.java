package com.prudential.core.common.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.prudential.core.common.authority.UserAuthoritiesPopulator;



public class WSAuthProvider implements AuthProvider {

	private static final Logger logger = LoggerFactory
			.getLogger(WSAuthProvider.class);

	
	@Autowired
	WSAuthenticationProvider provider;
	
	
	
	@Override
	public AuthProviderType type() {
		return AuthProviderType.WS;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(provider);
	}

}
