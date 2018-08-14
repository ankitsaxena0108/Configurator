package com.prudential.core.common.configuration.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.prubsn.adservice._interface.xsd.ADauditBean;
import com.prudential.core.ads.ADSClient;
import com.prudential.core.common.properties.CBIProperties;

@Component
public class WSAuthenticationProvider implements AuthenticationProvider {
	private static Logger logger = LoggerFactory.getLogger(WSAuthenticationProvider.class);

	@Override
	public Authentication authenticate(Authentication authentication) {

		CBIProperties billingSystemProperties = new CBIProperties();

		ADSClient webServiceADSClient = new ADSClient();
		WebAuthenticationDetails wad = (WebAuthenticationDetails) authentication.getDetails();

		String userIPAddress = wad.getRemoteAddress();
		ADauditBean adAuditBean = webServiceADSClient.authenticate(authentication.getName().trim(),
				authentication.getCredentials().toString().trim(), userIPAddress,
				billingSystemProperties.get("channel"));
		if (logger.isDebugEnabled()) {
			if (adAuditBean != null) {
				logger.debug("AD Response Code" + adAuditBean.getResCode());
			} else {
				logger.debug("adAuditBean is null");
			}

		}

		if (adAuditBean.getResCode().equals(billingSystemProperties.get("ads_resp_success"))) {

			if (logger.isDebugEnabled()) {

				logger.debug("User Authenticated:");

			}

			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(adAuditBean.getResCode().trim()));

			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
					authentication.getName().trim(), authentication.getCredentials(),
					getGrantedAuthorities(null, authentication.getName().trim()));

			result.setDetails(authentication.getDetails());

			return result;

		}

		if (logger.isDebugEnabled()) {

			logger.debug("User Not Authenticated:");

		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData,
			String username) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("BILL_ADMIN"));
		return authorities;

	}

}
