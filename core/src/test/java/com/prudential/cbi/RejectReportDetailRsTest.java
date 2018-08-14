package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.reject.web.RejectReportDetailRs;

/**
 * The class <code>RejectReportDetailRsTest</code> contains tests for the class <code>{@link RejectReportDetailRs}</code>.
 *
 * @generatedBy CodePro at 5/28/18 5:47 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class RejectReportDetailRsTest {
	/**
	 * Run the String getFailureCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testGetFailureCode_1()
		throws Exception {
		RejectReportDetailRs fixture = new RejectReportDetailRs();
		fixture.setFailureCode("1");
		fixture.setRowNumber(1L);

		String result = fixture.getFailureCode();

		// add additional test code here
		assertEquals("1", result);
	}

	/**
	 * Run the long getRowNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testGetRowNumber_1()
		throws Exception {
		RejectReportDetailRs fixture = new RejectReportDetailRs();
		fixture.setFailureCode("");
		fixture.setRowNumber(1L);

		long result = fixture.getRowNumber();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the void setFailureCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testSetFailureCode_1()
		throws Exception {
		RejectReportDetailRs fixture = new RejectReportDetailRs();
		fixture.setFailureCode("");
		fixture.setRowNumber(1L);
		String failureCode = "";

		fixture.setFailureCode(failureCode);

		// add additional test code here
	}

	/**
	 * Run the void setRowNumber(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testSetRowNumber_1()
		throws Exception {
		RejectReportDetailRs fixture = new RejectReportDetailRs();
		fixture.setFailureCode("");
		fixture.setRowNumber(1L);
		long rowNumber = 1L;

		fixture.setRowNumber(rowNumber);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
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
	 * @generatedBy CodePro at 5/28/18 5:47 PM
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
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RejectReportDetailRsTest.class);
	}
}