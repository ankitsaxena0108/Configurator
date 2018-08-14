package com.prudential.cbi;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

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
import com.prudential.core.cbi.scheduleInfo.Hourly;
import com.prudential.core.cbi.scheduleInfo.IncomingDetails;
import com.prudential.core.cbi.scheduleInfo.OtherConfig;
import com.prudential.core.cbi.scheduleInfo.OutgoingDetails;
import com.prudential.core.cbi.scheduleInfo.RecurrenceType;
import com.prudential.core.cbi.scheduleInfo.ScheduleDetails;
import com.prudential.core.cbi.scheduleInfo.SystemDetailRequest;
import com.prudential.core.cbi.scheduleInfo.SystemInfo;
import com.prudential.core.cbi.scheduleInfo.TransferProtocol;
import com.prudential.core.cbi.services.CBIConfigService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SourceSystemControllerTest {

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
	public void asaveScheduleInfo() throws Exception {
		
		SystemInfo sysyetnInfo = new SystemInfo();
		
		ScheduleDetails scheduleDetail =new ScheduleDetails();
		scheduleDetail.setStartTime_in_Hr("15");
		scheduleDetail.setStartTime_in_Min("20");
		scheduleDetail.setName("IL_CC");
		

		RecurrenceType recurrenceType = new RecurrenceType();
		
		Hourly hourly = new Hourly();
		hourly.setEveryHr("7");

		recurrenceType.setHourly(hourly);
		
	
		recurrenceType.setFreqType("hourly");
				
		
		scheduleDetail.setRecurrenceType(recurrenceType);
		sysyetnInfo.setScheduleType("sourceSchedule");
		sysyetnInfo.setName("IL_CC");
		sysyetnInfo.setCategory("Collection");
		sysyetnInfo.setScheduleDetails(scheduleDetail);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/savescheduleinfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sysyetnInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	
	@Test
	@WithMockUser("superit")
	public void bgetSourceSystemScheduleInfo() throws Exception {
		
        String type = "sourceSchedule";
        
		SystemDetailRequest sys =new SystemDetailRequest();
		sys.setScheduleType("sourceSchedule");
		sys.setName("IL_CC");
		sys.setCategory("Collection");
		sys.setScheduleType(type);	
		
		/*this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getSourceSystemSchedule")
				.contentType(MediaType.APPLICATION_JSON).content(type)
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.startTime_in_Hr").value("12:10:01"))
		.andExpect(jsonPath("$.startTime_in_Min").value("15:21"));*/
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getSourceSystemSchedule")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(sys))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	@Test
	public void csaveSourceSystemOtherInfo() throws Exception {
		
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
	
		outgoingDetails.setEncryptorProgrammingName("encryptorProgrammingName");
		TransferProtocol transferProtocol1 = new TransferProtocol();
		transferProtocol.setProtocolType("SFTP");
		transferProtocol.setPortNumber("9000");
		transferProtocol.setUserId("admin");
		transferProtocol.setPassword("admin");
		outgoingDetails.setTransferProtocol(transferProtocol1);
				
		otherConfig.setIncomingDetails(incomingDetails);
		otherConfig.setOutgoingDetails(outgoingDetails);
		
		otherInfo.setScheduleType("sourceSchedule");
		otherInfo.setName("IL_CC");
		otherInfo.setCategory("Collection");
		
		otherInfo.setOtherConfig(otherConfig);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/saveSourceSystemOtherinfo")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(otherInfo))
				// .content(convertObjectToJsonBytes(type))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser("superit")
	public void dgetSourceSystemOtherInfo()  throws Exception {
		
        String type = "sourceSchedule";
        
		SystemDetailRequest sys =new SystemDetailRequest();
		sys.setScheduleType("sourceSchedule");
		sys.setName("IL_CC");
		sys.setCategory("Collection");
	
		sys.setScheduleType(type);	
		
			
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/getSourceSystemOtherInfo")
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
