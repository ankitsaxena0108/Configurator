package com.prudential.cbi;

import org.junit.*;

import com.prudential.core.cbi.scheduleInfo.Daily;

import static org.junit.Assert.*;

/**
 * The class <code>DailyTest</code> contains tests for the class <code>{@link Daily}</code>.
 *
 * @generatedBy CodePro at 5/28/18 11:52 AM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class DailyTest {
	/**
	 * Run the String getDaily() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:52 AM
	 */
	@Test
	public void testGetDaily_1()
		throws Exception {
		Daily fixture = new Daily();
		fixture.setDaily("Mon");

		String result = fixture.getDaily();

		// add additional test code here
		assertEquals("Mon", result);
	}

	/**
	 * Run the void setDaily(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:52 AM
	 */
	@Test
	public void testSetDaily_1()
		throws Exception {
		Daily fixture = new Daily();
		fixture.setDaily("");
		String daily = "";

		fixture.setDaily(daily);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 11:52 AM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Daily fixture = new Daily();
		fixture.setDaily("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [daily = ]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 11:52 AM
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
	 * @generatedBy CodePro at 5/28/18 11:52 AM
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
	 * @generatedBy CodePro at 5/28/18 11:52 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DailyTest.class);
	}
}