package com.prudential.core.common;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BillingSystemModuleTest</code> contains tests for the class <code>{@link BillingSystemModule}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:37 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
public class BillingSystemModuleTest {
	/**
	 * Run the boolean isInValidRange(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	@Test
	public void testIsInValidRange_1()
		throws Exception {
		BillingSystemModule fixture = BillingSystemModule.CORE;
		int number = 1000;

		boolean result = fixture.isInValidRange(number);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isInValidRange(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	@Test
	public void testIsInValidRange_2()
		throws Exception {
		BillingSystemModule fixture = BillingSystemModule.CORE;
		int number = 1500;

		boolean result = fixture.isInValidRange(number);

		// add additional test code here
		assertEquals(true, result);
	}
	
	@Test
	public void testIsInValidRange_3()
		throws Exception {
		BillingSystemModule fixture = BillingSystemModule.CORE;
		int number = 2000;

		boolean result = fixture.isInValidRange(number);

		// add additional test code here
		assertEquals(false, result);
	}
	
	@Test
	public void testIsInValidRange_4()
		throws Exception {
		BillingSystemModule fixture = BillingSystemModule.CORE;
		int number = 500;

		boolean result = fixture.isInValidRange(number);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the BillingSystemModule module(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	@Test
	public void testModule_1()
		throws Exception {
		String errorCode = "1000";

		BillingSystemModule result = BillingSystemModule.module(errorCode);

		// add additional test code here
		assertNotNull(result);
		assertEquals("CORE", result.name());
		assertEquals("CORE", result.toString());
		assertEquals(0, result.ordinal());
	}

	/**
	 * Run the BillingSystemModule module(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	@Test
	public void testModule_2()
		throws Exception {
		String errorCode = "";

		BillingSystemModule result = BillingSystemModule.module(errorCode);

		// add additional test code here
		assertNotNull(result);
		assertEquals("CORE", result.name());
		assertEquals("CORE", result.toString());
		assertEquals(0, result.ordinal());
	}

	/**
	 * Run the BillingSystemModule module(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	@Test
	public void testModule_3()
		throws Exception {
		String errorCode = "0";

		BillingSystemModule result = BillingSystemModule.module(errorCode);

		// add additional test code here
		assertNotNull(result);
		assertEquals("CORE", result.name());
		assertEquals("CORE", result.toString());
		assertEquals(0, result.ordinal());
	}

	

	

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
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
	 * @generatedBy CodePro at 4/4/18 2:37 PM
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
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BillingSystemModuleTest.class);
	}
}