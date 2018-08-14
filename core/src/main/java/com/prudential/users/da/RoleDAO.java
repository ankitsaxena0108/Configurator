package com.prudential.users.da;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prudential.core.common.authority.Permission;
import com.prudential.core.common.authority.Role;

/**
 * Created by rawatv on 1/10/2017.
 */
@Service
public class RoleDAO {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PermissionRepository permRepo;
	
	public void create(Role role) {
		roleRepo.save(role);
		
	}
	
	public Iterable<Role> findAllRoles() {
		return roleRepo.findAll();
	}
	
	public Role findRole(long id) {
		return roleRepo.findOne(id);
	}
	
	public Role findRole(String roleName) {
		return roleRepo.findByRoleName(roleName);
	}

	public Iterable<Role> findRoles(String roleName) {
		return roleRepo.findByRoleNameContainingIgnoreCase(roleName);
	}
	
	public void update(Role role) {
		roleRepo.save(role);
		
	}

	public void delete(long id) {
		roleRepo.delete(id);
		
	}

	public Iterable<Permission> findAllPermissions() {
		return permRepo.findAll();
	}


	public Permission findPermission(String permissionName) {
		return permRepo.getByPermissionName(permissionName);
	}

	
}
