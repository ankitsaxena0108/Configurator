package com.prudential.core.common.locale;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prudential.core.common.dao.GenericDAO;


@Service("codeListDAO")
@SuppressWarnings("unchecked")
public class CodeListDAO extends GenericDAO{

	
	
	public List<CodeDetail> findAll(long locale)
	{
		
		String QUERY = " SELECT DISTINCT p FROM CodeDetail p JOIN FETCH  p.codeList  list where list.localeId=:localeId";
		return em
				.createQuery(QUERY).setParameter("localeId", locale).getResultList();
		
	}
	
	
	
	public List<CodeDetail> findByCode(long locale,String code)
	{
		String QUERY = " SELECT DISTINCT p FROM CodeDetail p JOIN FETCH  p.codeList  list where list.localeId=:localeId AND p.code=:code";
		return em
				.createQuery(QUERY).setParameter("localeId", locale).
				setParameter("code", code).
				getResultList();
	}
}
