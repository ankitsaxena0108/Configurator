package com.prudential.cbi.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.audit.web.FileAuditRs;
import com.prudential.core.cbi.model.FileAudit;
import com.prudential.core.cbi.model.FileAuditDetail;

/**
 * The class <code>FileAuditDAOTest</code> contains tests for the class
 * <code>{@link FileAuditDAO1}</code>.
 *
 * @generatedBy CodePro at 4/5/18 9:22 AM
 * @author nrusingh.mishra
 * @version $Revision: 1.0 $
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileAuditDAOTest {

	@Autowired
	FileAuditDAO fileAuditDAO;

	@Test
	public void testFileAuditDAO_1() throws Exception {
		FileAuditDAO result = new FileAuditDAO();
		assertNotNull(result);
	}

	@Test
	public void testCreateFileAudit_1() throws Exception {

		FileAudit fa = new FileAudit();
		fa.setSystemId("system1");
		fa.setApprovedAmount(BigDecimal.TEN);
		fa.setApprovedTxn(10);
		Date dt = new Date();
		fa.setEndDateTime(new Timestamp(formatDate("30/03/2018").getTime()));
		fa.setStartDateTime(new Timestamp(formatDate("15/03/2018").getTime()));
		fa.setFileCategory("Collection");
		fa.setFileDirection("Inward");
		fa.setFileName("filename001");
		fa.setFileStatus("PROCESSED");
		fa.setPaymentType("CreditCard");
		fa.setRejectedAmount(BigDecimal.ZERO);
		fa.setRejectedTxn(1);
		fa.setLastModified(new Timestamp(dt.getTime()));
		fa.setTotalAmount(BigDecimal.TEN);

		FileAuditDetail fad = new FileAuditDetail();
		fad.setFailureCode("100000");
		fad.setRowNumber(1);
		// fad.setLastModified(new Timestamp(dt.getTime()));
		fad.setFileAudit(fa);
		List<FileAuditDetail> auditList = new ArrayList<FileAuditDetail>();
		auditList.add(fad);
		fa.setFileAuditDetails(auditList);
		fa = fileAuditDAO.createFileAudit(fa);
		assertNotNull(fa.getLastModified());
	}

	private Date formatDate(String date) {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateObject = null;
		try {
			dateObject = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateObject;
	}

	@Test
	public void testWithAllParameters() {

		Map<String, Object> params = new HashMap<>();
		params.put("name", "system1");
		params.put("category", "Collection");
		params.put("fileDirection", "Inward");
		params.put("status", "PROCESSED");
		params.put("paymentType", "CreditCard");
		params.put("fromDate", "2018-03-12T00:00:00.000Z");
		params.put("toDate", "2018-03-27T00:00:00.000Z");
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<FileAuditRs> fileAuditDetails = fileAuditDAO.searchFileAudit(params, pageRequest);
		Boolean value = fileAuditDetails.getContent().size() > 0;
		assertEquals(true, value);
	}

	@Test
	public void testWithSystemName() {

		Map<String, Object> params = new HashMap<>();
		params.put("name", "system1");
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<FileAuditRs> fileAuditDetails = fileAuditDAO.searchFileAudit(params, pageRequest);
		Boolean value = fileAuditDetails.getContent().size() > 0;
		assertEquals(true, value);

	}

	@Test
	public void testWithFileCategory() {

		Map<String, Object> params = new HashMap<>();
		params.put("category", "Collection");
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<FileAuditRs> fileAuditDetails = fileAuditDAO.searchFileAudit(params, pageRequest);
		Boolean value = fileAuditDetails.getContent().size() > 0;
		assertEquals(true, value);

	}

	@Test
	public void testWithFileDirection() {

		Map<String, Object> params = new HashMap<>();
		params.put("fileDirection", "Inward");
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<FileAuditRs> fileAuditDetails = fileAuditDAO.searchFileAudit(params, pageRequest);
		Boolean value = fileAuditDetails.getContent().size() > 0;
		assertEquals(true, value);
	}

	@Test
	public void testWithFileStatus() {

		Map<String, Object> params = new HashMap<>();
		params.put("status", "PROCESSED");
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<FileAuditRs> fileAuditDetails = fileAuditDAO.searchFileAudit(params, pageRequest);
		Boolean value = fileAuditDetails.getContent().size() > 0;
		assertEquals(true, value);

	}

	@Test
	public void testWithPaymentType() {

		Map<String, Object> params = new HashMap<>();
		params.put("paymentType", "CreditCard");
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<FileAuditRs> fileAuditDetails = fileAuditDAO.searchFileAudit(params, pageRequest);
		Boolean value = fileAuditDetails.getContent().size() > 0;
		assertEquals(true, value);
	}

	@Test
	public void testWithDates() {
		Map<String, Object> params = new HashMap<>();
		params.put("fromDate", "2018-03-12T00:00:00.000Z");
		params.put("toDate", "2018-03-27T00:00:00.000Z");

		PageRequest pageRequest = new PageRequest(0, 10);
		Page<FileAuditRs> fileAuditDetails = fileAuditDAO.searchFileAudit(params, pageRequest);
		Boolean value = fileAuditDetails.getContent().size() > 0;
		assertEquals(true, value);

	}

	/*@Test
	public void testWitupdateStatusById() {
		
		fileAuditDAO.updateStatusById(121L, "PROCESSED");;
	
		assertEquals(true, true);

	}*/
	
	
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(FileAuditDAOTest.class);
	}
}