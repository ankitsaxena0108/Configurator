package com.prudential.core.cbi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.prudential.core.common.model.BillingSystemEntity;

@Entity
@Table(name = "FILE_AUDIT")
public class FileAudit extends BillingSystemEntity {

	private static final long serialVersionUID = 1L;

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
	
	@OneToMany(mappedBy = "fileAudit", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<FileAuditDetail> fileAuditDetails = new ArrayList<>();

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

	public List<FileAuditDetail> getFileAuditDetails() {
		return fileAuditDetails;
	}

	public void setFileAuditDetails(List<FileAuditDetail> fileAuditDetails) {
		this.fileAuditDetails = fileAuditDetails;
	}

	@Override
	public String toString() {
		return "FileAudit [systemId=" + systemId + ", fileCategory=" + fileCategory + ", fileDirection=" + fileDirection
				+ ", fileStatus=" + fileStatus + ", fileName=" + fileName + ", paymentType=" + paymentType
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", totalAmount=" + totalAmount
				+ ", approvedAmount=" + approvedAmount + ", approvedTxn=" + approvedTxn + ", rejectedTxn=" + rejectedTxn
				+ ", rejectedAmount=" + rejectedAmount + "]";
	}

}
