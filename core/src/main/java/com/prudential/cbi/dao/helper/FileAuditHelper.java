package com.prudential.cbi.dao.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.prudential.cbi.dao.FileAuditConstants;
import com.prudential.core.audit.web.FileAuditDetailRs;
import com.prudential.core.audit.web.FileAuditRs;
import com.prudential.core.cbi.model.FileAudit;
import com.prudential.core.cbi.model.FileAuditDetail;
import com.prudential.core.cbi.model.QFileAudit;
import com.prudential.core.common.utils.DateUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

public class FileAuditHelper {

	public static BooleanExpression addExpression(BooleanExpression queryExpression,
			BooleanExpression expressionParam) {
		if (queryExpression != null) {
			queryExpression = queryExpression.and(expressionParam);
		} else {
			queryExpression = expressionParam;
		}

		return queryExpression;
	}

	public static List<FileAuditRs> extractFileAuditResponse(Iterable<FileAudit> list) {

		List<FileAuditRs> auditRsList = new ArrayList<>();
		for (FileAudit fileAudit : list) {
			FileAuditRs fileAuditRs = new FileAuditRs();
			BeanUtils.copyProperties(fileAudit, fileAuditRs, "auditDetails");

			FileAuditDetailRs fileAuditDetailRs = null;
			List<FileAuditDetailRs> fileAuditDetailListRs = new ArrayList<>();
			for (FileAuditDetail fileAuditDetail : fileAudit.getFileAuditDetails()) {
				fileAuditDetailRs = new FileAuditDetailRs();
				BeanUtils.copyProperties(fileAuditDetail, fileAuditDetailRs);
				fileAuditDetailListRs.add(fileAuditDetailRs);
			}
			fileAuditRs.setAuditDetails(fileAuditDetailListRs);

			auditRsList.add(fileAuditRs);
		}
		return auditRsList;
	}

	public static BooleanExpression getQueryExpression(Map<String, Object> searchParams) {
		boolean searchBySystemName = searchParams.containsKey(FileAuditConstants.SYSTEM_NAME)
				&& !ObjectUtils.isEmpty(searchParams.get(FileAuditConstants.SYSTEM_NAME));

		boolean searchByFileDirection = searchParams.containsKey(FileAuditConstants.FILE_DIRECTION)
				&& !StringUtils.isEmpty(searchParams.get(FileAuditConstants.FILE_DIRECTION));

		boolean searchByCategory = searchParams.containsKey(FileAuditConstants.FILE_CATEGORY)
				&& !StringUtils.isEmpty(searchParams.get(FileAuditConstants.FILE_CATEGORY))
				&& Boolean.valueOf(searchParams.get(FileAuditConstants.FILE_CATEGORY).toString());

		boolean searchByStatus = searchParams.containsKey(FileAuditConstants.FILE_STATUS)
				&& !StringUtils.isEmpty(searchParams.get(FileAuditConstants.FILE_STATUS));

		boolean searchByPaymentType = searchParams.containsKey(FileAuditConstants.PAYMENT_TYPE)
				&& !StringUtils.isEmpty(searchParams.get(FileAuditConstants.PAYMENT_TYPE));

		boolean searchByFromDate = searchParams.containsKey(FileAuditConstants.FROM_DATE)
				&& !StringUtils.isEmpty(searchParams.get(FileAuditConstants.FROM_DATE));

		boolean searchByToDate = searchParams.containsKey(FileAuditConstants.TO_DATE)
				&& !StringUtils.isEmpty(searchParams.get(FileAuditConstants.TO_DATE));
		BooleanExpression queryExpression = null;
		if (searchBySystemName || searchByFileDirection || searchByCategory || searchByStatus || searchByPaymentType
				|| searchByFromDate || searchByToDate) {
			QFileAudit fileAudit = QFileAudit.fileAudit;

			if (searchBySystemName) {
				queryExpression = FileAuditHelper.addExpression(queryExpression, fileAudit.systemId
						.containsIgnoreCase(searchParams.get(FileAuditConstants.SYSTEM_NAME).toString()));
			}

			if (searchByFileDirection) {
				queryExpression = FileAuditHelper.addExpression(queryExpression, fileAudit.fileDirection
						.containsIgnoreCase(searchParams.get(FileAuditConstants.FILE_DIRECTION).toString()));
			}

			if (searchByCategory) {
				queryExpression = FileAuditHelper.addExpression(queryExpression, fileAudit.fileCategory
						.containsIgnoreCase(searchParams.get(FileAuditConstants.FILE_CATEGORY).toString()));
			}

			if (searchByStatus) {
				queryExpression = FileAuditHelper.addExpression(queryExpression, fileAudit.fileStatus
						.containsIgnoreCase(searchParams.get(FileAuditConstants.FILE_STATUS).toString()));
			}

			if (searchByPaymentType) {
				queryExpression = FileAuditHelper.addExpression(queryExpression, fileAudit.paymentType
						.containsIgnoreCase(searchParams.get(FileAuditConstants.PAYMENT_TYPE).toString()));
			}

			if (searchByFromDate) {
				queryExpression = FileAuditHelper.addExpression(queryExpression, fileAudit.startDateTime.goe(
						DateUtils.convertStringToTimeStamp(searchParams.get(FileAuditConstants.FROM_DATE).toString())));
			}

			if (searchByToDate) {
				queryExpression = FileAuditHelper.addExpression(queryExpression, fileAudit.startDateTime.loe(
						DateUtils.convertStringToTimeStamp(searchParams.get(FileAuditConstants.TO_DATE).toString())));
			}

		}
		return queryExpression;
	}

}
