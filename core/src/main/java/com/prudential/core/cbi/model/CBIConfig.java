package com.prudential.core.cbi.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.prudential.core.common.model.BillingSystemEntity;

@Entity
@Table(name = "CBICONFIG")
public class CBIConfig extends BillingSystemEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Lob()
	byte[] configBlob;

	@Lob
	byte[] scheduleInfo;
	
	@Lob
	byte[] otherConfig;

	public byte[] getOtherConfig() {
		return otherConfig;
	}

	public void setOtherConfig(byte[] otherConfig) {
		this.otherConfig = otherConfig;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	String fileName;
	
	String category;

	public byte[] getConfigBlob() {
		return configBlob;
	}

	public void setConfigBlob(byte[] configBlob) {
		this.configBlob = configBlob;
	}

	public byte[] getScheduleInfo() {
		return scheduleInfo;
	}

	public void setScheduleInfo(byte[] scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
