package com.prudential.core.users.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.prudential.core.common.Transferrable;
import com.prudential.core.common.authority.Permission;
import com.prudential.core.common.authority.Role;
import com.prudential.core.common.locale.Locale;
import com.prudential.core.common.model.BillingSystemEntity;
import com.prudential.core.users.UserDTO;

/**
 * Represents a USER for the Billing System (having login rights to system).
 */
@Entity

@Table(name = "USR_USER")
public class User extends BillingSystemEntity implements Transferrable<UserDTO> {
	public static final String FIELD_ADDRESSES = "addresses";
	public static final String FIELD_LOCALE = "locale";
	public static final String FIELD_ORGANIZATION = "organization";
	public static final String FIELD_ROLES = "roles";
	public static final String[] FIELD_ALL_RELATIONS = { FIELD_ADDRESSES, FIELD_LOCALE, FIELD_ORGANIZATION,
			FIELD_ROLES };

	private static final long serialVersionUID = 1L;

	private String login;

	private String name;

	private String status;

	@OneToOne
	@JoinColumn(name = "LOCALE_ID")
	private Locale locale;

	@ManyToMany
	@JoinTable(name = "USR_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	private List<Role> roles;

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

	public boolean isDeleted() {
		return StringUtils.hasText(this.status) ? Status.DELETED.name().equals(this.status) : false;
	}

	public void setStatus(Status status) {
		this.status = status.name();
	}

	public List<Role> getAllRoles() {
		List<Role> allRoles = new ArrayList<>();
		for (Role role : roles) {
			allRoles.add(role);
		}
		return allRoles;
	}

	public void addRole(Role role) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}

		this.roles.add(role);
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean hasRole(String roleName) {
		List<Role> roles = getAllRoles();
		for (Role role : roles) {
			if (role.getRoleName().equals(roleName)) {
				return true;
			}
		}

		return false;
	}

	public boolean hasRolePermission(String permissionName) {
		List<Role> roles = getAllRoles();
		Collection<Permission> permissions = new ArrayList<Permission>();
		for (Role role : roles) {
			permissions = role.getPermissions();
			for (Permission permission : permissions) {
				if (permission.getPermissionName().equals(permissionName)) {
					return true;
				}
			}

		}

		return false;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public enum Status {
		ACTIVE, DELETED;
	}

	@Override
	public void populate(UserDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDTO extract(String... skipProperties) {
		// TODO Auto-generated method stub
		return null;
	}

}