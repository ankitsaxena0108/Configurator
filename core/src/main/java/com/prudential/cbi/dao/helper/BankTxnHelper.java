package com.prudential.cbi.dao.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.prudential.cbi.dao.BankTnxConstants;
import com.prudential.cbi.dao.FileAuditConstants;
import com.prudential.core.audit.web.FileAuditDetailRs;
import com.prudential.core.audit.web.FileAuditRs;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.model.BankTxnRecordRes;
import com.prudential.core.cbi.model.FileAudit;
import com.prudential.core.cbi.model.FileAuditDetail;
import com.prudential.core.cbi.model.QBankTxnRecord;
import com.prudential.core.common.utils.DateUtils;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

public class BankTxnHelper {

	public static BooleanExpression addExpression(BooleanExpression queryExpression,
			BooleanExpression expressionParam) {
		if (queryExpression != null) {
			queryExpression = queryExpression.and(expressionParam);
		} else {
			queryExpression = expressionParam;
		}

		return queryExpression;
	}
	
	
	public static List<BankTxnRecordRes> extractFileAuditResponse(Iterable<BankTxnRecord> list) {

		List<BankTxnRecordRes> bankRsList = new ArrayList<>();
		for (BankTxnRecord bankTxn : list) {
			BankTxnRecordRes bankTxnRs = new BankTxnRecordRes();
			BeanUtils.copyProperties(bankTxn, bankTxnRs, "bankDetail");

		/*	FileAuditDetailRs fileAuditDetailRs = null;
			List<FileAuditDetailRs> fileAuditDetailListRs = new ArrayList<>();
			for (FileAuditDetail fileAuditDetail : fileAudit.getFileAuditDetails()) {
				fileAuditDetailRs = new FileAuditDetailRs();
				BeanUtils.copyProperties(fileAuditDetail, fileAuditDetailRs);
				fileAuditDetailListRs.add(fileAuditDetailRs);
			}
			bankTxnRs.setb(fileAuditDetailListRs);

			auditRsList.add(fileAuditRs);*/
			
			bankRsList.add(bankTxnRs);
		}
		return bankRsList;
	}
	
	public static BooleanExpression getQueryExpression(Map<String, Object> searchParams) {
		boolean searchBybankCode = searchParams.containsKey(BankTnxConstants.BANK_CODE)
				&& !ObjectUtils.isEmpty(searchParams.get(BankTnxConstants.BANK_CODE));

		/*boolean searchByBankState = searchParams.containsKey(BankTnxConstants.BANK_STATE)
				&& !StringUtils.isEmpty(searchParams.get(BankTnxConstants.BANK_STATE));*/

		boolean searchByFromPolicy = searchParams.containsKey(BankTnxConstants.FROM_POLICY)
				&& !StringUtils.isEmpty(searchParams.get(BankTnxConstants.FROM_POLICY));

		boolean searchByToPolicy = searchParams.containsKey(BankTnxConstants.TO_POLICY)
				&& !StringUtils.isEmpty(searchParams.get(BankTnxConstants.TO_POLICY));

		boolean searchByFromDate = searchParams.containsKey(BankTnxConstants.FROM_DATE)
				&& !StringUtils.isEmpty(searchParams.get(BankTnxConstants.FROM_DATE));

		boolean searchByToDate = searchParams.containsKey(BankTnxConstants.TO_DATE)
				&& !StringUtils.isEmpty(searchParams.get(BankTnxConstants.TO_DATE));
		BooleanExpression queryExpression = null;
		if (searchBybankCode || searchByFromPolicy || searchByToPolicy || searchByFromDate
				|| searchByToDate ) {
			QBankTxnRecord bankTxn = QBankTxnRecord.bankTxnRecord;

			if (searchBybankCode) {
				queryExpression = BankTxnHelper.addExpression(queryExpression, bankTxn.bankCode
						.containsIgnoreCase(searchParams.get(BankTnxConstants.BANK_CODE).toString()));
			}

			if (searchByFromPolicy) {
				queryExpression = BankTxnHelper.addExpression(queryExpression, bankTxn.policyNo
						.goe(searchParams.get(BankTnxConstants.FROM_POLICY).toString()));
			}

			if (searchByToPolicy) {
				queryExpression = BankTxnHelper.addExpression(queryExpression, bankTxn.policyNo.loe
						(searchParams.get(BankTnxConstants.TO_POLICY).toString()));
			}
			
			if (searchByFromDate) {
				queryExpression = BankTxnHelper.addExpression(queryExpression, bankTxn.txDate.goe(
						DateUtils.convertStringToTimeStamp(searchParams.get(BankTnxConstants.FROM_DATE).toString())));
			}


			if (searchByToDate) {
				queryExpression = BankTxnHelper.addExpression(queryExpression, bankTxn.txDate.loe(
						DateUtils.convertStringToTimeStamp(searchParams.get(BankTnxConstants.TO_DATE).toString())));
			}
			
			queryExpression= queryExpression.andAnyOf(bankTxn.state
						.containsIgnoreCase("BANK_RES_RECEIVED"),bankTxn.state
						.containsIgnoreCase("BANK_RESP_PROCESSED"),bankTxn.state
						.containsIgnoreCase("PROCESSED"));
					
		
			queryExpression = BankTxnHelper.addExpression(queryExpression, bankTxn.responseCode
					.eq(searchParams.get(BankTnxConstants.RESPONSE_CODE).toString()));
			
		//	bankTxn.amount.sum();

		}
		
		return queryExpression;
	}
	
	/*public static void getTotalSucessAmount() {
		QBankTxnRecord bankTxn = QBankTxnRecord.bankTxnRecord;
		JPAQuery query = new JPAQuery<>();
		query.from(bankTxn).where(bankTxn.responseCode.eq("00")).;
	}*/

}
