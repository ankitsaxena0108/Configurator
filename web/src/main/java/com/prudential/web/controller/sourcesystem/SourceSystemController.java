package com.prudential.web.controller.sourcesystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.prudential.core.cbi.scheduleInfo.AdditionalInfo;
import com.prudential.core.cbi.scheduleInfo.SystemDetailRequest;
import com.prudential.core.cbi.scheduleInfo.SystemInfo;
import com.prudential.core.cbi.services.CBIConfigService;

@RestController
@RequestMapping("/billingsystem")
public class SourceSystemController {

	String scheduleType = "sourceSchedule";
	@Autowired
	CBIConfigService cbiConfigService;

	private static final Logger logger = LoggerFactory.getLogger(SourceSystemController.class);

	@RequestMapping(value = "/savescheduleinfo", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveScheduleInfo(@RequestBody SystemInfo sys) {

		
		sys.setScheduleType(scheduleType);
		sys.setCategory(sys.getCategory());
		cbiConfigService.updateScheduleInfoData(sys);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSourceSystemSchedule", method = RequestMethod.POST)
	public ResponseEntity<String> getSourceSystemScheduleInfo(@RequestBody SystemDetailRequest systemDetailRequest)  {

		logger.debug("getSourceSystemScheduleInfo entered++++++++");
		
		systemDetailRequest.setScheduleType(scheduleType);
		Gson gson =new Gson();
		
		
		Object scheduleInfo =cbiConfigService.readScheduleInfoConfig(systemDetailRequest);		
		
		 String response =gson.toJson(scheduleInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/saveSourceSystemOtherinfo", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveSourceSystemOtherConfigInfo(@RequestBody AdditionalInfo additionInfo) {

		
		additionInfo.setScheduleType(scheduleType);
		cbiConfigService.updateOtherConfigData(additionInfo);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	
	@RequestMapping(value = "/getSourceSystemOtherInfo", method = RequestMethod.POST)
	public ResponseEntity<String> getSourceSystemOtherConfigInfo(@RequestBody SystemDetailRequest systemDetailRequest)  {

		logger.debug("getSourceSystemScheduleInfo entered++++++++");
		
		systemDetailRequest.setScheduleType(scheduleType);
		Gson gson =new Gson();
		
		
		Object scheduleInfo =cbiConfigService.readOtherConfig(systemDetailRequest);		
		
		 String response =gson.toJson(scheduleInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
}
