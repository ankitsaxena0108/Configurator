package com.prudential.core.common.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prudential.core.cbi.model.CBIConfig;

@Repository
public interface CBIConfigRepository extends CrudRepository<CBIConfig, Long> {
	public CBIConfig findByCategory(String category);
	

}
