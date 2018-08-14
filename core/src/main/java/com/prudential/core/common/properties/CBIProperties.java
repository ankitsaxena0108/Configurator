package com.prudential.core.common.properties;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class CBIProperties extends PropertiesSupport {
	private static final Logger logger = LoggerFactory.getLogger(CBIProperties.class);

	public static final String CBI_PROPERTIES = "cbi.properties";
	public static final String PAGE_SIZE = "page.size";
	public static final String SCHEMA_NAME = "schema.name";
	public static final String REPORTS_DIR = "reports.dir";
	public static final String AUTH_TYPE = "auth.type";

	private static Properties properties = new Properties();

	public CBIProperties() {
		loadProperties(CBI_PROPERTIES, properties);
	}

	public final String get(String property) {
		return properties.getProperty(property);
	}

	public static final String getSchemaName() {
		return properties.getProperty(SCHEMA_NAME);
	}

	public static final String getReportsDir() {
		return properties.getProperty(REPORTS_DIR);
	}

	public final int getPageSize() {
		String pageSize = properties.getProperty(PAGE_SIZE);
		try {
			logger.debug("Getting PageSize: {}", pageSize);
			return Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			logger.warn("Failed to parse page.size [{}], using default page.size=10", pageSize, e);
			return 10;
		}
	}

	public String get(String property, String valueIfNull) {
		String value = get(property);
		if (StringUtils.isEmpty(value)) {
			value = valueIfNull;
		}
		return value;
	}

	public static final String getAuthProviderType() {
		return properties.getProperty(AUTH_TYPE);
	}
}
