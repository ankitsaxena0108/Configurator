/**
 * ADauthUserServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.prubsn.adservice._interface.xsd;

import com.prudential.core.common.properties.CBIProperties;

public class ADauthUserServiceImplServiceLocator extends org.apache.axis.client.Service implements com.prubsn.adservice._interface.xsd.ADauthUserServiceImplService {

    public ADauthUserServiceImplServiceLocator() {
    }


    public ADauthUserServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ADauthUserServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for adauthuserserviceimplPort
    
    CBIProperties properties = new CBIProperties();
    private java.lang.String adauthuserserviceimplPort_address = properties.get("adswebservice");
    public java.lang.String getadauthuserserviceimplPortAddress() {
        return adauthuserserviceimplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String adauthuserserviceimplPortWSDDServiceName = "adauthuserserviceimplPort";

    public java.lang.String getadauthuserserviceimplPortWSDDServiceName() {
        return adauthuserserviceimplPortWSDDServiceName;
    }

    public void setadauthuserserviceimplPortWSDDServiceName(java.lang.String name) {
        adauthuserserviceimplPortWSDDServiceName = name;
    }

    public com.prubsn.adservice._interface.xsd.Adauthuserserviceimpl getadauthuserserviceimplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(adauthuserserviceimplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getadauthuserserviceimplPort(endpoint);
    }

    public com.prubsn.adservice._interface.xsd.Adauthuserserviceimpl getadauthuserserviceimplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.prubsn.adservice._interface.xsd.ADauthUserServiceImplServiceSoapBindingStub _stub = new com.prubsn.adservice._interface.xsd.ADauthUserServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getadauthuserserviceimplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setadauthuserserviceimplPortEndpointAddress(java.lang.String address) {
        adauthuserserviceimplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.prubsn.adservice._interface.xsd.Adauthuserserviceimpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.prubsn.adservice._interface.xsd.ADauthUserServiceImplServiceSoapBindingStub _stub = new com.prubsn.adservice._interface.xsd.ADauthUserServiceImplServiceSoapBindingStub(new java.net.URL(adauthuserserviceimplPort_address), this);
                _stub.setPortName(getadauthuserserviceimplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("adauthuserserviceimplPort".equals(inputPortName)) {
            return getadauthuserserviceimplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://interface.adservice.prubsn.com/xsd", "ADauthUserServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://interface.adservice.prubsn.com/xsd", "adauthuserserviceimplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("adauthuserserviceimplPort".equals(portName)) {
            setadauthuserserviceimplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
