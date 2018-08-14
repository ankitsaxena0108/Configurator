package com.prudential.cbi;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.cbi.model.BankTxnRecord;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTxnRecordClassTest {

	
	
	 @Test
	    public void testSetAcctNo() {
		 BankTxnRecord card = new BankTxnRecord();
	        card.setAcctNo("121");
	        assertEquals(card.getAcctNo(), "121");
	        
	    }
	 
	   @Test
	    public void testGetAcctNo() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setAcctNo("321");
	        assertEquals(card.getAcctNo(), "321");
	    }
	 
	   
	   
	   @Test
	    public void testSetAuditId() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setAuditId(1L);
	        assertTrue(card.getAuditId() == 1L);
	        
	    }
	 
	   @Test
	    public void testGetAuditId() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setAuditId(1L);
	        assertTrue(card.getAuditId() == 1L);
	    }
	   
	   
	   @Test
	    public void testSetBankCode() {
		 BankTxnRecord card = new BankTxnRecord();
	        card.setBankCode("xxxx");
	        assertEquals(card.getBankCode(), "xxxx");
	        
	    }
	 
	   @Test
	    public void testGetBankCode() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setBankCode("xxxx");
	        assertEquals(card.getBankCode(), "xxxx");
	    }
	 
	   
	   
	   @Test
	    public void testSetBankDetailRecord() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setBankDetailRecord("record");
	        assertTrue(card.getBankDetailRecord() == "record");
	        
	    }
	 
	   @Test
	    public void testGetBankDetailRecord() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setBankDetailRecord("record");
	        assertTrue(card.getBankDetailRecord() == "record");
	    }
	   
	   
	 /*  @Test
	    public void testSetBankFooterRecord() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setBankFooterRecord("footer");
	        assertTrue(card.getBankFooterRecord() == "footer");
	        
	    }
	 
	   @Test
	    public void testGetBankFooterRecord() {
		   BankTxnRecord card = new BankTxnRecord();
	        card.setBankFooterRecord("footer");
	        assertTrue(card.getBankFooterRecord() == "footer");
	    }*/
	/*    @Test
	    public void testGetAmount() {
	    	 BankTxnRecord card = new BankTxnRecord();
	        card.setAmount( new BigDecimal(0.01));
	        assertEquals(card.getAmount(),0.01);
	    }
	     
	    @Test
	    public void testSetAmount(){
	    	 BankTxnRecord card = new BankTxnRecord();
	    	 card.setAmount( new BigDecimal(0.01));
		        assertEquals(card.getAmount(),0.01);
		        
	    }*/
	     
	    
}
