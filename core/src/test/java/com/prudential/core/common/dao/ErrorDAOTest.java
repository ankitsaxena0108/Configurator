package com.prudential.core.common.dao;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prudential.JUnitCoreConfiguration;
import com.prudential.core.common.ErrorMessage;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorDAOTest {

	@Autowired
	ErrorDAO errorDAO;
	
	@Test
	public void errorMessage() {
		

		ErrorMessage errorMessage = errorDAO.errorMessage("1000",1L);
		assertEquals("Server side error, Contact Administrator", errorMessage.getErrorMessage());

	}

}
