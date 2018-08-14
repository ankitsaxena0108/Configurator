package com.prudential.core.cbi.services;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.model.CBIConfig;
import com.prudential.core.cbi.scheduleInfo.AdditionalInfo;
import com.prudential.core.cbi.scheduleInfo.OtherConfig;
import com.prudential.core.cbi.scheduleInfo.ScheduleDetails;
import com.prudential.core.cbi.scheduleInfo.SystemDetailRequest;
import com.prudential.core.cbi.scheduleInfo.SystemInfo;
import com.prudential.core.common.configuration.camelconfiguration.CBICamelConfiguration;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.dao.BankTxnRecordDAO;
import com.prudential.core.common.dao.CBIConfigRepository;

@Service
@Repository
public class CBIConfigService {

	@Autowired
	CBIConfigRepository repository;

	@Autowired
	BankTxnRecordDAO bankTxnRecordDAO;

	@Autowired
	CBICamelConfiguration camelConfig;

	@Transactional
	public boolean createCBIConfig(CBIConfig config) {

		repository.save(config);

		return true;

	}

	@Transactional
	public boolean createOrUpdateConfigBlob(String category, CBIConfig cbiConf) {

		CBIConfig cbiConfig = findCBIConfigByCategory(category);
		if (cbiConfig != null) {
			cbiConfig.setConfigBlob(cbiConf.getConfigBlob());
			cbiConfig.setFileName(cbiConf.getFileName());
			cbiConfig.setLastModified(new Timestamp(System.currentTimeMillis()));
			repository.save(cbiConfig);
		} else {
			CBIConfig newConfig = new CBIConfig();
			newConfig.setConfigBlob(cbiConf.getConfigBlob());
			newConfig.setFileName(cbiConf.getFileName());
			newConfig.setCategory(cbiConf.getCategory());
			newConfig.setLastModified(new Timestamp(System.currentTimeMillis()));
			repository.save(newConfig);
		}
		return true;

	}

	

	/*@Transactional
	public boolean updateScheduleInfoData(SystemInfo systemInfo) {
		Gson gson = new Gson();
		byte[] contentFile = null;
		String gsonString = null;
		Map<String, ScheduleDetails> scheduleMap = new HashMap<>();
		Map<String, Object> myMap = new HashMap<>();

		scheduleMap.put(systemInfo.getPaymentType(), systemInfo.getScheduleDetails());

		Map<String, Object> categoryMap = new HashMap<>();

		categoryMap.put(systemInfo.getCategory(), scheduleMap);

		// gsonString = gson.toJson(categoryMap);
		Map<String, Object> sourceSystemMap = new HashMap<>();
		sourceSystemMap.put(systemInfo.getName(), categoryMap);

		Map<String, Object> sourceDetails = new HashMap<>();
		sourceDetails.put(systemInfo.getScheduleType(), sourceSystemMap);

		gsonString = gson.toJson(sourceDetails);
		contentFile = gsonString.getBytes();

		byte[] scheduleInfoFile = null;

		CBIConfig cfg = repository.findByCategory(systemInfo.getCategory());

		scheduleInfoFile = cfg.getScheduleInfo();

		if (scheduleInfoFile == null) {

			cfg.setScheduleInfo(contentFile);

		} else {
			String scheduleInfo = new String(scheduleInfoFile);
			Type type = new TypeToken<Map<String, Map<String, Object>>>() {
			}.getType();
			myMap = gson.fromJson(scheduleInfo, type);


			Iterator it1 = myMap.entrySet().iterator();

			boolean flag = false;
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();

				if (pair.getKey().equals(systemInfo.getScheduleType())) {
					 ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) myMap
							.get(systemInfo.getScheduleType())).get(systemInfo.getName()))
									.get(systemInfo.getCategory()))
											.put(systemInfo.getPaymentType(), systemInfo.getScheduleDetails());
					flag = true;
				}

			}
			if (!flag)
				myMap.put(systemInfo.getScheduleType(), sourceSystemMap);

			String stringJs = gson.toJson(myMap);
			byte[] arr = stringJs.getBytes();
			cfg.setScheduleInfo(arr);

		}

		repository.save(cfg);
		return true;

	}*/

