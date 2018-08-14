package com.prudential.web.controller.sourcesystem;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prudential.core.common.dao.BankTxnRecordDAO;
import com.prudential.core.reject.web.RejectReportRs;
import com.prudential.web.paging.SearchRq;

@RestController
@RequestMapping("/billingsystem")
public class RejectReportController {
	private static final Logger logger = LoggerFactory.getLogger(RejectReportController.class);
	@Autowired
	private BankTxnRecordDAO bankTxnRecordDAO;

	@RequestMapping(value = "/rejectReportSearch")
	public ResponseEntity<Page<RejectReportRs>> getRejectReportDetals(@RequestBody SearchRq searchRq) {

		PageRequest pageRequest = new PageRequest(searchRq.getPage(), searchRq.getSize());
		Page<RejectReportRs> RejectReportPage=null;
		try {
			RejectReportPage = (Page<RejectReportRs>) bankTxnRecordDAO.reconRejectReport(searchRq.getParams(), pageRequest);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Got {} tags ", RejectReportPage != null ? RejectReportPage.getTotalElements() : 0);

		return new ResponseEntity<>(RejectReportPage, HttpStatus.OK);
	}
}
