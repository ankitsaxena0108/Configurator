package com.prudential.core.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CBIExceptionTest</code> contains tests for the class <code>{@link CBIException}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:45 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
public class CBIExceptionTest {
	/**
	 * Run the CBIException(Map<String,List<String>>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testCBIException_1()
		throws Exception {
		Map<String, List<String>> validationMessages = new HashMap();
		
		List<String> messagesList = new ArrayList<String>();
		
		messagesList.add("No config row found in the table:" + "CIMB_det_in");
		validationMessages.put("workbook", messagesList);
		
		CBIException result = new CBIException(validationMessages);

		// add additional test code here
		assertNotNull(validationMessages);
		assertEquals(1, validationMessages.get("workbook").size());
	}

	/**
	 * Run the CBIException(ErrorCode,Object[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testCBIException_2()
		throws Exception {
		ErrorCode errorCode = new ErrorCode("1002", "Error Uploading Bank Template.");

		CBIException result = new CBIException(errorCode);

		// add additional test code here
		assertNotNull(result);
		assertEquals("1002", result.getErrorCode());
		assertEquals("com.prudential.core.common.CBIException: Error Uploading Bank Template.", result.toString());
		assertEquals("Error Uploading Bank Template.", result.getLocalizedMessage());
		assertEquals("Error Uploading Bank Template.", result.getMessage());
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
		new org.junit.runner.JUnitCore().run(CBIExceptionTest.class);
	}
}