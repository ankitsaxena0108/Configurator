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
import com.prudential.core.cbi.services.rs.CBIConfigRs;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CBIConfigRsClassTest {

	
	 @Test
	    public void testSetCategory() {
		 CBIConfigRs card = new  CBIConfigRs();
	        card.setCategory("category");
	        assertEquals(card.getCategory(), "category");
	        
	    }
	 
	   @Test
	    public void testGetCBICategory() {
		   CBIConfigRs card = new  CBIConfigRs();
	        card.setCategory("category");
	        assertEquals(card.getCategory(), "category");
	    }
	   
		 @Test
		    public void testSetFileName() {
			 CBIConfigRs card = new  CBIConfigRs();
		        card.setFileName("fileName");
		        assertEquals(card.getFileName(), "fileName");
		        
		    }
		 
		   @Test
		    public void testGetFileName() {
			   CBIConfigRs card = new  CBIConfigRs();
		        card.setFileName("fileName");
		        assertEquals(card.getFileName(), "fileName");
		    }
		   
		   @Test
		    public void testSetOtherDetails() {
			 CBIConfigRs card = new  CBIConfigRs();
		        card.setOtherDetails("otherDetails");
		        assertEquals(card.getOtherDetails(), "otherDetails");
		        
		    }
		 
		   @Test
		    public void testGetOtherDetails() {
			   CBIConfigRs card = new  CBIConfigRs();
		        card.setOtherDetails("otherDetails");
		        assertEquals(card.getOtherDetails(), "otherDetails");
		    }
		   
		   @Test
		    public void testSetScheduleInfo() {
			 CBIConfigRs card = new  CBIConfigRs();
		        card.setScheduleInfo("scheduleInfo");
		        assertEquals(card.getScheduleInfo(), "scheduleInfo");
		        
		    }
		 
		   @Test
		    public void testGetScheduleInfo() {
			   CBIConfigRs card = new  CBIConfigRs();
		        card.setScheduleInfo("scheduleInfo");
		        assertEquals(card.getScheduleInfo(), "scheduleInfo");
		    }
		   
		   @Test
		    public void testSetCbiConfigDetails() {
			 CBIConfigRs card = new  CBIConfigRs();
		        card.setCbiConfigDetails("cbiConfigDetails");
		        assertEquals(card.getCbiConfigDetails(), "cbiConfigDetails");
		        
		    }
		 
		   @Test
		    public void testGetCbiConfigDetails() {
			   CBIConfigRs card = new  CBIConfigRs();
		        card.setCbiConfigDetails("cbiConfigDetails");
		        assertEquals(card.getCbiConfigDetails(), "cbiConfigDetails");
		    }
}
