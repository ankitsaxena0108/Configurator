package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.RecurrenceType;
import com.prudential.core.cbi.scheduleInfo.ScheduleDetails;

/**
 * The class <code>ScheduleDetailsTest</code> contains tests for the class <code>{@link ScheduleDetails}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:24 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class ScheduleDetailsTest {
	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("MB_CC");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("MB_CC", result);
	}

	/**
	 * Run the RecurrenceType getRecurrenceType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testGetRecurrenceType_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("");

		RecurrenceType result = fixture.getRecurrenceType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ClassPojo [weekly = null, monthly = null, hourly = null, freqType = null, daily = null]", result.toString());
		assertEquals(null, result.getMonthly());
		assertEquals(null, result.getHourly());
		assertEquals(null, result.getWeekly());
		assertEquals(null, result.getDaily());
		assertEquals(null, result.getFreqType());
	}

	/**
	 * Run the String getStartTime_in_Hr() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testGetStartTime_in_Hr_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("10");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("");

		String result = fixture.getStartTime_in_Hr();

		// add additional test code here
		assertEquals("10", result);
	}

	/**
	 * Run the String getStartTime_in_Min() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testGetStartTime_in_Min_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("05");
		fixture.setName("");

		String result = fixture.getStartTime_in_Min();

		// add additional test code here
		assertEquals("05", result);
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setRecurrenceType(RecurrenceType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testSetRecurrenceType_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("");
		RecurrenceType recurrenceType = new RecurrenceType();

		fixture.setRecurrenceType(recurrenceType);

		// add additional test code here
	}

	/**
	 * Run the void setStartTime_in_Hr(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testSetStartTime_in_Hr_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("");
		String startTime_in_Hr = "";

		fixture.setStartTime_in_Hr(startTime_in_Hr);

		// add additional test code here
	}

	/**
	 * Run the void setStartTime_in_Min(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testSetStartTime_in_Min_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("");
		String startTime_in_Min = "";

		fixture.setStartTime_in_Min(startTime_in_Min);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		ScheduleDetails fixture = new ScheduleDetails();
		fixture.setStartTime_in_Hr("");
		fixture.setRecurrenceType(new RecurrenceType());
		fixture.setStartTime_in_Min("");
		fixture.setName("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [recurrenceType = ClassPojo [weekly = null, monthly = null, hourly = null, freqType = null, daily = null], startTime_in_Hr = , startTime_in_Min = ]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:24 PM
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
	 * @generatedBy CodePro at 5/28/18 12:24 PM
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
	 * @generatedBy CodePro at 5/28/18 12:24 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ScheduleDetailsTest.class);
	}
}