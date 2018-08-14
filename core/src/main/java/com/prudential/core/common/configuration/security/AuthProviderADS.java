package com.prudential.core.common.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.stereotype.Component;

import com.prudential.core.common.properties.CBIProperties;

@Component
public class AuthProviderADS implements AuthProvider {
	private static final Logger logger = LoggerFactory.getLogger(AuthProviderADS.class);
	private static final String ADS_HOST = "auth.host";
	private static final String ADS_PORT = "auth.port";
	private static final String ADS_DOMAIN = "ads.domain";

	private String domain;
	private String url;

	public AuthProviderADS() {

		CBIProperties properties = new CBIProperties();
		
		if(!properties.get("auth.type").equals("ADS"))
			return;
		
		StringBuilder urlBuilder = new StringBuilder("ldap://");
		urlBuilder.append(properties.get(ADS_HOST, "localhost")).append(":");
		urlBuilder.append(properties.get(ADS_PORT)).append("/");

		url = urlBuilder.substring(0, urlBuilder.length() - ",".length());
		domain = properties.get(ADS_DOMAIN);
		logger.debug("Using LDAP url {}, domain {}", url, domain);
	}

	@Override
	public AuthProviderType type() {
		return AuthProviderType.ADS;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	}

	@Bean
	public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
		CBIProperties properties = new CBIProperties();
		
		if(!properties.get("auth.type").equals("ADS"))
			return null;

		
		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(domain, url);
		provider.setConvertSubErrorCodesToExceptions(true);
		provider.setUseAuthenticationRequestCredentials(true);

		return provider;
	}

}
