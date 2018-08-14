package com.prudential.users.da;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.configurations.BankConfig;
import com.prudential.core.cbi.configurations.CommonBankingInterfaceConfig;
import com.prudential.core.cbi.sourcesystem.SourceSystemConfig;

/**
 * The class <code>CommonBankingInterfaceConfigTest</code> contains tests for the class <code>{@link CommonBankingInterfaceConfig}</code>.
 *
 * @generatedBy CodePro at 5/28/18 3:37 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class CommonBankingInterfaceConfigTest {
	/**
	 * Run the String getBankInwardRootFolder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetBankInwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("root");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());

		String result = fixture.getBankInwardRootFolder();

		// add additional test code here
		assertEquals("root", result);
	}

	/**
	 * Run the String getBankOutwardRootFolder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetBankOutwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("outward");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());

		String result = fixture.getBankOutwardRootFolder();

		// add additional test code here
		assertEquals("outward", result);
	}

	/**
	 * Run the String getBankResponseProcessingPollingInterval() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetBankResponseProcessingPollingInterval_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("bankresponse");
		fixture.setSourceSystems(new LinkedList());

		String result = fixture.getBankResponseProcessingPollingInterval();

		// add additional test code here
		assertEquals("bankresponse", result);
	}

	/**
	 * Run the List<BankConfig> getBanks() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetBanks_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());

		List<BankConfig> result = fixture.getBanks();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getSourceFeedProcessingPollingInterval() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetSourceFeedProcessingPollingInterval_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("SourceFeed");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());

		String result = fixture.getSourceFeedProcessingPollingInterval();

		// add additional test code here
		assertEquals("SourceFeed", result);
	}

	/**
	 * Run the String getSourceInwardRootFolder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetSourceInwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());

		String result = fixture.getSourceInwardRootFolder();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSourceOutwardRootFolder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetSourceOutwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());

		String result = fixture.getSourceOutwardRootFolder();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<SourceSystemConfig> getSourceSystems() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testGetSourceSystems_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());

		List<SourceSystemConfig> result = fixture.getSourceSystems();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void setBankInwardRootFolder(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetBankInwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		String bankInwardRootFolder = "";

		fixture.setBankInwardRootFolder(bankInwardRootFolder);

		// add additional test code here
	}

	/**
	 * Run the void setBankOutwardRootFolder(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetBankOutwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		String bankOutwardRootFolder = "";

		fixture.setBankOutwardRootFolder(bankOutwardRootFolder);

		// add additional test code here
	}

	/**
	 * Run the void setBankResponseProcessingPollingInterval(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetBankResponseProcessingPollingInterval_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		String bankResponseProcessingPollingInterval = "";

		fixture.setBankResponseProcessingPollingInterval(bankResponseProcessingPollingInterval);

		// add additional test code here
	}

	/**
	 * Run the void setBanks(List<BankConfig>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetBanks_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		List<BankConfig> banks = new LinkedList();

		fixture.setBanks(banks);

		// add additional test code here
	}

	/**
	 * Run the void setSourceFeedProcessingPollingInterval(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetSourceFeedProcessingPollingInterval_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		String sourceFeedProcessingPollingInterval = "";

		fixture.setSourceFeedProcessingPollingInterval(sourceFeedProcessingPollingInterval);

		// add additional test code here
	}

	/**
	 * Run the void setSourceInwardRootFolder(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetSourceInwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		String sourceInwardRootFolder = "";

		fixture.setSourceInwardRootFolder(sourceInwardRootFolder);

		// add additional test code here
	}

	/**
	 * Run the void setSourceOutwardRootFolder(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetSourceOutwardRootFolder_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		String sourceOutwardRootFolder = "";

		fixture.setSourceOutwardRootFolder(sourceOutwardRootFolder);

		// add additional test code here
	}

	/**
	 * Run the void setSourceSystems(List<SourceSystemConfig>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	@Test
	public void testSetSourceSystems_1()
		throws Exception {
		CommonBankingInterfaceConfig fixture = new CommonBankingInterfaceConfig();
		fixture.setBankInwardRootFolder("");
		fixture.setSourceOutwardRootFolder("");
		fixture.setBanks(new LinkedList());
		fixture.setSourceInwardRootFolder("");
		fixture.setSourceFeedProcessingPollingInterval("");
		fixture.setBankOutwardRootFolder("");
		fixture.setBankResponseProcessingPollingInterval("");
		fixture.setSourceSystems(new LinkedList());
		List<SourceSystemConfig> sourceSystems = new LinkedList();

		fixture.setSourceSystems(sourceSystems);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 3:37 PM
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
	 * @generatedBy CodePro at 5/28/18 3:37 PM
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
	 * @generatedBy CodePro at 5/28/18 3:37 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CommonBankingInterfaceConfigTest.class);
	}
}