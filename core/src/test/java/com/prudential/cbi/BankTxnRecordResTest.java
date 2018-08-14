package com.prudential.cbi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.cbi.model.BankTxnRecordRes;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTxnRecordResTest {

	
	 @Test
	    public void testSetAcctNo() {
		 BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setAcctNo("121");
	        assertEquals(card.getAcctNo(), "121");
	        
	    }
	 
	   @Test
	    public void testGetAcctNo() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setAcctNo("321");
	        assertEquals(card.getAcctNo(), "321");
	    }
	 
	   
	   
	   @Test
	    public void testSetAuditId() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setAuditId(1L);
	        assertTrue(card.getAuditId() == 1L);
	        
	    }
	 
	   @Test
	    public void testGetAuditId() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setAuditId(1L);
	        assertTrue(card.getAuditId() == 1L);
	    }
	   
	   
	   @Test
	    public void testSetBankCode() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setBankCode("xxxx");
	        assertEquals(card.getBankCode(), "xxxx");
	        
	    }
	 
	   @Test
	    public void testGetBankCode() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setBankCode("xxxx");
	        assertEquals(card.getBankCode(), "xxxx");
	    }
	 
	   
	   
	   @Test
	    public void testSetBankDetailRecord() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setBankDetailRecord("record");
	        assertTrue(card.getBankDetailRecord() == "record");
	        
	    }
	 
	   @Test
	    public void testGetBankDetailRecord() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setBankDetailRecord("record");
	        assertTrue(card.getBankDetailRecord() == "record");
	    }
	   
	   
	 /*  @Test
	    public void testSetBankFooterRecord() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setBankFooterRecord("footer");
	        assertTrue(card.getBankFooterRecord() == "footer");
	        
	    }
	 
	   @Test
	    public void testGetBankFooterRecord() {
		   BankTxnRecordRes card = new BankTxnRecordRes();
	        card.setBankFooterRecord("footer");
	        assertTrue(card.getBankFooterRecord() == "footer");
	    }*/
}
