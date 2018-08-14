package com.prudential.core.common;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prudential.core.common.locale.Locale;

@Repository
public interface LocaleRepository extends CrudRepository<Locale, Long>{
	public Locale findByLanguageAndCountry(String language, String country);
}
