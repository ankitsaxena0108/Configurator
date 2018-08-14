package com.prudential.core.common.locale;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by rawatv on 1/18/2017.
 */
@Entity
@Table(name = "COR_LOCALIZED_VALUE")
public class LocalizedValue {

	@Id
	@Column(name = "LOCALIZED_VALUE_ID")
	private String localizedValueId;

	@ManyToOne
	@JoinColumn(name = "LOCALIZED_ENTITY_ID")
	private LocalizedEntity localizedEntity;

	@ManyToOne
	@JoinColumn(name = "LOCALE_ID")
	private Locale locale;

	@Column
	private String field;

	@Column
	private String value;

	@Column(name = "LOCALIZED_VALUE")
	private String localizedValue;

	@Version
	@Column(name = "LAST_MODIFIED")
	private Timestamp lastModified;

	public String getLocalizedValueId() {
		return localizedValueId;
	}

	public void setLocalizedValueId(String localizedValueId) {
		this.localizedValueId = localizedValueId;
	}

	public LocalizedEntity getLocalizedEntity() {
		return localizedEntity;
	}

	public void setLocalizedEntity(LocalizedEntity localizedEntity) {
		this.localizedEntity = localizedEntity;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLocalizedValue() {
		return localizedValue;
	}

	public void setLocalizedValue(String localizedValue) {
		this.localizedValue = localizedValue;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
}
