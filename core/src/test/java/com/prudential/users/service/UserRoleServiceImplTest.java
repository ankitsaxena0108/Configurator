package com.prudential.users.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.common.authority.Role;
import com.prudential.core.common.authority.UserRoleService;
import com.prudential.core.users.model.User;

/**
 * The class <code>UserRoleServiceImplTest</code> contains tests for the class <code>{@link UserRoleServiceImpl}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:45 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
public class UserRoleServiceImplTest {
	
	@Autowired
	private UserRoleService userRoleService;
	/**
	 * Run the List<Role> getHierarchyForRole(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testGetHierarchyForRole_1()
		throws Exception {
		String roleName = "BILL_ADMIN";

		List<Role> result = userRoleService.getHierarchyForRole(roleName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.prudential.users.service.UserRoleServiceImpl.getHierarchyForRole(UserRoleServiceImpl.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the User getUser(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testGetUser_1()
		throws Exception {
		String userId = "superit";

		User result = userRoleService.getUser(userId);

		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UserRoleServiceImplTest.class);
	}
}