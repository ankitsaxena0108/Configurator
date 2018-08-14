package com.prudential.core.common.service;

public interface ErrorService {

    public String getLocalizedMessage(String errorCode,Object ... params);
}
