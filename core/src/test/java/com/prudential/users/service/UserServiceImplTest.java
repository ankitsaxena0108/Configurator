package com.prudential.users.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.common.ThreadLocalVars;
import com.prudential.core.common.authority.PermissionDTO;
import com.prudential.core.common.authority.RoleDTO;
import com.prudential.core.common.menu.MenuItem;
import com.prudential.core.users.UserDTO;
import com.prudential.core.users.UserService;

/**
 * The class <code>UserServiceImplTest</code> contains tests for the class
 * <code>{@link UserServiceImpl}</code>.
 *
 * @generatedBy CodePro at 4/4/18 5:13 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
public class UserServiceImplTest {
	@Autowired
	private UserService userService;

	@Test
	public void testCurrentLocaleId_2() throws Exception {
		ThreadLocalVars.set("superit");
		long result = userService.currentLocaleId();

		assertEquals(1L, result);
	}


	@Test
	public void testGetAllUserRoles_1() throws Exception {

		String name = "superit";

		List<RoleDTO> result = userService.getAllUserRoles(name);

		assertNotNull(result);
	}

	@Test
	public void testGetPermissions_1() throws Exception {

		List<PermissionDTO> result = userService.getPermissions();

		assertNotNull(result);
	}

	@Test
	public void testGetRole_1() throws Exception {

		long roleId = 1L;

		RoleDTO result = userService.getRole(roleId);

		assertNotNull(result);
	}

	@Test
	public void testGetRoles_2() throws Exception {

		List<RoleDTO> result = userService.getRoles();

		assertNotNull(result);
	}

	@Test
	public void testGetRoles_3() throws Exception {

		String roleName = "BILL_ADMIN";

		List<RoleDTO> result = userService.getRoles(roleName);

		assertNotNull(result);
	}

	@Test
	public void testGetUserMenu_1() throws Exception {

		String login = "superit";

		List<MenuItem> result = userService.getUserMenu(login);

		assertNotNull(result);
	}

	@Test
	public void testRoleExists_1() throws Exception {

		String roleName = "BILL_ADMIN";

		boolean result = userService.roleExists(roleName);

		assertTrue(result);
	}

	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 5:13 PM
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 * @generatedBy CodePro at 4/4/18 5:13 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UserServiceImplTest.class);
	}
}