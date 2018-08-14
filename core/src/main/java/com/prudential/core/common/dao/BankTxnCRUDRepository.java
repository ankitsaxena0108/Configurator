package com.prudential.core.common.dao;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.model.FileAudit;

@Repository
public interface BankTxnCRUDRepository extends CrudRepository<BankTxnRecord, Long>, QueryDslPredicateExecutor<BankTxnRecord>  {


	
}