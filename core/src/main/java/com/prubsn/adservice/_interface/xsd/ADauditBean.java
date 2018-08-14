/**
 * ADauditBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.prubsn.adservice._interface.xsd;

public class ADauditBean  implements java.io.Serializable {
    private java.lang.Integer auditID;

    private java.lang.String channel;

    private java.lang.String domainId;

    private java.lang.String password;

    private java.lang.String reqDate;

    private java.lang.String reqIPAddress;

    private java.lang.String resCode;

    private java.lang.String resString;

    public ADauditBean() {
    }

    public ADauditBean(
           java.lang.Integer auditID,
           java.lang.String channel,
           java.lang.String domainId,
           java.lang.String password,
           java.lang.String reqDate,
           java.lang.String reqIPAddress,
           java.lang.String resCode,
           java.lang.String resString) {
           this.auditID = auditID;
           this.channel = channel;
           this.domainId = domainId;
           this.password = password;
           this.reqDate = reqDate;
           this.reqIPAddress = reqIPAddress;
           this.resCode = resCode;
           this.resString = resString;
    }


    /**
     * Gets the auditID value for this ADauditBean.
     * 
     * @return auditID
     */
    public java.lang.Integer getAuditID() {
        return auditID;
    }


    /**
     * Sets the auditID value for this ADauditBean.
     * 
     * @param auditID
     */
    public void setAuditID(java.lang.Integer auditID) {
        this.auditID = auditID;
    }


    /**
     * Gets the channel value for this ADauditBean.
     * 
     * @return channel
     */
    public java.lang.String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this ADauditBean.
     * 
     * @param channel
     */
    public void setChannel(java.lang.String channel) {
        this.channel = channel;
    }


    /**
     * Gets the domainId value for this ADauditBean.
     * 
     * @return domainId
     */
    public java.lang.String getDomainId() {
        return domainId;
    }


    /**
     * Sets the domainId value for this ADauditBean.
     * 
     * @param domainId
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }


    /**
     * Gets the password value for this ADauditBean.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ADauditBean.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the reqDate value for this ADauditBean.
     * 
     * @return reqDate
     */
    public java.lang.String getReqDate() {
        return reqDate;
    }


    /**
     * Sets the reqDate value for this ADauditBean.
     * 
     * @param reqDate
     */
    public void setReqDate(java.lang.String reqDate) {
        this.reqDate = reqDate;
    }


    /**
     * Gets the reqIPAddress value for this ADauditBean.
     * 
     * @return reqIPAddress
     */
    public java.lang.String getReqIPAddress() {
        return reqIPAddress;
    }


    /**
     * Sets the reqIPAddress value for this ADauditBean.
     * 
     * @param reqIPAddress
     */
    public void setReqIPAddress(java.lang.String reqIPAddress) {
        this.reqIPAddress = reqIPAddress;
    }


    /**
     * Gets the resCode value for this ADauditBean.
     * 
     * @return resCode
     */
    public java.lang.String getResCode() {
        return resCode;
    }


    /**
     * Sets the resCode value for this ADauditBean.
     * 
     * @param resCode
     */
    public void setResCode(java.lang.String resCode) {
        this.resCode = resCode;
    }


    /**
     * Gets the resString value for this ADauditBean.
     * 
     * @return resString
     */
    public java.lang.String getResString() {
        return resString;
    }


    /**
     * Sets the resString value for this ADauditBean.
     * 
     * @param resString
     */
    public void setResString(java.lang.String resString) {
        this.resString = resString;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ADauditBean)) return false;
        ADauditBean other = (ADauditBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.auditID==null && other.getAuditID()==null) || 
             (this.auditID!=null &&
              this.auditID.equals(other.getAuditID()))) &&
            ((this.channel==null && other.getChannel()==null) || 
             (this.channel!=null &&
              this.channel.equals(other.getChannel()))) &&
            ((this.domainId==null && other.getDomainId()==null) || 
             (this.domainId!=null &&
              this.domainId.equals(other.getDomainId()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.reqDate==null && other.getReqDate()==null) || 
             (this.reqDate!=null &&
              this.reqDate.equals(other.getReqDate()))) &&
            ((this.reqIPAddress==null && other.getReqIPAddress()==null) || 
             (this.reqIPAddress!=null &&
              this.reqIPAddress.equals(other.getReqIPAddress()))) &&
            ((this.resCode==null && other.getResCode()==null) || 
             (this.resCode!=null &&
              this.resCode.equals(other.getResCode()))) &&
            ((this.resString==null && other.getResString()==null) || 
             (this.resString!=null &&
              this.resString.equals(other.getResString())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAuditID() != null) {
            _hashCode += getAuditID().hashCode();
        }
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        if (getDomainId() != null) {
            _hashCode += getDomainId().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getReqDate() != null) {
            _hashCode += getReqDate().hashCode();
        }
        if (getReqIPAddress() != null) {
            _hashCode += getReqIPAddress().hashCode();
        }
        if (getResCode() != null) {
            _hashCode += getResCode().hashCode();
        }
        if (getResString() != null) {
            _hashCode += getResString().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ADauditBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://interface.adservice.prubsn.com/xsd", "aDauditBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auditID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domainId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domainId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reqIPAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reqIPAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
