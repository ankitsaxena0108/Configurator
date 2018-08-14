package com.prudential.core.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prudential.core.common.properties.CBIProperties;

@JsonIgnoreProperties
public class BillingSystemPagedRequest extends BillingSystemRequest {

    private int pageNumber;
    private int pageSize;
    private static CBIProperties properties = new CBIProperties();

    public BillingSystemPagedRequest() {
        super();
        
        this.pageNumber = 1;
        this.pageSize = properties.getPageSize();
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStart() {
        return (this.pageNumber - 1) * this.pageSize;
    }
}