package com.prudential.core.common.configuration.excel;

/**
 * Configuration for Source system or bank
 * 
 * @author sajal.gupta
 *
 */
public final class EndpointConfig {

	private Table configTable;
	
	private Table inComputeDetTable;
	private Table inComputeHdrTable;
	private Table inComputeFtrTable;
	
	private Table outComputeDetTable;
	private Table outComputeHdrTable;
	private Table outComputeFtrTable;
	
	private Table outTable;

	public Table getConfigTable() {
		return configTable;
	}

	void setConfigTable(Table configTable) {
		this.configTable = configTable;
	}

	public Table getInComputeDetTable() {
		return inComputeDetTable;
	}

	void setInComputeDetTable(Table inComputeDetTable) {
		this.inComputeDetTable = inComputeDetTable;
	}

	public Table getInComputeHdrTable() {
		return inComputeHdrTable;
	}

	void setInComputeHdrTable(Table inComputeHdrTable) {
		this.inComputeHdrTable = inComputeHdrTable;
	}

	public Table getInComputeFtrTable() {
		return inComputeFtrTable;
	}

	void setInComputeFtrTable(Table inComputeFtrTable) {
		this.inComputeFtrTable = inComputeFtrTable;
	}

	public Table getOutComputeDetTable() {
		return outComputeDetTable;
	}

	void setOutComputeDetTable(Table outComputeDetTable) {
		this.outComputeDetTable = outComputeDetTable;
	}

	public Table getOutComputeHdrTable() {
		return outComputeHdrTable;
	}

	void setOutComputeHdrTable(Table outComputeHdrTable) {
		this.outComputeHdrTable = outComputeHdrTable;
	}

	public Table getOutComputeFtrTable() {
		return outComputeFtrTable;
	}

	void setOutComputeFtrTable(Table outComputeFtrTable) {
		this.outComputeFtrTable = outComputeFtrTable;
	}

	public Table getOutTable() {
		return outTable;
	}

	void setOutTable(Table outTable) {
		this.outTable = outTable;
	}
}
