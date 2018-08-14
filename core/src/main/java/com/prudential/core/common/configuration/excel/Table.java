package com.prudential.core.common.configuration.excel;

public class Table {
		
	static final Table EMPTY_TABLE = new Table(new String[0],new String[0]);

	private String[] colNames;
	private String[] formulae;
	
	Table(String[] colNames, String[] formulae){
		this.colNames = colNames;
		this.formulae = formulae;
	}
	
	public String[] getColumns(){
		return colNames;
	}
	
	public String[] getRow(){
		return formulae;
	}
}
