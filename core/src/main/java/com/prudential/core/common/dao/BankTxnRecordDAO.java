package com.prudential.core.common.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.prudential.cbi.dao.BankTnxConstants;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.model.QBankTxnRecord;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.properties.CBIProperties;
import com.prudential.core.recon.web.ReconReportRs;
import com.prudential.core.reject.web.RejectReportRs;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class BankTxnRecordDAO {

	@Autowired
	private BankTxnCRUDRepository bankTxnRepo;

	@Autowired
	private EntityManager em;

	@Value("${hibernate.jdbc.batch_size}")
	private String batchSize;

	private static final Logger logger = LoggerFactory.getLogger(BankTxnRecordDAO.class);

	public List<BankTxnRecord> fetchBankRecords(String systemName, String category, String paymentType, String state,
			String fileName) {

		QBankTxnRecord bankRecord = QBankTxnRecord.bankTxnRecord;

		BooleanExpression queryExpression = null;

		queryExpression = bankRecord.bankCode.eq(systemName);

		queryExpression = queryExpression.and(bankRecord.category.eq(category));

		queryExpression = queryExpression.and(bankRecord.paymentMode.eq(paymentType));

		queryExpression = queryExpression.and(bankRecord.state.eq(state));

		queryExpression = queryExpression.and(bankRecord.bankRequestFilename.eq(fileName));

		BankTxnRecord record = bankTxnRepo.findOne(queryExpression);

		queryExpression = null;

		queryExpression = bankRecord.bankCode.eq(systemName);

		queryExpression = queryExpression.and(bankRecord.category.eq(category));

		queryExpression = queryExpression.and(bankRecord.paymentMode.eq(paymentType));

		queryExpression = queryExpression.and(bankRecord.state.eq(state));

		queryExpression = queryExpression.and(bankRecord.batchNumber.eq(record.getBatchNumber()));

		logger.debug("Querying BankTxnRecords for  using Query: {}", queryExpression);

		return IteratorUtils.toList(bankTxnRepo.findAll(queryExpression).iterator());

	}

	public void updateBankTxnRecordStatus(List<String> id, String state) {
		String updateStateQuery = "UPDATE BankTxnRecord p SET p.state = :state WHERE p.id IN (:ids)";

		em.createQuery(updateStateQuery).setParameter("state", state).setParameter("ids", id).executeUpdate();
	}

	public void updateBankTxnRecordByAuditId(Long id, String state) {
		String updateStateQuery = "UPDATE BankTxnRecord p SET p.state = :state WHERE p.auditId = (:id)";

		em.createQuery(updateStateQuery).setParameter("state", state).setParameter("id", id).executeUpdate();
	}

	public String createBankTxnRecord(BankTxnRecord record) {

		bankTxnRepo.save(record);

		return record.getId();

	}

	public BankTxnRecord findBankTxnRecord(String id) {

		QBankTxnRecord bankRecord = QBankTxnRecord.bankTxnRecord;

		BooleanExpression queryExpression = null;

		queryExpression = bankRecord.id.eq(id);

		BankTxnRecord bankTxnRecord = bankTxnRepo.findOne(queryExpression);

		return bankTxnRecord;

	}

	@Transactional
	public void deleteBankTxnRecord(BankTxnRecord record) {

		bankTxnRepo.delete(record);

	}

	public List<String> getDistinctBankFileNames(String systemName, String category, String paymentType, String state) {

		QBankTxnRecord bankRecord = QBankTxnRecord.bankTxnRecord;

		@SuppressWarnings("unchecked")
		List<String> resultset = em.createQuery(
				"SELECT DISTINCT(p.bankRequestFilename) FROM BankTxnRecord p WHERE p.bankCode=:bankCode AND "
						+ "p.category=:category AND p.paymentMode=:paymentType AND p.state=:state AND p.bankRequestFilename!=null"
						+ "")
				.setParameter("bankCode", systemName).setParameter("category", category)
				.setParameter("paymentType", paymentType).setParameter("state", state).getResultList();

		return resultset;

	}

	/**
	 * 
	 * @param entities
	 * @return
	 */
	public boolean batchInsertRecords(List<BankTxnRecord> entities) {

		for (BankTxnRecord t : entities) {
			persistOrMerge(t);
		}

		return true;
	}

	/**
	 * 
	 * @param record
	 */
	private void persistOrMerge(BankTxnRecord record) {
		em.persist(record);
	}

	/**
	 * 
	 * @param fileName
	 * @param bankCode
	 * @param state
	 * @return
	 */
	public BankTxnRecord getFileBatchNumber(String policyNumber, String bankCode, String state) {

		QBankTxnRecord bankRecord = QBankTxnRecord.bankTxnRecord;

		BooleanExpression queryExpression = null;

		queryExpression = bankRecord.txRefNo.eq(policyNumber);

		queryExpression = queryExpression.and(bankRecord.state.eq(state));

		queryExpression = queryExpression.and(bankRecord.bankCode.eq(bankCode));

		return bankTxnRepo.findOne(queryExpression);
	}

	public BankTxnRecord getRecordPerBankPolicy(String bankCode, String policyNumber, String state, int batchNumber)

	{
		QBankTxnRecord bankRecord = QBankTxnRecord.bankTxnRecord;

		BooleanExpression queryExpression = null;

		queryExpression = bankRecord.bankCode.eq(bankCode);

		queryExpression = queryExpression.and(bankRecord.state.eq(state));

		queryExpression = queryExpression.and(bankRecord.policyNo.eq(policyNumber));

		queryExpression = queryExpression.and(bankRecord.batchNumber.eq(batchNumber));

		return bankTxnRepo.findOne(queryExpression);
	}

	@SuppressWarnings("unchecked")
	public Map<String, List<BankTxnRecord>> fetchSourceResponsePerBank(String sourceSystem, String category,
			String paymentType) {

		String state = BankTxnRecord.State.BANK_RESP_PROCESSED.toString();
		Map<String, List<BankTxnRecord>> result = new HashMap<>();

		@SuppressWarnings("unchecked")
		List<String> resultset = em
				.createQuery("SELECT DISTINCT(p.bankCode) FROM BankTxnRecord p WHERE p.srcSystem=:srcsystem AND "
						+ "p.category=:category AND p.paymentMode=:paymentType AND p.state=:state" + "")
				.setParameter("srcsystem", sourceSystem).setParameter("category", category)
				.setParameter("paymentType", paymentType).setParameter("state", state).getResultList();

		for (String bankCode : resultset) {
			QBankTxnRecord bankRecord = QBankTxnRecord.bankTxnRecord;

			BooleanExpression queryExpression = null;

			queryExpression = bankRecord.bankCode.eq(bankCode);

			queryExpression = queryExpression.and(bankRecord.srcSystem.eq(sourceSystem));

			queryExpression = queryExpression.and(bankRecord.category.eq(category));

			queryExpression = queryExpression.and(bankRecord.paymentMode.eq(paymentType));

			queryExpression = queryExpression.and(bankRecord.state.eq(state));

			List<BankTxnRecord> list = IteratorUtils.toList(bankTxnRepo.findAll(queryExpression).iterator());
			result.put(bankCode, list);

			for (BankTxnRecord record : list) {
				record.setState("PROCESSED");
			}
		}

		return result;
	}

	public void updateBankTxnRecordByBatchNumberAndState(int id, String state, String previousState, String bankName) {

		String updateStateQuery = "UPDATE BankTxnRecord p SET p.state = :state WHERE p.batchNumber = (:id) "
				+ "AND p.bankCode = (:bankCode) " + "AND p.state = (:oldState) OR p.state = (:newState) ";

		em.createQuery(updateStateQuery).setParameter("state", CBIRouteUtils.getNextState(state)).setParameter("id", id)
				.setParameter("bankCode", bankName).setParameter("oldState", previousState)
				.setParameter("newState", state).executeUpdate();

	}

	@Transactional
	public void updateBankTxnRecordByFileNameAndState(String state, String bankName, String fileName) {

		String updateStateQuery = "UPDATE BankTxnRecord p SET p.state = :state WHERE p.bankRequestFilename = (:fileName) "
				+ "AND p.state = (:oldState) AND p.bankCode = (:bankCode) ";

		em.createQuery(updateStateQuery).setParameter("state", CBIRouteUtils.getNextState(state))
				.setParameter("fileName", fileName).setParameter("oldState", state).setParameter("bankCode", bankName)
				.executeUpdate();

	}

	@Transactional
	public Page<ReconReportRs> reconReportForSuccess(Map<String, Object> searchParams, PageRequest pageRequest)
			throws ParseException {

		Map<String, ReconReportRs> map = new LinkedHashMap<>();

		CBIProperties billingSystemProperties = new CBIProperties();

		String success = billingSystemProperties.get("success");

		String fail = billingSystemProperties.get("fail");

		String[] successList = success.split(",");

		String[] failList = fail.split(",");

		Date s = convertUtilDate(searchParams.get(BankTnxConstants.FROM_DATE));
		Date s1 = convertUtilDate(searchParams.get(BankTnxConstants.TO_DATE));

		ReconReportRs res = new ReconReportRs();
		Query queryString = em.createQuery(
				"select p.bankCode,sum(p.amount),p.responseCode from BankTxnRecord p where p.policyNo between :policyStartRange AND :policyEndRange and p.state in ('BANK_RES_RECEIVED','BANK_RESP_PROCESSED','PROCESSED') and p.txDate between :fromTxDate and :toTxDate group by p.bankCode,p.amount,p.responseCode order by p.bankCode");

		@SuppressWarnings("unchecked")

		List<Object[]> reconRec = queryString
				.setParameter("policyStartRange", searchParams.get(BankTnxConstants.FROM_POLICY))
				.setParameter("policyEndRange", searchParams.get(BankTnxConstants.TO_POLICY))

				.setParameter("fromTxDate", s).setParameter("toTxDate", s1).getResultList();
		Iterator<Object[]> reconRecIterator = reconRec.listIterator();
		while (reconRecIterator.hasNext()) {
			Object[] bankTxnRecord = reconRecIterator.next();
			String bankCode = (String) bankTxnRecord[0];
			BigDecimal amount = (BigDecimal) bankTxnRecord[1];
			String respCode = (String) bankTxnRecord[2];

			ReconReportRs resp = new ReconReportRs();

			if (map.containsKey(bankCode)) {

				resp = map.get(bankCode);

				for (int J = 0; J < successList.length; J++) {
					if (respCode.equals(successList[J])) {
						if (resp.getTotalAmount() != null) {
							resp.setTotalAmount(resp.getTotalAmount().add(amount));
						} else {
							resp.setTotalAmount(BigDecimal.ZERO);
							resp.setTotalAmount(resp.getTotalAmount().add(amount));
						}

						if (resp.getTotalBilledAmount() != null) {
							resp.setTotalBilledAmount(resp.getTotalBilledAmount().add(amount));
						} else {
							resp.setTotalBilledAmount(BigDecimal.ZERO);
							resp.setTotalBilledAmount(resp.getTotalBilledAmount().add(amount));
						}

					}
				}
				for (int k = 0; k < failList.length; k++) {
					if (respCode.equals(failList[k])) {
						if (resp.getTotalAmount() != null) {
							resp.setTotalAmount(resp.getTotalAmount().add(amount));
						} else {
							resp.setTotalAmount(BigDecimal.ZERO);
							resp.setTotalAmount(resp.getTotalAmount().add(amount));
						}
						if (resp.getTotalRejectedAmount() != null) {
							resp.setTotalRejectedAmount(resp.getTotalRejectedAmount().add(amount));
						} else {
							resp.setTotalRejectedAmount(BigDecimal.ZERO);
							resp.setTotalRejectedAmount(resp.getTotalRejectedAmount().add(amount));

						}
					}
				}

				map.put(bankCode, resp);
			} else {

				for (int J = 0; J < successList.length; J++) {

					if (resp.getTotalBilledAmount() == null) {
						resp.setTotalBilledAmount(BigDecimal.ZERO);
					}
					if (respCode.equals(successList[J])) {
						resp.setTotalAmount(amount);
						resp.setTotalBilledAmount(amount);
					}
				}

				for (int k = 0; k < failList.length; k++) {

					if (resp.getTotalRejectedAmount() == null) {
						resp.setTotalRejectedAmount(BigDecimal.ZERO);
					}
					if (respCode.equals(failList[k])) {
						resp.setTotalAmount(amount);
						resp.setTotalRejectedAmount(amount);
					}
				}

				map.put(bankCode, resp);

			}

		}

		List<ReconReportRs> respList = new ArrayList<ReconReportRs>();

		for (Map.Entry<String, ReconReportRs> entry : map.entrySet()) {
			ReconReportRs report = entry.getValue();
			report.setBankName(entry.getKey());
			respList.add(report);
		}

		Page<ReconReportRs> reconReportPage = new PageImpl<>(respList, pageRequest, respList.size());

		return reconReportPage;

	}

	@Transactional
	public Page<RejectReportRs> reconRejectReport(Map<String, Object> searchParams, PageRequest pageRequest)
			throws ParseException {

		Map<String, RejectReportRs> map = new LinkedHashMap<>();
		CBIProperties billingSystemProperties = new CBIProperties();
		List<RejectReportRs> respList = new ArrayList<RejectReportRs>();

		String fail = billingSystemProperties.get("fail");
		String[] failList = fail.split(",");

		Date s = convertUtilDate(searchParams.get(BankTnxConstants.FROM_DATE));
		Date s1 = convertUtilDate(searchParams.get(BankTnxConstants.TO_DATE));

		Query queryString = em.createQuery(
				"select p.bankCode,sum(p.amount),p.responseCode from BankTxnRecord p where p.policyNo between :policyStartRange AND :policyEndRange and p.state in ('BANK_RES_RECEIVED','BANK_RESP_PROCESSED','PROCESSED') and p.txDate between :fromTxDate and :toTxDate group by p.bankCode,p.amount,p.responseCode order by p.bankCode ");

		@SuppressWarnings("unchecked")

		List<Object[]> reconRec = queryString
				.setParameter("policyStartRange", searchParams.get(BankTnxConstants.FROM_POLICY))
				.setParameter("policyEndRange", searchParams.get(BankTnxConstants.TO_POLICY))

				.setParameter("fromTxDate", s).setParameter("toTxDate", s1).getResultList();
		Iterator<Object[]> reconRecIterator = reconRec.listIterator();
		while (reconRecIterator.hasNext()) {
			Object[] bankTxnRecord = reconRecIterator.next();
			String bankCode = (String) bankTxnRecord[0];
			String respCode = (String) bankTxnRecord[2];

			RejectReportRs resp = new RejectReportRs();

			for (int k = 0; k < failList.length; k++) {
				if (respCode.equals(failList[k])) {
					resp.setBankName(bankCode);
					resp.setRejectionCode(respCode);
					respList.add(resp);
				}
			}

		}

		Page<RejectReportRs> rejectReportPage = new PageImpl<>(respList, pageRequest, respList.size());
		return rejectReportPage;

	}

	public static Date convertUtilDate(Object object) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		String dateInString = (String) object;
		Date date = sdf.parse(dateInString);
		return date;
	}
}
