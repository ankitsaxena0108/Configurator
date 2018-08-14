package com.prudential.core.common.dao;

public class DataConstraintException extends Exception {

    private static final long serialVersionUID = 1L;

    private String errorCode;
    
    public DataConstraintException(String code, String message) {
        super(message);
        
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
