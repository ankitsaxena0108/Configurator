package com.prudential.core.common.configuration.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Sheet {
	
	private static Logger logger = LoggerFactory.getLogger(Sheet.class);
	
	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;
	protected FormulaEvaluator evaluator;
	
	private Map<String,XSSFTable> tables = new HashMap<String, XSSFTable>();
	protected Cell[] configColRow;
	protected Cell[] configRow;

	private Cell[] inputDetRow,inputHdrRow,inputFtrRow;

	//in computes
	private Cell[] inputDetCompRow,inputHdrCompRow,inputFtrCompRow;	
	private int headerValidCellIndex = -1,footerValidCellIndex = -1, detValidCellIndex = -1;

	//in compute colunm
	private String[] inputDetCompColName,inputHdrCompColName,inputFtrCompColName;
	private Cell[] inFtrAggValueRow,inFtrAggFuncRow;
	
	//out computes
	private Cell[] hdrComputeRow;
	private String[] outDetComputeCols;
	private Cell[] detComputeRow;
	private Cell seqCell;
	private Cell[] footerAggValueRow,footerAggFuncRow;
	
	private Cell currBatchNoCell;
	private String destFileName;
	private int fileNameIndex = -1;
	private Cell[] outRow;
	
	private String name;
	private String delimiter;
	String regexEscDelimiter;	
	String[] headerIdentifier,detailIdentifier,footerIdentifier;
	int[] headerStartIndex,detailStartIndex,footerStartIndex;
	private int hdrRowCount = 1;
	private int detailRowCount = 1;
	private int batchSize;	
	private Cell srcCell;
	private boolean isEnabled = true;
			
	public Sheet(XSSFWorkbook workbook,FormulaEvaluator evaluator, XSSFSheet sheet){
		this.workbook = workbook;
		this.evaluator = evaluator;
		this.sheet = sheet;
		//evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		List<XSSFTable> tableList = sheet.getTables();
		for(int i=0;i<tableList.size();i++){
			XSSFTable table = tableList.get(i);
			tables.put(table.getName(),table);
		}
	}
	
	public String getName(){
		return name;
	}
	
	int getOutBatchSize(){
		return batchSize;
	}
	
	String getDelimiter(){
		return delimiter;
	}
	
	final int getDetailRowCount(){
		return detailRowCount;
	}
	
	final int getHeaderRowCount(){
		return hdrRowCount;
	}
	
	public final boolean isEnabled(){
		return isEnabled;
	}
	
	final boolean isValid(){
		//if(validationCell == null) return true;
		//CellValue cellValue = evaluator.evaluate(validationCell);
		//return cellValue != null ? cellValue.getBooleanValue() : false;
		return detValidCellIndex == -1 ? true : inputDetCompRow[detValidCellIndex].getBooleanCellValue();
	}
	
	final boolean isHeaderValid(){
		return headerValidCellIndex == -1 ? true : inputHdrCompRow[headerValidCellIndex].getBooleanCellValue();
	}
	
	final boolean isFooterValid(){
		return footerValidCellIndex == -1 ? true : inputFtrCompRow[footerValidCellIndex].getBooleanCellValue();
	}
	
	public final EndpointConfig getConfig(){
		EndpointConfig config  = new EndpointConfig();
		config.setConfigTable(getConfigTable(sheet.getSheetName() + "_" + getConfigName(),1));
		config.setInComputeDetTable(getConfigTable(name+"_det_in_com",1));
		config.setInComputeHdrTable(getConfigTable(name+"_hdr_in_com",1));
		config.setInComputeFtrTable(getConfigTable(name+"_ftr_in_com",1));

		config.setOutComputeDetTable(getConfigTable(name+"_det_out_com",1));
		config.setOutComputeHdrTable(getConfigTable(name+"_hdr_out_com",1));
		config.setOutComputeFtrTable(getConfigTable(name+"_ftr_out_com",2));
		
		config.setOutTable(getConfigTable(name+"_out",1));
		
		return config;
	}
			
	protected Cell[] getRow(String tableName, int rowIndex, boolean createRow){
		XSSFTable inputTable = tables.get(tableName);
		Cell[] inputRow  = null;
		if(inputTable != null){
			CellReference firstCell = inputTable.getCellReferences().getFirstCell();
			CellReference lastCell = inputTable.getCellReferences().getLastCell();
			int colCount = lastCell.getCol() - firstCell.getCol() + 1;
			Row row = sheet.getRow(firstCell.getRow()+rowIndex);
			if(row == null && createRow){
				row = sheet.createRow(firstCell.getRow()+rowIndex);
			}
			if(row != null){
				inputRow = new Cell[colCount];
				int startCol = firstCell.getCol();
				for(int i=0;i<inputRow.length;i++){
					inputRow[i] = row.getCell(startCol+i,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				}
			}
		}
		return inputRow;
	}
	
	private Table getConfigTable(String tableName, int rowIndex){
		Cell[] colCells = getRow(tableName,0,false);
		if(colCells != null){
			String[] colNames = new String[colCells.length];
			for(int i=0;i<colNames.length;i++) colNames[i] = colCells[i].getStringCellValue();
			Cell[] row = getRow(tableName,rowIndex,true);
			String[] rowValues = new String[row.length];
			for(int i=0;i<row.length;i++) rowValues[i] = row[i].toString();
			return new Table(colNames,rowValues);
		}
		return Table.EMPTY_TABLE;
	}
	
	String getFileName(){
		return destFileName;
	}
	
	final void setSource(String srcName){
		this.srcCell.setCellValue(srcName);
	}
	
	final void setHeaderInput(List<String[]> input, Response response){
		response.setHeader();
		setInput(input,inputHdrCompColName,inputHdrCompRow,inputHdrRow,response);
	}
	
	final void setDetailInput(List<String[]> input, Response response){
		setInput(input,inputDetCompColName,inputDetCompRow,inputDetRow,response);
		if(inFtrAggFuncRow != null){
			CellValue cellValue = null;
			for(int i=0;i<inFtrAggFuncRow.length;i++){
				cellValue = evaluator.evaluate(inFtrAggFuncRow[i]);
				if(cellValue != null){
					inFtrAggValueRow[i].setCellValue(cellValue.getNumberValue());
				}
			}
		}
	}
	
	final void setFooterInput(List<String[]> input, Response response){
		response.setFooter();
		setInput(input,inputFtrCompColName,inputFtrCompRow,inputFtrRow,response);			
	}
	
	final boolean isFooter(String[] input){
		if(regexEscDelimiter != null){
			if(footerStartIndex == null){
				return input[0].startsWith(footerIdentifier[0]);
			}else{
				return footerIdentifier[0].equals(input[footerStartIndex[0]]);
			}
		}else{
			if(footerStartIndex == null){
				return input[0].startsWith(footerIdentifier[0]);
			}else{
				return input[0].startsWith(footerIdentifier[0],footerStartIndex[0]);
			}
		}
	}
	
	private void setInput(List<String[]> inputList,String[] computeColNameRow, Cell[] computeRow,Cell[] inputRow, Response response){
		int totalLength = 0;
		for(int i=0;i<inputList.size();i++){
			totalLength += inputList.get(i).length;
		}
		if(totalLength != inputRow.length)
			throw new RuntimeException("Input row length mismatch: passed:" + totalLength + " expected:" + inputRow.length);
		for(int i=0;i < inputList.size();i++){
			String[] input = inputList.get(i);
			for(int j=0;j<input.length;j++){
				inputRow[i+j].setCellValue(input[j]);
			}
		}
		if(computeRow != null){
			for(int i=0;i<computeRow.length;i++){
				Object val = getValue(evaluator.evaluate(computeRow[i]));
				response.addComputedValue(computeColNameRow[i],val);
			}
		}
	}
			
	private Object getValue(CellValue cellValue){
		if(cellValue == null) return null;
		switch (cellValue.getCellTypeEnum()) {
	    case BOOLEAN:
	        return cellValue.getBooleanValue();
	    case NUMERIC:
	        return cellValue.getNumberValue();
	    case STRING:
	        return cellValue.getStringValue();
	    case ERROR:
	        throw new RuntimeException("Exception in computing value:" + cellValue);
	    default:
	        return null;
		}
	}
	
	/*public final boolean filter(){
		if(conditionCell == null) return false;
		CellValue cellValue = evaluator.evaluate(conditionCell);
		return cellValue != null ? cellValue.getBooleanValue() : false;
	}*/
	
	protected abstract String[] executeRoutingRules();
	
	/**
	 * Output processing of header
	 * @param sb
	 */
	public final void processHeaderOut(StringBuilder sb){
		if(outRow[0] != null){
			CellValue cellValue = evaluator.evaluate(outRow[0]);
			if(cellValue != null)
				sb.append(getStringValue(cellValue));
		}
	}
	
	public final void processHeaderCompute(int currBatch){
		if(hdrComputeRow != null){
			if(currBatchNoCell != null){
				currBatchNoCell.setCellValue(currBatch);
			}
			for(int i=0;i<hdrComputeRow.length;i++){
				CellValue val = evaluator.evaluate(hdrComputeRow[i]);
				if(i == fileNameIndex){
					this.destFileName = val != null ? val.getStringValue() : null;
				}
			}
		}
	}	
	
	/**
	 * Output processing of footer
	 * @param sb
	 */
	public final void processFooter(StringBuilder sb){		
		if(outRow[2] != null){
			CellValue cellValue = evaluator.evaluate(outRow[2]);
			if(cellValue != null){
				sb.append(getStringValue(cellValue));
			}
			if(footerAggValueRow != null){
				for(int i=0;i<footerAggValueRow.length;i++){
					footerAggValueRow[i].setCellValue(0);
				}
			}
		}
	}
	
	private String getStringValue(CellValue cellValue){
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_STRING:
	        return cellValue.getStringValue();
		case Cell.CELL_TYPE_BOOLEAN:
	        return Boolean.toString(cellValue.getBooleanValue());
	    case Cell.CELL_TYPE_NUMERIC:
	    	return Double.toString(cellValue.getNumberValue());
	    default:
	        return null;
		}
	}
	
	/**
	 * Output process of detail
	 * @param sb
	 */
	public final void processRow(StringBuilder sb, Map<String,Object> inputValues, int seqNo){
		if(logger.isDebugEnabled())
			logger.debug("Process output sheet:" + sheet.getSheetName() + ":" + toTypedString(inputValues));
		CellValue cellValue = null;	
		if(detComputeRow != null){
			if(seqCell != null){
				seqCell.setCellValue(seqNo);
			}
			for(int i=0;i<detComputeRow.length;i++){
				Object val = inputValues.get(outDetComputeCols[i]);
				if(val != null){
					setCellValue(detComputeRow[i],val);
					evaluator.clearAllCachedResultValues(); //TODO
				}else{
					evaluator.evaluate(detComputeRow[i]);
				}
			}
		}
		cellValue = evaluator.evaluate(outRow[1]);
		sb.append(getStringValue(cellValue));
		if(footerAggFuncRow != null){
			for(int i=0;i<footerAggFuncRow.length;i++){
				cellValue = evaluator.evaluate(footerAggFuncRow[i]);
				if(cellValue != null){
					footerAggValueRow[i].setCellValue(cellValue.getNumberValue());
				}
			}
		}
	}
	
	private String toTypedString(Map<String,Object> values){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		values.forEach((name,value) -> {
			sb.append(name).append("=");
			if(value != null)
				sb.append(value).append("[").append(value.getClass().getSimpleName()).append("]");
			else
				sb.append("null");
			sb.append(", ");
		});
		sb.append("}");
		return sb.toString();
	}
		
	private void setCellValue(Cell cell, Object val){
		if(val instanceof String) {cell.setCellValue((String)val);}
		else if(val instanceof Number) { cell.setCellValue((Double)val);}
		else if(val instanceof Boolean) { cell.setCellValue((Boolean)val);}
		else if(val instanceof Date) { cell.setCellValue((Date)val);}
	}
	
	public final List<String> processConfig(){
		String configTableName = sheet.getSheetName() + "_" + getConfigName();
		configColRow = getRow(configTableName,0,false);
		configRow = getRow(configTableName,1,false);
		List<String> validationMessages = new ArrayList<String>();
		if(configColRow == null || configRow == null){
			validationMessages.add("No config row found in the table:" + configTableName);
			return validationMessages;
		}
		for(int i=0;i<configColRow.length;i++){
			String colName = configColRow[i].getStringCellValue();
			if(colName.equalsIgnoreCase("name")){
				name = configRow[i].getStringCellValue();
			}else if(colName.equalsIgnoreCase("delimiter")){
				delimiter = configRow[i] != null ? configRow[i].getStringCellValue() : null;
				if(delimiter != null && delimiter.length() > 0){
					regexEscDelimiter = Pattern.quote(delimiter);
				}
			}else if(colName.equalsIgnoreCase("hdrIdentifier")){
				String headerIdVal = configRow[i] != null ? configRow[i].getStringCellValue() : null;
				if(headerIdVal != null){
					StringTokenizer st = new StringTokenizer(headerIdVal,";");
					hdrRowCount = st.countTokens();
					headerIdentifier = new String[hdrRowCount];
					int cnt = 0;
					while(st.hasMoreTokens()){
						String token = st.nextToken();
						String[] arr = token.split(",");
						headerIdentifier[cnt] = arr[0];
						if(arr.length > 1){
							headerStartIndex = new int[hdrRowCount];
							headerStartIndex[cnt] = Integer.parseInt(arr[1]);
						}
						cnt++;
					}
				}
			}else if(colName.equalsIgnoreCase("detIdentifier")){
				String detailIdVal = configRow[i] != null ? configRow[i].getStringCellValue() : null;
				if(detailIdVal != null){
					StringTokenizer st = new StringTokenizer(detailIdVal,";");
					detailRowCount = st.countTokens();
					if(detailRowCount == 0) detailRowCount = 1;
					detailIdentifier = new String[detailRowCount];
					int cnt = 0;
					while(st.hasMoreTokens()){
						String detailIdItem = st.nextToken();
						String[] arr = detailIdItem.split(",");
						detailIdentifier[cnt] = arr[0];
						if(arr.length > 1) {
							detailStartIndex = new int[detailRowCount];
							detailStartIndex[cnt] = Integer.parseInt(arr[1]);
						}
						cnt++;
					}
				}
			}else if(colName.equalsIgnoreCase("ftrIdentifier")){
				String footerIdVal = configRow[i] != null ? configRow[i].getStringCellValue() : null;
				footerIdentifier = new String[0];
				if(footerIdVal != null && footerIdVal.length() > 0){
					footerIdentifier = new String[1];
					String[] arr = footerIdVal.split(",");
					footerIdentifier[0] = arr[0];
					if(arr.length > 1) {
						footerStartIndex = new int[0];
						footerStartIndex[0] = Integer.parseInt(arr[1]);
					}
				}
			}else if(colName.equalsIgnoreCase("enabled")){
				String value = configRow[i] != null ? configRow[i].getStringCellValue() : null;
				if(value != null && value.equals("N")) isEnabled = false;
			}/*else if(colName.equalsIgnoreCase("filterCondition")){
				conditionCell = configRow[i];
			}else if(colName.equalsIgnoreCase("validationCondition")){
				validationCell = configRow[i];
			}*/else if(colName.equalsIgnoreCase("batchsize")){
				batchSize = configRow[i] != null ? (int)configRow[i].getNumericCellValue() : -1;
			}else if(colName.equalsIgnoreCase("source")){
				srcCell = configRow[i];
			}else{
				processConfigRow(colName,configRow[i],validationMessages);
			}
		}
		if(name == null){
			validationMessages.add("Name not defined in the config table:" + configTableName);
		}
		if(srcCell == null){
			validationMessages.add("Source column not defined in the config table:" + configTableName);
		}
		
		//in
		Cell[] cols = getRow(name+"_det_in",0,false);
		inputDetRow = getRow(name+"_det_in",1,true);
		inputHdrRow = getRow(name+"_hdr_in",1,false);
		inputFtrRow = getRow(name+"_ftr_in",1,false);
		
		//if(cols == null){
		//	validationMessages.add("Input detail table not defined:" + (name+"_det_in"));
		//}

		//in compute
		inputDetCompRow = getRow(name+"_det_in_com",1,false);
		inputHdrCompRow = getRow(name+"_hdr_in_com",1,false);
		inputFtrCompRow = getRow(name+"_ftr_in_com",1,false);
		
		inputDetCompColName = getColNames(getRow(name+"_det_in_com",0,false));
		inputHdrCompColName = getColNames(getRow(name+"_hdr_in_com",0,false));
		inputFtrCompColName = getColNames(getRow(name+"_ftr_in_com",0,false));
		
		if(inputHdrCompColName != null){
			for(int i=0;i<inputHdrCompColName.length;i++){
				if(inputHdrCompColName[i].equals("isValid")){
					headerValidCellIndex = i;
				}
			}
		}
		if(inputDetCompColName != null){
			for(int i=0;i<inputDetCompColName.length;i++){
				if(inputDetCompColName[i].equals("isValid")){
					detValidCellIndex = i;
				}
			}
		}
		if(inputFtrCompColName != null){
			for(int i=0;i<inputFtrCompColName.length;i++){
				if(inputFtrCompColName[i].equals("isValid")){
					footerValidCellIndex = i;
				}
			}
		}
		Cell[] inFtrColName = getRow(name+"_ftr_in_agg",0,false);
		if(inFtrColName != null){
			inFtrAggValueRow = getRow(name+"_ftr_in_agg",1,true);
			inFtrAggFuncRow = getRow(name+"_ftr_in_agg",2,true);
			for(int i=0;i<inFtrAggValueRow.length;i++){
				inFtrAggValueRow[i].setCellValue(0);
			}
		}
		if(inFtrColName != null && (footerAggFuncRow == null || footerAggValueRow == null)){
			validationMessages.add("Input Footer agg func not defined:" + (name+"_ftr_in_agg"));
		}
		
		//out compute
		Cell[] outDetColCells = getRow(name+"_det_out_com",0,false);
		if(outDetColCells != null){
			detComputeRow = getRow(name+"_det_out_com",1,false);
			outDetComputeCols = new String[outDetColCells.length];
			for(int i=0;i<outDetColCells.length;i++){
				outDetComputeCols[i] = outDetColCells[i].getStringCellValue();
				if(outDetComputeCols[i].equalsIgnoreCase("sequenceNo")){
					seqCell = detComputeRow[i];
				}
			}
		}
		Cell[] hdrCompCols = getRow(name+"_hdr_out_com",0,false);
		if(hdrCompCols != null){
			hdrComputeRow = getRow(name+"_hdr_out_com",1,true);
			for(int i=0;i<hdrCompCols.length;i++){
				if(hdrCompCols[i].getStringCellValue().equalsIgnoreCase("fileName")){
					fileNameIndex = i;
				}else if(hdrCompCols[i].getStringCellValue().equalsIgnoreCase("currBatch")){
					currBatchNoCell = hdrComputeRow[i];
				}
			}
		}
		Cell[] footerColName = getRow(name+"_ftr_out_com",0,false);
		if(footerColName != null){
			footerAggValueRow = getRow(name+"_ftr_out_com",1,true);
			footerAggFuncRow = getRow(name+"_ftr_out_com",2,true);
			for(int i=0;i<footerAggValueRow.length;i++){
				footerAggValueRow[i].setCellValue(0);
			}
		}
		if(footerColName != null && (footerAggFuncRow == null || footerAggValueRow == null)){
			validationMessages.add("Footer agg func not defined:" + (name+"_ftr_out_com"));
		}
		//out
		outRow = getRow(name+"_out",1,true);
		//if(outRow == null){
		//	validationMessages.add("Output table not defined:" + (name+"_out"));
		//}
		processConfig(validationMessages);
		List<XSSFTable> tables = sheet.getTables();
		for(int i=0;i<tables.size();i++){
			printTable(tables.get(i));
		}
		return validationMessages;
	}
	
	
	protected void processConfigRow(String colName, Cell rowCell, List<String> validationMessages){}
	
	/**
	 * Hook to add sheet specific configuration and validations
	 * @param validationMessages
	 */
	protected void processConfig(List<String> validationMessages){}
	
	
	private void printTable(XSSFTable table){
		CellReference first = table.getCellReferences().getFirstCell();
		CellReference last = table.getCellReferences().getLastCell();
		int colCount = last.getCol() - first.getCol() + 1;
		int rowCount = last.getRow() - first.getRow() + 1;
		if(logger.isDebugEnabled()) {
			logger.debug("Table:" + table.getName() + " [Cols:" + colCount + ",Rows:" + rowCount + "]");
		}
		
		for(int i=0;i<rowCount;i++){
			Cell[] cells = getRow(table.getName(),i,false);
			if(cells != null){
				for(int j=0;j<cells.length;j++){
					if(logger.isDebugEnabled()) {
						logger.debug("cell value:"+cells[j]);
						logger.debug(" ");
					}
				}
			}
		}
	}
	
	private String[] getColNames(Cell[] row){
		if(row == null) return null;
		String[] colNames = new String[row.length];
		for(int i=0;i<colNames.length;i++){
			colNames[i] = row[i].getStringCellValue();
		}
		return colNames;
	}
	
	protected abstract String getConfigName();
}
