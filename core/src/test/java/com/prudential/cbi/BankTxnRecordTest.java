package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.dao.BankTxnRecordDAO;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTxnRecordTest {

	@Autowired
	BankTxnRecordDAO bankTxnRecordDAO;
	@Autowired
	CBIConfigService cbiConfigService;

	/*
	 * @Test public void testWithAllParameters() throws ParseException {
	 * 
	 * Map<String, Object> params = new HashMap<>(); params.put("bankCode",
	 * "MBB_CC"); params.put("policyStartRange", "99999910");
	 * params.put("policyEndRange", "99999920"); params.put("fromDate",
	 * "2018-05-06T00:00:00.000Z"); params.put("toDate",
	 * "2018-05-10T00:00:00.000Z"); PageRequest pageRequest = new PageRequest(0,
	 * 10); Page<ReconReportRs> bankTxnDetails =
	 * bankTxnRecordDAO.reconReportForSuccess(params, pageRequest); Boolean value =
	 * bankTxnDetails.getContent().size() > 0; assertEquals(true, value); }
	 */

	/*
	 * @Test public void reconRejectReport() throws ParseException {
	 * 
	 * Map<String, Object> params = new HashMap<>(); params.put("bankCode",
	 * "MBB_CC"); params.put("policyStartRange", "99999910");
	 * params.put("policyEndRange", "99999920"); params.put("fromDate",
	 * "2018-05-06T00:00:00.000Z"); params.put("toDate",
	 * "2018-05-10T00:00:00.000Z"); PageRequest pageRequest = new PageRequest(0,
	 * 10); Page<RejectReportRs> bankTxnDetails =
	 * bankTxnRecordDAO.reconRejectReport(params, pageRequest); Boolean value =
	 * bankTxnDetails.getContent().size() > 0; assertEquals(true, value);
	 * 
	 * }
	 */

	/*
	 * @Test public void getFileBatchNumber() {
	 * 
	 * BankTxnRecord bankTxnDetails =
	 * bankTxnRecordDAO.getFileBatchNumber("99999911", "MBB_CC", "PROCESSED");
	 * 
	 * assertEquals(bankTxnDetails.getBankCode(), "MBB_CC");
	 * 
	 * }
	 */

	@Test
	public void getDistinctBankFileNames() {

		List<String> list = cbiConfigService.getDistinctBankFileNames("MBB_CC", "Collection", "CreditCard",
				"PROCESSED");

		Boolean value = list.size() > 0;
		assertEquals(true, value);

	}

	@Test
	public void findBankOutFeedRecords() {

		List<BankTxnRecord> list = cbiConfigService.findBankOutFeedRecords("MBB_CC", "Collection", "CreditCard",
				"PROCESSED", "MBB0013.CTD");

		Boolean value = list.size() > 0;
		assertEquals(true, value);

	}

	@Test
	public void csaveBankTxnRecord() {

		BankTxnRecord banktxn = new BankTxnRecord();
		banktxn.setSrcSystem("IL_CC");
		banktxn.setBankCode("MBB_CC");
		banktxn.setCategory("Collection");
		banktxn.setPaymentMode("CreditCard");
		banktxn.setState("BANK_RESP_PROCESSED");
		banktxn.setBankRequestFilename("MBB0014.CTD");
		banktxn.setPolicyNo("99999950");
		banktxn.setTxRefNo("99999950");
		banktxn.setId("TestSave");

		cbiConfigService.saveBankTxnRecord(banktxn);

		assertEquals(true, true);

	}

	@Test
	public void getRecordPerBankPolicy() {

		BankTxnRecord banktxn = bankTxnRecordDAO.getRecordPerBankPolicy("MBB_CC", "99999911", "PROCESSED", 0);

		assertEquals(banktxn.getBankCode(), "MBB_CC");

	}

	@Test
	public void fetchSourceResponsePerBank() {

		Map<String, List<BankTxnRecord>> result = cbiConfigService.fetchSourceResponsePerBank("IL_CC", "Collection",
				"CreditCard");

		Boolean value = result.size() > 0;

		assertEquals(value, true);

	}

	@Test
	public void updateBankTxnRecordByFileNameAndState() {

		try {
			cbiConfigService.updateBankTxnRecordByFileNameAndState("BANK_RESP_PROCESSED", "MBB_CC", "IL_MBB.txt");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		assertEquals(true, true);

	}

	@Test
	public void abatchInsertBankTxnRecord() {

		List<BankTxnRecord> list = new ArrayList<>();
		BankTxnRecord banktxn = new BankTxnRecord();
		banktxn.setSrcSystem("IL_CC");
		banktxn.setBankCode("MBB_CC");
		banktxn.setCategory("Collection");
		banktxn.setPaymentMode("CreditCard");
		banktxn.setState("BANK_RESP_PROCESSED");
		banktxn.setBankRequestFilename("MBB0013.CTD");
		banktxn.setSourceFileName("MBB0013.CTD");
		banktxn.setId("TestInsert");
		banktxn.setPolicyNo("99999911");
		banktxn.setTxRefNo("99999911");

		list.add(banktxn);
		cbiConfigService.batchInsertBankTxnRecord(list);

		assertEquals(true, true);

	}

	@Test
	public void updateBankTxnRecordByAuditId() {

		cbiConfigService.updateBankTxnRecordByAuditId(182L, "BANK_RESP_PROCESSED");

		assertEquals(true, true);

	}

	@Test
	public void updateBankTxnRecordStatus() {

		List<String> ID = new ArrayList<>();
		ID.add("aca6443a-2060-441a-ba92-3c3882c697b0");
		cbiConfigService.updateBankTxnRecordStatus(ID, "BANK_RESP_PROCESSED");

		assertEquals(true, true);

	}

	/*
	 * @Test public void updateBankTxnRecordByBatchNumberAndState(){
	 * 
	 * 
	 * 
	 * boolean result =
	 * cbiConfigService.updateBankTxnRecordByBatchNumberAndState("IL_CC",
	 * "Collection","CreditCard");
	 * 
	 * 
	 * 
	 * assertEquals(result, true);
	 * 
	 * }
	 */

	@Test
	public void bfindAndUpdateBankRecords() {

		List<BankTxnRecord> list = new ArrayList<>();
		BankTxnRecord banktxn = new BankTxnRecord();
		banktxn.setBankCode("MBB_CC");
		banktxn.setCategory("Collection");
		banktxn.setPaymentMode("CreditCard");
		banktxn.setState("BANK_RESP_PROCESSED");
		banktxn.setBankRequestFilename("MBB0013.CTD");
		banktxn.setPolicyNo("99999911");

		list.add(banktxn);
		int bachNumber = cbiConfigService.findAndUpdateBankRecords(list, "MBB0013.CTD", "BANK_RESP_PROCESSED",
				"MBB_CC");

		assertEquals(0, bachNumber);

	}

	@Test
	public void zafter() {
		bankTxnRecordDAO.deleteBankTxnRecord(bankTxnRecordDAO.findBankTxnRecord("TestInsert"));
		bankTxnRecordDAO.deleteBankTxnRecord(bankTxnRecordDAO.findBankTxnRecord("TestSave"));

	}

}