	@Transactional
	public boolean updateScheduleInfoData(SystemInfo systemInfo) {
		Gson gson = new Gson();
		byte[] contentFile = null;
		String gsonString = null;
		Map<String, ScheduleDetails> scheduleMap = new HashMap<>();
		Map<String, Object> myMap = new HashMap<>();


		// gsonString = gson.toJson(categoryMap);
		Map<String, Object> sourceSystemMap = new HashMap<>();
		sourceSystemMap.put(systemInfo.getName(), systemInfo.getScheduleDetails());

		Map<String, Object> sourceDetails = new HashMap<>();
		sourceDetails.put(systemInfo.getScheduleType(), sourceSystemMap);

		gsonString = gson.toJson(sourceDetails);
		contentFile = gsonString.getBytes();

		byte[] scheduleInfoFile = null;

		CBIConfig cfg = repository.findByCategory(systemInfo.getCategory());

		scheduleInfoFile = cfg.getScheduleInfo();

		if (scheduleInfoFile == null) {

			cfg.setScheduleInfo(contentFile);

		} else {
			String scheduleInfo = new String(scheduleInfoFile);
			Type type = new TypeToken<Map<String, Map<String, Object>>>() {
			}.getType();
			myMap = gson.fromJson(scheduleInfo, type);


			Iterator it1 = myMap.entrySet().iterator();

			boolean flag = false;
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();

				if (pair.getKey().equals(systemInfo.getScheduleType())) {
					((Map<String, Object>) myMap
							.get(systemInfo.getScheduleType())).put(systemInfo.getName(), systemInfo.getScheduleDetails());
									
											
					flag = true;
				}

			}
			if (!flag)
				myMap.put(systemInfo.getScheduleType(), sourceSystemMap);

			String stringJs = gson.toJson(myMap);
			byte[] arr = stringJs.getBytes();
			cfg.setScheduleInfo(arr);

		}

		repository.save(cfg);
		return true;

	}

/*	@Transactional
	public Object readScheduleInfoConfig(SystemDetailRequest sys) {
		byte[] arr = null;
		Object obj = null;
		byte[] scheduleInfoFile = null;
		Map<String, SystemInfo> myMap = new HashMap<>();
		Gson gson = new Gson();

		CBIConfig cfg = repository.findByCategory(sys.getCategory());
		scheduleInfoFile = cfg.getScheduleInfo();

		String str = new String(scheduleInfoFile);
		Type type = new TypeToken<Map<String, Map<String, Object>>>() {
		}.getType();
		myMap = gson.fromJson(str, type);

		Iterator it1 = myMap.entrySet().iterator();

		boolean flag = false;
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry) it1.next();

			if (pair.getKey().equals(sys.getScheduleType())) {
				
				obj = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) myMap
						.get(sys.getScheduleType())).get(sys.getName())).get(sys.getCategory()))
								.get(sys.getPaymentType());

			}

		}

		return obj;
	}
	*/
	
	@Transactional
	public Object readScheduleInfoConfig(SystemDetailRequest sys) {
		byte[] arr = null;
		Object obj = null;
		byte[] scheduleInfoFile = null;
		Map<String, SystemInfo> myMap = new HashMap<>();
		Gson gson = new Gson();

		CBIConfig cfg = repository.findByCategory(sys.getCategory());
		
		//	CBIConfig cfg = repository.findOne(1L);
		
		scheduleInfoFile = cfg.getScheduleInfo();

		String str = new String(scheduleInfoFile);
		Type type = new TypeToken<Map<String, Map<String, Object>>>() {
		}.getType();
		myMap = gson.fromJson(str, type);

		Iterator it1 = myMap.entrySet().iterator();

		boolean flag = false;
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry) it1.next();

			if (pair.getKey().equals(sys.getScheduleType())) {
				
				obj = ((Map<String, Object>) ((Map<String, Object>) myMap
						.get(sys.getScheduleType())).get(sys.getName()));

			}

		}

		return obj;
	}
	
	
	@Transactional
	public boolean updateOtherConfigData(AdditionalInfo additionalInfo) {
		Gson gson = new Gson();
		byte[] contentFile = null;
		String gsonString = null;
		Map<String, OtherConfig> otherMap = new HashMap<>();
		Map<String, Object> myMap = new HashMap<>();


		Map<String, Object> sourceSystemMap = new HashMap<>();
		sourceSystemMap.put(additionalInfo.getName(), additionalInfo.getOtherConfig());

		Map<String, Object> sourceDetails = new HashMap<>();
		sourceDetails.put(additionalInfo.getScheduleType(), sourceSystemMap);

		gsonString = gson.toJson(sourceDetails);
		contentFile = gsonString.getBytes();

		byte[] otherConfigFile = null;

		CBIConfig cfg = repository.findByCategory(additionalInfo.getCategory());

		otherConfigFile = cfg.getOtherConfig();

		if (otherConfigFile == null) {

			cfg.setOtherConfig(contentFile);

		} else {
			String otherConfig = new String(otherConfigFile);
			Type type = new TypeToken<Map<String, Map<String, Object>>>() {
			}.getType();
			myMap = gson.fromJson(otherConfig, type);


			Iterator it1 = myMap.entrySet().iterator();

			boolean flag = false;
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();

				if (pair.getKey().equals(additionalInfo.getScheduleType())) {
					  ((Map<String, Object>) myMap
							.get(additionalInfo.getScheduleType())).put(additionalInfo.getName(), additionalInfo.getOtherConfig());
					flag = true;
				}

			}
			if (!flag)
				myMap.put(additionalInfo.getScheduleType(), sourceSystemMap);

			String stringJs = gson.toJson(myMap);
			byte[] arr = stringJs.getBytes();
			cfg.setOtherConfig(arr);

		}

		repository.save(cfg);
		return true;
	}
	
	@Transactional
	public Object readOtherConfig(SystemDetailRequest sys) {
		byte[] arr = null;
		Object obj = null;
		byte[] otherConfigFile = null;
		Map<String, SystemInfo> myMap = new HashMap<>();
		Gson gson = new Gson();

		CBIConfig cfg = repository.findByCategory(sys.getCategory());
		otherConfigFile = cfg.getOtherConfig();
		

		String str = new String(otherConfigFile);
		Type type = new TypeToken<Map<String, Map<String, Object>>>() {
		}.getType();
		myMap = gson.fromJson(str, type);

		Iterator it1 = myMap.entrySet().iterator();

		boolean flag = false;
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry) it1.next();

			if (pair.getKey().equals(sys.getScheduleType())) {
				
				obj =   ((Map<String, Object>) ((Map<String, Object>) myMap
						.get(sys.getScheduleType())).get(sys.getName()));
								

			}

		}

		return obj;
	}
	
