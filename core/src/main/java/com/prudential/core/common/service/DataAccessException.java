package com.prudential.core.common.service;

import com.prudential.core.common.BillingSystemRuntimeException;

/**
 * Generic class to represent any error while accessing Data..
 */
public class DataAccessException extends BillingSystemRuntimeException {
    private static final long serialVersionUID = 1L;

    public DataAccessException(String message) {
        super("1000", message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
