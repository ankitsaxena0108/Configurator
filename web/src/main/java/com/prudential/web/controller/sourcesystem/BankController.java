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
public class BankController {

	String scheduleType = "bankSchedule";
	@Autowired
	CBIConfigService cbiConfigService;

	private static final Logger logger = LoggerFactory.getLogger(BankController.class);

	@RequestMapping(value = "/saveBankScheduleInfo", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveBankScheduleInfo(@RequestBody SystemInfo info) {

		logger.debug("saveBankScheduleInfo entered++++++++");
		
		info.setScheduleType(scheduleType);
		info.setCategory(info.getCategory());
		cbiConfigService.updateScheduleInfoData(info);
       
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBankSchedule", method = RequestMethod.POST)
	public ResponseEntity<String> getBankSchedule(@RequestBody SystemDetailRequest sys)  {

		logger.debug("getBankSchedule entered++++++++");
		
		Gson gson =new Gson();
		
		sys.setScheduleType(scheduleType);
		sys.setCategory(sys.getCategory());
		Object scheduleInfo =cbiConfigService.readScheduleInfoConfig(sys);		
		 String response =gson.toJson(scheduleInfo);
			
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/saveBankOtherInf", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveBankOtherInfo(@RequestBody AdditionalInfo info) {

		logger.debug("saveBankScheduleInfo entered++++++++");
		
		info.setScheduleType(scheduleType);
		
		info.setCategory(info.getCategory());
		cbiConfigService.updateOtherConfigData(info);
       
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBankOtherInfo", method = RequestMethod.POST)
	public ResponseEntity<String> getBankOtherInfo(@RequestBody SystemDetailRequest sys)  {

		logger.debug("getBankSchedule entered++++++++");
		
		Gson gson =new Gson();
		
		sys.setScheduleType(scheduleType);
		
		sys.setCategory(sys.getCategory());
		Object scheduleInfo =cbiConfigService.readOtherConfig(sys);		
		 String response =gson.toJson(scheduleInfo);
			
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
}
