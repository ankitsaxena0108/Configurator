package com.prudential.core.common.configuration.excel;

import java.util.HashMap;
import java.util.Map;

public final class Response {

	private String name;
	private boolean isValid = true;
	private Output out = new Output();
	private Map<String,Object> computedValues = new HashMap<String, Object>(8);
	private boolean isDetail = true;
	private boolean isHeader;
	private boolean isFooter;
	
	Response(String name, Map<String,Object> initVars){
		this.name = name;
		if(initVars != null)
			computedValues.putAll(initVars);
	}
	
	void addComputedValue(String name, Object value){
		computedValues.put(name, value);
	}
	
	public Map<String,Object> getComputedValues(){
		return computedValues;
	}
	
	public String getName(){
		return name;
	}
	
	public Output getOutput(){
		return out;
	}
	
	public boolean isHeader(){
		return isHeader;
	}
	
	public boolean isDetail(){
		return isDetail;
	}
	
	public boolean isFooter(){
		return isFooter;
	}
	
	public void setValid(boolean isValid){
		this.isValid = isValid;
	}
	
	public boolean isValid(){
		return isValid;
	}
	
	void setHeader(){
		this.isHeader = true;
		this.isDetail = false;
	}
	
	void setFooter(){
		this.isFooter = true;
		this.isDetail = false;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		if(isValid){
			if(computedValues.size() > 0){
				sb.append(" ").append(computedValues);
			}
			sb.append(" ").append(out);
		}else{
			sb.append(":Invalid");
		}
		return sb.toString();
	}
	
	public static final class Output {
		
		private String name;
		private String fileName;
		private String headerRow;
		private String detailRow;
		private String footerRow;
		
		private int currBatchNo;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public boolean isAvailable(){
			return name != null;
		}
		
		public String getFileName() {
			return fileName;
		}
		
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		
		public String getHeaderRow() {
			return headerRow;
		}
		
		public void setHeaderRow(String headerRow) {
			this.headerRow = headerRow;
		}
		
		public String getDetailRow() {
			return detailRow;
		}
		
		public void setDetailRow(String detailRow) {
			this.detailRow = detailRow;
		}
		
		public String getFooterRow() {
			return footerRow;
		}
		
		public void setFooterRow(String footerRow) {
			this.footerRow = footerRow;
		}
		
		public int getCurrBatch(){
			return currBatchNo;
		}
		
		public void setCurrBatch(int batchNo){
			this.currBatchNo = batchNo;
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("out:");
			if(name != null)
				sb.append(name);
			if(fileName != null){
				sb.append("[file:").append(fileName).append("]");
			}
			sb.append("[batch:").append(currBatchNo).append("]");
			if(headerRow != null){
				sb.append("[hdr:").append(headerRow).append("]");
			}if(detailRow != null){
				sb.append("[det:").append(detailRow).append("]");
			}if(footerRow != null){
				sb.append("[ftr:").append(footerRow).append("]");
			}
			return sb.toString();
		}
	}
}
