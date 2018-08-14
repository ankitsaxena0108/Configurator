package com.prudential.users.da;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.configurations.BankConfig;

/**
 * The class <code>BankConfigTest</code> contains tests for the class <code>{@link BankConfig}</code>.
 *
 * @generatedBy CodePro at 5/28/18 3:19 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class BankConfigTest {
	/**
	 * Run the String getBankCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testGetBankCode_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("");
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setBankCode("MB_CC");

		String result = fixture.getBankCode();

		// add additional test code here
		assertEquals("MB_CC", result);
	}

	/**
	 * Run the String getCategory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testGetCategory_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("");
		fixture.setPaymentType("");
		fixture.setCategory("collection");
		fixture.setBankCode("");

		String result = fixture.getCategory();

		// add additional test code here
		assertEquals("collection", result);
	}

	/**
	 * Run the String getCronConfig() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testGetCronConfig_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("config");
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setBankCode("");

		String result = fixture.getCronConfig();

		// add additional test code here
		assertEquals("config", result);
	}

	/**
	 * Run the String getPaymentType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testGetPaymentType_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("");
		fixture.setPaymentType("debit");
		fixture.setCategory("");
		fixture.setBankCode("");

		String result = fixture.getPaymentType();

		// add additional test code here
		assertEquals("debit", result);
	}

	/**
	 * Run the void setBankCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testSetBankCode_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("");
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setBankCode("");
		String bankCode = "";

		fixture.setBankCode(bankCode);

		// add additional test code here
	}

	/**
	 * Run the void setCategory(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testSetCategory_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("");
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setBankCode("");
		String category = "";

		fixture.setCategory(category);

		// add additional test code here
	}

	/**
	 * Run the void setCronConfig(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testSetCronConfig_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("");
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setBankCode("");
		String cronConfig = "";

		fixture.setCronConfig(cronConfig);

		// add additional test code here
	}

	/**
	 * Run the void setPaymentType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	@Test
	public void testSetPaymentType_1()
		throws Exception {
		BankConfig fixture = new BankConfig();
		fixture.setCronConfig("");
		fixture.setPaymentType("");
		fixture.setCategory("");
		fixture.setBankCode("");
		String paymentType = "";

		fixture.setPaymentType(paymentType);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 3:19 PM
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
	 * @generatedBy CodePro at 5/28/18 3:19 PM
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
	 * @generatedBy CodePro at 5/28/18 3:19 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BankConfigTest.class);
	}
}