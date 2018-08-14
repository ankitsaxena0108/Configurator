package com.prudential.core.cbi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "BANKTXNRECORD")
public class BankTxnRecord {

	
	private static final long serialVersionUID = 1L;

	public static enum State {
		SOURCE_FEED_RECIEVED, SOURCE_FEED_PROCESSED, FEED_INPROGRESS, BANK_FEED_CREATED, BANK_RES_RECEIVED, BANK_RESP_PROCESSED, PROCESSED
	};

	public static enum TxCategory {
		COLLECTION, PAYOUT
	};

	/*
	 * //This can be dynamic it should be configured in a master table and use the
	 * foreign key here enum PaymentMode {CREDIT_CARD, DEBIT_CARD,E_BANKING};
	 */

	@Id
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Version
	@Column(name = "LAST_MODIFIED")
	private Timestamp lastModified;

	private String srcSystem;

	private String bankCode;

	private String category;

	private String paymentMode;

	private BigDecimal amount;

	private String sourceFileName;

	private String bankRequestFilename;

	// This id correlates bank request to bank response

	private String txRefNo;

	private String custName;

	private String acctNo;

	private String binNumber;

	private String cardNo;

	private String expiryDate;

	private String policyNo;

	// Actual billing/payment date present in the req/response feed

	private Date txDate;

	private String responseCode;

	private String state;

	private int batchNumber;

	private Date bankResRecvDate;

	private Date bankReqFeedCreateDate;

	private Date srcResFeedCreateDate;

	private Date srcReqFeedCreateDate;

	private String bankDetailRecord;

	private String bankHeaderRecord;

	private String bankFooterRecord;

	private String sourceDetailRecord;

	private String sourceHeaderRecord;

	private String sourceFooterRecord;

	private Long auditId;

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getSrcSystem() {
		return srcSystem;
	}

	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	public String getBankRequestFilename() {
		return bankRequestFilename;
	}

	public void setBankRequestFilename(String bankRequestFilename) {
		this.bankRequestFilename = bankRequestFilename;
	}

	public String getTxRefNo() {
		return txRefNo;
	}

	public void setTxRefNo(String txRefNo) {
		this.txRefNo = txRefNo;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBinNumber() {
		return binNumber;
	}

	public void setBinNumber(String binNumber) {
		this.binNumber = binNumber;
	}

	public int getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getBankResRecvDate() {
		return bankResRecvDate;
	}

	public void setBankResRecvDate(Date bankResRecvDate) {
		this.bankResRecvDate = bankResRecvDate;
	}

	public Date getBankReqFeedCreateDate() {
		return bankReqFeedCreateDate;
	}

	public void setBankReqFeedCreateDate(Date bankReqFeedCreateDate) {
		this.bankReqFeedCreateDate = bankReqFeedCreateDate;
	}

	public Date getSrcResFeedCreateDate() {
		return srcResFeedCreateDate;
	}

	public void setSrcResFeedCreateDate(Date srcResFeedCreateDate) {
		this.srcResFeedCreateDate = srcResFeedCreateDate;
	}

	public Date getSrcReqFeedCreateDate() {
		return srcReqFeedCreateDate;
	}

	public void setSrcReqFeedCreateDate(Date srcReqFeedCreateDate) {
		this.srcReqFeedCreateDate = srcReqFeedCreateDate;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankDetailRecord() {
		return bankDetailRecord;
	}

	public void setBankDetailRecord(String bankDetailRecord) {
		this.bankDetailRecord = bankDetailRecord;
	}

	public String getBankHeaderRecord() {
		return bankHeaderRecord;
	}

	public void setBankHeaderRecord(String bankHeaderRecord) {
		this.bankHeaderRecord = bankHeaderRecord;
	}

	public String getBankFooterRecord() {
		return bankFooterRecord;
	}

	public void setBankFooterRecord(String bankFooterRecord) {
		this.bankFooterRecord = bankFooterRecord;
	}

	public String getSourceDetailRecord() {
		return sourceDetailRecord;
	}

	public void setSourceDetailRecord(String sourceDetailRecord) {
		this.sourceDetailRecord = sourceDetailRecord;
	}

	public String getSourceHeaderRecord() {
		return sourceHeaderRecord;
	}

	public void setSourceHeaderRecord(String sourceHeaderRecord) {
		this.sourceHeaderRecord = sourceHeaderRecord;
	}

	public String getSourceFooterRecord() {
		return sourceFooterRecord;
	}

	public void setSourceFooterRecord(String sourceFooterRecord) {
		this.sourceFooterRecord = sourceFooterRecord;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "BankTxnRecord [srcSystem=" + srcSystem + ", bankCode=" + bankCode + ", category=" + category
				+ ", paymentMode=" + paymentMode + ", amount=" + amount + ", sourceFileName=" + sourceFileName
				+ ", bankRequestFilename=" + bankRequestFilename + ", txRefNo=" + txRefNo + ", custName=" + custName
				+ ", acctNo=" + acctNo + ", cardNo=" + cardNo + ", policyNo=" + policyNo + ", txDate=" + txDate
				+ ", responseCode=" + responseCode + ", state=" + state + ", bankResRecvDate=" + bankResRecvDate
				+ ", bankReqFeedCreateDate=" + bankReqFeedCreateDate + ", srcResFeedCreateDate=" + srcResFeedCreateDate
				+ ", srcReqFeedCreateDate=" + srcReqFeedCreateDate + ", getSrcSystem()=" + getSrcSystem()
				+ ", getBankCode()=" + getBankCode() + ", getCategory()=" + getCategory() + ", getPaymentMode()="
				+ getPaymentMode() + ", getAmount()=" + getAmount() + ", getSourceFileName()=" + getSourceFileName()
				+ ", getBankRequestFilename()=" + getBankRequestFilename() + ", getTxRefNo()=" + getTxRefNo()
				+ ", getAcctNo()=" + getAcctNo() + ", getCardNo()=" + getCardNo() + ", getPolicyNo()=" + getPolicyNo()
				+ ", getTxDate()=" + getTxDate() + ", getResponseCode()=" + getResponseCode() + ", getState()="
				+ getState() + ", getBankResRecvDate()=" + getBankResRecvDate() + ", getBankReqFeedCreateDate()="
				+ getBankReqFeedCreateDate() + ", getSrcResFeedCreateDate()=" + getSrcResFeedCreateDate()
				+ ", getSrcReqFeedCreateDate()=" + getSrcReqFeedCreateDate() + ", getCustName()=" + getCustName() + "]";
	}
}
