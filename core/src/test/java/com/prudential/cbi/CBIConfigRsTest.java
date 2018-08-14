package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.services.rs.CBIConfigRs;

/**
 * The class <code>CBIConfigRsTest</code> contains tests for the class <code>{@link CBIConfigRs}</code>.
 *
 * @generatedBy CodePro at 5/28/18 4:38 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class CBIConfigRsTest {
	/**
	 * Run the String getCategory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testGetCategory_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("collection");

		String result = fixture.getCategory();

		// add additional test code here
		assertEquals("collection", result);
	}

	/**
	 * Run the String getCbiConfigDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testGetCbiConfigDetails_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("details");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("");

		String result = fixture.getCbiConfigDetails();

		// add additional test code here
		assertEquals("details", result);
	}

	/**
	 * Run the String getFileName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testGetFileName_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("BankConfig.xlsx");
		fixture.setCategory("");

		String result = fixture.getFileName();

		// add additional test code here
		assertEquals("BankConfig.xlsx", result);
		
	}

	/**
	 * Run the String getOtherDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testGetOtherDetails_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("DETAILS");
		fixture.setFileName("");
		fixture.setCategory("");

		String result = fixture.getOtherDetails();

		// add additional test code here
		assertEquals("DETAILS", result);
	}

	/**
	 * Run the String getScheduleInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testGetScheduleInfo_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("ScheduleInfo");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("");

		String result = fixture.getScheduleInfo();

		// add additional test code here
		assertEquals("ScheduleInfo", result);
	}

	/**
	 * Run the void setCategory(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testSetCategory_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("");
		String category = "";

		fixture.setCategory(category);

		// add additional test code here
	}

	/**
	 * Run the void setCbiConfigDetails(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testSetCbiConfigDetails_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("");
		String cbiConfigDetails = "";

		fixture.setCbiConfigDetails(cbiConfigDetails);

		// add additional test code here
	}

	/**
	 * Run the void setFileName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testSetFileName_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("");
		String fileName = "";

		fixture.setFileName(fileName);

		// add additional test code here
	}

	/**
	 * Run the void setOtherDetails(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testSetOtherDetails_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("");
		String otherDetails = "";

		fixture.setOtherDetails(otherDetails);

		// add additional test code here
	}

	/**
	 * Run the void setScheduleInfo(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	@Test
	public void testSetScheduleInfo_1()
		throws Exception {
		CBIConfigRs fixture = new CBIConfigRs();
		fixture.setCbiConfigDetails("");
		fixture.setScheduleInfo("");
		fixture.setOtherDetails("");
		fixture.setFileName("");
		fixture.setCategory("");
		String scheduleInfo = "";

		fixture.setScheduleInfo(scheduleInfo);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 4:38 PM
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
	 * @generatedBy CodePro at 5/28/18 4:38 PM
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
	 * @generatedBy CodePro at 5/28/18 4:38 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CBIConfigRsTest.class);
	}
}