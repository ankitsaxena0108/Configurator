package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.Day;

/**
 * The class <code>DayTest</code> contains tests for the class <code>{@link Day}</code>.
 *
 * @generatedBy CodePro at 5/28/18 11:58 AM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class DayTest {
	/**
	 * Run the String getDay() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:58 AM
	 */
	@Test
	public void testGetDay_1()
		throws Exception {
		Day fixture = new Day();
		fixture.setDay("Mon");
		fixture.setOfEvery("");

		String result = fixture.getDay();

		// add additional test code here
		assertEquals("Mon", result);
	}

	/**
	 * Run the String getOfEvery() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:58 AM
	 */
	@Test
	public void testGetOfEvery_1()
		throws Exception {
		Day fixture = new Day();
		fixture.setDay("");
		fixture.setOfEvery("wed");

		String result = fixture.getOfEvery();

		// add additional test code here
		assertEquals("wed", result);
	}

	/**
	 * Run the void setDay(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:58 AM
	 */
	@Test
	public void testSetDay_1()
		throws Exception {
		Day fixture = new Day();
		fixture.setDay("");
		fixture.setOfEvery("");
		String Day = "";

		fixture.setDay(Day);

		// add additional test code here
	}

	/**
	 * Run the void setOfEvery(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:58 AM
	 */
	@Test
	public void testSetOfEvery_1()
		throws Exception {
		Day fixture = new Day();
		fixture.setDay("");
		fixture.setOfEvery("");
		String ofEvery = "";

		fixture.setOfEvery(ofEvery);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:58 AM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Day fixture = new Day();
		fixture.setDay("");
		fixture.setOfEvery("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [ofEvery = , Day = ]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 11:58 AM
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
	 * @generatedBy CodePro at 5/28/18 11:58 AM
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
	 * @generatedBy CodePro at 5/28/18 11:58 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DayTest.class);
	}
}