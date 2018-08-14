package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.cbi.audit.Auditsummary;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditsummaryClassTest {

	
	 @Test
	    public void testSetFailedCount() {
		 Auditsummary card = new  Auditsummary();
	        card.setFailedCount("failedCount");
	        assertEquals(card.getFailedCount(), "failedCount");
	        
	    }
	 
	   @Test
	    public void testGetCategory() {
		   Auditsummary card = new  Auditsummary();
	        card.setFailedCount("failedCount");
	        assertEquals(card.getFailedCount(), "failedCount");
	    }
	   
	   @Test
	    public void testSetFileDirection() {
		 Auditsummary card = new  Auditsummary();
	        card.setFileDirection("fileDirection");
	        assertEquals(card.getFileDirection(), "fileDirection");
	        
	    }
	 
	   @Test
	    public void testGetFileDirection() {
		   Auditsummary card = new  Auditsummary();
	        card.setFileDirection("fileDirection");
	        assertEquals(card.getFileDirection(), "fileDirection");
	    }
	   
	   @Test
	    public void testSetFileName() {
		 Auditsummary card = new  Auditsummary();
	        card.setFileName("FileName");
	        assertEquals(card.getFileName(), "FileName");
	        
	    }
	 
	   @Test
	    public void testGetFileName() {
		   Auditsummary card = new  Auditsummary();
	        card.setFileName("FileName");
	        assertEquals(card.getFileName(), "FileName");
	    }
	   
	   @Test
	    public void testSetId() {
		 Auditsummary card = new  Auditsummary();
	        card.setId("1");
	        assertEquals(card.getId(), "1");
	        
	    }
	 
	   @Test
	    public void testGetId() {
		   Auditsummary card = new  Auditsummary();
	        card.setId("1");
	        assertEquals(card.getId(), "1");
	    }
	   
	   @Test
	    public void testSetPaymentType() {
		 Auditsummary card = new  Auditsummary();
	        card.setPaymentType("paymentType");
	        assertEquals(card.getPaymentType(), "paymentType");
	        
	    }
	 
	   @Test
	    public void testGetPaymentType() {
		   Auditsummary card = new  Auditsummary();
	        card.setPaymentType("paymentType");
	        assertEquals(card.getPaymentType(), "paymentType");
	    }
	   
	   @Test
	    public void testSetStartDateTime() {
		 Auditsummary card = new  Auditsummary();
	        card.setStartDateTime("12/12/2012");
	        assertEquals(card.getStartDateTime(), "12/12/2012");
	        
	    }
	 
	   @Test
	    public void testGetStartDateTime() {
		   Auditsummary card = new  Auditsummary();
	        card.setStartDateTime("12/12/2012");
	        assertEquals(card.getStartDateTime(), "12/12/2012");
	    }
	   
	   @Test
	    public void testSetEndDateDateTime() {
		   Auditsummary card = new  Auditsummary();
	        card.setEndDateDateTime("12/12/2014");
	        assertEquals(card.getEndDateDateTime(), "12/12/2014");
	        
	    }
	 
	   @Test
	    public void testGetEndDateDateTime() {
		   Auditsummary card = new  Auditsummary();
	        card.setEndDateDateTime("12/12/2014");
	        assertEquals(card.getEndDateDateTime(), "12/12/2014");

	   }

	   @Test
	    public void testSetStatus() {
		   Auditsummary card = new  Auditsummary();
	        card.setStatus("status");
	        assertEquals(card.getStatus(), "status");
	        
	    }
	 
	   @Test
	    public void testGetStatus() {
		   Auditsummary card = new  Auditsummary();
	        card.setStatus("status");
	        assertEquals(card.getStatus(), "status");
	    }
	   
	   @Test
	    public void testSetSuccessCount() {
		   Auditsummary card = new  Auditsummary();
	        card.setSuccessCount("5");
	        assertEquals(card.getSuccessCount(), "5");
	        
	    }
	 
	   @Test
	    public void testGetSuccessCount() {
		   Auditsummary card = new  Auditsummary();
	        card.setSuccessCount("5");
	        assertEquals(card.getSuccessCount(), "5");
	    }
}
