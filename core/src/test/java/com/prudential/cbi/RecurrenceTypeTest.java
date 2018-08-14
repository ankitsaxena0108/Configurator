package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.Daily;
import com.prudential.core.cbi.scheduleInfo.Hourly;
import com.prudential.core.cbi.scheduleInfo.Monthly;
import com.prudential.core.cbi.scheduleInfo.RecurrenceType;
import com.prudential.core.cbi.scheduleInfo.Weekly;

/**
 * The class <code>RecurrenceTypeTest</code> contains tests for the class <code>{@link RecurrenceType}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:21 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class RecurrenceTypeTest {
	/**
	 * Run the Daily getDaily() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testGetDaily_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());

		Daily result = fixture.getDaily();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ClassPojo [daily = null]", result.toString());
		assertEquals(null, result.getDaily());
	}

	/**
	 * Run the String getFreqType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testGetFreqType_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());

		String result = fixture.getFreqType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Hourly getHourly() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testGetHourly_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());

		Hourly result = fixture.getHourly();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ClassPojo [everyHr = null]", result.toString());
		assertEquals(null, result.getEveryHr());
	}

	/**
	 * Run the Monthly getMonthly() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testGetMonthly_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());

		Monthly result = fixture.getMonthly();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ClassPojo [monthlyFreType = null, day = 0, week = 0]", result.toString());
		assertEquals("0", result.getMonth());
		assertEquals("0", result.getDay());
		assertEquals("0", result.getThe());
		assertEquals("0", result.getWeek());
		assertEquals(null, result.getMonthlyFreType());
	}

	/**
	 * Run the Weekly getWeekly() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testGetWeekly_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());

		Weekly result = fixture.getWeekly();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ClassPojo [sun = null]", result.toString());
		assertEquals(null, result.getSun());
		assertEquals(Boolean.FALSE, result.getSat());
		assertEquals(Boolean.FALSE, result.getWed());
		assertEquals(Boolean.FALSE, result.getThu());
		assertEquals(Boolean.FALSE, result.getTue());
		assertEquals(Boolean.FALSE, result.getFri());
		assertEquals(Boolean.FALSE, result.getMon());
	}

	/**
	 * Run the void setDaily(Daily) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testSetDaily_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());
		Daily daily = new Daily();

		fixture.setDaily(daily);

		// add additional test code here
	}

	/**
	 * Run the void setFreqType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testSetFreqType_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());
		String freqType = "";

		fixture.setFreqType(freqType);

		// add additional test code here
	}

	/**
	 * Run the void setHourly(Hourly) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testSetHourly_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());
		Hourly hourly = new Hourly();

		fixture.setHourly(hourly);

		// add additional test code here
	}

	/**
	 * Run the void setMonthly(Monthly) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testSetMonthly_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());
		Monthly monthly = new Monthly();

		fixture.setMonthly(monthly);

		// add additional test code here
	}

	/**
	 * Run the void setWeekly(Weekly) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testSetWeekly_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());
		Weekly weekly = new Weekly();

		fixture.setWeekly(weekly);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		RecurrenceType fixture = new RecurrenceType();
		fixture.setWeekly(new Weekly());
		fixture.setFreqType("");
		fixture.setHourly(new Hourly());
		fixture.setDaily(new Daily());
		fixture.setMonthly(new Monthly());

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [weekly = ClassPojo [sun = null], monthly = ClassPojo [monthlyFreType = null, day = 0, week = 0], hourly = ClassPojo [everyHr = null], freqType = , daily = ClassPojo [daily = null]]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:21 PM
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
	 * @generatedBy CodePro at 5/28/18 12:21 PM
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
	 * @generatedBy CodePro at 5/28/18 12:21 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RecurrenceTypeTest.class);
	}
}