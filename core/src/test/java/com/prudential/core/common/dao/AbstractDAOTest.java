package com.prudential.core.common.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.model.CBIConfig;

/**
 * The class <code>AbstractDAOTest</code> contains tests for the class <code>{@link AbstractDAO}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:36 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
public class AbstractDAOTest {
	/**
	 * Run the String extractClassName(Class<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:36 PM
	 */
	@Test
	public void testExtractClassName_1()
		throws Exception {
		AbstractDAO fixture = new AbstractDAO();
		fixture.em = null;
		Class<CBIConfig> entityClazz = CBIConfig.class;

		String result = fixture.extractClassName(entityClazz);

		// add additional test code here
		assertEquals("CBIConfig", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 2:36 PM
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
	 * @generatedBy CodePro at 4/4/18 2:36 PM
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
	 * @generatedBy CodePro at 4/4/18 2:36 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(AbstractDAOTest.class);
	}
}