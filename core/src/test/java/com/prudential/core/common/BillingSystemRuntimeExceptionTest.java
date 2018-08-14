package com.prudential.core.common;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BillingSystemRuntimeExceptionTest</code> contains tests for the class <code>{@link BillingSystemRuntimeException}</code>.
 *
 * @generatedBy CodePro at 4/4/18 3:04 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
public class BillingSystemRuntimeExceptionTest {
	/**
	 * Run the BillingSystemRuntimeException(ErrorCode,Object[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	@Test
	public void testBillingSystemRuntimeException_1()
		throws Exception {
		ErrorCode errorCode = new ErrorCode("1000", "Server side error, Contact Administrator");

		BillingSystemRuntimeException result = new BillingSystemRuntimeException(errorCode);

		// add additional test code here
		assertNotNull(result);
		assertEquals("1000", result.getErrorCode());
		assertEquals(null, result.getCause());
		assertEquals("com.prudential.core.common.BillingSystemRuntimeException: Server side error, Contact Administrator", result.toString());
		assertEquals("Server side error, Contact Administrator", result.getLocalizedMessage());
		assertEquals("Server side error, Contact Administrator", result.getMessage());
	}

	/**
	 * Run the BillingSystemRuntimeException(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	@Test
	public void testBillingSystemRuntimeException_2()
		throws Exception {
		String errorCode = "1000";
		String logMessage = "Server side error, Contact Administrator";

		BillingSystemRuntimeException result = new BillingSystemRuntimeException(errorCode, logMessage);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getParams());
		assertEquals("1000", result.getErrorCode());
		assertEquals(null, result.getCause());
		assertEquals("com.prudential.core.common.BillingSystemRuntimeException: Server side error, Contact Administrator", result.toString());
		assertEquals("Server side error, Contact Administrator", result.getLocalizedMessage());
		assertEquals("Server side error, Contact Administrator", result.getMessage());
	}

	/**
	 * Run the BillingSystemRuntimeException(String,Throwable) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	@Test
	public void testBillingSystemRuntimeException_3()
		throws Exception {
		String errorCode = "1000";
		Throwable cause = new Throwable();


		BillingSystemRuntimeException result = new BillingSystemRuntimeException(errorCode, cause);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getParams());
		assertEquals("1000", result.getErrorCode());
		assertEquals("com.prudential.core.common.BillingSystemRuntimeException: java.lang.Throwable", result.toString());
		assertEquals("java.lang.Throwable", result.getLocalizedMessage());
		assertEquals("java.lang.Throwable", result.getMessage());
	}

	/**
	 * Run the String getErrorCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	@Test
	public void testGetErrorCode_1()
		throws Exception {
		BillingSystemRuntimeException fixture = new BillingSystemRuntimeException("1000", new Throwable());
		fixture.setParams(new Object[] {"param1"});
		fixture.addSuppressed(new Throwable());

		String result = fixture.getErrorCode();

		// add additional test code here
		assertEquals("1000", result);
	}

	/**
	 * Run the BillingSystemModule getModule() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	@Test
	public void testGetModule_1()
		throws Exception {
		BillingSystemRuntimeException fixture = new BillingSystemRuntimeException("1000", new Throwable());
		fixture.setParams(new Object[] {"param1"});
		fixture.addSuppressed(new Throwable());

		BillingSystemModule result = fixture.getModule();

		// add additional test code here
		assertNotNull(result);
		assertEquals("CORE", result.name());
		assertEquals("CORE", result.toString());
		assertEquals(0, result.ordinal());
	}

	/**
	 * Run the Object[] getParams() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	@Test
	public void testGetParams_1()
		throws Exception {
		BillingSystemRuntimeException fixture = new BillingSystemRuntimeException("1000", new Throwable());
		fixture.setParams(new Object[] {"param1"});
		fixture.addSuppressed(new Throwable());

		Object[] result = fixture.getParams();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
	}

	/**
	 * Run the void setParams(Object[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	@Test
	public void testSetParams_1()
		throws Exception {
		BillingSystemRuntimeException fixture = new BillingSystemRuntimeException("1000", new Throwable());
		fixture.setParams(new Object[] {"param1"});
		fixture.addSuppressed(new Throwable());
		Object[] result = fixture.getParams();
		assertEquals(1, result.length);

	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 3:04 PM
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
	 * @generatedBy CodePro at 4/4/18 3:04 PM
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
	 * @generatedBy CodePro at 4/4/18 3:04 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BillingSystemRuntimeExceptionTest.class);
	}
}