package com.prudential.core.ads;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prubsn.adservice._interface.xsd.ADauditBean;
import com.prubsn.adservice._interface.xsd.ADauthUserServiceImplServiceLocator;
import com.prubsn.adservice._interface.xsd.ADauthUserServiceImplServiceSoapBindingStub;
import com.prubsn.adservice._interface.xsd.Exception;

/**
 * 
 * @author mohit.kumar
 *
 */
@Service
public class ADSClient {
	private static final Logger logger = LoggerFactory.getLogger(ADSClient.class);

	public ADauditBean authenticate(String userName, String password, String ip, String channel) {
		ADauditBean dauditBean = new ADauditBean();
		dauditBean.setDomainId(userName);
		dauditBean.setPassword(password);
		dauditBean.setReqIPAddress(ip);
		dauditBean.setChannel(channel);

		ADauthUserServiceImplServiceLocator locator = new ADauthUserServiceImplServiceLocator();

		java.net.URL url = null;
		try {
			url = new java.net.URL(locator.getadauthuserserviceimplPortAddress());
		} catch (MalformedURLException e2) {
			logger.error("Protocol is not specified, or an unknown protocol is found" + e2.getMessage());
		}

		ADauthUserServiceImplServiceSoapBindingStub stub = null;
		try {
			stub = new ADauthUserServiceImplServiceSoapBindingStub(url, locator);
		} catch (AxisFault e2) {
			logger.error("SOAP faults" + e2.getMessage());
		}

		try {
			return stub.authenticateUser(dauditBean);
		} catch (Exception e) {
			logger.error("Error while authenticating user" + e.getMessage());
		} catch (RemoteException e) {
			logger.error("Error while authenticating" + e.getMessage());
		}
		return null;

	}

}
