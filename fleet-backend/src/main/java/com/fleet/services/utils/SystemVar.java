package com.fleet.services.utils;

import org.springframework.util.StringUtils;

public final class SystemVar {
	
	private SystemVar() {
		// Do nothing
	}
	
	public static String getSystemVariable(String key, String defaultValue) {
		String value = System.getenv(key);
		if(StringUtils.isEmpty(value)) {
			value = System.getProperty(key, defaultValue);
		}
		if(StringUtils.isEmpty(value)) {
			value = defaultValue;
		}
		
		print(key);
		return value;
	}
	
	private static void print(String key) {
		System.out.println("##############################");
		System.out.println("System.getenv("+key+") =" + System.getenv(key));
		System.out.println("System.getProperty("+key+") =" + System.getProperty(key));
		System.out.println("##############################");
	}
}