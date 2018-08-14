package com.prudential.web.controller.cbi;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.prudential.core.cbi.model.CBIConfig;
import com.prudential.core.cbi.scheduleInfo.AdditionalInfo;
import com.prudential.core.cbi.scheduleInfo.SystemDetailRequest;
import com.prudential.core.cbi.scheduleInfo.SystemInfo;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.cbi.services.rs.CBIConfigRs;
import com.prudential.core.common.CBIException;
import com.prudential.core.common.ErrorCode;
import com.prudential.core.common.configuration.camelconfiguration.CBICamelConfiguration;
import com.prudential.core.common.configuration.excel.ValidationException;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfigurator;

@RestController
@RequestMapping("/billingsystem")
public class DashboardController {

	@Autowired
	CBIConfigService cbiConfigService;
	@Autowired
	CBICamelConfiguration cbiCamelConfiguration;
	
	String scheduleType;

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "category") String categoryJson)
			throws ValidationException, CBIException {

		logger.debug("Upload file entered");
		BankFeedConfigurator configurator = null;
		byte[] fileBytes = null;

		try {
			configurator = BankFeedConfigurator.from(file.getInputStream());
			fileBytes = file.getBytes();
		} catch (IOException ie) {
			throw new CBIException(ErrorCode.CORE_1002, file.getOriginalFilename());
		} catch (ValidationException ve) {

			throw new CBIException(ve.getMessages());
		}
		ObjectMapper mapper = new ObjectMapper();
		String category="";
		try {
			category = mapper.readValue(categoryJson, String.class);
		} catch (JsonParseException e) {
			throw new CBIException(ErrorCode.CORE_1002, file.getOriginalFilename());
		} catch (JsonMappingException e) {
			throw new CBIException(ErrorCode.CORE_1002, file.getOriginalFilename());
		} catch (IOException e) {
			throw new CBIException(ErrorCode.CORE_1002, file.getOriginalFilename());
		}
		CBIConfig cbiConfig = new CBIConfig();

		cbiConfig.setConfigBlob(fileBytes);
		cbiConfig.setCategory(category);
		cbiConfig.setFileName(file.getOriginalFilename());
		cbiConfigService.createOrUpdateConfigBlob(category, cbiConfig);

		return new ResponseEntity<>(configurator.getConfigJSON(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/getScheduleStatus", method = RequestMethod.GET)
	public ResponseEntity<Boolean> getScheduleStatus() throws CBIException {
		return new ResponseEntity<>(cbiCamelConfiguration.getStarted(), HttpStatus.OK);

	}

	@RequestMapping(value = "/getTemplate/{category}", method = RequestMethod.GET)
	public ResponseEntity<CBIConfigRs> getCBIConfigDetails(@PathVariable("category") String category) throws CBIException {

		logger.debug("get template file entered");
		ByteArrayInputStream bis =null;
		BankFeedConfigurator configurator = null;
		CBIConfig cbiconf = cbiConfigService.findCBIConfigByCategory(category);
		if(cbiconf == null)
		{
			cbiconf= new CBIConfig();
		}
		else
		{
			bis=  new ByteArrayInputStream(cbiconf.getConfigBlob());
			try {

				configurator = BankFeedConfigurator.from(bis);

			} catch (IOException ie) {
				throw new CBIException(ErrorCode.CORE_1003, "");
			} catch (ValidationException ve) {

				throw new CBIException(ve.getMessages());
			} catch (Exception e) {
				throw new CBIException(ErrorCode.CORE_1003, "");
			}
		}
		

		

		
		CBIConfigRs cbiConfigRs= new CBIConfigRs();
		cbiConfigRs.setCategory(cbiconf.getCategory());
		cbiConfigRs.setFileName(cbiconf.getFileName());
		cbiConfigRs.setOtherDetails("");
		cbiConfigRs.setCbiConfigDetails(configurator!=null?configurator.getConfigJSON():"");
		cbiConfigRs.setScheduleInfo("");
		return new ResponseEntity<>(cbiConfigRs, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/fileDownload/{category}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("category") String category) {
		logger.debug("Download File {}");

		try {
			CBIConfig cbiconf = cbiConfigService.findCBIConfigByCategory(category);

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.addHeader("Content-Disposition", "filename=" + cbiconf.getFileName());
			response.setContentLength(cbiconf.getConfigBlob().length);
			ServletOutputStream os = response.getOutputStream();
			os.write(cbiconf.getConfigBlob());
			os.flush();

		} catch (Exception e) {
			logger.error("Failed to retrieve Bank config file: {}", e);
		}
	}
	
	
	
	@RequestMapping(value = "/saveInputFeedScheduleInfo", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveInputFeedScheduleInfo(@RequestBody SystemInfo systemInfo) {
		
		logger.debug("saveInputFeedScheduleInfo entered++++++++");	
		scheduleType="inputFeedSchedule";
		systemInfo.setScheduleType(scheduleType);
		systemInfo.setCategory(systemInfo.getCategory());
		
		
		cbiConfigService.updateGlobalScheduleInfo(systemInfo);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getInputFeedScheduleInfo", method = RequestMethod.POST)
	public ResponseEntity<String> getInputFeedScheduleInfo(@RequestBody SystemDetailRequest systemDetailRequest)  {

		logger.debug("getInputFeedScheduleInfo entered++++++++");			
		scheduleType="inputFeedSchedule";		
		Gson gson = new Gson();		
		systemDetailRequest.setScheduleType(scheduleType);
		systemDetailRequest.setCategory(systemDetailRequest.getCategory());
		
		Object scheduleInfo =cbiConfigService.readGlobalScheduleConfig(systemDetailRequest);
			
		String response=gson.toJson(scheduleInfo);		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/saveBankFeedScheduleInfo", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveBankFeedScheduleInfo(@RequestBody SystemInfo systemInfo) {
		
		logger.debug("saveBankFeedScheduleInfo entered++++++++");	
		
		scheduleType="bankFeedSchedule";
		
		systemInfo.setScheduleType(scheduleType);
		systemInfo.setCategory(systemInfo.getCategory());
			
		cbiConfigService.updateGlobalScheduleInfo(systemInfo);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBankFeedScheduleInfo", method = RequestMethod.POST)
	public ResponseEntity<String> getBankFeedScheduleInfo(@RequestBody SystemDetailRequest systemDetailRequest)  {

		logger.debug("getBankFeedScheduleInfo entered++++++++");	
		scheduleType="bankFeedSchedule";	
		systemDetailRequest.setScheduleType(scheduleType);
		systemDetailRequest.setCategory(systemDetailRequest.getCategory());
		
		Gson gson = new Gson();	
		
		Object scheduleInfo =cbiConfigService.readGlobalScheduleConfig(systemDetailRequest);
		String response=gson.toJson(scheduleInfo);		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/saveInputFeedOtherInfo", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveInputFeedOtherInfo(@RequestBody AdditionalInfo Info) {
		
		logger.debug("saveInputFeedScheduleInfo entered++++++++");		
		
		Info.setCategory(Info.getCategory());
		cbiConfigService.updateOtherConfigData(Info);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getInputFeedOtherInfo", method = RequestMethod.POST)
	public ResponseEntity<String> getInputFeedOtherInfo(@RequestBody SystemDetailRequest systemDetailRequest)  {

		logger.debug("getInputFeedScheduleInfo entered++++++++");			
		scheduleType="inputFeedSchedule";		
		Gson gson = new Gson();		
		Object otherInfo =cbiConfigService.readOtherConfig(systemDetailRequest);
		 String response =gson.toJson(otherInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/saveBankFeedOtherInfo", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveBankFeedOtherInfo(@RequestBody AdditionalInfo Info) {
		
		logger.debug("saveBankFeedScheduleInfo entered++++++++");	
		
			
		cbiConfigService.updateOtherConfigData(Info);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBankFeedOtherInfo", method = RequestMethod.POST)
	public ResponseEntity<String> getBankFeedOtherInfo(@RequestBody SystemDetailRequest systemDetailRequest)  {

		logger.debug("getBankFeedScheduleInfo entered++++++++");			
				
		Gson gson = new Gson();		
		Object otherInfo =cbiConfigService.readOtherConfig(systemDetailRequest);
			
		String response =gson.toJson(otherInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/changeJobStatus", method = RequestMethod.POST)
	public ResponseEntity<String> changeJobStatus(@RequestBody Boolean jobStatus)  {

		logger.debug("changeJobStatus entered++++++++");	
		if(jobStatus)
		{
			try {
				logger.debug("Camel start job triggered by user");
				cbiCamelConfiguration.start();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		else
		{
			try {
				logger.debug("Camel Stop job triggered by user");
				cbiCamelConfiguration.stop();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
			
		return new ResponseEntity<>( HttpStatus.OK);

	}
	
	
	
	
	
	
}
