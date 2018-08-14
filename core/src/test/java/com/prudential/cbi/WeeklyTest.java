package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prudential.core.cbi.scheduleInfo.Weekly;

/**
 * The class <code>WeeklyTest</code> contains tests for the class <code>{@link Weekly}</code>.
 *
 * @generatedBy CodePro at 5/28/18 12:16 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
public class WeeklyTest {
	/**
	 * Run the Weekly() constructor test.
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testWeekly_1()
		throws Exception {
		Weekly result = new Weekly();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Boolean getFri() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testGetFri_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		Boolean result = fixture.getFri();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getMon() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testGetMon_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		Boolean result = fixture.getMon();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getSat() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testGetSat_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		Boolean result = fixture.getSat();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getSun() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testGetSun_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		Boolean result = fixture.getSun();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getThu() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testGetThu_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		Boolean result = fixture.getThu();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getTue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testGetTue_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		Boolean result = fixture.getTue();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getWed() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testGetWed_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		Boolean result = fixture.getWed();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the void setFri(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testSetFri_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));
		Boolean fri = new Boolean(true);

		fixture.setFri(fri);

		// add additional test code here
	}

	/**
	 * Run the void setMon(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testSetMon_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));
		Boolean mon = new Boolean(true);

		fixture.setMon(mon);

		// add additional test code here
	}

	/**
	 * Run the void setSat(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testSetSat_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));
		Boolean sat = new Boolean(true);

		fixture.setSat(sat);

		// add additional test code here
	}

	/**
	 * Run the void setSun(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testSetSun_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));
		Boolean sun = new Boolean(true);

		fixture.setSun(sun);

		// add additional test code here
	}

	/**
	 * Run the void setThu(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testSetThu_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));
		Boolean thu = new Boolean(true);

		fixture.setThu(thu);

		// add additional test code here
	}

	/**
	 * Run the void setTue(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testSetTue_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));
		Boolean tue = new Boolean(true);

		fixture.setTue(tue);

		// add additional test code here
	}

	/**
	 * Run the void setWed(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testSetWed_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));
		Boolean wed = new Boolean(true);

		fixture.setWed(wed);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Weekly fixture = new Weekly();
		fixture.setWed(new Boolean(true));
		fixture.setSat(new Boolean(true));
		fixture.setThu(new Boolean(true));
		fixture.setTue(new Boolean(true));
		fixture.setMon(new Boolean(true));
		fixture.setSun(new Boolean(true));
		fixture.setFri(new Boolean(true));

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ClassPojo [sun = true]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/28/18 12:16 PM
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
	 * @generatedBy CodePro at 5/28/18 12:16 PM
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
	 * @generatedBy CodePro at 5/28/18 12:16 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WeeklyTest.class);
	}
}