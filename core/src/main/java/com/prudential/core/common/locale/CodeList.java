package com.prudential.core.common.locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import com.prudential.core.common.model.BillingSystemEntity;

@Entity
@Table(name = "COR_LOCALIZEDCODELIST")
@FilterDef(name = "getByLocale", parameters = @ParamDef(name = "localeId", type = "long"))

public class CodeList extends BillingSystemEntity {

	private static final long serialVersionUID = 1L;

	private String codeValue;

	private String codeDescription;

	@Column(name = "LOCALE_ID")
	private long localeId;

	@Column(name = "LOCALIZEDCODE_ID")
	private long codeDetail;

	/**
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * @param codeValue
	 *            the codeValue to set
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * @return the codeDescription
	 */
	public String getCodeDescription() {
		return codeDescription;
	}

	/**
	 * @param codeDescription
	 *            the codeDescription to set
	 */
	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	/**
	 * @return the localeId
	 */
	public long getLocaleId() {
		return localeId;
	}

	/**
	 * @param localeId
	 *            the localeId to set
	 */
	public void setLocaleId(long localeId) {
		this.localeId = localeId;
	}

}
