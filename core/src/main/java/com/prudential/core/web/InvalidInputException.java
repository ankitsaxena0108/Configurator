package com.prudential.core.web;

import com.prudential.core.common.BillingSystemRuntimeException;
import com.prudential.core.common.ErrorCode;

public class InvalidInputException extends BillingSystemRuntimeException {

    private static final String ERROR_CODE = "1001";
    private static final long serialVersionUID = 1L;
    public InvalidInputException(String logMessage) {
        super(ERROR_CODE, logMessage);
    }
    
    public InvalidInputException(String errorCode, String logMessage) {
        super(errorCode, logMessage);
    }

	public InvalidInputException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}
}
