package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.Monthly;

/**
 * The class <code>MonthlyTest</code> contains tests for the class <code>{@link Monthly}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:10 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class MonthlyTest {
	/**
	 * Run the Monthly() constructor test.
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testMonthly_1()
		throws Exception {
		Monthly result = new Monthly();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the String getDay() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testGetDay_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
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
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testGetMonth_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("jan");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
		fixture.setDay("");

		String result = fixture.getMonth();

		// add additional test code here
		assertEquals("jan", result);
	}

	/**
	 * Run the String getMonthlyFreType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testGetMonthlyFreType_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("MonthlyFreType");
		fixture.setWeek("");
		fixture.setThe("");
		fixture.setDay("");

		String result = fixture.getMonthlyFreType();

		// add additional test code here
		assertEquals("MonthlyFreType", result);
	}

	/**
	 * Run the String getThe() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testGetThe_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("the");
		fixture.setDay("");

		String result = fixture.getThe();

		// add additional test code here
		assertEquals("the", result);
	}

	/**
	 * Run the String getWeek() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testGetWeek_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("2nd week");
		fixture.setThe("");
		fixture.setDay("");

		String result = fixture.getWeek();

		// add additional test code here
		assertEquals("2nd week", result);
	}

	/**
	 * Run the void setDay(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testSetDay_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
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
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testSetMonth_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
		fixture.setDay("");
		String month = "";

		fixture.setMonth(month);

		// add additional test code here
	}

	/**
	 * Run the void setMonthlyFreType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testSetMonthlyFreType_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
		fixture.setDay("");
		String monthlyFreType = "";

		fixture.setMonthlyFreType(monthlyFreType);

		// add additional test code here
	}

	/**
	 * Run the void setThe(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testSetThe_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
		fixture.setDay("");
		String the = "";

		fixture.setThe(the);

		// add additional test code here
	}

	/**
	 * Run the void setWeek(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testSetWeek_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
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
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Monthly fixture = new Monthly();
		fixture.setMonth("");
		fixture.setMonthlyFreType("");
		fixture.setWeek("");
		fixture.setThe("");
		fixture.setDay("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [monthlyFreType = , day = , week = ]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:10 PM
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
	 * @generatedBy CodePro at 5/28/18 12:10 PM
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
	 * @generatedBy CodePro at 5/28/18 12:10 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MonthlyTest.class);
	}
}