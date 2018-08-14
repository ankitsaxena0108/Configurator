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

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.audit.web.FileAuditRs;
import com.prudential.core.common.dao.BankTxnRecordDAO;
import com.prudential.core.recon.web.ReconReportRs;
import com.prudential.web.paging.SearchRq;

@RestController
@RequestMapping("/billingsystem")
public class ReconReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReconReportController.class);
	@Autowired
	private BankTxnRecordDAO bankTxnRecordDAO;

	@RequestMapping(value = "/reconReportSearch")
	public ResponseEntity<Page<ReconReportRs>> getReconReportDetals(@RequestBody SearchRq searchRq) {

		PageRequest pageRequest = new PageRequest(searchRq.getPage(), searchRq.getSize());
		Page<ReconReportRs> ReconReportPage = null;
		try {
			ReconReportPage = (Page<ReconReportRs>) bankTxnRecordDAO.reconReportForSuccess(searchRq.getParams(), pageRequest);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Got {} tags ", ReconReportPage != null ? ReconReportPage.getTotalElements() : 0);

		return new ResponseEntity<>(ReconReportPage, HttpStatus.OK);
	}
}
