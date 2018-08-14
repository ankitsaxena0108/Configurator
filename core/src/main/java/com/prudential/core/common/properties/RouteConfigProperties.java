package com.prudential.core.common.properties;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class RouteConfigProperties extends PropertiesSupport {
    private static final Logger logger = LoggerFactory.getLogger(CBIProperties.class);
    
    public static final String ROUTE_PROPERTIES = "routeConfig.properties";


    private static Properties properties = new Properties();
    
    public RouteConfigProperties() {
        loadProperties(ROUTE_PROPERTIES, properties);
    }
    
    public final String get(String property) {
        return properties.getProperty(property);
    }
    


	public String get(String property, String valueIfNull) {
		String value = get(property);
		if (StringUtils.isEmpty(value)) {
			value = valueIfNull;
		}
		return value;
	}
	
}
