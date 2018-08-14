package com.prudential.cbi.dao;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prudential.core.cbi.model.FileAudit;
@Repository
public interface FileAuditRepository extends CrudRepository<FileAudit, Long>, QueryDslPredicateExecutor<FileAudit> {

}
