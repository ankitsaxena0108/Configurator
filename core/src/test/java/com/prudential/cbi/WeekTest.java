package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.Week;

/**
 * The class <code>WeekTest</code> contains tests for the class <code>{@link Week}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:14 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class WeekTest {
	/**
	 * Run the String getDay() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	@Test
	public void testGetDay_1()
		throws Exception {
		Week fixture = new Week();
		fixture.setWeek("");
		fixture.setMonth("");
		fixture.setDay("tue");

		String result = fixture.getDay();

		// add additional test code here
		assertEquals("tue", result);
	}

	/**
	 * Run the String getMonth() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	@Test
	public void testGetMonth_1()
		throws Exception {
		Week fixture = new Week();
		fixture.setWeek("");
		fixture.setMonth("dec");
		fixture.setDay("");

		String result = fixture.getMonth();

		// add additional test code here
		assertEquals("dec", result);
	}

	/**
	 * Run the String getWeek() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	@Test
	public void testGetWeek_1()
		throws Exception {
		Week fixture = new Week();
		fixture.setWeek("3rd");
		fixture.setMonth("");
		fixture.setDay("");

		String result = fixture.getWeek();

		// add additional test code here
		assertEquals("3rd", result);
	}

	/**
	 * Run the void setDay(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	@Test
	public void testSetDay_1()
		throws Exception {
		Week fixture = new Week();
		fixture.setWeek("");
		fixture.setMonth("");
		fixture.setDay("");
		String day = "";

		fixture.setDay(day);

		// add additional test code here
	}

	/**
	 * Run the void setMonth(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	@Test
	public void testSetMonth_1()
		throws Exception {
		Week fixture = new Week();
		fixture.setWeek("");
		fixture.setMonth("");
		fixture.setDay("");
		String month = "";

		fixture.setMonth(month);

		// add additional test code here
	}

	/**
	 * Run the void setWeek(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	@Test
	public void testSetWeek_1()
		throws Exception {
		Week fixture = new Week();
		fixture.setWeek("");
		fixture.setMonth("");
		fixture.setDay("");
		String week = "";

		fixture.setWeek(week);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Week fixture = new Week();
		fixture.setWeek("");
		fixture.setMonth("");
		fixture.setDay("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [month = , day = , week = ]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:14 PM
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
	 * @generatedBy CodePro at 5/28/18 12:14 PM
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
	 * @generatedBy CodePro at 5/28/18 12:14 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WeekTest.class);
	}
}