package com.prudential.core.common.configuration.camelconfiguration.helper;

import java.io.File;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.model.FileAuditDetail;
import com.prudential.core.cbi.scheduleInfo.OtherConfig;
import com.prudential.core.cbi.scheduleInfo.ScheduleDetails;
import com.prudential.core.common.configuration.excel.EndpointConfig;
import com.prudential.core.common.configuration.excel.Response;
import com.prudential.core.common.configuration.excel.Response.Output;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfig;

public class CBIRouteUtils {

	private static final Logger logger = LoggerFactory.getLogger(CBIRouteUtils.class);

	public static Map<String, String> getCategoryAndPaymentType(String fileName) {
		Map<String, String> value = new HashMap<String, String>();

		value.put(CBIConstants.CATEGORY_KEY, CBIConstants.COLLECTION);

		if (fileName.toUpperCase().contains("ENROL"))
			value.put(CBIConstants.CATEGORY_KEY, CBIConstants.Enrollment);

		if (fileName.toUpperCase().contains("CC")) {
			value.put(CBIConstants.PAYMENT_MODE_KEY, CBIConstants.CREDIT_CARD);
		} else if (fileName.toUpperCase().contains("DD") && !fileName.toUpperCase().contains("BIRO")) {
			value.put(CBIConstants.PAYMENT_MODE_KEY, CBIConstants.DIRECT_DEBIT);
		}

		else if (fileName.toUpperCase().contains("BIRO"))
			value.put(CBIConstants.PAYMENT_MODE_KEY, CBIConstants.BIRO);

		else if (fileName.toUpperCase().contains("EBANK"))
			value.put(CBIConstants.PAYMENT_MODE_KEY, CBIConstants.Ebanking);

		return value;
	}

	public static String getNextState(String state) {
		String nextState = null;

		if (state.equals(BankTxnRecord.State.SOURCE_FEED_RECIEVED.toString()))
			nextState = BankTxnRecord.State.SOURCE_FEED_PROCESSED.toString();

		if (state.equals(BankTxnRecord.State.SOURCE_FEED_PROCESSED.toString()))
			nextState = BankTxnRecord.State.FEED_INPROGRESS.toString();

		if (state.equals(BankTxnRecord.State.FEED_INPROGRESS.toString()))
			nextState = BankTxnRecord.State.BANK_FEED_CREATED.toString();

		else if (state.equals(BankTxnRecord.State.BANK_FEED_CREATED.toString()))
			nextState = BankTxnRecord.State.BANK_RES_RECEIVED.toString();

		else if (state.equals(BankTxnRecord.State.BANK_RES_RECEIVED.toString()))
			nextState = BankTxnRecord.State.BANK_RESP_PROCESSED.toString();

		else if (state.equals(BankTxnRecord.State.BANK_RESP_PROCESSED.toString()))
			nextState = BankTxnRecord.State.PROCESSED.toString();

		return nextState;
	}

	public static String getFileRouteID(String rootPath, String systemName, String feedPolling)

	{
		String route = "";
		route = route.concat("file:");

		if (feedPolling == null) {
			route = route.concat(rootPath + systemName + "/");
			route = route.concat("?autoCreate=true&fileExist=Append");
		}

		else {
			route = route.concat(rootPath + systemName + "/Staging/");
			route = route.concat("?move=.completed&moveFailed=Exception&delay=" + feedPolling);
		}

		return route;
	}

	public static Map<String, List> getListOfSystems(BankFeedConfig bankFeedConfig) {
		List<String> banks = new ArrayList<String>(bankFeedConfig.getBanks().keySet());
		List<String> sourceSystems = new ArrayList<String>(bankFeedConfig.getSources().keySet());

		Map<String, List> systems = new HashMap<String, List>();

		systems.put("banks", banks);
		systems.put("sources", sourceSystems);

		return systems;
	}

	public static Integer getBatchSize(BankFeedConfig bankFeedConfig, String systemName) {
		EndpointConfig bankConfig = bankFeedConfig.getBanks().get(systemName);

		int index = Arrays.asList(bankConfig.getConfigTable().getColumns()).indexOf("Batchsize");

		Double value = Double.parseDouble(bankConfig.getConfigTable().getRow()[index]);
		return new Integer(value.intValue());

	}

	// encryption decryption Logic to go there

	public static String encryptDecryptValues(String value, Boolean encrypt) {
		if (value == null)
			return null;

		if (encrypt) {
			return value;
		}

		return value;
	}

