package com.prudential.core.common.configuration.excel;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ValidationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String NEWLINE = "\r\n";
	private Map<String,List<String>> msgs = null;
	
	public ValidationException(Map<String,List<String>> msgs){
		this.msgs = msgs;
	}
	
	public ValidationException(String message){
		 msgs = Collections.singletonMap("workbook",Collections.singletonList(message));
	}
	
	public Map<String,List<String>> getMessages(){
		return msgs;
	}
	
	public String getMessage(){
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,List<String>> entry : msgs.entrySet()){
			sb.append(NEWLINE);
			sb.append("Validation Failures in sheet:" + entry.getKey());
			sb.append(NEWLINE);
			List<String> validationFailureMessages = entry.getValue();
			for(int i=0;i<validationFailureMessages.size();i++){
				sb.append(">>").append(validationFailureMessages.get(i));
				sb.append(NEWLINE);
			}
		}
		return sb.toString();
	}
	
	public String toString(){
		return getMessage();
	}
}
