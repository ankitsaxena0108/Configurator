package com.prudential.core.cbi.scheduleInfo;

public class OtherConfig {

	
	IncomingDetails incomingDetails;
	OutgoingDetails outgoingDetails;
	
	
	public IncomingDetails getIncomingDetails() {
		return incomingDetails;
	}
	public void setIncomingDetails(IncomingDetails incomingDetails) {
		this.incomingDetails = incomingDetails;
	}
	public OutgoingDetails getOutgoingDetails() {
		return outgoingDetails;
	}
	public void setOutgoingDetails(OutgoingDetails outgoingDetails) {
		this.outgoingDetails = outgoingDetails;
	}
	
	
	@Override
	public String toString() {
		return "OtherConfig [incomingDetails=" + incomingDetails + ", outgoingDetails=" + outgoingDetails + "]";
	}
	
	
	
	
}
