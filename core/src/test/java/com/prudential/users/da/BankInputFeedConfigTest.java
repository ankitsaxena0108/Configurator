package com.prudential.users.da;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.configurations.BankInputFeedConfig;

/**
 * The class <code>BankInputFeedConfigTest</code> contains tests for the class <code>{@link BankInputFeedConfig}</code>.
 *
 * @generatedBy CodePro at 5/28/18 3:27 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class BankInputFeedConfigTest {
	/**
	 * Run the String getFilenamePattern() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:27 PM
	 */
	@Test
	public void testGetFilenamePattern_1()
		throws Exception {
		BankInputFeedConfig fixture = new BankInputFeedConfig();
		fixture.setFilenamePattern("txt");
		fixture.setLocationUri("");
		fixture.setParserConfig("");

		String result = fixture.getFilenamePattern();

		// add additional test code here
		assertEquals("txt", result);
	}

	/**
	 * Run the String getLocationUri() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:27 PM
	 */
	@Test
	public void testGetLocationUri_1()
		throws Exception {
		BankInputFeedConfig fixture = new BankInputFeedConfig();
		fixture.setFilenamePattern("");
		fixture.setLocationUri("www");
		fixture.setParserConfig("");

		String result = fixture.getLocationUri();

		// add additional test code here
		assertEquals("www", result);
	}

	/**
	 * Run the String getParserConfig() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:27 PM
	 */
	@Test
	public void testGetParserConfig_1()
		throws Exception {
		BankInputFeedConfig fixture = new BankInputFeedConfig();
		fixture.setFilenamePattern("");
		fixture.setLocationUri("");
		fixture.setParserConfig("ParserConfig");

		String result = fixture.getParserConfig();

		// add additional test code here
		assertEquals("ParserConfig", result);
	}

	/**
	 * Run the void setFilenamePattern(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:27 PM
	 */
	@Test
	public void testSetFilenamePattern_1()
		throws Exception {
		BankInputFeedConfig fixture = new BankInputFeedConfig();
		fixture.setFilenamePattern("");
		fixture.setLocationUri("");
		fixture.setParserConfig("");
		String filenamePattern = "";

		fixture.setFilenamePattern(filenamePattern);

		// add additional test code here
	}

	/**
	 * Run the void setLocationUri(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:27 PM
	 */
	@Test
	public void testSetLocationUri_1()
		throws Exception {
		BankInputFeedConfig fixture = new BankInputFeedConfig();
		fixture.setFilenamePattern("");
		fixture.setLocationUri("");
		fixture.setParserConfig("");
		String locationUri = "";

		fixture.setLocationUri(locationUri);

		// add additional test code here
	}

	/**
	 * Run the void setParserConfig(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:27 PM
	 */
	@Test
	public void testSetParserConfig_1()
		throws Exception {
		BankInputFeedConfig fixture = new BankInputFeedConfig();
		fixture.setFilenamePattern("");
		fixture.setLocationUri("");
		fixture.setParserConfig("");
		String parserConfig = "";

		fixture.setParserConfig(parserConfig);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 3:27 PM
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
	 * @generatedBy CodePro at 5/28/18 3:27 PM
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
	 * @generatedBy CodePro at 5/28/18 3:27 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BankInputFeedConfigTest.class);
	}
}