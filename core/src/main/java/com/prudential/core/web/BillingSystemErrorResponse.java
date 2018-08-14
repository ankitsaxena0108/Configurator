package com.prudential.core.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.prudential.core.common.BillingSystemException;
import com.prudential.core.common.service.ErrorService;

public class BillingSystemErrorResponse extends BillingSystemResponse {
	private HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
	private String errorCode;
	private String errorMsg;
	private Object[] params;
	private Map<String, List<String>> validationMessages;
	public static String NEWLINE = System.getProperty("line.separator");
	public static final String EMTY_STRING="";
	public BillingSystemErrorResponse(ErrorService errorService, BillingSystemException basException) {
		this.params = basException.getParams();

		if (params == null) {
			params = new Object[0];
		}

		if (basException.getValidationMessages() == null
				|| (basException.getValidationMessages() != null && basException.getValidationMessages().size() == 0)) {

			this.errorCode = basException.getErrorCode();

			this.errorMsg = errorService.getLocalizedMessage(errorCode, params);

		} else {
			while (basException.getValidationMessages().keySet().iterator().hasNext()) {
				this.errorCode = basException.getValidationMessages().keySet().iterator().next();
				break;
			}

			if (basException.getValidationMessages().containsKey(this.errorCode)) {
				List<String> errorMsgList = basException.getValidationMessages().get(this.errorCode);
				String concatErrorMsg = EMTY_STRING;
				String resultString=EMTY_STRING;
				resultString=resultString+NEWLINE;
				for (int count = 1; count <= errorMsgList.size(); count++) {
					resultString=resultString+String.valueOf(count)+":"+errorMsgList.get(count-1);
					if(errorMsgList.size()!=count) {
						resultString=resultString.concat(",");
					}
				}
				this.errorMsg = resultString;
			}

			this.validationMessages = basException.getValidationMessages();
		}

	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public Map<String, List<String>> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(Map<String, List<String>> validationMessages) {
		this.validationMessages = validationMessages;
	}

}
