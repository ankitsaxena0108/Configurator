package com.prudential.core.common.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import com.prudential.core.common.properties.CBIProperties;

@Component
public class AuthProviderLDAP implements AuthProvider {
	private static final Logger logger = LoggerFactory
			.getLogger(AuthProviderLDAP.class);
	private static final String LDAP_HOST = "auth.host";
	private static final String LDAP_PORT = "auth.port";
	private static final String LDAP_DC = "ldap.dc";
	private static final String LDAP_DN = "ldap.ou";

	@Autowired
	@Qualifier("userAuthoritiesPopulator")
	private LdapAuthoritiesPopulator userAuthoritiesPopulator;

	private String dnPattern;
	private String url;

	public AuthProviderLDAP() {
		
		
		CBIProperties properties = new CBIProperties();
		
		if(!properties.get("auth.type").equals("LDAP"))
			return;
		
		
		StringBuilder urlBuilder = new StringBuilder("ldap://");
		urlBuilder.append(properties.get(LDAP_HOST, "localhost")).append(":");
		urlBuilder.append(properties.get(LDAP_PORT)).append("/");

		String[] dcArray = properties.get(LDAP_DC).split(",");
		for (String dc : dcArray) {
			urlBuilder.append("dc=").append(dc).append(",");
		}

		url = urlBuilder.substring(0, urlBuilder.length() - ",".length());
		dnPattern = "ou=" + properties.get(LDAP_DN);
		logger.debug("Using LDAP url {}, dnPattern {}", url, dnPattern);
	}

	@Override
	public AuthProviderType type() {
		return AuthProviderType.LDAP;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns("cn={0}," + dnPattern)
				.contextSource().url(url).and()
				.ldapAuthoritiesPopulator(userAuthoritiesPopulator);
	}

}
