package com.prudential.core.common;

import java.util.List;
import java.util.Map;

public class BillingSystemException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private BillingSystemModule module;
	private Object[] params;
	private Map<String, List<String>> validationMessages;

	public BillingSystemException(ErrorCode errorCode, Object... params) {
		this(errorCode.getErrorCode(), errorCode.getLogMessage());

		this.params = params;
	}

	public BillingSystemException(Map<String, List<String>> validationMessages) {
		this.validationMessages = validationMessages;
	}

	public BillingSystemException(String errorCode, Object... params) {
		this(errorCode, "");

		this.params = params;
	}

	public BillingSystemException(String errorCode, String logMessage) {
		super(logMessage);

		this.errorCode = errorCode;
		this.module = BillingSystemModule.module(errorCode);
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

	public Map<String, List<String>> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(Map<String, List<String>> validationMessages) {
		this.validationMessages = validationMessages;
	}

}
