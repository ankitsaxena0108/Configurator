package com.prudential.core.cbi.scheduleInfo;

public class IncomingDetails {

	
	String responseType;
	String decryptorProgrammingName;
	TransferProtocol  transferProtocol;
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public String getDecryptorProgrammingName() {
		return decryptorProgrammingName;
	}
	public void setDecryptorProgrammingName(String decryptorProgrammingName) {
		this.decryptorProgrammingName = decryptorProgrammingName;
	}
	public TransferProtocol  getTransferProtocol() {
		return transferProtocol;
	}
	public void setTransferProtocol(TransferProtocol  transferProtocol) {
		this.transferProtocol = transferProtocol;
	}
	@Override
	public String toString() {
		return "IncomingDetails [responseType=" + responseType + ", decryptorProgrammingName="
				+ decryptorProgrammingName + ", transferProtocol=" + transferProtocol + "]";
	}
	
	
	
}
