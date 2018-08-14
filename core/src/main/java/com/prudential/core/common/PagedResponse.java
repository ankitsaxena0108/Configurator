package com.prudential.core.common;

import java.util.List;

public class PagedResponse<T> {

    private List<T> records;
    private long totalRecords;
    
    public PagedResponse(List<T> records, long totalRecords) {
        super();
        this.records = records;
        this.totalRecords = totalRecords;
    }

    public List<T> getRecords() {
        return records;
    }

    public long getTotalRecords() {
        return totalRecords;
    }
}
