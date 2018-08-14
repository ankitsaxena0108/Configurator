package com.prudential.web.paging;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prudential.core.web.PagedRequest;

@JsonIgnoreProperties
public class PagedResponse<T> {

	private int page;
	private int size;
	private long totalRecords;
	private List<T> records;
	
	public PagedResponse(PagedRequest pageRq, List<T> records, long totalRecords) {
		super();
		this.page = pageRq.getPage() + 1;
		this.size = pageRq.getSize();
		this.totalRecords = totalRecords;
		this.records = records;
	}
	public int getPage() {
		return page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getTotalRecords() {
		return totalRecords;
	}
	public List<T> getRecords() {
		return records;
	} 
}
