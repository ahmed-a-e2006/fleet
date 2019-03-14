package com.fleet.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fleet.daos.config.DaoConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.Driver;

@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) throws Exception{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] { "com.fleet.daos.orm" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaDialect(new HibernateJpaDialect());
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource(DaoConfig daoConfig) throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(Driver.class.getCanonicalName());
		ds.setJdbcUrl(daoConfig.getJdbcUrl());
		ds.setUser(daoConfig.getUser());
		ds.setPassword(daoConfig.getPassword());
		
		ds.setMinPoolSize(1);
		ds.setMaxPoolSize(30);
		ds.setMaxConnectionAge(10);
		ds.setMaxIdleTimeExcessConnections(10);
		ds.setUnreturnedConnectionTimeout(100);
		ds.setPropertyCycle(10);
		ds.setMaxIdleTime(60);
		ds.setAcquireIncrement(5);
		ds.setMaxStatements(0);
		ds.setMaxStatementsPerConnection(150);
		ds.setStatementCacheNumDeferredCloseThreads(1);
		ds.setIdleConnectionTestPeriod(60);
		ds.setAcquireRetryAttempts(30);
		ds.setAcquireRetryDelay(100);
		ds.setTestConnectionOnCheckout(false);
		
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) throws Exception{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.use_sql_comments", "false");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		return properties;
	}
}