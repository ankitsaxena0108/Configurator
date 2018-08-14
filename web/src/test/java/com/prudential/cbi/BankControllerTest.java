 package com.prudential.cbi;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.cbi.scheduleInfo.AdditionalInfo;
import com.prudential.core.cbi.scheduleInfo.Daily;
import com.prudential.core.cbi.scheduleInfo.Hourly;
import com.prudential.core.cbi.scheduleInfo.IncomingDetails;
import com.prudential.core.cbi.scheduleInfo.Monthly;
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
public class BankControllerTest {

	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Autowired
	CBIConfigService cbiConfigService;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	/*@Test
	public void asaveBankScheduleInfo() throws Exception {
		
		String type="bankSchedule";
		ScheduleDetails scheduleDetail = new ScheduleDetails();
		RecurrenceType recurrenceType = new RecurrenceType();
		Weekly weekly = new Weekly();
		// String [] ster = {"MON","TUE"};
		weekly.setMon(true);
		Monthly monthly = new Monthly();
		monthly.setMonthlyFreType("DEC");
		Hourly hourly = new Hourly();
		hourly.setEveryHr("11:00AM");
		Daily daily = new Daily();
		daily.setDaily("Thus");
		recurrenceType.setDaily(daily);
		recurrenceType.setHourly(hourly);
		recurrenceType.setMonthly(monthly);
		recurrenceType.setWeekly(weekly);
		recurrenceType.setFreqType("XXXX");
		// scheduleDetail.setFreqType("abcd");
		scheduleDetail.setRecurrenceType(recurrenceType);
		scheduleDetail.setStartTime_in_Hr("12:10:01");
		scheduleDetail.setStartTime_in_Min("15:20");
		scheduleDetail.setName(type);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveBankScheduleInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(scheduleDetail))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}*/

	@Test
	public void asaveBankScheduleInfo() throws Exception {
		

		SystemInfo sysyetnInfo = new SystemInfo();
	
		ScheduleDetails scheduleDetail =new ScheduleDetails();
		scheduleDetail.setStartTime_in_Hr("15");
		scheduleDetail.setStartTime_in_Min("20");
		scheduleDetail.setName("IIL_c");
		
	
		RecurrenceType recurrenceType = new RecurrenceType();
		
	/*	Hourly hourly = new Hourly();
		hourly.setEveryHr("7");
	
		recurrenceType.setHourly(hourly);*/
		
		Weekly weekly =new Weekly();
		weekly.setFri(true);
		weekly.setMon(true);
		weekly.setSun(true);
	
		recurrenceType.setWeekly(weekly);
		recurrenceType.setFreqType("weekly");
				
		
		scheduleDetail.setRecurrenceType(recurrenceType);
		sysyetnInfo.setScheduleType("bankSchedule");
		sysyetnInfo.setName("MBB_CC");
		sysyetnInfo.setCategory("Collection");
		
		sysyetnInfo.setScheduleDetails(scheduleDetail);
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveBankScheduleInfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sysyetnInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser("superit")
	public void bgetBankSchedule() throws Exception {
	
		
String type = "bankSchedule";
        
		SystemDetailRequest sys =new SystemDetailRequest();
		sys.setScheduleType("bankSchedule");
		sys.setName("MBB_CC");
		sys.setCategory("Collection");
		sys.setScheduleType(type);
		
	/*	this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getBankSchedule")
				.contentType(MediaType.APPLICATION_JSON).content(type)
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.startTime_in_Hr").value("12:10:01"))
		.andExpect(jsonPath("$.startTime_in_Min").value("15:20"));*/
		
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getBankSchedule")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sys))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	@Test
	public void csaveBankOtherInfo() throws Exception {
		
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
		
		otherInfo.setScheduleType("bankSchedule");
		otherInfo.setName("MBB_CC");
		otherInfo.setCategory("Collection");
		
		otherInfo.setOtherConfig(otherConfig);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveBankOtherInf")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(otherInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser("superit")
	public void dgetBankOtherInfo()  throws Exception {
		
        String type = "bankSchedule";
        
		SystemDetailRequest sys =new SystemDetailRequest();
		sys.setScheduleType("bankSchedule");
		sys.setName("MBB_CC");
		sys.setCategory("Collection");
		
		sys.setScheduleType(type);	
		
			
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getBankOtherInfo")
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
