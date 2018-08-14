package com.prudential.core.users;

import com.prudential.core.common.BillingSystemException;
import com.prudential.core.common.ErrorCode;

public class UsersException extends BillingSystemException {

	private static final long serialVersionUID = 1L;
	
	public UsersException(ErrorCode errorCode, Object ... params) {
		super(errorCode, params);
	}
}
