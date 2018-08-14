package com.prudential.core.audit.web;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

import com.prudential.core.web.BillingSystemResponse;

public class FileAuditRs extends BillingSystemResponse {
	private String systemId;

	private String fileCategory;

	private String fileDirection;

	private String fileStatus;

	private String fileName;

	private String paymentType;

	private Timestamp startDateTime;

	private Timestamp endDateTime;

	private BigDecimal totalAmount;

	private BigDecimal approvedAmount;

	private int approvedTxn;

	private int rejectedTxn;

	private BigDecimal rejectedAmount;

	private Collection<FileAuditDetailRs> auditDetails;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}

	public String getFileDirection() {
		return fileDirection;
	}

	public void setFileDirection(String fileDirection) {
		this.fileDirection = fileDirection;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(BigDecimal approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public int getApprovedTxn() {
		return approvedTxn;
	}

	public void setApprovedTxn(int approvedTxn) {
		this.approvedTxn = approvedTxn;
	}

	public int getRejectedTxn() {
		return rejectedTxn;
	}

	public void setRejectedTxn(int rejectedTxn) {
		this.rejectedTxn = rejectedTxn;
	}

	public BigDecimal getRejectedAmount() {
		return rejectedAmount;
	}

	public void setRejectedAmount(BigDecimal rejectedAmount) {
		this.rejectedAmount = rejectedAmount;
	}

	public Collection<FileAuditDetailRs> getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(Collection<FileAuditDetailRs> auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public String toString() {
		return "FileAuditRs [systemId=" + systemId + ", fileName=" + fileName + "]";
	}
}