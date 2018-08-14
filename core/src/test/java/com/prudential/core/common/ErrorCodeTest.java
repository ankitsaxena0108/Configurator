package com.prudential.core.common;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ErrorCodeTest</code> contains tests for the class <code>{@link ErrorCode}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:45 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
public class ErrorCodeTest {
	/**
	 * Run the ErrorCode(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testErrorCode_1()
		throws Exception {
		String errorCode = "1000";
		String logMessage = "Server side error, Contact Administrator";

		ErrorCode result = new ErrorCode(errorCode, logMessage);

		// add additional test code here
		assertNotNull(result);
		assertEquals("1000", result.getErrorCode());
		assertEquals("Server side error, Contact Administrator", result.getLogMessage());
	}

	/**
	 * Run the String getErrorCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testGetErrorCode_1()
		throws Exception {
		ErrorCode fixture = new ErrorCode("1000", "Server side error, Contact Administrator");

		String result = fixture.getErrorCode();

		// add additional test code here
		assertEquals("1000", result);
	}

	/**
	 * Run the String getLogMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testGetLogMessage_1()
		throws Exception {
		ErrorCode fixture = new ErrorCode("1000", "Server side error, Contact Administrator");

		String result = fixture.getLogMessage();

		// add additional test code here
		assertEquals("Server side error, Contact Administrator", result);
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
		new org.junit.runner.JUnitCore().run(ErrorCodeTest.class);
	}
}