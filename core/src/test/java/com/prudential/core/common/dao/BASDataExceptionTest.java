package com.prudential.core.common.dao;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BASDataExceptionTest</code> contains tests for the class <code>{@link BASDataException}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:37 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
public class BASDataExceptionTest {
	/**
	 * Run the BASDataException(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	@Test
	public void testBASDataException_1()
		throws Exception {
		String logMessage = "Server side error, Contact Administrator";

		BASDataException result = new BASDataException(logMessage);

		// add additional test code here
		assertNotNull(result);
		
		assertEquals("1000", result.getErrorCode());
		
		assertEquals("Server side error, Contact Administrator", result.getMessage());
	}

	/**
	 * Run the BASDataException(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:37 PM
	 */
	@Test
	public void testBASDataException_2()
		throws Exception {
		String errorCode = "1000";
		String logMessage = "Server side error, Contact Administrator";

		BASDataException result = new BASDataException(errorCode, logMessage);

		// add additional test code here
		assertNotNull(result);

		assertEquals("1000", result.getErrorCode());
		
		assertEquals("Server side error, Contact Administrator", result.getMessage());
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
		new org.junit.runner.JUnitCore().run(BASDataExceptionTest.class);
	}
}