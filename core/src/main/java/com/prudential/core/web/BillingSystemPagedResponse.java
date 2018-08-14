package com.prudential.core.web;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prudential.core.common.PagedResponse;

@JsonIgnoreProperties
public class BillingSystemPagedResponse<Q extends BillingSystemPagedRequest, S> extends BillingSystemResponse {

    private BillingSystemPagedRequest rq;
    private List<S> records;
    private long totalRecords;
    
    public BillingSystemPagedResponse(BillingSystemPagedRequest rq, PagedResponse<S> pagedRs) {
        if (rq == null) {
            throw new InvalidInputException("BASPagedRequest cannot be null");
        }
        
        if (pagedRs == null) {
            throw new InvalidInputException("PagedResponse cannot be null");
        }
        
        this.rq = rq;
        this.records = records != null ? pagedRs.getRecords() : Collections.<S>emptyList();
        this.totalRecords = pagedRs.getTotalRecords();
    }
    
    public BillingSystemPagedResponse(BillingSystemPagedRequest rq, List<S> records, long totalRecords) {
        super();
        
        if (rq == null) {
            throw new InvalidInputException("BASPagedRequest cannot be null");
        }
        
        this.rq = rq;
        this.records = records != null ? records : Collections.<S>emptyList();
        this.totalRecords = totalRecords;
    }

    public int getPageNumber() {
        return rq.getPageNumber();
    }
    
    public int getPageSize() {
        return rq.getPageSize();
    }

    public List<S> getRecords() {
        return records;
    }

    public long getTotalRecords() {
        return totalRecords;
    }
    
    
   

}
