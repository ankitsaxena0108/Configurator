package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.IncomingDetails;
import com.prudential.core.cbi.scheduleInfo.TransferProtocol;

/**
 * The class <code>IncomingDetailsTest</code> contains tests for the class <code>{@link IncomingDetails}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:06 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class IncomingDetailsTest {
	/**
	 * Run the String getDecryptorProgrammingName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	@Test
	public void testGetDecryptorProgrammingName_1()
		throws Exception {
		IncomingDetails fixture = new IncomingDetails();
		fixture.setTransferProtocol(new TransferProtocol());
		fixture.setResponseType("");
		fixture.setDecryptorProgrammingName("DecryptorProgrammingName");

		String result = fixture.getDecryptorProgrammingName();

		// add additional test code here
		assertEquals("DecryptorProgrammingName", result);
	}

	/**
	 * Run the String getResponseType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	@Test
	public void testGetResponseType_1()
		throws Exception {
		IncomingDetails fixture = new IncomingDetails();
		fixture.setTransferProtocol(new TransferProtocol());
		fixture.setResponseType("true");
		fixture.setDecryptorProgrammingName("");

		String result = fixture.getResponseType();

		// add additional test code here
		assertEquals("true", result);
	}

	/**
	 * Run the TransferProtocol getTransferProtocol() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	@Test
	public void testGetTransferProtocol_1()
		throws Exception {
		IncomingDetails fixture = new IncomingDetails();
		fixture.setTransferProtocol(new TransferProtocol());
		fixture.setResponseType("");
		fixture.setDecryptorProgrammingName("");

		TransferProtocol result = fixture.getTransferProtocol();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ClassPojo [portNumber = null, filelocation = null, protocolType = null, userId = null, password = null]", result.toString());
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getUserId());
		assertEquals(null, result.getPortNumber());
		assertEquals(null, result.getFilelocation());
		assertEquals(null, result.getProtocolType());
	}

	/**
	 * Run the void setDecryptorProgrammingName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	@Test
	public void testSetDecryptorProgrammingName_1()
		throws Exception {
		IncomingDetails fixture = new IncomingDetails();
		fixture.setTransferProtocol(new TransferProtocol());
		fixture.setResponseType("");
		fixture.setDecryptorProgrammingName("");
		String decryptorProgrammingName = "";

		fixture.setDecryptorProgrammingName(decryptorProgrammingName);

		// add additional test code here
	}

	/**
	 * Run the void setResponseType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	@Test
	public void testSetResponseType_1()
		throws Exception {
		IncomingDetails fixture = new IncomingDetails();
		fixture.setTransferProtocol(new TransferProtocol());
		fixture.setResponseType("");
		fixture.setDecryptorProgrammingName("");
		String responseType = "";

		fixture.setResponseType(responseType);

		// add additional test code here
	}

	/**
	 * Run the void setTransferProtocol(TransferProtocol) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	@Test
	public void testSetTransferProtocol_1()
		throws Exception {
		IncomingDetails fixture = new IncomingDetails();
		fixture.setTransferProtocol(new TransferProtocol());
		fixture.setResponseType("");
		fixture.setDecryptorProgrammingName("");
		TransferProtocol transferProtocol = new TransferProtocol();

		fixture.setTransferProtocol(transferProtocol);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		IncomingDetails fixture = new IncomingDetails();
		fixture.setTransferProtocol(new TransferProtocol());
		fixture.setResponseType("");
		fixture.setDecryptorProgrammingName("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("IncomingDetails [responseType=, decryptorProgrammingName=, transferProtocol=ClassPojo [portNumber = null, filelocation = null, protocolType = null, userId = null, password = null]]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:06 PM
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
	 * @generatedBy CodePro at 5/28/18 12:06 PM
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
	 * @generatedBy CodePro at 5/28/18 12:06 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(IncomingDetailsTest.class);
	}
}