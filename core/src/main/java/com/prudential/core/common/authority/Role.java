package com.prudential.core.common.authority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.prudential.core.common.Transferrable;
import com.prudential.core.common.model.BillingSystemEntity;
import com.prudential.core.common.utils.ListUpdatables;
import com.prudential.core.users.model.User;

@Entity
@Table(name = "COR_ROLE")
public class Role extends BillingSystemEntity implements ListUpdatables, Transferrable<RoleDTO> {
	private static final long serialVersionUID = 1L;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@ManyToMany
	@JoinTable(name = "COR_ROLE_PERMISSION", joinColumns = {
			@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID") })
	private Collection<Permission> permissions;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role() {
		// required by JPA
	}

	public Role(long roleId) {
		this.id = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String authorityName) {
		this.roleName = authorityName;
	}

	public Collection<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public boolean isSame(Object another) {
		if (another == null) {
			return false;
		}

		return roleName.equals(another.toString());
	}

	@Override
	public void update(Object updated) {
		this.roleName = updated != null ? updated.toString() : null;

	}

	@Override
	public void populate(RoleDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RoleDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoleDTO extract(String... skipProperties) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(this.id);
		roleDTO.setLastModified(this.getLastModified());
		roleDTO.setRoleName(this.roleName);

		List<PermissionDTO> permissionsDTO = new ArrayList<>();
		for (Permission permission : permissions) {
			permissionsDTO.add(permission.extract());
		}
		roleDTO.setPermissions(permissionsDTO);
		return roleDTO;
	}
}
