package com.prudential.core.common.configuration.excel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configurator instance should be created for consuming feed file entries. This class is not thread safe
 * @author sajal.gupta
 *
 */
public abstract class FeedConfigurator {

	private static Logger logger = LoggerFactory.getLogger(FeedConfigurator.class);
	
	private XSSFWorkbook workbook;
	private FormulaEvaluator evaluator;

	private Sheet currSource;
	private Map<String,Sheet> destSheets;
	private Collection<Sheet> destSheetList;
	private StringBuilder outRow = new StringBuilder();
	private Map<String,Aggregate> aggregates = new HashMap<String, Aggregate>();
	private Map<String,Integer> startBatchNos = new HashMap<String, Integer>();

	private Map<String,Object> initVars;
	private boolean headerParsed;
	private int currRowCount = 0;
	private List<String[]> rows = new ArrayList<String[]>(2);
	
	protected FeedConfigurator(XSSFWorkbook workbook) {
		this.workbook = workbook;
		this.evaluator = new LoggingFormulaEvaluator(workbook.getCreationHelper().createFormulaEvaluator());
	}
	
	public void init(Sheet currSource, Map<String,Sheet> dests,Map<String,Object> initVars,Map<String,Integer> startBatchNos){
		this.currSource = currSource;
		this.destSheets = dests;
		destSheetList = dests.values();
		for(Sheet s: destSheetList){
			s.setSource(currSource.getName());
		}
		aggregates.clear();
		headerParsed = false;
		currRowCount = 0;
		rows.clear();
		this.startBatchNos.clear();
		if(startBatchNos != null)
			this.startBatchNos.putAll(startBatchNos);
	}
	
	protected final void load() throws ValidationException{
		load(workbook,evaluator);
	}
	
	protected abstract void load(XSSFWorkbook workbook,FormulaEvaluator evaluator) throws ValidationException;
		
	/**
	 * Parse the row based on the source sheet and generate the feed in the destination format
	 * 
	 * @param row
	 * @return
	 */
	public final Response process(String row, boolean parseOnly){
		if(logger.isDebugEnabled())
			logger.debug(currSource.getName() + " input:" + row);
		evaluator.clearAllCachedResultValues();
		Response response = new Response(currSource.getName(),initVars);
		String[] rowValues = currSource.regexEscDelimiter != null ? row.split(currSource.regexEscDelimiter) : new String[]{row};
		if(headerParsed || currSource.headerIdentifier.length == 0){
			if(currSource.footerIdentifier.length == 0 || !currSource.isFooter(rowValues)){
				currRowCount++;
				rows.add(rowValues);
				if(currRowCount == currSource.getDetailRowCount()){
					currSource.setDetailInput(rows,response);
					currRowCount = 0;
					rows.clear();
				}else{
					return null;
				}
			}else{
				currSource.setFooterInput(Collections.singletonList(rowValues),response);
				response.setValid(currSource.isFooterValid());
			}
		}else{
			currRowCount++;
			rows.add(rowValues);
			if(currRowCount == currSource.getHeaderRowCount()){
				currSource.setHeaderInput(rows,response);
				response.setValid(currSource.isHeaderValid());
				currRowCount = 0;
				rows.clear();
				headerParsed = true;
			}else{
				return null;
			}
		}
		if(response.isDetail()){
			if(currSource.isValid()){
				response.setValid(true);
				String[] destSheetNames = currSource.executeRoutingRules();
				if(destSheetNames != null && destSheetNames.length > 0){
					for(int i=0;i<destSheetNames.length;i++){
						Sheet destSheet = destSheets.get(destSheetNames[i]);
						if(destSheet != null && destSheet.isEnabled()){
							response.getOutput().setName(destSheet.getName());
							if(!parseOnly)
								processDestSheet(destSheet,response);
							break;
						}
					}
				}else{
					if(logger.isWarnEnabled())
						logger.warn("No destination sheet found for row:" + row);
				}
			}else{
				if(logger.isErrorEnabled())
					logger.error("Invalid row:" + row);
			}
		}
		return response;
	}
	
	public Response process(String row){
		try{
			return process(row,false);
		}catch(Exception e){
			logger.error("Failed to process row:" + row + " Msg:" + e.getClass() + " " + e.getMessage());
			Response response = new Response(currSource.getName(),initVars);
			response.setValid(false);
			currRowCount = 0;
			rows.clear();
			return response;
		}
	}
	
	public void processDestSheet(Sheet destSheet, Response response){
		outRow.setLength(0);
		String sheetName = destSheet.getName();
		Aggregate agg = aggregates.get(sheetName);
		if(agg == null){
			Object val = startBatchNos.get(destSheet.getName());
			agg = new Aggregate(destSheet.getOutBatchSize(),(val != null ? (Integer)val:0));
			aggregates.put(destSheet.getName(),agg);
		}
		response.getOutput().setName(sheetName);
		response.getOutput().setCurrBatch(agg.getCurrBatchCount());
		agg.incrementRowCount();
		if(agg.isAddHeader()){
			//StringBuilder headerSb = new StringBuilder();
			//destSheet.processHeader(headerSb,agg.getCurrBatchCount());
			//agg.setFileName(destSheet.getFileName());
			//response.getOutput().setHeaderRow(headerSb.toString());
			destSheet.processHeaderCompute(agg.getCurrBatchCount());
			agg.setFileName(destSheet.getFileName());
		}
		//response.getOutput().setFileName(agg.getFileName());
		destSheet.processRow(outRow, response.getComputedValues(),agg.getCurrCount());
		response.getOutput().setDetailRow(outRow.toString());
		if(agg.isAddFooter()){
			StringBuilder footerSb = new StringBuilder();
			destSheet.processFooter(footerSb);
			response.getOutput().setFooterRow(footerSb.toString());
			StringBuilder headerSb = new StringBuilder();
			destSheet.processHeaderOut(headerSb);
			response.getOutput().setHeaderRow(headerSb.toString());
			response.getOutput().setFileName(destSheet.getFileName());
		}
	}
	
	/**
	 * Should be call after all the rows are parsed to generate the final footer in destination format
	 * @return
	 */
	public final List<Response> processFinal(){
		List<Response> footers = new ArrayList<Response>();
		for(Map.Entry<String,Aggregate> entry : aggregates.entrySet()){
			if(entry.getValue().getCurrCount() > 0){
				Sheet bankSheet = destSheets.get(entry.getKey());
				Response r = new Response(currSource.getName(),initVars);
				r.getOutput().setName(entry.getKey());
				StringBuilder footerSb = new StringBuilder();
				bankSheet.processFooter(footerSb);
				r.getOutput().setFooterRow(footerSb.toString());
				int batchNo = entry.getValue().getCurrBatchCount();
				r.getOutput().setCurrBatch(batchNo);
				StringBuilder headerSb = new StringBuilder();
				bankSheet.processHeaderOut(headerSb);
				r.getOutput().setHeaderRow(headerSb.toString());
				r.getOutput().setFileName(bankSheet.getFileName());
				footers.add(r);
			}
		}
		return footers;
	}
}
