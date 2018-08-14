package com.prudential.core.common.authority;

import com.prudential.core.common.AbstractDTO;

public class PermissionDTO extends AbstractDTO {

	private String permissionName;

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
}