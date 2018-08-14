package com.prudential.core.recon.web;

import java.math.BigDecimal;
import java.util.Collection;

import com.prudential.core.web.BillingSystemResponse;

public class ReconReportRs extends BillingSystemResponse {
	
	private String bankName;
	private BigDecimal totalAmount;
	private BigDecimal totalBilledAmount;
	private BigDecimal totalRejectedAmount;
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getTotalBilledAmount() {
		return totalBilledAmount;
	}

	public void setTotalBilledAmount(BigDecimal totalBilledAmount) {
		this.totalBilledAmount = totalBilledAmount;
	}

	public BigDecimal getTotalRejectedAmount() {
		return totalRejectedAmount;
	}

	public void setTotalRejectedAmount(BigDecimal totalRejectedAmount) {
		this.totalRejectedAmount = totalRejectedAmount;
	}

	public Collection<ReconReportDetailRs> getReconReportDetailRs() {
		return reconReportDetailRs;
	}

	public void setReconReportDetailRs(Collection<ReconReportDetailRs> reconReportDetailRs) {
		this.reconReportDetailRs = reconReportDetailRs;
	}

	private Collection<ReconReportDetailRs> reconReportDetailRs;

	

	
}