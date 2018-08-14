package com.prudential.core.common.authority;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.prudential.core.common.AbstractDTO;

public class RoleDTO extends AbstractDTO {
	private String roleName;
	private List<PermissionDTO> permissions;

	public RoleDTO() {
		// Default Constructor
	}
	
	public RoleDTO(Role role, boolean deepCopy) {
		BeanUtils.copyProperties(role, this, "permissions");
		
		
		if (deepCopy) {
			permissions = new ArrayList<>();
			PermissionDTO permissionRs = null;
			for (Permission permission : role.getPermissions()) {
				permissionRs = new PermissionDTO();
				BeanUtils.copyProperties(permission, permissionRs, "roles");
			}
		}
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public List<PermissionDTO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDTO> permissions) {
		this.permissions = permissions;
	}

}