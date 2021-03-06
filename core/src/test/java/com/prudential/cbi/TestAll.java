package com.prudential.cbi;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 5/28/18 12:32 PM
 * @author mohit.kumar
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	DailyTest.class,
	OtherConfigTest.class,
	IncomingDetailsTest.class,
	ScheduleDetailsTest.class,
	WeekTest.class,
	MonthlyTest.class,
	HourlyTest.class,
	TransferProtocolTest.class,
	SystemInfoTest.class,
	DayTest.class,
	WeeklyTest.class,
	RecurrenceTypeTest.class,
	SystemDetailRequestTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 5/28/18 12:32 PM
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
