package com.prudential.core.common.configuration;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.camel.component.jpa.JpaComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.prudential.core.common.configuration.camelconfiguration.CBICamelConfiguration;
import com.prudential.core.common.configuration.security.AuthProivderCustom;
import com.prudential.core.common.configuration.security.AuthProvider;
import com.prudential.core.common.configuration.security.AuthProviderADS;
import com.prudential.core.common.configuration.security.AuthProviderLDAP;
import com.prudential.core.common.configuration.security.WSAuthProvider;
import com.prudential.core.common.dao.CoreDaoPackageScan;
import com.prudential.core.common.properties.CBIProperties;
import com.prudential.core.common.service.CoreServicePackageScan;

/**
 * API Configuration for all modules - should be named more appropriately e.g.
 * CommonConfiguration. Also, should be moved to appropriate project.
 *
 * Serves the purpose of providing all Hibernate common services.
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.prudential.core", "com.prudential.users", "com.prudential.cbi",
		"com.prudential.web"

})
@EnableJpaAuditing
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = { CoreServicePackageScan.class, CoreDaoPackageScan.class }, basePackages = {
		"com.prudential.core", "com.prudential.users", "com.prudential.cbi", "com.prudential.web",
		"com.prubsn.adservice._interface.xsd"

})
public class CoreConfiguration {
	private final static Logger logger = LoggerFactory.getLogger(CoreConfiguration.class);
	public static final String TABLE_AUTO_NUMBER = "COR_AUTO_NUMBER";

	@Bean
	public DataSource dataSource() {
		CBIProperties cbiProperties = new CBIProperties();
		DataSource ds = null;
		try {
			logger.debug("Initializing DataSource...");
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) envContext.lookup(cbiProperties.get("datasource"));
			// ds.
		} catch (NamingException e) {
			logger.error("Check Tomcat Configuration conf/context.xml for datasouce i.e. <Resource .../> entry", e);
			throw new RuntimeException("Failed to initialize DataSource", e);
		}

		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired Properties additionalProperties) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.prudential.core", "com.prudential.users", "com.prudential.cbi", "com.prudential.web");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties);
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public AuthProvider authProvider() {
		logger.debug("Auth Type: {0}" , CBIProperties.getAuthProviderType());
		if ("ADS".equals(CBIProperties.getAuthProviderType())) {
			return new AuthProviderADS();
		}

		if ("WS".equals(CBIProperties.getAuthProviderType())) {
			return new WSAuthProvider();
		}

		if ("CUSTOM".equals(CBIProperties.getAuthProviderType())) {
			return new AuthProivderCustom();
		}
		return new AuthProviderLDAP();
	}

	@Bean
	public Properties additionalProperties() {
		Properties properties = new Properties();
		CBIProperties cbiProperties = new CBIProperties();
		properties.setProperty("hibernate.dialect", cbiProperties.get("hibernate.dialect"));
		properties.setProperty("hibernate.jdbc.batch_size", cbiProperties.get("hibernate.jdbc.batch_size"));
		properties.setProperty("hibernate.default_schema", cbiProperties.get(CBIProperties.SCHEMA_NAME));
		properties.setProperty("show_sql", "true");
		return properties;
	}

	@Bean(name = "jpa")
	public JpaComponent jpaCompoment(EntityManagerFactory entityManagerFactory,
			PlatformTransactionManager transactionManager) {
		JpaComponent jpaComponent = new JpaComponent();
		jpaComponent.setEntityManagerFactory(entityManagerFactory);
		jpaComponent.setTransactionManager(transactionManager);
		jpaComponent.setSharedEntityManager(true);
		jpaComponent.setJoinTransaction(false);
		return jpaComponent;
	}

	@Bean
	public CBICamelConfiguration camelConfiguration(@Autowired Properties additionalProperties,
			EntityManagerFactory emf) throws Exception {
		CBICamelConfiguration camelConfiguration = new CBICamelConfiguration(
				jpaCompoment(entityManagerFactory(additionalProperties).getObject(), transactionManager(emf)));
		return camelConfiguration;
	}

}
