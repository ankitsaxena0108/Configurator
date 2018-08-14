package com.prudential.core.common.configuration.excel;

public final class Aggregate {
	
	private int batchSize;
	private int currCount;
	private int currBatchCount;	
	private boolean isAddHeader;
	private boolean isAddFooter;
	private String fileName;
	
	Aggregate(int batchSize, int startBatchNo){
		this.batchSize = batchSize;
		this.currBatchCount = startBatchNo;
	}
	
	public void incrementRowCount(){
		if(currCount == 0){
			isAddFooter = false;
			isAddHeader = true;
		}else{
			isAddHeader = false;
		}
		currCount++;
		if(batchSize > 0 && currCount == batchSize){
			isAddFooter = true;
			currBatchCount++;
			currCount = 0;
		}
	}
	
	public int getCurrCount(){
		return currCount;
	}
	
	public int getCurrBatchCount(){
		return currBatchCount;
	}
	
	public boolean isAddHeader(){
		return isAddHeader;
	}

	public boolean isAddFooter(){
		return isAddFooter;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	void setFileName(String fileName){
		this.fileName = fileName;
	}
}
