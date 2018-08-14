package com.prudential.core.common.locale;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.prudential.core.common.model.BillingSystemEntity;

@Entity
@Table(name = "COR_LOCALIZEDCODE")
public class CodeDetail extends BillingSystemEntity {

	private static final long serialVersionUID = 1L;

	private String code;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCALIZEDCODE_ID", referencedColumnName = "ID")
	@Filter(name = "getByLocale", condition = "localeId=:localeId")
	private Set<CodeList> codeList;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the codeList
	 */
	public Set<CodeList> getCodeList() {
		return codeList;
	}

	/**
	 * @param codeList
	 *            the codeList to set
	 */
	public void setCodeList(Set<CodeList> codeList) {
		this.codeList = codeList;
	}

}
