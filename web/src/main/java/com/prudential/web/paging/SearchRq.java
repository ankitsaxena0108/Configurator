package com.prudential.web.paging;

import java.util.HashMap;
import java.util.Map;

import com.prudential.core.web.PagedRequest;



public class SearchRq extends PagedRequest {

	private Map<String, Object> params = new HashMap<>();

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
