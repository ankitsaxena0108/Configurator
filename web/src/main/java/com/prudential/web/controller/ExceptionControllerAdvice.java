package com.prudential.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prudential.core.common.BillingSystemException;
import com.prudential.core.common.service.ErrorService;
import com.prudential.core.web.BillingSystemErrorResponse;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
    @Autowired(required=false)
    private ErrorService errorService;
	
	@ExceptionHandler(BillingSystemException.class)
    public ResponseEntity<BillingSystemErrorResponse> handleBASException(BillingSystemException bsException) {
	    BillingSystemErrorResponse errorResponse = new BillingSystemErrorResponse(errorService, bsException);
        return new ResponseEntity<BillingSystemErrorResponse>(errorResponse, errorResponse.getHttpStatus());
    }
}
