package com.prudential.core.common.authority;

import java.util.List;

import com.prudential.core.users.model.User;



public interface UserRoleService {

    public User getUser(String userId);

    public List<Role> getHierarchyForRole(String roleyName);

}
