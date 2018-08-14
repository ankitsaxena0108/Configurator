package com.prudential.core.common.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {
    
    private static ApplicationContext APP_CONTEXT;
    
    public static <T> T getBean(Class<T> clazz) {
        if (APP_CONTEXT != null) {
            return APP_CONTEXT.getBean(clazz);
        }
        
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (APP_CONTEXT == null && applicationContext.getParent() == null) {
            APP_CONTEXT = applicationContext;
        }
    }

}
