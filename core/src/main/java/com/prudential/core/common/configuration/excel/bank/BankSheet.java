package com.prudential.core.common.configuration.excel.bank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.prudential.core.common.configuration.excel.Sheet;


public final class BankSheet extends Sheet{
	
	private static final String CONFIG_TABLE_NAME = "bank_config";
	
	private Map<String,Cell> srcRules = new LinkedHashMap<String, Cell>();

	public BankSheet(XSSFWorkbook workbook,FormulaEvaluator evaluator, XSSFSheet sheet) {
		super(workbook,evaluator,sheet);
	}
	
	protected String getConfigName(){
		return CONFIG_TABLE_NAME;
	}
	
	protected void processConfigRow(String colName, Cell rowCell, List<String> validationMessages){	
		if(colName.toLowerCase().endsWith("rule")){
			srcRules.put(colName,rowCell);
		}
	}
	
	protected String[] executeRoutingRules(){
		CellValue cellValue = evaluator.evaluate(srcRules.values().iterator().next());
		String val = cellValue != null ? cellValue.getStringValue() : null;
		return val != null ? val.split(",") : null;
	}
	
	static boolean isBankConfig(XSSFSheet sheet){
		List<XSSFTable> tables = sheet.getTables();
		for(int i=0;i<tables.size();i++){
			if(tables.get(i).getName().contains(CONFIG_TABLE_NAME))
				return true;
		}
		return false;
	}
}
