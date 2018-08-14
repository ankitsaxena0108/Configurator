/**
 * Adauthuserserviceimpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.prubsn.adservice._interface.xsd;

public interface Adauthuserserviceimpl extends java.rmi.Remote {
    public com.prubsn.adservice._interface.xsd.ADauditBean authenticateUser(com.prubsn.adservice._interface.xsd.ADauditBean objADauthUserRequest) throws java.rmi.RemoteException, com.prubsn.adservice._interface.xsd.Exception;
    public com.prubsn.adservice._interface.xsd.ADvalidateBean validateUser(com.prubsn.adservice._interface.xsd.ADvalidateBean objADvalidateUserRequest) throws java.rmi.RemoteException, com.prubsn.adservice._interface.xsd.Exception;
}
