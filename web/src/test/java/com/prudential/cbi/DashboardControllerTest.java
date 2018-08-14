package com.prudential.cbi;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
@WebAppConfiguration
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DashboardControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Autowired
	CBIConfigService cbiConfigService;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void asaveInputFeedScheduleInfo() throws Exception {

		SystemInfo sysyetnInfo = new SystemInfo();

		ScheduleDetails scheduleDetail = new ScheduleDetails();
		scheduleDetail.setStartTime_in_Hr("15");
		scheduleDetail.setStartTime_in_Min("20");
		scheduleDetail.setName("IIL_c");

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
		sysyetnInfo.setScheduleType("inputFeedSchedule");
		sysyetnInfo.setName("inputFeedSchedule");
		sysyetnInfo.setCategory("Collection");
		
		sysyetnInfo.setScheduleDetails(scheduleDetail);

		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveInputFeedScheduleInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sysyetnInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	@WithMockUser("superit")
	public void bgetInputFeedScheduleInfo() throws Exception {

		String type = "inputFeedSchedule";

		SystemDetailRequest sys = new SystemDetailRequest();
		sys.setScheduleType("inputFeedSchedule");
		sys.setName("inputFeedSchedule");
		sys.setCategory("Collection");
		sys.setScheduleType(type);

		/*
		 * this.mockMvc .perform(MockMvcRequestBuilders.post(
		 * "/billingsystem/getInputFeedScheduleInfo")
		 * .contentType(MediaType.APPLICATION_JSON).content(type)
		 * .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		 * .andExpect(status().isOk()).andExpect(content().contentType(
		 * "application/json;charset=UTF-8"))
		 * .andExpect(jsonPath("$.startTime_in_Hr").value("12:10:01"))
		 * .andExpect(jsonPath("$.startTime_in_Min").value("15:20"));
		 */

		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getInputFeedScheduleInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sys))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	public void csaveBankFeedScheduleInfo() throws Exception {

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
		sysyetnInfo.setScheduleType("bankFeedSchedule");
		sysyetnInfo.setName("bankFeedSchedule");
		sysyetnInfo.setCategory("Collection");
		sysyetnInfo.setScheduleDetails(scheduleDetail);

		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveBankFeedScheduleInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sysyetnInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	@WithMockUser("superit")
	public void dgetBankFeedScheduleInfo() throws Exception {
		String type = "bankFeedSchedule";

		SystemDetailRequest sys = new SystemDetailRequest();
		sys.setScheduleType("bankFeedSchedule");
		sys.setName("bankFeedSchedule");
		sys.setCategory("Collection");
		sys.setScheduleType(type);

		/*
		 * this.mockMvc .perform(MockMvcRequestBuilders.post(
		 * "/billingsystem/getBankFeedScheduleInfo")
		 * .contentType(MediaType.APPLICATION_JSON).content(type)
		 * .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		 * .andExpect(status().isOk()).andExpect(content().contentType(
		 * "application/json;charset=UTF-8"))
		 * .andExpect(jsonPath("$.startTime_in_Hr").value("12:10:01"))
		 * .andExpect(jsonPath("$.startTime_in_Min").value("15:20"));
		 */

		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getBankFeedScheduleInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sys))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	@WithMockUser("superit")
	public void fdownloadFile() throws Exception {
		CBIConfig cfg = new CBIConfig();
		cfg.setFileName("xyz");
		//long id = 1L;
		String category = "Collection";
		CBIConfigService mock = org.mockito.Mockito.mock(CBIConfigService.class);
		when(mock.findCBIConfigByCategory("Collection")).thenReturn(cfg);

		this.mockMvc.perform(get("/billingsystem/fileDownload/collections").contentType(MediaType.APPLICATION_JSON)
				.content(convertObjectToJsonBytes(category))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	@WithMockUser("superit")
	public void guploadFile() throws Exception {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("BankConfig_Collection.xlsx").getFile());

		byte[] fileBytes = FileUtils.readFileToByteArray(file);

		MockMultipartFile firstFile = new MockMultipartFile("file", "BankConfig_Collection.xlsx",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", fileBytes);

		String category = "Collection";
		Gson gson = new Gson();
		String json = gson.toJson(category);

		this.mockMvc.perform(
				MockMvcRequestBuilders.multipart("/billingsystem/uploadFile").file(firstFile).param("category", json))
				.andExpect(status().isOk());

	}
	
	
	
	@Test
	public void hsaveInputFeedOtherInfo() throws Exception {
		
		AdditionalInfo otherInfo = new AdditionalInfo();
		
		OtherConfig otherConfig  =new OtherConfig();
		
		IncomingDetails incomingDetails =new IncomingDetails();
		OutgoingDetails outgoingDetails =new  OutgoingDetails();
		
		incomingDetails.setDecryptorProgrammingName("decryptorProgrammingName");
		incomingDetails.setResponseType("responseType");
		TransferProtocol transferProtocol = new TransferProtocol();
		transferProtocol.setProtocolType("SFTP");
		transferProtocol.setPortNumber("9000");
		transferProtocol.setUserId("admin");
		transferProtocol.setPassword("admin");
		incomingDetails.setTransferProtocol(transferProtocol);
	
		outgoingDetails.setEncryptorProgrammingName("encryptorProgrammingNameing");
		TransferProtocol transferProtocol1 = new TransferProtocol();
		transferProtocol.setProtocolType("SFTP");
		transferProtocol.setPortNumber("9000");
		transferProtocol.setUserId("admin");
		transferProtocol.setPassword("admin");
		outgoingDetails.setTransferProtocol(transferProtocol1);
				
		otherConfig.setIncomingDetails(incomingDetails);
		otherConfig.setOutgoingDetails(outgoingDetails);
		
		otherInfo.setScheduleType("inputFeedSchedule");
		otherInfo.setName("inputFeedSchedule");
		otherInfo.setCategory("Collection");
	
		otherInfo.setOtherConfig(otherConfig);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveInputFeedOtherInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(otherInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser("superit")
	public void igetInputFeedOtherInfo()  throws Exception {
		
        String type = "inputFeedSchedule";
        
		SystemDetailRequest sys =new SystemDetailRequest();
		sys.setScheduleType("inputFeedSchedule");
		sys.setName("inputFeedSchedule");
		sys.setCategory("Collection");
		
		sys.setScheduleType(type);	
		
			
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getInputFeedOtherInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sys))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void jsaveBankFeedOtherInfo() throws Exception {
		
		AdditionalInfo otherInfo = new AdditionalInfo();
		
		OtherConfig otherConfig  =new OtherConfig();
		
		IncomingDetails incomingDetails =new IncomingDetails();
		OutgoingDetails outgoingDetails =new  OutgoingDetails();
		
		incomingDetails.setDecryptorProgrammingName("decryptorProgrammingName");
		incomingDetails.setResponseType("responseType");
		TransferProtocol transferProtocol = new TransferProtocol();
		transferProtocol.setProtocolType("SFTP");
		transferProtocol.setPortNumber("9000");
		transferProtocol.setUserId("admin");
		transferProtocol.setPassword("admin");
		incomingDetails.setTransferProtocol(transferProtocol);
	
		outgoingDetails.setEncryptorProgrammingName("encryptorProgrammingNameing");
		TransferProtocol transferProtocol1 = new TransferProtocol();
		transferProtocol.setProtocolType("SFTP");
		transferProtocol.setPortNumber("9000");
		transferProtocol.setUserId("admin");
		transferProtocol.setPassword("admin");
		outgoingDetails.setTransferProtocol(transferProtocol1);
				
		otherConfig.setIncomingDetails(incomingDetails);
		otherConfig.setOutgoingDetails(outgoingDetails);
		
		otherInfo.setScheduleType("BankFeedSchedule");
		otherInfo.setName("BankFeedSchedule");
		otherInfo.setCategory("Collection");
		otherInfo.setOtherConfig(otherConfig);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveBankFeedOtherInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(otherInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser("superit")
	public void kgetBankFeedOtherInfo()  throws Exception {
		
        String type = "BankFeedSchedule";
        
		SystemDetailRequest sys =new SystemDetailRequest();
		sys.setScheduleType("BankFeedSchedule");
		sys.setName("BankFeedSchedule");
		sys.setCategory("Collection");
		
		sys.setScheduleType(type);	
		
			
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getBankFeedOtherInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sys))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

	public static String createStringWithLength(int length) {
		StringBuilder builder = new StringBuilder();

		for (int index = 0; index < length; index++) {
			builder.append("a");
		}

		return builder.toString();
	}
}
