package com.prudential.core.common;

import java.util.List;
import java.util.Map;

public class CBIException extends BillingSystemException {
	private static final long serialVersionUID = 1L;

	public CBIException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}

	public CBIException(Map<String, List<String>> validationMessages) {

		super(validationMessages);
	}
}
