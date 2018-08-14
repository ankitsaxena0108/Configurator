package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.SystemDetailRequest;

/**
 * The class <code>SystemDetailRequestTest</code> contains tests for the class <code>{@link SystemDetailRequest}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:29 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class SystemDetailRequestTest {
	/**
	 * Run the String getCategory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testGetCategory_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("category");
		fixture.setScheduleType("");
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
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setScheduleType("");
		fixture.setName("MB_CC");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("MB_CC", result);
	}

	/**
	 * Run the String getPaymentType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testGetPaymentType_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("PaymentType");
		fixture.setCategory("");
		fixture.setScheduleType("");
		fixture.setName("");

		String result = fixture.getPaymentType();

		// add additional test code here
		assertEquals("PaymentType", result);
	}

	/**
	 * Run the String getScheduleType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testGetScheduleType_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setScheduleType("MB_CC");
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
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testSetCategory_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setScheduleType("");
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
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setScheduleType("");
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
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testSetPaymentType_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setScheduleType("");
		fixture.setName("");
		String paymentType = "";

		fixture.setPaymentType(paymentType);

		// add additional test code here
	}

	/**
	 * Run the void setScheduleType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testSetScheduleType_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setScheduleType("");
		fixture.setName("");
		String scheduleType = "";

		fixture.setScheduleType(scheduleType);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		SystemDetailRequest fixture = new SystemDetailRequest();
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setScheduleType("");
		fixture.setName("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("SystemDetail [scheduleType=, name=, category=, paymentType=]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:29 PM
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
	 * @generatedBy CodePro at 5/28/18 12:29 PM
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
	 * @generatedBy CodePro at 5/28/18 12:29 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SystemDetailRequestTest.class);
	}
}