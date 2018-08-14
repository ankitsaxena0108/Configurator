package com.prudential.core.common.configuration.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName().trim();
		String pwd = authentication.getCredentials().toString().trim();

		if (name.equals("admin") && pwd.equals("Q1W2E3!@#")) {

			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
					authentication.getName().trim(), authentication.getCredentials(),
					getGrantedAuthorities(null, authentication.getName().trim()));

			result.setDetails(authentication.getDetails());

			return result;

		}

		return null;
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData,
			String username) {
		Set<GrantedAuthority> authorities = new HashSet<>();

		authorities.add(new SimpleGrantedAuthority("BILL_ADMIN"));
		return authorities;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
