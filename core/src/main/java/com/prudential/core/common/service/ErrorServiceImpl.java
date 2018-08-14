package com.prudential.core.common.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prudential.core.common.ErrorMessage;
import com.prudential.core.common.LocaleRepository;
import com.prudential.core.common.dao.ErrorDAO;
import com.prudential.core.common.locale.Locale;
import com.prudential.core.users.UserService;
import com.prudential.core.users.UsersException;

@Service
public class ErrorServiceImpl implements ErrorService {
	
    private static final Logger logger = LoggerFactory.getLogger(ErrorServiceImpl.class);


	@Autowired
	private ErrorDAO errorDAO;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocaleRepository localeRepository;

	@Override
	@Transactional(readOnly = true)
	public String getLocalizedMessage(String errorCode, Object... params) {
		try {
			long localeId = userService.currentLocaleId();
	        return getLocalizedMessage(errorCode, localeId, params);

		} catch (UsersException e) {
			Locale first = localeRepository.findAll().iterator().next();
			return getLocalizedMessage(errorCode, first.getLocaleId(), params);
		}
	}
	
	private String getLocalizedMessage(String errorCode, long localeId, Object... params) {
		ErrorMessage errorMessage = errorDAO.errorMessage(errorCode, localeId);
		String message = MessageFormat.format(errorMessage.getErrorMessage(), params);
        logger.warn(message);
        return message;
	}
}
