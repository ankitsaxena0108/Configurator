package com.prudential.cbi;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.web.paging.SearchRq;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
public class FileAuditControllerTest {

	@Autowired
	FileAuditDAO fileAuditDAO;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	@WithMockUser("superit")
	public void testWithAllParameters() throws Exception {
		SearchRq searchRq = new SearchRq();
		searchRq.setPage(1);
		Map<String, Object> params = new HashMap<>();
		params.put("name", "system1");
		params.put("category", "Collections");
		params.put("fileDirection", "Inward");
		params.put("status", "Completed");
		params.put("paymentType", "Credit");
		/*params.put("fromDate", "15/03/2018");
		params.put("toDate", "30/03/2018");*/
		searchRq.setParams(params);
		
		PageRequest pageRequest = new PageRequest(searchRq.getPage(), searchRq.getSize());
		Long count = fileAuditDAO.searchFileAudit(params, pageRequest).getTotalElements();

		/*
		 * MvcResult result =this.mockMvc.perform(
		 * MockMvcRequestBuilders.post("/billingsystem/auditsearch")
		 * .contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(
		 * searchRq)) .accept(MediaType.APPLICATION_JSON))
		 * .andExpect(status().isOk()).andReturn(); String content =
		 * result.getResponse().getContentAsString();
		 */
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/billingsystem/auditsearch")
						.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(searchRq))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.totalElements").value(count));

	}

	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}
}