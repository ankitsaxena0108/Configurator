package com.prudential.users.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.users.UserDTO;

/**
 * The class <code>UserDTOTest</code> contains tests for the class <code>{@link UserDTO}</code>.
 *
 * @generatedBy CodePro at 5/29/18 12:31 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class UserDTOTest {
	/**
	 * Run the Long getLocaleId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testGetLocaleId_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");

		Long result = fixture.getLocaleId();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the String getLogin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testGetLogin_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("superit");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");

		String result = fixture.getLogin();

		// add additional test code here
		assertEquals("superit", result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("scheduler");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("scheduler", result);
	}

	/**
	 * Run the List<String> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testGetRoles_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");

		List<String> result = fixture.getRoles();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testGetStatus_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("status");

		String result = fixture.getStatus();

		// add additional test code here
		assertEquals("status", result);
	}

	/**
	 * Run the void setLocaleId(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testSetLocaleId_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");
		Long localeId = new Long(1L);

		fixture.setLocaleId(localeId);

		// add additional test code here
	}

	/**
	 * Run the void setLogin(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testSetLogin_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");
		String login = "";

		fixture.setLogin(login);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setRoles(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testSetRoles_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");
		List<String> roles = new LinkedList();

		fixture.setRoles(roles);

		// add additional test code here
	}

	/**
	 * Run the void setStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	@Test
	public void testSetStatus_1()
		throws Exception {
		UserDTO fixture = new UserDTO();
		fixture.setLogin("");
		fixture.setLocaleId(new Long(1L));
		fixture.setName("");
		fixture.setRoles(new LinkedList());
		fixture.setStatus("");
		String status = "";

		fixture.setStatus(status);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/29/18 12:31 PM
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
	 * @generatedBy CodePro at 5/29/18 12:31 PM
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
	 * @generatedBy CodePro at 5/29/18 12:31 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UserDTOTest.class);
	}
}