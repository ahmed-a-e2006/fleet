package com.fleet.services.utils;

import org.springframework.util.StringUtils;

public final class SystemVar {
	
	private SystemVar() {
		// Do nothing
	}
	
	public static String getSystemVariable(String key, String defaultValue) {
		String value = System.getenv(key);
		if(StringUtils.isEmpty(value)) {
			value = System.getProperty(key);
		}
		if(StringUtils.isEmpty(value)) {
			value = defaultValue;
		}
		
		System.out.println("##############################");
		System.out.println(key + "=" + value);
		System.out.println("##############################");
		return value;
	}
}