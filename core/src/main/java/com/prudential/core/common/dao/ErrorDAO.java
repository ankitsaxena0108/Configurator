package com.prudential.core.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prudential.core.common.ErrorMessage;

@Service
public class ErrorDAO {
	
	@Autowired
	private ErrorRepository errorRepository;
	
	public ErrorMessage errorMessage(String errorCode, long localeId) {
		return errorRepository.findOneByErrorCodeAndLocale_LocaleId(errorCode, localeId);
	}

}
