package com.prudential.core.cbi.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.prudential.core.common.model.BillingSystemEntity;

@Entity
@Table(name = "FILE_AUDIT_DTL")
public class FileAuditDetail extends BillingSystemEntity {

	private static final long serialVersionUID = 1L;

	private long rowNumber;

	private String failureCode;
	
    @ManyToOne
    @JoinColumn(name = "AUDIT_ID")
    private FileAudit fileAudit;

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

	public FileAudit getFileAudit() {
		return fileAudit;
	}

	public void setFileAudit(FileAudit fileAudit) {
		this.fileAudit = fileAudit;
	}

}
