package com.prudential.core.common;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ThreadLocalVarsTest</code> contains tests for the class <code>{@link ThreadLocalVars}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:32 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
public class ThreadLocalVarsTest {
	/**
	 * Run the ThreadLocalVars() constructor test.
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testThreadLocalVars_1()
		throws Exception {
		ThreadLocalVars result = new ThreadLocalVars();
		assertNotNull(result);
	}

	/**
	 * Run the Object getAuditStoredValue(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testGetAuditStoredValue_1()
		throws Exception {
		String key = "";

		Object result = ThreadLocalVars.getAuditStoredValue(key);

		// add additional test code here
		assertEquals(null, result);
	}

	
	/**
	 * Run the String getCurrentUser() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testGetCurrentUser_1()
		throws Exception {
		ThreadLocalVars.set("user1");
		String result = ThreadLocalVars.getCurrentUser();
		assertEquals("user1", result);
	}

	
	/**
	 * Run the void putAuditStoredValues(String,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testPutAuditStoredValues_1()
		throws Exception {
		String key = "key1";
		Object value = "value1";

		ThreadLocalVars.putAuditStoredValues(key, value);

		assertEquals("value1",ThreadLocalVars.getAuditStoredValue("key1"));
	}

	/**
	 * Run the void remove() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testRemove_1()
		throws Exception {
		String user = "user1";

		ThreadLocalVars.set(user);
		

		ThreadLocalVars.remove();
		assertEquals(null,ThreadLocalVars.getCurrentUser());

	}

	/**
	 * Run the void removeAuditStoredValues() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testRemoveAuditStoredValues_1()
		throws Exception {
		Map<String, Object> values = new HashMap();
		values.put("key1", "value1");
		values.put("key2", "value2");

		ThreadLocalVars.setAuditStoredValues(values);
		ThreadLocalVars.removeAuditStoredValues();
		assertEquals(null,ThreadLocalVars.getAuditStoredValue("key1"));
	}

	/**
	 * Run the void set(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testSet_1()
		throws Exception {
		String user = "user1";

		ThreadLocalVars.set(user);
		assertEquals("user1",ThreadLocalVars.getCurrentUser());
	}

	/**
	 * Run the void setAuditStoredValues(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	@Test
	public void testSetAuditStoredValues_1()
		throws Exception {
		Map<String, Object> values = new HashMap();
		values.put("key1", "value1");
		values.put("key2", "value2");

		ThreadLocalVars.setAuditStoredValues(values);
		assertEquals(2,values.size());

	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 2:32 PM
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
	 * @generatedBy CodePro at 4/4/18 2:32 PM
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
	 * @generatedBy CodePro at 4/4/18 2:32 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ThreadLocalVarsTest.class);
	}
}