package com.prudential.users.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prudential.core.common.LocaleRepository;
import com.prudential.core.common.authority.Permission;
import com.prudential.core.common.authority.PermissionDTO;
import com.prudential.core.common.authority.Role;
import com.prudential.core.common.authority.RoleDTO;
import com.prudential.core.common.locale.Locale;
import com.prudential.core.common.menu.Menu;
import com.prudential.core.common.menu.MenuItem;
import com.prudential.core.common.properties.XMLConfiguration;
import com.prudential.core.users.UserService;
import com.prudential.core.users.UsersException;
import com.prudential.core.users.model.User;
import com.prudential.users.da.RoleDAO;
import com.prudential.users.da.UserDAO;
import com.prudential.users.da.UserRepository;

@Component
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocaleRepository localeRepository;

	private XMLConfiguration<Menu> menuConfiguration;

	public long currentLocaleId() throws UsersException {
		User user = userDAO.currentUser();
		Locale locale = null;
		if (user.getLocale() == null) {
			locale = localeRepository.findByLanguageAndCountry("en", "US");
		} else {
			locale = user.getLocale();
		}
		return locale.getLocaleId();
	}

	@Transactional(readOnly = true)
	public List<MenuItem> getUserMenu(String login) {
		if (menuConfiguration == null) {
			menuConfiguration = new XMLConfiguration<>(Menu.APPLICATION_MENU_CONFIGURATION, Menu.class);
		}

		Menu menu = menuConfiguration.value();
		User user = userDAO.findUser(login);

		List<MenuItem> restrictedMenuItems = filterMenuByRole(menu.getMenuItems(), user);
		return filterMenusWithChildren(restrictedMenuItems);
		// return restrictedMenuItems;
	}

	private List<MenuItem> filterMenuByRole(List<MenuItem> menuItems, User user) {
		List<MenuItem> filteredItems = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItems) {

			final String permission = menuItem.getPermissions();
			if (permission == null) {
				filteredItems.add(menuItem);
			} else if (user.hasRolePermission(permission)) {
				filteredItems.add(menuItem);
				continue;
			}
			menuItem.setSubMenu(filterMenuByRole(menuItem.getSubMenu(), user));

		}
		return filteredItems;
	}

	private List<MenuItem> filterMenusWithChildren(List<MenuItem> filteredItems) {
		List<MenuItem> newFilteredItems = new ArrayList<MenuItem>();

		for (MenuItem menuItem : filteredItems) {
			if (hasLeafNode(menuItem)) {
				newFilteredItems.add(menuItem);
				continue;
			}
		}
		return newFilteredItems;
	}

	private boolean hasLeafNode(MenuItem menuItem) {

		if (menuItem.getPermissions() != null) {
			return Boolean.TRUE;
		} else if (menuItem.getSubMenu().size() > 0) {
			for (MenuItem subMenuItem : menuItem.getSubMenu()) {
				if (hasLeafNode(subMenuItem)) {
					return Boolean.TRUE;
				}
			}
		} else {
			return Boolean.FALSE;
		}
		return false;
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> getAllUserRoles(String name) {
		User user = userRepository.findByLogin(name);

		List<RoleDTO> allRoles = new ArrayList<RoleDTO>();
		for (Role userRole : user.getRoles()) {

			allRoles.add(new RoleDTO(userRole, true));

		}

		return allRoles;
	}

	@Transactional(readOnly = true)
	public RoleDTO getRole(long roleId) {
		Role role = roleDAO.findRole(roleId);
		RoleDTO roleRs = new RoleDTO();
		BeanUtils.copyProperties(role, roleRs);
		return roleRs;
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> getRoles() {
		Iterable<Role> roles = roleDAO.findAllRoles();

		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();
		for (Role role : roles) {
			rolesDTO.add(role.extract());
		}
		return rolesDTO;
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> getRoles(String roleName) {
		Iterable<Role> roles = roleDAO.findRoles(roleName);
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		for (Role role : roles) {
			RoleDTO roleDTO = new RoleDTO();
			BeanUtils.copyProperties(role, roleDTO, "permissions");
			PermissionDTO permDTO = null;
			List<PermissionDTO> permDTOs = new ArrayList<PermissionDTO>();
			for (Permission perm : role.getPermissions()) {
				permDTO = new PermissionDTO();
				BeanUtils.copyProperties(perm, permDTO);
				permDTOs.add(permDTO);
			}
			roleDTO.setPermissions(permDTOs);
			roleDTOs.add(roleDTO);
		}
		return roleDTOs;
	}

	public List<PermissionDTO> getPermissions() {
		Iterable<Permission> permissions = roleDAO.findAllPermissions();
		List<PermissionDTO> permissionsRs = new ArrayList<PermissionDTO>();
		for (Permission permission : permissions) {
			PermissionDTO permissionRs = new PermissionDTO();
			BeanUtils.copyProperties(permission, permissionRs);

			permissionsRs.add(permissionRs);
		}
		return permissionsRs;

	}

	public boolean roleExists(String roleName) {
		return (roleDAO.findRole(roleName) != null) ? true : false;
	}

	void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
