package com.prudential.cbi.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.prudential.cbi.dao.helper.FileAuditHelper;
import com.prudential.core.audit.web.FileAuditRs;
import com.prudential.core.cbi.model.FileAudit;
import com.prudential.core.cbi.model.FileAuditDetail;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
@Repository
public class FileAuditDAO {

	@Autowired
	private FileAuditRepository fileAuditRepo;
	
	@Autowired
	private FileAuditDetailRepository fileAuditDetailRepo;

	private static final Logger logger = LoggerFactory.getLogger(FileAuditDAO.class);

	@Transactional
	public Page<FileAuditRs> searchFileAudit(Map<String, Object> searchParams, PageRequest pageRequest) {
		BooleanExpression queryExpression = FileAuditHelper.getQueryExpression(searchParams);
		Page<FileAudit> fileAuditsPage = fileAuditRepo.findAll(queryExpression, pageRequest);
		logger.debug("Querying file audit for {}, using Query: {}, Found: {}", searchParams, queryExpression,
				fileAuditsPage.getContent());

		List<FileAuditRs> fileAuditListRs = FileAuditHelper.extractFileAuditResponse(fileAuditsPage.getContent());

		Page<FileAuditRs> fileAuditRsPage = new PageImpl<>(fileAuditListRs, pageRequest,
				fileAuditsPage.getTotalElements());
		return fileAuditRsPage;

	}

	@Transactional
	public FileAudit createFileAudit(FileAudit fileAudit) {
		return fileAuditRepo.save(fileAudit);

	}
	
	@Transactional
	public FileAudit findById(Long id) {
		return fileAuditRepo.findOne(id);

	}
	
	
	@Transactional
	public void updateStatusById(Long id,String fileStatus) {
		FileAudit record = fileAuditRepo.findOne(id);
		record.setFileStatus(fileStatus);
		record.setEndDateTime(new Timestamp(new Date().getTime()));

	}

	@Transactional
	public FileAuditDetail createFileAuditDetail(FileAuditDetail fileAuditDetail) {
		return fileAuditDetailRepo.save(fileAuditDetail);

	}


}
