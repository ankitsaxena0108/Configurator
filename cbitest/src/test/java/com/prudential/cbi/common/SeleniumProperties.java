package com.prudential.cbi.common;

import java.util.Properties;

import com.prudential.core.common.properties.PropertiesSupport;

public class SeleniumProperties extends PropertiesSupport {

	private static Properties seleniumproperties = new Properties();
	public static final String SELENIUM_PROPERTIES = "config.properties";

	public SeleniumProperties() {
		loadProperties(SELENIUM_PROPERTIES, seleniumproperties);
	}

	@Override
	public String get(String property) {
		return seleniumproperties.getProperty(property);
	}

}
