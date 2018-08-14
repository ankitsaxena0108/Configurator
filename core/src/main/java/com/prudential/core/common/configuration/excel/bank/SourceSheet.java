package com.prudential.core.common.configuration.excel.bank;

import java.util.HashMap;
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



public final class SourceSheet extends Sheet{
	
	private static final String CONFIG_TABLE_NAME = "src_config";
	
	private Map<String,Cell> bankRules = new LinkedHashMap<String, Cell>();
	
	public SourceSheet(XSSFWorkbook workbook,FormulaEvaluator evaluator, XSSFSheet sheet){
		super(workbook,evaluator,sheet);
	}
	
	protected String getConfigName(){
		return CONFIG_TABLE_NAME;
	}	
	
	protected void processConfigRow(String colName, Cell rowCell, List<String> validationMessages){	
		if(colName.toLowerCase().endsWith("rule")){
			bankRules.put(colName,rowCell);
		}
	}
		
	static boolean isSourceConfig(XSSFSheet sheet){
		List<XSSFTable> tables = sheet.getTables();
		for(int i=0;i<tables.size();i++){
			if(tables.get(i).getName().contains(CONFIG_TABLE_NAME))
				return true;
		}
		return false;
	}
	
	protected String[] executeRoutingRules(){
		/*String category = null;
		Cell categoryRule = bankRules.get(category);
		
		Cell paymentModeRule = null;
		Cell bankRule = null;
		String banks = null;
		if(categoryRule != null){
			CellValue cellValue = evaluator.evaluate(categoryRule);
			String paymentMode = cellValue != null ? cellValue.getStringValue() : null;
			paymentModeRule = bankRules.get(paymentMode);
		}
		if(paymentModeRule != null){
			CellValue cellValue = evaluator.evaluate(paymentModeRule);
			String bankRuleName = cellValue != null ? cellValue.getStringValue() : null;
			bankRule = bankRules.get(bankRuleName);
		}
		if(bankRule != null){
			CellValue cellValue = evaluator.evaluate(bankRule);
			banks = cellValue != null ? cellValue.getStringValue() : null;
		}
		return null;*/
		
		CellValue cellValue = evaluator.evaluate(bankRules.values().iterator().next());
		String val = cellValue != null ? cellValue.getStringValue() : null;
		return val != null ? val.split(",") : null;
	}
}
