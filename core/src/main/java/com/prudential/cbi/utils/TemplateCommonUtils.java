package com.prudential.cbi.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import com.prudential.core.cbi.model.BankTxnRecord;

public class TemplateCommonUtils {
	
	public static final String ZERO = "0";
	public static final String SPACE = " ";
	private static final SimpleDateFormat timeformatter = new SimpleDateFormat("yyyyMMddHHmmss");
	
	

	 //Get Formatted balance
	 public String getFormattedAmount(BigDecimal amount,int length)
	 {
		return null;
	 }	
	
	 
	 //get footer checkSum
	 public String getFooterCheckSum()
	 {
		 return null;
		 
	 }
	 
	
	 //fill the field with filler value on left =1 and right =0
	public String appendValues(String filler,String value,int length,int right)
	 {
		if(value==null || value.isEmpty())
		{
			value=filler;
		}
		 String paddingValue=filler;
		 for(int i=0;i<length-1;i++)
			 filler=filler+paddingValue;
		 if(right==0)
			 value = value+filler.substring(value.length());
			 else
			 value= filler.substring(value.length())+value;
		 return value;
	 }
	
	
	public String getFormattedDate(String date)
	 {
		 return timeformatter.format(date).substring(0, 8);
	 }

	
	public static BankTxnRecord getSystemGeneratedTxnRecordValues(BankTxnRecord txnRecord)
	{
		
		return txnRecord;
		
	}
}
