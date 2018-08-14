package com.prudential.core.common;

public class ErrorCode {

    private String errorCode;
    private String logMessage;
    
    // Core Related
    public static final ErrorCode CORE_1000 = new ErrorCode("1000", "Server side error - unable to determine current user");
    public static final ErrorCode CORE_1001 = new ErrorCode("1001", "Validation errors [%s]");
    public static final ErrorCode CORE_1002 = new ErrorCode("1002", "File Upload Error [%s]");
    public static final ErrorCode CORE_1003 = new ErrorCode("1003", "File Read Error [%s]");
    
  
    
    // Users Related
    public static final ErrorCode USER_9000 = new ErrorCode("9000", "Role Exists");
	public static final ErrorCode USER_9001 = new ErrorCode("9001", "User by this login Exists");
	public static final ErrorCode USER_9002 = new ErrorCode("9002", "User linked to Agencies");

	
	
	
	
	

    public ErrorCode(String errorCode, String logMessage) {
        super();
        this.errorCode = errorCode;
        this.logMessage = logMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getLogMessage() {
        return logMessage;
    }
}
