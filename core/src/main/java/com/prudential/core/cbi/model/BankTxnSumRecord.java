package com.prudential.core.cbi.model;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

public class BankTxnSumRecord {

	private Page<BankTxnRecordRes>  recordPage;
	
	private int SumAmount;

	public Page<BankTxnRecordRes> getRecordPage() {
		return recordPage;
	}

	public void setRecordPage(Page<BankTxnRecordRes> recordPage) {
		this.recordPage = recordPage;
	}

	public int getSumAmount() {
		return SumAmount;
	}

	public void setSumAmount(int sumAmount) {
		SumAmount = sumAmount;
	}

	
	
	
	
	
}
