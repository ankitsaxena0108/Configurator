package com.prudential.core.cbi.configurations;

import java.util.List;

import com.prudential.core.cbi.sourcesystem.SourceSystemConfig;



public class CommonBankingInterfaceConfig {

	String sourceFeedProcessingPollingInterval;
	String bankResponseProcessingPollingInterval;
	String sourceInwardRootFolder;
	String bankInwardRootFolder;
	String sourceOutwardRootFolder;
	String bankOutwardRootFolder;
	
	List<BankConfig> Banks;
	List<SourceSystemConfig> sourceSystems;

	
	public String getSourceFeedProcessingPollingInterval() {
		return sourceFeedProcessingPollingInterval;
	}
	public void setSourceFeedProcessingPollingInterval(String sourceFeedProcessingPollingInterval) {
		this.sourceFeedProcessingPollingInterval = sourceFeedProcessingPollingInterval;
	}
	public String getBankResponseProcessingPollingInterval() {
		return bankResponseProcessingPollingInterval;
	}
	public void setBankResponseProcessingPollingInterval(String bankResponseProcessingPollingInterval) {
		this.bankResponseProcessingPollingInterval = bankResponseProcessingPollingInterval;
	}

	public String getBankInwardRootFolder() {
		return bankInwardRootFolder;
	}
	public void setBankInwardRootFolder(String bankInwardRootFolder) {
		this.bankInwardRootFolder = bankInwardRootFolder;
	}
	public String getSourceOutwardRootFolder() {
		return sourceOutwardRootFolder;
	}
	public void setSourceOutwardRootFolder(String sourceOutwardRootFolder) {
		this.sourceOutwardRootFolder = sourceOutwardRootFolder;
	}
	public String getBankOutwardRootFolder() {
		return bankOutwardRootFolder;
	}
	public void setBankOutwardRootFolder(String bankOutwardRootFolder) {
		this.bankOutwardRootFolder = bankOutwardRootFolder;
	}
	public List<BankConfig> getBanks() {
		return Banks;
	}
	public void setBanks(List<BankConfig> banks) {
		Banks = banks;
	}
	public List<SourceSystemConfig> getSourceSystems() {
		return sourceSystems;
	}
	public void setSourceSystems(List<SourceSystemConfig> sourceSystems) {
		this.sourceSystems = sourceSystems;
	}
	public String getSourceInwardRootFolder() {
		return sourceInwardRootFolder;
	}
	public void setSourceInwardRootFolder(String sourceInwardRootFolder) {
		this.sourceInwardRootFolder = sourceInwardRootFolder;
	}
	
	
}
