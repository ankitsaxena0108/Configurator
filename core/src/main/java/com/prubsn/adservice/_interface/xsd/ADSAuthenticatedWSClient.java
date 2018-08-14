package com.prubsn.adservice._interface.xsd;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("adsAuthenticatedWSClient")
public class ADSAuthenticatedWSClient {

	
	public ErrorResponse authenticateUser(ADauditBean objADUserRequest) {
		ErrorResponse errorResponse =new ErrorResponse();
		try {
		 	ADauthUserServiceImplServiceSoapBindingStub stub = new ADauthUserServiceImplServiceSoapBindingStub();
//		 	stub.set

			
			try {
				ADauditBean objADUserResponse = stub.authenticateUser(objADUserRequest);
				errorResponse.setResCode(objADUserResponse.getResCode());
				errorResponse.setResString(objADUserResponse.getResString());
				
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
