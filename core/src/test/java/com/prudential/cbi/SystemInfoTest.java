package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.ScheduleDetails;
import com.prudential.core.cbi.scheduleInfo.SystemInfo;

/**
 * The class <code>SystemInfoTest</code> contains tests for the class <code>{@link SystemInfo}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:30 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class SystemInfoTest {
	/**
	 * Run the String getCategory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testGetCategory_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("category");
		fixture.setPaymentType("");
		fixture.setName("");

		String result = fixture.getCategory();

		// add additional test code here
		assertEquals("category", result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("SC_CC");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("SC_CC", result);
	}

	/**
	 * Run the String getPaymentType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testGetPaymentType_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("Debit");
		fixture.setName("");

		String result = fixture.getPaymentType();

		// add additional test code here
		assertEquals("Debit", result);
	}

	/**
	 * Run the ScheduleDetails getScheduleDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testGetScheduleDetails_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("");

		ScheduleDetails result = fixture.getScheduleDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ClassPojo [recurrenceType = null, startTime_in_Hr = null, startTime_in_Min = null]", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getRecurrenceType());
		assertEquals(null, result.getStartTime_in_Hr());
		assertEquals(null, result.getStartTime_in_Min());
	}

	/**
	 * Run the String getScheduleType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testGetScheduleType_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("MB_CC");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("");

		String result = fixture.getScheduleType();

		// add additional test code here
		assertEquals("MB_CC", result);
	}

	/**
	 * Run the void setCategory(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testSetCategory_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("");
		String category = "";

		fixture.setCategory(category);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setPaymentType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testSetPaymentType_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("");
		String paymentType = "";

		fixture.setPaymentType(paymentType);

		// add additional test code here
	}

	/**
	 * Run the void setScheduleDetails(ScheduleDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testSetScheduleDetails_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("");
		ScheduleDetails scheduleDetails = new ScheduleDetails();

		fixture.setScheduleDetails(scheduleDetails);

		// add additional test code here
	}

	/**
	 * Run the void setScheduleType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	@Test
	public void testSetScheduleType_1()
		throws Exception {
		SystemInfo fixture = new SystemInfo();
		fixture.setScheduleDetails(new ScheduleDetails());
		fixture.setScheduleType("");
		fixture.setCategory("");
		fixture.setPaymentType("");
		fixture.setName("");
		String scheduleType = "";

		fixture.setScheduleType(scheduleType);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:30 PM
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
	 * @generatedBy CodePro at 5/28/18 12:30 PM
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
	 * @generatedBy CodePro at 5/28/18 12:30 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SystemInfoTest.class);
	}
}