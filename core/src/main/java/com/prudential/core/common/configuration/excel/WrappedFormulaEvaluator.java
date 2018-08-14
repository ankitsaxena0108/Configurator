package com.prudential.core.common.configuration.excel;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public abstract class WrappedFormulaEvaluator implements FormulaEvaluator{
	
	private FormulaEvaluator evaluator;
	
	public WrappedFormulaEvaluator(FormulaEvaluator evaluator){
		this.evaluator = evaluator;
	}

	public void clearAllCachedResultValues() {
		evaluator.clearAllCachedResultValues();
	}

	public void notifySetFormula(Cell cell) {
		evaluator.notifySetFormula(cell);
	}

	public void notifyDeleteCell(Cell cell) {
		evaluator.notifyDeleteCell(cell);
	}

	public void notifyUpdateCell(Cell cell) {
		evaluator.notifyUpdateCell(cell);
	}

	public void evaluateAll() {
		evaluator.evaluateAll();
	}

	public CellValue evaluate(Cell cell) {
		return evaluator.evaluate(cell);
	}

	public int evaluateFormulaCell(Cell cell) {
		return evaluator.evaluateFormulaCell(cell);
	}

	public CellType evaluateFormulaCellEnum(Cell cell) {
		return evaluator.evaluateFormulaCellEnum(cell);
	}

	public Cell evaluateInCell(Cell cell) {
		return evaluator.evaluateInCell(cell);
	}

	public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> workbooks) {
		evaluator.setupReferencedWorkbooks(workbooks);
	}

	public void setIgnoreMissingWorkbooks(boolean ignore) {
		evaluator.setIgnoreMissingWorkbooks(ignore);
	}

	public void setDebugEvaluationOutputForNextEval(boolean value) {
		evaluator.setDebugEvaluationOutputForNextEval(value);
	}
}
