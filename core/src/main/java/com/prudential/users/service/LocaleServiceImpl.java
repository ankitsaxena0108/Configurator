package com.prudential.users.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prudential.core.common.locale.Locale;
import com.prudential.core.common.locale.LocaleService;
import com.prudential.core.users.UsersException;
import com.prudential.core.users.model.User;
import com.prudential.users.da.UserDAO;

@Service
public class LocaleServiceImpl implements LocaleService {

	private static final Logger LOG = LoggerFactory.getLogger(LocaleServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;

	public Locale currentLocale() {
		Locale currentLocale = null;
		try {
			User loggedInUser = userDAO.currentUser();
			currentLocale = loggedInUser.getLocale();
		} catch (UsersException e) {
			LOG.warn("Failed to find current user, defaulting to US locale", e);
			currentLocale = new Locale(java.util.Locale.US);
		}
		
		return currentLocale;
	}
	

}
