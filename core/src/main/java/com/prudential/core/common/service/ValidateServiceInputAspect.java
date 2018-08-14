package com.prudential.core.common.service;


import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.SoftException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prudential.core.common.BillingSystemException;
import com.prudential.core.common.ErrorCode;

@Aspect
@Component
public class ValidateServiceInputAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(ValidateServiceInputAspect.class);
    private final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Before("execution(* com.prudential..*ServiceImpl.*(.., @javax.validation.Valid (*), ..))") 
    public void setCurrentUser(JoinPoint joinPoint) throws BillingSystemException {
        logger.debug("Found JoinPoint: "+joinPoint);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Annotation[][] annotations;
        try {
            annotations = joinPoint.getTarget().getClass().
                getMethod(methodName, parameterTypes).getParameterAnnotations();
        } catch (Exception e) {
            throw new SoftException(e);
        }
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = new HashSet<>();
        int i = 0;
        for (Object arg : joinPoint.getArgs()) {
            for (Annotation annotation : annotations[i]) {
                if (annotation.annotationType() == Valid.class) {
                		logger.debug("Found Annotated Element {} -> {}: "+annotation, arg);
                		violations.addAll(validator.validate(arg));
                }
            }
            i++;
        }
        
        if (!violations.isEmpty()) {
        		StringBuilder errorMsg = new StringBuilder();
        		for (ConstraintViolation<Object> constraintViolation : violations) {
				errorMsg.append(constraintViolation.getMessage()).append(LINE_SEPARATOR);
			}
        		throw new BillingSystemException(ErrorCode.CORE_1001, errorMsg.toString());
        }
    }
}
