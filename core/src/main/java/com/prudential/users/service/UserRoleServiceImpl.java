package com.prudential.users.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prudential.core.common.authority.Permission;
import com.prudential.core.common.authority.Role;
import com.prudential.core.common.authority.UserRoleService;
import com.prudential.core.users.model.User;
import com.prudential.users.da.RoleDAO;
import com.prudential.users.da.UserDAO;

/**
 * Created by rawatv on 1/5/2017.
 */
@Component
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	public User getUser(String userId) {
		User user = userDAO.findUser(userId);

		return user;
	}

	@Transactional(readOnly = true)
	public List<Role> getHierarchyForRole(String roleName) {
		Role parent = roleDAO.findRole(roleName);

		List<Role> allRoles = new ArrayList<Role>();
		addChildren(allRoles, parent);
		return allRoles;
	}

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly=true) public Iterable<Role> topRoles() { Role
	 * parentRole = roleDAO.findRole(-1l); return roleDAO.findRole(parentRole); }
	 */

	private void addChildren(List<Role> allRoles, Role role) {
		/*
		 * if (!role.getChildren().isEmpty()) { for (Role childRole :
		 * role.getChildren()) { addChildren(allRoles, childRole); } }
		 */

		allRoles.add(role);
		List<Permission> permissions;
		if (role.getPermissions() != null) {
			permissions = new ArrayList<Permission>(role.getPermissions());
			role.setPermissions(permissions);
		}
	}

}
