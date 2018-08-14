package com.prudential.users.da;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.common.ThreadLocalVars;
import com.prudential.core.common.locale.Locale;
import com.prudential.core.users.model.User;

/**
 * The class <code>UserDAOTest</code> contains tests for the class
 * <code>{@link UserDAO}</code>.
 *
 * @generatedBy CodePro at 4/4/18 5:13 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
public class UserDAOTest {
	@Autowired
	private UserDAO userDAO;

	/**
	 * Run the UserDAO() constructor test.
	 *
	 * @generatedBy CodePro at 4/4/18 5:13 PM
	 */
	@Test
	public void testUserDAO_1() throws Exception {
		UserDAO result = new UserDAO();
		assertNotNull(result);
	}

	/**
	 * Run the User currentUser() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 5:13 PM
	 */
	@Test
	public void testCurrentUser_1() throws Exception {
		ThreadLocalVars.set("superit");
		User result = userDAO.currentUser();
		assertEquals("superit",result.getLogin());
	}

	/**
	 * Run the Iterable<User> findAll() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 5:13 PM
	 */
	@Test
	public void testFindAll_1() throws Exception {
		Iterable<User> result = userDAO.findAll();
		assertNotNull(result);
	}


	@Test
	public void testFindLocale_1() throws Exception {
		String language = "en";
		String country = "US";

		Locale result = userDAO.findLocale(language, country);

		assertNotNull(result);
	}

	
	@Test
	public void testFindUser_1() throws Exception {

		long id = 1L;

		User result = userDAO.findUser(id);

		assertNotNull(result);
	}

	
	@Test
	public void testFindUser_2() throws Exception {
		String login = "superit";

		User result = userDAO.findUser(login);

		assertNotNull(result);
	}

	
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UserDAOTest.class);
	}
}