package com.prudential.web.configuration.junit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.web.configuration.WebConfiguration;

@Configuration
@Import({ JUnitCoreConfiguration.class, WebConfiguration.class })
public class JUnitConfiguration {

}
