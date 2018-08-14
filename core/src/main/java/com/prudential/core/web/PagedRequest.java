package com.prudential.core.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prudential.core.common.properties.CBIProperties;


@JsonIgnoreProperties
public class PagedRequest {
	private static CBIProperties properties = new CBIProperties();
	
	private int page;

	public int getPage() {
		return page > 0 ? page -1 : 0;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return properties.getPageSize();
	}
}
