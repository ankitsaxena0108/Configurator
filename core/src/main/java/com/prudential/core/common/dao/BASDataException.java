package com.prudential.core.common.dao;

import com.prudential.core.common.BillingSystemRuntimeException;

public class BASDataException extends BillingSystemRuntimeException {

    private static final long serialVersionUID = 1L;

    public BASDataException(String logMessage) {
        super("1000", logMessage);
    }
    
    public BASDataException(String errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
