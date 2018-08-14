package com.prudential.core.common.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prudential.core.common.ErrorMessage;

@Repository
public interface ErrorRepository extends CrudRepository<ErrorMessage, Long>{
	
	public ErrorMessage findOneByErrorCodeAndLocale_LocaleId(String errorCode, long localeId);

}
