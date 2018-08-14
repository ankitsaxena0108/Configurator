package com.prudential.core.common.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import com.prudential.core.common.configuration.security.AuthProvider;

/**
 * Holds Security Config for the application.
 */

@EnableWebSecurity
public class SecurityConfig {

	private RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();

	@Autowired
	private AuthProvider authProvider;

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		authProvider.configure(auth);

	}

	@Bean
	public AffirmativeBased getAccessDecisionManager() {
		DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
		expressionHandler.setRoleHierarchy(roleHierarchy);

		WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
		webExpressionVoter.setExpressionHandler(expressionHandler);

		List<AccessDecisionVoter<? extends Object>> voters = new ArrayList<>();

		voters.add(webExpressionVoter);
		return new AffirmativeBased(voters);
	}

}
