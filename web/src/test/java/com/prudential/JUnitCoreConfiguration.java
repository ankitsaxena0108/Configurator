package com.prudential;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.prudential.core.common.configuration.CoreConfiguration;

@Configuration
@Import({ CoreConfiguration.class })
public class JUnitCoreConfiguration {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = null;
		try {
			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.hibernate.dialect.OracleDialect");
			dataSource.setUrl("jdbc:oracle:thin:@10.10.12.197:1521:VIET53");
			dataSource.setUsername("system");
			dataSource.setPassword("Password123");
		} catch (Exception e) {
			throw new RuntimeException("Failed to initialize DataSource", e);
		}

		return dataSource;
	}

	@Bean
	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.setProperty("hibernate.default_schema", "cbi");
		properties.setProperty("show_sql", "true");

		return properties;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired Properties additionalProperties) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.prudential.core.common", "com.prudential.core.users", "com.prudential.core.web",
				"com.prudential.core.common.model", "com.prudential.core.common.authority",
				"com.prudential.core.common.locale", "com.prudential.core.cbi.model");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties);
		return em;
	}

}
