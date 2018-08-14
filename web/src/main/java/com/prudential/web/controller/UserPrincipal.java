package com.prudential.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.prudential.core.common.authority.PermissionDTO;
import com.prudential.core.common.authority.RoleDTO;

public class UserPrincipal {

	private Principal principal;
	private Map<RoleDTO, Collection<PermissionDTO>> rolePermissions = new HashMap<>();

	public UserPrincipal(Principal principal) {
		super();
		this.principal = principal;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public Map<String, List<String>> getRolePermissions() {
		Map<String, List<String>> permissonMap = new HashMap<>();
		for (Entry<RoleDTO, Collection<PermissionDTO>> rolePermissionEntry : rolePermissions.entrySet()) {
			List<String> permissions = new ArrayList<>();
			for (PermissionDTO permission : rolePermissionEntry.getValue()) {
				permissions.add(permission.getPermissionName());
			}
			permissonMap.put(rolePermissionEntry.getKey().getRoleName(), permissions);
		}

		return permissonMap;
	}

	public void addRolePermissions(RoleDTO role) {
		this.rolePermissions.put(role, role.getPermissions());

	}

}
