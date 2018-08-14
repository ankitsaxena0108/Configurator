package com.prudential.cbi;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.cbi.audit.AuditObject;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditObjectClassTest {

	

	 @Test
	    public void testSetCategoryo() {
		 AuditObject card = new  AuditObject();
	        card.setCategory("category");
	        assertEquals(card.getCategory(), "category");
	        
	    }
	 
	   @Test
	    public void testGetCategory() {
		   AuditObject card = new  AuditObject();
	        card.setCategory("category");
	        assertEquals(card.getCategory(), "category");
	    }
	   

		 @Test
		    public void testSetFileDirection() {
			 AuditObject card = new  AuditObject();
		        card.setFileDirection("fileDirection");
		        assertEquals(card.getFileDirection(), "fileDirection");
		        
		    }
		 
		   @Test
		    public void testGetFileDirection() {
			   AuditObject card = new  AuditObject();
		        card.setFileDirection("fileDirection");
		        assertEquals(card.getFileDirection(), "fileDirection");
		    }
		   
		   @Test
		    public void testSetFromDate() {
			 AuditObject card = new  AuditObject();
		        card.setFromDate("14/11/2014");
		        assertEquals(card.getFromDate(), "14/11/2014");
		        
		    }
		 
		   @Test
		    public void testGetFromDate() {
			   AuditObject card = new  AuditObject();
		        card.setFromDate("14/11/2014");
		        assertEquals(card.getFromDate(), "14/11/2014");
		    }
	 
		   @Test
		    public void testSetName() {
			 AuditObject card = new  AuditObject();
		        card.setName("name");
		        assertEquals(card.getName(), "name");
		        
		    }
		 
		   @Test
		    public void testGetName() {
			   AuditObject card = new  AuditObject();
		        card.setName("name");
		        assertEquals(card.getName(), "name");
		    }
		   
		   @Test
		    public void testSetPaymentType() {
			 AuditObject card = new  AuditObject();
		        card.setPaymentType("paymentType");
		        assertEquals(card.getPaymentType(), "paymentType");
		        
		    }
		 
		   @Test
		    public void testGetPaymentType() {
			   AuditObject card = new  AuditObject();
		        card.setPaymentType("paymentType");
		        assertEquals(card.getPaymentType(), "paymentType");
		    }
		   
		   @Test
		    public void testSetStatus() {
			 AuditObject card = new  AuditObject();
		        card.setStatus("status");
		        assertEquals(card.getStatus(), "status");
		        
		    }
		 
		   @Test
		    public void testGetStatus() {
			   AuditObject card = new  AuditObject();
		        card.setStatus("status");
		        assertEquals(card.getStatus(), "status");
		    }
		   
		   @Test
		    public void testSetToDate() {
			 AuditObject card = new  AuditObject();
		        card.setToDate("15/04/15");
		        assertEquals(card.getToDate(), "15/04/15");
		        
		    }
		 
		   @Test
		    public void testGetToDate() {
			   AuditObject card = new  AuditObject();
		        card.setToDate("15/04/15");
		        assertEquals(card.getToDate(), "15/04/15");
		    }
		   
		  /* @Test
		    public void testSetAuditsummary() {
			 AuditObject card = new  AuditObject();
			 Auditsummary audit =new Auditsummary();
			 
			 audit.setFileName("file");
			 Auditsummary []auditt = {audit};
		        card.setAuditsummary(auditt);
		        Auditsummary[] summm = card.getAuditsummary();
		        assertEquals(card.getAuditsummary(), "15/04/15");
		        
		    }
		 
		   @Test
		    public void testGetAuditsummary() {
			   AuditObject card = new  AuditObject();
				 Auditsummary audit =new Auditsummary();
				 
				 audit.setFileName("file");
				 Auditsummary []auditt = {audit};
			        card.setAuditsummary(auditt);
			        Auditsummary[] summm = card.getAuditsummary();
			        assertEquals(card.getAuditsummary(), "15/04/15");
		    }*/
		   
}
