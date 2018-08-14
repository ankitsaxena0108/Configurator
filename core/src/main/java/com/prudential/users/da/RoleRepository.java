package com.prudential.users.da;

import com.prudential.core.common.authority.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

	public Role findByRoleName(String roleName);

	public Iterable<Role> findByRoleNameContainingIgnoreCase(String roleName);

}
