package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.IncomingDetails;
import com.prudential.core.cbi.scheduleInfo.OtherConfig;
import com.prudential.core.cbi.scheduleInfo.OutgoingDetails;

/**
 * The class <code>OtherConfigTest</code> contains tests for the class <code>{@link OtherConfig}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:20 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class OtherConfigTest {
	/**
	 * Run the IncomingDetails getIncomingDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:20 PM
	 */
	@Test
	public void testGetIncomingDetails_1()
		throws Exception {
		OtherConfig fixture = new OtherConfig();
		fixture.setOutgoingDetails(new OutgoingDetails());
		fixture.setIncomingDetails(new IncomingDetails());

		IncomingDetails result = fixture.getIncomingDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IncomingDetails [responseType=null, decryptorProgrammingName=null, transferProtocol=null]", result.toString());
		assertEquals(null, result.getResponseType());
		assertEquals(null, result.getDecryptorProgrammingName());
		assertEquals(null, result.getTransferProtocol());
	}

	/**
	 * Run the OutgoingDetails getOutgoingDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:20 PM
	 */
	@Test
	public void testGetOutgoingDetails_1()
		throws Exception {
		OtherConfig fixture = new OtherConfig();
		fixture.setOutgoingDetails(new OutgoingDetails());
		fixture.setIncomingDetails(new IncomingDetails());

		OutgoingDetails result = fixture.getOutgoingDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals("OutgoingDetails [encryptorProgrammingName=null, transferProtocol=null]", result.toString());
		assertEquals(null, result.getEncryptorProgrammingName());
		assertEquals(null, result.getTransferProtocol());
	}

	/**
	 * Run the void setIncomingDetails(IncomingDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:20 PM
	 */
	@Test
	public void testSetIncomingDetails_1()
		throws Exception {
		OtherConfig fixture = new OtherConfig();
		fixture.setOutgoingDetails(new OutgoingDetails());
		fixture.setIncomingDetails(new IncomingDetails());
		IncomingDetails incomingDetails = new IncomingDetails();

		fixture.setIncomingDetails(incomingDetails);

		// add additional test code here
	}

	/**
	 * Run the void setOutgoingDetails(OutgoingDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:20 PM
	 */
	@Test
	public void testSetOutgoingDetails_1()
		throws Exception {
		OtherConfig fixture = new OtherConfig();
		fixture.setOutgoingDetails(new OutgoingDetails());
		fixture.setIncomingDetails(new IncomingDetails());
		OutgoingDetails outgoingDetails = new OutgoingDetails();

		fixture.setOutgoingDetails(outgoingDetails);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:20 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		OtherConfig fixture = new OtherConfig();
		fixture.setOutgoingDetails(new OutgoingDetails());
		fixture.setIncomingDetails(new IncomingDetails());

		String result = fixture.toString();

		// add additional test code here
		assertEquals("OtherConfig [incomingDetails=IncomingDetails [responseType=null, decryptorProgrammingName=null, transferProtocol=null], outgoingDetails=OutgoingDetails [encryptorProgrammingName=null, transferProtocol=null]]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:20 PM
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
	 * @generatedBy CodePro at 5/28/18 12:20 PM
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
	 * @generatedBy CodePro at 5/28/18 12:20 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(OtherConfigTest.class);
	}
}