package com.prudential.users.da;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prudential.core.common.authority.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{

	public Permission getByPermissionName(String permissionName);

}
