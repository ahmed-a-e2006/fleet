package com.fleet.daos.config;

import org.springframework.stereotype.Component;

import com.fleet.services.utils.SystemVar;

@Component
public class DaoConfig {
	
	private final static String JDBC_URL_KEY = "JDBC_URL";
	private final static String USER_KEY = "JDBC_USER";
	private final static String PASSWORD_KEY = "JDBC_PASSWORD";
	
	private final static String DEFAULT_JDBC_URL = "jdbc:mysql://localhost:3306/fleet";
	private final static String DEFAULT_USER = "fleet";
	private final static String DEFAULT_PASSWORD = "fleet";

	public String getJdbcUrl() {
		return SystemVar.getSystemVariable(JDBC_URL_KEY, DEFAULT_JDBC_URL);
	}

	public String getUser() {
		return SystemVar.getSystemVariable(USER_KEY, DEFAULT_USER);
	}

	public String getPassword() {
		return SystemVar.getSystemVariable(PASSWORD_KEY, DEFAULT_PASSWORD);
	}
}