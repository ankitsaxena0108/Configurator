package com.prudential.core.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillingSystemRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(BillingSystemException.class);
    
    private String errorCode;
    private BillingSystemModule module;
    private Object[] params;
    
    public BillingSystemRuntimeException(ErrorCode errorCode, Object ... params) {
        this(errorCode.getErrorCode(), errorCode.getLogMessage());
        
        this.params = params;
    }

    public BillingSystemRuntimeException(String errorCode, String logMessage) {
        super(logMessage);
        
        this.errorCode = errorCode;
        this.module = BillingSystemModule.module(errorCode);
        logger.error(logMessage);
    }

    public BillingSystemRuntimeException(String errorCode, Throwable cause) {
        super(cause);
        
        this.errorCode = errorCode;
        this.module = BillingSystemModule.module(errorCode);
        logger.error(cause.getMessage(), cause);
    }
    
    public BillingSystemModule getModule() {
        return module;
    }

    public String getErrorCode() {
        return errorCode;
    }
    
    public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
}
