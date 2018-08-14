package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.sourcesystem.SourceInputFeedConfig;
import com.prudential.core.cbi.sourcesystem.SourceOutFeedConfig;
import com.prudential.core.cbi.sourcesystem.SourceSystemConfig;

/**
 * The class <code>SourceSystemConfigTest</code> contains tests for the class <code>{@link SourceSystemConfig}</code>.
 *
 * @generatedBy CodePro at 6/4/18 1:04 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class SourceSystemConfigTest {
	/**
	 * Run the Map<String, Object> getAdditionalAttributes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetAdditionalAttributes_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());

		Map<String, Object> result = fixture.getAdditionalAttributes();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getCategory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetCategory_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("category");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());

		String result = fixture.getCategory();

		// add additional test code here
		assertEquals("category", result);
	}

	/**
	 * Run the String getCronConfig() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetCronConfig_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("config");
		fixture.setAdditionalAttributes(new HashMap());

		String result = fixture.getCronConfig();

		// add additional test code here
		assertEquals("config", result);
	}

	/**
	 * Run the String getPaymentType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetPaymentType_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("debit");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());

		String result = fixture.getPaymentType();

		// add additional test code here
		assertEquals("debit", result);
	}

	/**
	 * Run the String getPollingInterval() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetPollingInterval_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("2");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());

		String result = fixture.getPollingInterval();

		// add additional test code here
		assertEquals("2", result);
	}

	/**
	 * Run the Map<String, SourceInputFeedConfig> getSourceInputFeedConfig() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetSourceInputFeedConfig_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());

		Map<String, SourceInputFeedConfig> result = fixture.getSourceInputFeedConfig();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, SourceOutFeedConfig> getSourceOutFeedConfig() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetSourceOutFeedConfig_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());

		Map<String, SourceOutFeedConfig> result = fixture.getSourceOutFeedConfig();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getSourceSystemName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testGetSourceSystemName_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("sc");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());

		String result = fixture.getSourceSystemName();

		// add additional test code here
		assertEquals("sc", result);
	}

	/**
	 * Run the void setAdditionalAttributes(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetAdditionalAttributes_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		Map<String, Object> additionalAttributes = new HashMap();

		fixture.setAdditionalAttributes(additionalAttributes);

		// add additional test code here
	}

	/**
	 * Run the void setCategory(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetCategory_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		String category = "";

		fixture.setCategory(category);

		// add additional test code here
	}

	/**
	 * Run the void setCronConfig(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetCronConfig_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		String cronConfig = "";

		fixture.setCronConfig(cronConfig);

		// add additional test code here
	}

	/**
	 * Run the void setPaymentType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetPaymentType_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		String paymentType = "";

		fixture.setPaymentType(paymentType);

		// add additional test code here
	}

	/**
	 * Run the void setPollingInterval(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetPollingInterval_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		String pollingInterval = "";

		fixture.setPollingInterval(pollingInterval);

		// add additional test code here
	}

	/**
	 * Run the void setSourceInputFeedConfig(Map<String,SourceInputFeedConfig>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetSourceInputFeedConfig_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		Map<String, SourceInputFeedConfig> sourceInputFeedConfig = new HashMap();

		fixture.setSourceInputFeedConfig(sourceInputFeedConfig);

		// add additional test code here
	}

	/**
	 * Run the void setSourceOutFeedConfig(Map<String,SourceOutFeedConfig>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetSourceOutFeedConfig_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		Map<String, SourceOutFeedConfig> sourceOutFeedConfig = new HashMap();

		fixture.setSourceOutFeedConfig(sourceOutFeedConfig);

		// add additional test code here
	}

	/**
	 * Run the void setSourceSystemName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	@Test
	public void testSetSourceSystemName_1()
		throws Exception {
		SourceSystemConfig fixture = new SourceSystemConfig();
		fixture.setSourceOutFeedConfig(new HashMap());
		fixture.setPollingInterval("");
		fixture.setPaymentType("");
		fixture.setSourceSystemName("");
		fixture.setSourceInputFeedConfig(new HashMap());
		fixture.setCategory("");
		fixture.setCronConfig("");
		fixture.setAdditionalAttributes(new HashMap());
		String sourceSystemName = "";

		fixture.setSourceSystemName(sourceSystemName);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 6/4/18 1:04 PM
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
	 * @generatedBy CodePro at 6/4/18 1:04 PM
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
	 * @generatedBy CodePro at 6/4/18 1:04 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SourceSystemConfigTest.class);
	}
}