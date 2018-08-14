package com.prubsn.adservice._interface.xsd;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

public class ADSValidateWSClient {

	
	public ErrorResponse validateUser() {
		
		ErrorResponse errorResponse =new ErrorResponse();
		
		try {
		ADauthUserServiceImplServiceSoapBindingStub stub = new ADauthUserServiceImplServiceSoapBindingStub();
		ADvalidateBean objADUserRequest = new ADvalidateBean();
		errorResponse.setResCode(objADUserRequest.getResCode());
		errorResponse.setResString(objADUserRequest.getResString());
		
		
		
		try {
			stub.validateUser(objADUserRequest);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errorResponse;
	}
}
