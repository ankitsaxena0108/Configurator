package com.prudential.route;

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

//@Configuration
//@Import({ CoreConfiguration.class })
public class JunitMySQLConfiguration {/*


	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = null;
        try {
            dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/commonbanking");
            dataSource.setUsername("root");
            dataSource.setPassword("Password123");
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize DataSource", e);
        }

        return dataSource;
	}
	
	@Bean
	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.default_schema", "commonbanking");
		properties.setProperty("show_sql", "true");
		
		return properties;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired Properties additionalProperties) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.prudential.core.common", "com.prudential.core.users", "com.prudential.core.web",
				"com.prudential.core.common.model", "com.prudential.core.common.authority",
				"com.prudential.core.common.locale","com.prudential.core.cbi.model");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties);
		return em;
	}
	


*/}
