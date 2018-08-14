package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.Hourly;

/**
 * The class <code>HourlyTest</code> contains tests for the class <code>{@link Hourly}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:03 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class HourlyTest {
	/**
	 * Run the String getEveryHr() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:03 PM
	 */
	@Test
	public void testGetEveryHr_1()
		throws Exception {
		Hourly fixture = new Hourly();
		fixture.setEveryHr("5");

		String result = fixture.getEveryHr();

		// add additional test code here
		assertEquals("5", result);
	}

	/**
	 * Run the void setEveryHr(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:03 PM
	 */
	@Test
	public void testSetEveryHr_1()
		throws Exception {
		Hourly fixture = new Hourly();
		fixture.setEveryHr("");
		String everyHr = "";

		fixture.setEveryHr(everyHr);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:03 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Hourly fixture = new Hourly();
		fixture.setEveryHr("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [everyHr = ]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:03 PM
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
	 * @generatedBy CodePro at 5/28/18 12:03 PM
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
	 * @generatedBy CodePro at 5/28/18 12:03 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HourlyTest.class);
	}
}