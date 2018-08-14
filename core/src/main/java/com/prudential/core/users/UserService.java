package com.prudential.core.users;

import java.util.List;

import com.prudential.core.common.authority.PermissionDTO;
import com.prudential.core.common.authority.RoleDTO;
import com.prudential.core.common.locale.Locale;
import com.prudential.core.common.menu.MenuItem;
import com.prudential.core.users.model.User;

//@Secured("ROLE_ADMIN")
public interface UserService {

	
	/**
	 * Finds current locale - identified by currently logged in User's
	 * {@link User#getLocale()}
	 * 
	 * @param login
	 * @return {@link Locale#getId()} representing Locale
	 * @throws UsersException
	 */
	public long currentLocaleId() throws UsersException;

	public List<MenuItem> getUserMenu(String login);

	public List<RoleDTO> getAllUserRoles(String userName);

	public RoleDTO getRole(long roleId);

	public List<RoleDTO> getRoles();

	public List<RoleDTO> getRoles(String roleName);

	public List<PermissionDTO> getPermissions();

	public boolean roleExists(String roleName);
}
