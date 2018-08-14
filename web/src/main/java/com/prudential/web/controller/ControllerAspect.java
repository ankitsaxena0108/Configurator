package com.prudential.web.controller;

import java.security.Principal;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prudential.core.common.ThreadLocalVars;

@Aspect
@Component
public class ControllerAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
    
    @Pointcut("execution(* com.prudential.web.controller.*.*Controller.*(..)) && args(principal, ..)")
    public void anyRequestMethod(Principal principal) {
    }
    
    @Before("anyRequestMethod(principal)") 
    public void setCurrentUser(Principal principal) {
        String user = principal != null ? principal.getName() : null;
        logger.debug("Setting {} as user", user);
        
        ThreadLocalVars.set(user);
    }
}
