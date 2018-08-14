package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.reject.web.RejectReportDetailRs;
import com.prudential.core.reject.web.RejectReportRs;

/**
 * The class <code>RejectReportRsTest</code> contains tests for the class <code>{@link RejectReportRs}</code>.
 *
 * @generatedBy CodePro at 5/28/18 5:47 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class RejectReportRsTest {
	/**
	 * Run the String getBankName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testGetBankName_1()
		throws Exception {
		RejectReportRs fixture = new RejectReportRs();
		fixture.setRejectionCode("");
		fixture.setBankName("IL_CC");
		fixture.setReconReportDetailRs(new LinkedList());

		String result = fixture.getBankName();

		// add additional test code here
		assertEquals("IL_CC", result);
	}

	/**
	 * Run the Collection<RejectReportDetailRs> getReconReportDetailRs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testGetReconReportDetailRs_1()
		throws Exception {
		RejectReportRs fixture = new RejectReportRs();
		fixture.setRejectionCode("");
		fixture.setBankName("");
		fixture.setReconReportDetailRs(new LinkedList());

		Collection<RejectReportDetailRs> result = fixture.getReconReportDetailRs();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getRejectionCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testGetRejectionCode_1()
		throws Exception {
		RejectReportRs fixture = new RejectReportRs();
		fixture.setRejectionCode("1");
		fixture.setBankName("");
		fixture.setReconReportDetailRs(new LinkedList());

		String result = fixture.getRejectionCode();

		// add additional test code here
		assertEquals("1", result);
	}

	/**
	 * Run the void setBankName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testSetBankName_1()
		throws Exception {
		RejectReportRs fixture = new RejectReportRs();
		fixture.setRejectionCode("");
		fixture.setBankName("");
		fixture.setReconReportDetailRs(new LinkedList());
		String bankName = "";

		fixture.setBankName(bankName);

		// add additional test code here
	}

	/**
	 * Run the void setReconReportDetailRs(Collection<RejectReportDetailRs>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testSetReconReportDetailRs_1()
		throws Exception {
		RejectReportRs fixture = new RejectReportRs();
		fixture.setRejectionCode("");
		fixture.setBankName("");
		fixture.setReconReportDetailRs(new LinkedList());
		Collection<RejectReportDetailRs> reconReportDetailRs = new LinkedList();

		fixture.setReconReportDetailRs(reconReportDetailRs);

		// add additional test code here
	}

	/**
	 * Run the void setRejectionCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 5:47 PM
	 */
	@Test
	public void testSetRejectionCode_1()
		throws Exception {
		RejectReportRs fixture = new RejectReportRs();
		fixture.setRejectionCode("");
		fixture.setBankName("");
		fixture.setReconReportDetailRs(new LinkedList());
		String rejectionCode = "";

		fixture.setRejectionCode(rejectionCode);

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
		new org.junit.runner.JUnitCore().run(RejectReportRsTest.class);
	}
}