package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.cbi.utils.TemplateCommonUtils;
import com.prudential.core.cbi.model.BankTxnRecord;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TemplateCommonUtilsTest {

	
	
	  @Test
	    public void testGetFormattedDate() {
		  /*TemplateCommonUtils card = new TemplateCommonUtils();
	      String value =  card.getFormattedDate("20140430193247");
	        assertEquals(value, value);*/
	        
	    }
	 
	  /* @Test
	    public void testAppendValues() {
		 
	    }*/
	   
	   
	   @Test
	    public void testGetSystemGeneratedTxnRecordValues() {
		   TemplateCommonUtils card = new TemplateCommonUtils();
		   BankTxnRecord bank =new BankTxnRecord();
		   bank.setAcctNo("123");
		   card.getSystemGeneratedTxnRecordValues(bank);
		   assertEquals(bank.getAcctNo(), "123");
	   }
}
