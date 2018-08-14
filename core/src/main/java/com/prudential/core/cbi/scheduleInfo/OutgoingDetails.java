package com.prudential.core.cbi.scheduleInfo;

public class OutgoingDetails {

	
	String encryptorProgrammingName;
	TransferProtocol  transferProtocol;
	
	
	
	public String getEncryptorProgrammingName() {
		return encryptorProgrammingName;
	}
	public void setEncryptorProgrammingName(String encryptorProgrammingName) {
		this.encryptorProgrammingName = encryptorProgrammingName;
	}
	public TransferProtocol  getTransferProtocol() {
		return transferProtocol;
	}
	public void setTransferProtocol(TransferProtocol  transferProtocol) {
		this.transferProtocol = transferProtocol;
	}
	@Override
	public String toString() {
		return "OutgoingDetails [encryptorProgrammingName=" + encryptorProgrammingName + ", transferProtocol="
				+ transferProtocol + "]";
	}
	
	
	
	
}
