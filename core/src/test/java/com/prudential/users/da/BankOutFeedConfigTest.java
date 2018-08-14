package com.prudential.users.da;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.configurations.BankOutFeedConfig;

/**
 * The class <code>BankOutFeedConfigTest</code> contains tests for the class <code>{@link BankOutFeedConfig}</code>.
 *
 * @generatedBy CodePro at 5/28/18 3:29 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class BankOutFeedConfigTest {
	/**
	 * Run the String getFileFooterTemplate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testGetFileFooterTemplate_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("abc");
		fixture.setFileHeaderTemplate("");

		String result = fixture.getFileFooterTemplate();

		// add additional test code here
		assertEquals("abc", result);
	}

	/**
	 * Run the String getFileHeaderTemplate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testGetFileHeaderTemplate_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("headerTemplate");

		String result = fixture.getFileHeaderTemplate();

		// add additional test code here
		assertEquals("headerTemplate", result);
	}

	/**
	 * Run the String getFileNamePattern() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testGetFileNamePattern_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("txt");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");

		String result = fixture.getFileNamePattern();

		// add additional test code here
		assertEquals("txt", result);
	}

	/**
	 * Run the String getFileTemplate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testGetFileTemplate_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("filetemplate");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");

		String result = fixture.getFileTemplate();

		// add additional test code here
		assertEquals("filetemplate", result);
	}

	/**
	 * Run the String getFilterCondition() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testGetFilterCondition_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("filter");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");

		String result = fixture.getFilterCondition();

		// add additional test code here
		assertEquals("filter", result);
	}

	/**
	 * Run the String getLocationUri() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testGetLocationUri_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("D");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");

		String result = fixture.getLocationUri();

		// add additional test code here
		assertEquals("D", result);
	}

	/**
	 * Run the void setFileFooterTemplate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testSetFileFooterTemplate_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");
		String fileFooterTemplate = "";

		fixture.setFileFooterTemplate(fileFooterTemplate);

		// add additional test code here
	}

	/**
	 * Run the void setFileHeaderTemplate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testSetFileHeaderTemplate_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");
		String fileHeaderTemplate = "";

		fixture.setFileHeaderTemplate(fileHeaderTemplate);

		// add additional test code here
	}

	/**
	 * Run the void setFileNamePattern(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testSetFileNamePattern_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");
		String fileNamePattern = "";

		fixture.setFileNamePattern(fileNamePattern);

		// add additional test code here
	}

	/**
	 * Run the void setFileTemplate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testSetFileTemplate_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");
		String fileTemplate = "";

		fixture.setFileTemplate(fileTemplate);

		// add additional test code here
	}

	/**
	 * Run the void setFilterCondition(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testSetFilterCondition_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");
		String filterCondition = "";

		fixture.setFilterCondition(filterCondition);

		// add additional test code here
	}

	/**
	 * Run the void setLocationUri(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	@Test
	public void testSetLocationUri_1()
		throws Exception {
		BankOutFeedConfig fixture = new BankOutFeedConfig();
		fixture.setFilterCondition("");
		fixture.setFileNamePattern("");
		fixture.setLocationUri("");
		fixture.setFileTemplate("");
		fixture.setFileFooterTemplate("");
		fixture.setFileHeaderTemplate("");
		String locationUri = "";

		fixture.setLocationUri(locationUri);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 3:29 PM
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
	 * @generatedBy CodePro at 5/28/18 3:29 PM
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
	 * @generatedBy CodePro at 5/28/18 3:29 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BankOutFeedConfigTest.class);
	}
}