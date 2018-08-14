package com.prudential.core.web;

import java.sql.Timestamp;

import com.prudential.core.common.AbstractDTO;

public abstract class BillingSystemResponse extends AbstractDTO{

    
    private boolean hasError;
    
    private String errorCode;
    
    private String errorMsg;
    
    private Timestamp lastModified;



    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
}