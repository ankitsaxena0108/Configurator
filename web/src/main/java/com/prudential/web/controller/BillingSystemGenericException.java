package com.prudential.web.controller;

import com.prudential.core.common.BillingSystemException;
import com.prudential.core.common.ErrorCode;

public class BillingSystemGenericException extends BillingSystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMsg;
	
	public BillingSystemGenericException(String errCode, String errMsg) {
		super(errCode,errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public BillingSystemGenericException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BillingSystemGenericException(String errCode) {
		super(errCode,"");
		this.errCode = errCode;
		this.errMsg = "";
	}	

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}


}
