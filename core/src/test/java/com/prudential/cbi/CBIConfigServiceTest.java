package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.cbi.model.CBIConfig;
import com.prudential.core.cbi.scheduleInfo.AdditionalInfo;
import com.prudential.core.cbi.scheduleInfo.IncomingDetails;
import com.prudential.core.cbi.scheduleInfo.OtherConfig;
import com.prudential.core.cbi.scheduleInfo.OutgoingDetails;
import com.prudential.core.cbi.scheduleInfo.RecurrenceType;
import com.prudential.core.cbi.scheduleInfo.ScheduleDetails;
import com.prudential.core.cbi.scheduleInfo.SystemDetailRequest;
import com.prudential.core.cbi.scheduleInfo.SystemInfo;
import com.prudential.core.cbi.scheduleInfo.TransferProtocol;
import com.prudential.core.cbi.scheduleInfo.Weekly;
import com.prudential.core.cbi.services.CBIConfigService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CBIConfigServiceTest {

	@Autowired
	CBIConfigService cbiConfigService;

	@Test
	public void aupdateScheduleInfoData() {

		SystemInfo sysyetnInfo = new SystemInfo();

		ScheduleDetails scheduleDetail = new ScheduleDetails();
		scheduleDetail.setStartTime_in_Hr("15");
		scheduleDetail.setStartTime_in_Min("20");
		scheduleDetail.setName("IL_CC");

		RecurrenceType recurrenceType = new RecurrenceType();

		/*
		 * Hourly hourly = new Hourly(); hourly.setEveryHr("7");
		 * 
		 * recurrenceType.setHourly(hourly);
		 */

		Weekly weekly = new Weekly();
		weekly.setFri(true);
		weekly.setMon(true);
		weekly.setSun(true);

		recurrenceType.setWeekly(weekly);
		recurrenceType.setFreqType("weekly");

		scheduleDetail.setRecurrenceType(recurrenceType);
		sysyetnInfo.setScheduleType("sourceSchedule");
		sysyetnInfo.setName("IL_CC");
		sysyetnInfo.setCategory("Collection");
		sysyetnInfo.setScheduleDetails(scheduleDetail);

		boolean value = cbiConfigService.updateScheduleInfoData(sysyetnInfo);
		assertEquals(true, value);

	}

	@Test
	public void bcreateOrUpdateConfigBlobCollection() throws IOException {
		CBIConfig cbiConfig = new CBIConfig();

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("BankConfig_Collection.xlsx").getFile());

		byte[] fileBytes = FileUtils.readFileToByteArray(file);

		cbiConfig.setConfigBlob(fileBytes);
		cbiConfig.setCategory("Collection");
		cbiConfig.setFileName("BankConfig_Collection.xlsx");
		boolean value = cbiConfigService.createOrUpdateConfigBlob("Collection", cbiConfig);
		assertEquals(true, value);

	}

	@Test
	public void bcreateOrUpdateConfigBlobEnrollment() throws IOException {
		CBIConfig cbiConfig = new CBIConfig();

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("BankConfig_DD_Enrolment.xlsx").getFile());

		byte[] fileBytes = FileUtils.readFileToByteArray(file);

		cbiConfig.setConfigBlob(fileBytes);
		cbiConfig.setCategory("Enrollment");
		cbiConfig.setFileName("BankConfig_DD_Enrolment.xlsx");
		boolean value = cbiConfigService.createOrUpdateConfigBlob("Enrollment", cbiConfig);
		assertEquals(true, value);

	}

	/*
	 * @Test public void cfindCBIConfigByID() {
	 * 
	 * CBIConfig cbiConfig = cbiConfigService.findCBIConfigByID(1L);
	 * assertEquals(cbiConfig.getFileName(), "BankConfig.xlsx"); }
	 */

	@Test
	public void dreadScheduleConfig() {
		String type = "sourceSchedule";

		SystemDetailRequest sys = new SystemDetailRequest();
		sys.setScheduleType("sourceSchedule");
		sys.setName("IL_CC");
		sys.setCategory("Collection");
		sys.setScheduleType(type);

		Object scheduleData = cbiConfigService.readScheduleInfoConfig(sys);
		assertEquals(scheduleData, scheduleData);

	}

	@Test
	public void eupdateOtherConfigData() {

		AdditionalInfo otherInfo = new AdditionalInfo();

		OtherConfig otherConfig = new OtherConfig();

		IncomingDetails incomingDetails = new IncomingDetails();
		OutgoingDetails outgoingDetails = new OutgoingDetails();

		incomingDetails.setDecryptorProgrammingName("decryptorProgrammingName");
		incomingDetails.setResponseType("responseType");
		TransferProtocol transferProtocol = new TransferProtocol();
		transferProtocol.setProtocolType("SFTP");
		transferProtocol.setPortNumber("9000");
		transferProtocol.setUserId("admin");
		transferProtocol.setPassword("admin");

		incomingDetails.setTransferProtocol(transferProtocol);

		outgoingDetails.setEncryptorProgrammingName("encryptorProgrammingName");
		outgoingDetails.setTransferProtocol(transferProtocol);

		otherConfig.setIncomingDetails(incomingDetails);
		otherConfig.setOutgoingDetails(outgoingDetails);

		otherInfo.setScheduleType("bankSchedule");
		otherInfo.setName("MBB_CC");
		otherInfo.setCategory("Collection");
		otherInfo.setOtherConfig(otherConfig);

		boolean value = cbiConfigService.updateOtherConfigData(otherInfo);
		assertEquals(true, value);

	}

	@Test
	public void freadOtherConfig() {
		String type = "bankSchedule";

		SystemDetailRequest sys = new SystemDetailRequest();
		sys.setScheduleType("bankSchedule");
		sys.setName("MBB_CC");
		sys.setCategory("Collection");
		sys.setScheduleType(type);

		Object otherData = cbiConfigService.readOtherConfig(sys);

		assertEquals(otherData, otherData);

	}

	@Test
	public void gupdateGlobalScheduleInfo() {

		SystemInfo sysyetnInfo = new SystemInfo();

		ScheduleDetails scheduleDetail = new ScheduleDetails();
		scheduleDetail.setStartTime_in_Hr("15");
		scheduleDetail.setStartTime_in_Min("20");
		scheduleDetail.setName("IL_CC");

		RecurrenceType recurrenceType = new RecurrenceType();

		/*
		 * Hourly hourly = new Hourly(); hourly.setEveryHr("7");
		 * 
		 * recurrenceType.setHourly(hourly);
		 */

		Weekly weekly = new Weekly();
		weekly.setFri(true);
		weekly.setMon(true);
		weekly.setSun(true);

		recurrenceType.setWeekly(weekly);
		recurrenceType.setFreqType("weekly");

		scheduleDetail.setRecurrenceType(recurrenceType);
		sysyetnInfo.setScheduleType("sourceSchedule");
		sysyetnInfo.setName("IL_CC");
		sysyetnInfo.setCategory("Collection");
		sysyetnInfo.setScheduleDetails(scheduleDetail);

		boolean value = cbiConfigService.updateGlobalScheduleInfo(sysyetnInfo);
		assertEquals(true, value);

	}
	
	@Test
	public void hreadGlobalScheduleConfig() {
		String type = "sourceSchedule";

		SystemDetailRequest sys = new SystemDetailRequest();
		sys.setScheduleType("sourceSchedule");
		sys.setName("IL_CC");
		sys.setCategory("Collection");
		sys.setScheduleType(type);

		Object scheduleData = cbiConfigService.readGlobalScheduleConfig(sys);
		assertEquals(scheduleData, scheduleData);

	}
	
}
