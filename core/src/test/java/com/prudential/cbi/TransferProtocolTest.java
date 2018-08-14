package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.TransferProtocol;

/**
 * The class <code>TransferProtocolTest</code> contains tests for the class <code>{@link TransferProtocol}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:32 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class TransferProtocolTest {
	/**
	 * Run the String getFilelocation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testGetFilelocation_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("D");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");

		String result = fixture.getFilelocation();

		// add additional test code here
		assertEquals("D", result);
	}

	/**
	 * Run the String getPassword() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testGetPassword_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("123");
		fixture.setUserId("");

		String result = fixture.getPassword();

		// add additional test code here
		assertEquals("123", result);
	}

	/**
	 * Run the String getPortNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testGetPortNumber_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("8888");
		fixture.setPassword("");
		fixture.setUserId("");

		String result = fixture.getPortNumber();

		// add additional test code here
		assertEquals("8888", result);
	}

	/**
	 * Run the String getProtocolType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testGetProtocolType_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("http");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");

		String result = fixture.getProtocolType();

		// add additional test code here
		assertEquals("http", result);
	}

	/**
	 * Run the String getUserId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testGetUserId_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("1");

		String result = fixture.getUserId();

		// add additional test code here
		assertEquals("1", result);
	}

	/**
	 * Run the void setFilelocation(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testSetFilelocation_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");
		String filelocation = "";

		fixture.setFilelocation(filelocation);

		// add additional test code here
	}

	/**
	 * Run the void setPassword(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testSetPassword_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");
		String password = "";

		fixture.setPassword(password);

		// add additional test code here
	}

	/**
	 * Run the void setPortNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testSetPortNumber_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");
		String portNumber = "";

		fixture.setPortNumber(portNumber);

		// add additional test code here
	}

	/**
	 * Run the void setProtocolType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testSetProtocolType_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");
		String protocolType = "";

		fixture.setProtocolType(protocolType);

		// add additional test code here
	}

	/**
	 * Run the void setUserId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testSetUserId_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");
		String userId = "";

		fixture.setUserId(userId);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		TransferProtocol fixture = new TransferProtocol();
		fixture.setFilelocation("");
		fixture.setProtocolType("");
		fixture.setPortNumber("");
		fixture.setPassword("");
		fixture.setUserId("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [portNumber = , filelocation = , protocolType = , userId = , password = ]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
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
	 * @generatedBy CodePro at 5/28/18 12:32 PM
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
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TransferProtocolTest.class);
	}
}