package com.prudential.core.reject.web;

import java.math.BigDecimal;
import java.util.Collection;

import com.prudential.core.web.BillingSystemResponse;

public class RejectReportRs extends BillingSystemResponse {
	
	private String bankName;
	private String rejectionCode;
	
	private Collection<RejectReportDetailRs> reconReportDetailRs;
	
	
	public Collection<RejectReportDetailRs> getReconReportDetailRs() {
		return reconReportDetailRs;
	}

	public void setReconReportDetailRs(Collection<RejectReportDetailRs> reconReportDetailRs) {
		this.reconReportDetailRs = reconReportDetailRs;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRejectionCode() {
		return rejectionCode;
	}

	public void setRejectionCode(String rejectionCode) {
		this.rejectionCode = rejectionCode;
	}
	
	



	

	
}