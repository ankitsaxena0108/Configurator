package com.prudential.web.controller.sourcesystem;

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
import com.prudential.web.paging.SearchRq;

@RestController
@RequestMapping("/billingsystem")
public class FileAuditController {
	private static final Logger logger = LoggerFactory.getLogger(FileAuditController.class);
	@Autowired
	private FileAuditDAO fileAuditDAO;

	@RequestMapping(value = "/auditsearch")
	public ResponseEntity<Page<FileAuditRs>> getFileAuditInfo(@RequestBody SearchRq searchRq) {

		PageRequest pageRequest = new PageRequest(searchRq.getPage(), searchRq.getSize());
		Page<FileAuditRs> auditsPage = fileAuditDAO.searchFileAudit(searchRq.getParams(), pageRequest);
		logger.debug("Got {} tags ", auditsPage != null ? auditsPage.getTotalElements() : 0);

		return new ResponseEntity<>(auditsPage, HttpStatus.OK);
	}
}
