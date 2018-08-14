package com.prudential.core.common;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Base Class for all Data Transfer between Controller and Channel OR Controller
 * and Service.

 */
@JsonIgnoreProperties
abstract public class AbstractDTO {
	private Long id;
	private Timestamp lastModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "DTO [id=" + id + "]";
	}

}
