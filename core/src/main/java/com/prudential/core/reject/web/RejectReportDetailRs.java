package com.prudential.core.reject.web;

import com.prudential.core.web.BillingSystemResponse;

public class RejectReportDetailRs extends BillingSystemResponse {

	private long rowNumber;

	private String failureCode;

	public long getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(long rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	
}