/*	@SuppressWarnings("unchecked")
	@Transactional
	public boolean updateGlobalScheduleInfo(SystemInfo systemInfo) {
		Gson gson = new Gson();
		byte[] contentFile = null;
		String gsonString = null;
		
		Map<String, Object> myMap = new HashMap<>();

		Map<String, Object> globalScheduleMap = new HashMap<>();
		globalScheduleMap.put(systemInfo.getScheduleType(), systemInfo.getScheduleDetails());

		gsonString = gson.toJson(globalScheduleMap);
		contentFile = gsonString.getBytes();

		byte[] scheduleInfoFile = null;

		CBIConfig cfg = repository.findByCategory(systemInfo.getCategory());

		scheduleInfoFile = cfg.getScheduleInfo();

		if (scheduleInfoFile == null) {

			cfg.setScheduleInfo(contentFile);

		} else {
			String scheduleInfo = new String(scheduleInfoFile);
			Type type = new TypeToken<Map<String, Map<String, Object>>>() {
			}.getType();
			myMap = gson.fromJson(scheduleInfo, type);

			Iterator it1 = myMap.entrySet().iterator();

			boolean flag = false;
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();

				if (pair.getKey().equals(systemInfo.getScheduleType())) {
					myMap.put(systemInfo.getScheduleType(),systemInfo.getScheduleDetails());							

					flag = true;
				}

			}
			if (!flag)
				myMap.put(systemInfo.getScheduleType(), systemInfo.getScheduleDetails());

			String stringJs = gson.toJson(myMap);
			byte[] arr = stringJs.getBytes();
			cfg.setScheduleInfo(arr);

		}

		repository.save(cfg);
		return true;

	}*/
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public boolean updateGlobalScheduleInfo(SystemInfo systemInfo) {
		Gson gson = new Gson();
		byte[] contentFile = null;
		String gsonString = null;
		
		Map<String, Object> myMap = new HashMap<>();

		Map<String, Object> globalScheduleMap = new HashMap<>();
		globalScheduleMap.put(systemInfo.getScheduleType(), systemInfo.getScheduleDetails());

		gsonString = gson.toJson(globalScheduleMap);
		contentFile = gsonString.getBytes();

		byte[] scheduleInfoFile = null;

		CBIConfig cfg = repository.findByCategory(systemInfo.getCategory());
		
	

		scheduleInfoFile = cfg.getScheduleInfo();

		if (scheduleInfoFile == null) {

			cfg.setScheduleInfo(contentFile);

		} else {
			String scheduleInfo = new String(scheduleInfoFile);
			Type type = new TypeToken<Map<String, Map<String, Object>>>() {
			}.getType();
			myMap = gson.fromJson(scheduleInfo, type);

			Iterator it1 = myMap.entrySet().iterator();

			boolean flag = false;
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();

				if (pair.getKey().equals(systemInfo.getScheduleType())) {
					myMap.put(systemInfo.getScheduleType(),systemInfo.getScheduleDetails());							

					flag = true;
				}

			}
			if (!flag)
				myMap.put(systemInfo.getScheduleType(), systemInfo.getScheduleDetails());

			String stringJs = gson.toJson(myMap);
			byte[] arr = stringJs.getBytes();
			cfg.setScheduleInfo(arr);

		}

		repository.save(cfg);
		return true;

	}

	@Transactional
	public Object readGlobalScheduleConfig(SystemDetailRequest sys) {
		byte[] arr = null;
		Object obj = null;
		byte[] scheduleInfoFile = null;
		Map<String, SystemInfo> myMap = new HashMap<>();
		Gson gson = new Gson();

		CBIConfig cfg = repository.findByCategory(sys.getCategory());
		scheduleInfoFile = cfg.getScheduleInfo();

		String str = new String(scheduleInfoFile);
		Type type = new TypeToken<Map<String, Map<String, Object>>>() {
		}.getType();
		myMap = gson.fromJson(str, type);

		Iterator it1 = myMap.entrySet().iterator();

		boolean flag = false;
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry) it1.next();

			if (pair.getKey().equals(sys.getScheduleType())) {
				
				obj = ((Map<String, Object>)myMap.get(sys.getScheduleType()));	;

			}

		}

		return obj;
	}
	
	

	@Transactional
	public CBIConfig findCBIConfigByID(Long id) {
		CBIConfig cbiConfig = repository.findOne(id);
		return cbiConfig;
	}
	
	public Iterable<CBIConfig> findAllConfig() {
		 
		return repository.findAll();
	}
	

	@Transactional
	public CBIConfig findCBIConfigByCategory(String category) {
		return repository.findByCategory(category);
	}

	
	
	@Transactional
	public List<BankTxnRecord> findBankOutFeedRecords(String bankCode,String category,String paymentType,String state,String fileName)
	{
		return bankTxnRecordDAO.fetchBankRecords(bankCode, category, paymentType, state,fileName);
	}

	
	
	@Transactional
	public List<String> getDistinctBankFileNames(String systemName, String category, String paymentType, String state)
	{
		return bankTxnRecordDAO.getDistinctBankFileNames(systemName, category, paymentType, state);
	}
	
	
	
	
	
	@Transactional
	public boolean updateBankTxnRecordStatus(List<String> id,String state) {
		
		bankTxnRecordDAO.updateBankTxnRecordStatus(id,state);
		
		return true;
	}
	
	
	@Transactional
	public boolean updateBankTxnRecordByAuditId(Long id, String state) {
		
		bankTxnRecordDAO.updateBankTxnRecordByAuditId(id,state);
		
		return true;
	}
	
	
	@Transactional
	public boolean updateBankTxnRecordByBatchNumberAndState(int id, String state,String previousState,String bankName) {
		
		bankTxnRecordDAO.updateBankTxnRecordByBatchNumberAndState(id,state,previousState,bankName);
		
		return true;
	}
	
	
	
	@Transactional
	public boolean updateBankTxnRecordByFileNameAndState(String state,String bankName, String fileName) {
		
		bankTxnRecordDAO.updateBankTxnRecordByFileNameAndState(state,bankName, fileName);
		
		return true;
	}
	
	
	
	
	@Transactional
	public boolean saveBankTxnRecord(BankTxnRecord record) {
		
		bankTxnRecordDAO.createBankTxnRecord(record);
		
		return true;
	}
	
	
	@Transactional
	public boolean batchInsertBankTxnRecord(List<BankTxnRecord> entities)
	{
		return bankTxnRecordDAO.batchInsertRecords(entities);
	}
	
	

	@Transactional
	public int findAndUpdateBankRecords(List<BankTxnRecord> txnRecords,String fileName,String state,String bankCode)
	{

		/*we can use the policy number 
		 * and bank name to find the batch Number and then Update the state and get the records*/
		
		BankTxnRecord fileRecord=bankTxnRecordDAO.getFileBatchNumber(txnRecords.get(0).getPolicyNo().trim(),bankCode,state);
		
		String nextState = CBIRouteUtils.getNextState(state);
		
		for (BankTxnRecord record : txnRecords) {
			String policyNo = record.getPolicyNo().trim();

			BankTxnRecord updateValue = bankTxnRecordDAO.getRecordPerBankPolicy(fileRecord.getBankCode(),
					policyNo, state, fileRecord.getBatchNumber());

			updateValue.setState(nextState);
			updateValue.setSourceDetailRecord(record.getSourceDetailRecord());
			updateValue.setResponseCode(record.getResponseCode());
		}
		
		return fileRecord.getBatchNumber();
		
	}	
		
	
	@Transactional
	public Map<String,List<BankTxnRecord>> fetchSourceResponsePerBank(String sourceSystem,String category, String paymentType)
	{
		return bankTxnRecordDAO.fetchSourceResponsePerBank(sourceSystem,category,paymentType);
	}


}
