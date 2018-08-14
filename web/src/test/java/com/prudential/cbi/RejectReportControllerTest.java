package com.prudential.cbi;

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
import org.springframework.data.domain.PageRequest;
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
import com.prudential.core.common.dao.BankTxnRecordDAO;
import com.prudential.web.paging.SearchRq;
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RejectReportControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Autowired
    BankTxnRecordDAO bankTxnRecord;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	@WithMockUser("superit")
	public void getRejectReportDetals() throws Exception {
		
		
		SearchRq searchRq =new SearchRq();
		
		Map<String, Object> params = new HashMap<>();
		params.put("bankCode", "MBB_CC");
		params.put("fromPolicyNo", "99999900");
		params.put("toPolicyNo", "99999980");
		params.put("fromDate", "2018-05-06T00:00:00.000Z");
		params.put("toDate", "2018-05-10T00:00:00.000Z");
		
		searchRq.setParams(params);
		
		
		PageRequest pageRequest = new PageRequest(searchRq.getPage(), searchRq.getSize());
		Long count = bankTxnRecord.reconRejectReport(params, pageRequest).getTotalElements();
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/billingsystem/rejectReportSearch")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjectToJsonBytes(searchRq))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.totalElements").value(count));
		
		
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
