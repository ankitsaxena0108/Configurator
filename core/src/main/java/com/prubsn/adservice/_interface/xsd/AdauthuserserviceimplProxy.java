package com.prubsn.adservice._interface.xsd;

public class AdauthuserserviceimplProxy implements com.prubsn.adservice._interface.xsd.Adauthuserserviceimpl {
  private String _endpoint = null;
  private com.prubsn.adservice._interface.xsd.Adauthuserserviceimpl adauthuserserviceimpl = null;
  
  public AdauthuserserviceimplProxy() {
    _initAdauthuserserviceimplProxy();
  }
  
  public AdauthuserserviceimplProxy(String endpoint) {
    _endpoint = endpoint;
    _initAdauthuserserviceimplProxy();
  }
  
  private void _initAdauthuserserviceimplProxy() {
    try {
      adauthuserserviceimpl = (new com.prubsn.adservice._interface.xsd.ADauthUserServiceImplServiceLocator()).getadauthuserserviceimplPort();
      if (adauthuserserviceimpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)adauthuserserviceimpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)adauthuserserviceimpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (adauthuserserviceimpl != null)
      ((javax.xml.rpc.Stub)adauthuserserviceimpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.prubsn.adservice._interface.xsd.Adauthuserserviceimpl getAdauthuserserviceimpl() {
    if (adauthuserserviceimpl == null)
      _initAdauthuserserviceimplProxy();
    return adauthuserserviceimpl;
  }
  
  public com.prubsn.adservice._interface.xsd.ADauditBean authenticateUser(com.prubsn.adservice._interface.xsd.ADauditBean objADauthUserRequest) throws java.rmi.RemoteException, com.prubsn.adservice._interface.xsd.Exception{
    if (adauthuserserviceimpl == null)
      _initAdauthuserserviceimplProxy();
    return adauthuserserviceimpl.authenticateUser(objADauthUserRequest);
  }
  
  public com.prubsn.adservice._interface.xsd.ADvalidateBean validateUser(com.prubsn.adservice._interface.xsd.ADvalidateBean objADvalidateUserRequest) throws java.rmi.RemoteException, com.prubsn.adservice._interface.xsd.Exception{
    if (adauthuserserviceimpl == null)
      _initAdauthuserserviceimplProxy();
    return adauthuserserviceimpl.validateUser(objADvalidateUserRequest);
  }
  
  
}