	public static BankTxnRecord getBankTxnRecord(String category, String paymentType, String state, Response response,
			BankTxnRecord record, Output output, String body, String fileName, Exchange exchange) {
		record.setAcctNo((String) response.getComputedValues().get("AcctNo"));

		if (response.getComputedValues().get("Amount") != null) {
			record.setAmount(new BigDecimal(String.valueOf(response.getComputedValues().get("Amount"))));
		}

		record.setId(UUID.randomUUID().toString());

		// encrypt Card Number Before Storing
		record.setCardNo(CBIRouteUtils.encryptDecryptValues((String) response.getComputedValues().get("CardNo"), true));

		if (response.getComputedValues().get("PolicyNo") != null) {
			record.setPolicyNo(String.valueOf(response.getComputedValues().get("PolicyNo")));
			record.setTxRefNo((String) response.getComputedValues().get("PolicyNo"));

		}

		record.setCustName((String) response.getComputedValues().get("CustomerName"));
		record.setExpiryDate((String) response.getComputedValues().get("Expiry"));

		record.setBankRequestFilename(output.getFileName());

		if (paymentType.equals(CBIConstants.BIRO) || paymentType.equals(CBIConstants.Ebanking)) {
			record.setSrcSystem(output.getName());
			record.setBankCode(response.getName());
			record.setBankRequestFilename(fileName);
			record.setSourceFileName(fileName);
		} else {
			record.setSrcSystem(response.getName());
			record.setBankCode(output.getName());
			record.setSourceFileName(fileName);
		}

		record.setBatchNumber(output.getCurrBatch());

		record.setBankHeaderRecord(output.getHeaderRow());

		// encrypt Bank Record before Storing
		record.setBankDetailRecord(CBIRouteUtils.encryptDecryptValues(output.getDetailRow(), true));
		record.setBankFooterRecord(output.getFooterRow());

		// encrypt Source Record before Storing
		if (response.getComputedValues().get("DefaultResponse") != null)
			record.setSourceDetailRecord(CBIRouteUtils
					.encryptDecryptValues((String) response.getComputedValues().get("DefaultResponse"), true));

		else
			record.setSourceDetailRecord(output.getDetailRow());

		record.setSourceFooterRecord(null);
		record.setSourceHeaderRecord(null);

		record.setBankReqFeedCreateDate(exchange.getProperty(Exchange.CREATED_TIMESTAMP, Date.class));
		record.setTxDate(exchange.getProperty(Exchange.CREATED_TIMESTAMP, Date.class));
		record.setCategory(category);
		record.setPaymentMode(paymentType);
		record.setState(state);
		record.setAuditId((Long) exchange.getProperty("auditId"));

		return record;
	}

	/**
	 * @param otherConfig
	 * @param systemList
	 * @return
	 */
	public static Map<String, OtherConfig> getOtherConfig(byte[] otherConfig, Map<String, List> systemList) {

		if (otherConfig == null)
			return null;

		Gson gson = new Gson();

		Map<String, OtherConfig> otherConfigMap = new HashMap<>();

		List<String> banks = systemList.get("banks");

		Map<String, Object> myMap = new HashMap<>();

		Type type = new TypeToken<Map<String, Map<String, Object>>>() {
		}.getType();

		Map<String, Object> bankSchedule = ((Map<String, Object>) myMap.get("bankSchedule"));

		ObjectMapper mapper = new ObjectMapper();

		for (String bank : banks) {

			Map<String, Object> record = (Map<String, Object>) bankSchedule.get(bank);

			if (record != null)

			{

				try {
					OtherConfig value = mapper.readValue(gson.toJson(record), OtherConfig.class);
					otherConfigMap.put(bank, value);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

			}

		}

		return otherConfigMap;

	}

	public static Map<String, String> getCronExpression(byte[] scheduleInfoFile, Map<String, List> systemList) {

		if (scheduleInfoFile == null)
			return new HashMap<String, String>();

		Gson gson = new Gson();
		Map<String, Object> myMap = new HashMap<>();

		Map<String, String> cronExpressionMap = new HashMap<>();

		Type type = new TypeToken<Map<String, Map<String, Object>>>() {
		}.getType();

		String str = new String(scheduleInfoFile);

		myMap = gson.fromJson(str, type);

		Map<String, Object> sourceSchedule = ((Map<String, Object>) myMap.get("sourceSchedule"));

		List<String> sources = systemList.get("sources");
		for (String source : sources) {

			cronExpressionMap.put(source, cronBuilder((Map<String, Object>) sourceSchedule.get(source)));
		}

		Map<String, Object> bankScehdule = ((Map<String, Object>) myMap.get("bankSchedule"));

		List<String> banks = systemList.get("banks");

		for (String bank : banks) {
			cronExpressionMap.put(bank, cronBuilder((Map<String, Object>) sourceSchedule.get(bank)));
		}

		Map<String, Object> inputFeedSchedule = ((Map<String, Object>) myMap.get("inputFeedSchedule"));

		cronExpressionMap.put("inputFeedSchedule", cronBuilder(inputFeedSchedule));

		Map<String, Object> bankFeedSchedule = ((Map<String, Object>) myMap.get("bankFeedSchedule"));

		cronExpressionMap.put("bankFeedSchedule", cronBuilder(bankFeedSchedule));

		return cronExpressionMap;
	}

	private static String cronBuilder(Map<String, Object> source) {
		Gson gson = new Gson();
		String cronExp = "0+0/2+*+?+*+*";

		if (source == null || source.isEmpty())
			return cronExp;

		ObjectMapper mapper = new ObjectMapper();
		try {
			ScheduleDetails value = mapper.readValue(gson.toJson(source), ScheduleDetails.class);

			CronExpression expression = new CronExpression();
			cronExp = expression.getCronExpression(value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return cronExp;
	}

	public static void createAuditDetail(Long auditId, int index, FileAuditDAO auditDao, String exception) {

		FileAuditDetail obj = new FileAuditDetail();
		if (exception.length() > 100)
			exception.substring(0, 100);

		obj.setFailureCode(exception);
		obj.setRowNumber(index);
		obj.setFileAudit(auditDao.findById(auditId));

		auditDao.createFileAuditDetail(obj);

	}

	public static void backupFiles(String route) {
		try
		{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String time = dateFormat.format(now);
		File dir = new File(route + time);
		
		if (!dir.exists()) {
			dir.mkdir();
		} else {
			File[] backupFiles = dir.listFiles();
			for (File file : backupFiles) {
				if (file.isFile()) {
					file.delete();
				}
			}
		}
		File[] files = new File(route).listFiles();
		for (File file : files) {
			if (file.isFile()) {
				file.renameTo(new File(dir + "/" + file.getName()));

			}
		}
		}catch(Exception e )
		{
			logger.error("Cannot Backup File ", e.fillInStackTrace());
		}

	}

}
