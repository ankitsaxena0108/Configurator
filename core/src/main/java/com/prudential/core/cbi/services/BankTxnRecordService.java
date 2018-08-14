package com.prudential.core.cbi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prudential.core.common.dao.BankTxnCRUDRepository;

@Service
public class BankTxnRecordService {

	@Autowired
	private BankTxnCRUDRepository bankTxnCRUDRepository;
	

}
