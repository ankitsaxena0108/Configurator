package com.prudential.core.common;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.prudential.core.common.locale.Locale;



@Entity
@Table(name = "COR_ERROR_MESSAGE")
public class ErrorMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ERROR_CODE")
    private String errorCode;
    
    @ManyToOne
    @JoinColumn(name = "LOCALE_ID")
    private Locale locale;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Transient
    private BillingSystemModule module;
    
    @Column(name = "MODULE")
    private String moduleAsString;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BillingSystemModule getModule() {
        return module;
    }

    public void setModule(BillingSystemModule module) {
        this.module = module;
        this.moduleAsString = module.toString();
    } 
}