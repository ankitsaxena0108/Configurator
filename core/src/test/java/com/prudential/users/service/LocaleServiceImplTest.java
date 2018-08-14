package com.prudential.users.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.common.locale.Locale;
import com.prudential.core.common.locale.LocaleService;

/**
 * The class <code>LocaleServiceImplTest</code> contains tests for the class <code>{@link LocaleServiceImpl}</code>.
 *
 * @generatedBy CodePro at 4/4/18 2:45 PM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
public class LocaleServiceImplTest {
	
	@Autowired
	private LocaleService localeService;
	
	/**
	 * Run the LocaleServiceImpl() constructor test.
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testLocaleServiceImpl_1()
		throws Exception {
		LocaleServiceImpl result = new LocaleServiceImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Locale currentLocale() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	@Test
	public void testCurrentLocale_1()
		throws Exception {

		Locale result = localeService.currentLocale();
		assertEquals("US",result.getCountry());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/4/18 2:45 PM
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
	 * @generatedBy CodePro at 4/4/18 2:45 PM
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
	 * @generatedBy CodePro at 4/4/18 2:45 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(LocaleServiceImplTest.class);
	}
}