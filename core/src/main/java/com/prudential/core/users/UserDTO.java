package com.prudential.core.users;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.prudential.core.common.AbstractDTO;

/**
 * Represents a USER for the Billing System (having login rights to system).
 */
public class UserDTO extends AbstractDTO {
	@NotNull(message = "Please check login")
	@Size(min = 4, max = 8, message = "login length should be between 4 & 8")
	private String login;

	private String name;

	private String status;

	private List<String> roles;

	private Long localeId;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Long getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
}