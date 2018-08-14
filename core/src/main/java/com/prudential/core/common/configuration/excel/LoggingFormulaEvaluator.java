package com.prudential.core.common.configuration.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggingFormulaEvaluator extends WrappedFormulaEvaluator{

	private static Logger logger = LoggerFactory.getLogger(LoggingFormulaEvaluator.class);
	
	public LoggingFormulaEvaluator(FormulaEvaluator evaluator) {
		super(evaluator);
	}
	
	public CellValue evaluate(Cell cell) {
		try{
			CellValue val = super.evaluate(cell);
			if(val != null && val.getCellTypeEnum() == CellType.ERROR){
				if(logger.isErrorEnabled())
					logger.error("Evaluated invalid value in cell:" + cell.getAddress() + " cell:" + cell);
			}else{
				if(logger.isDebugEnabled())
					logger.info("Evaluated cell:" + cell.getAddress() + " value:" + (val != null ? val.formatAsString() : "null"));
			}
			return val;
		}catch(RuntimeException e){
			logger.error("Exception evaluating cell:" + cell.getAddress() + ":" + cell,e);
			throw e;
		}
	}
}
