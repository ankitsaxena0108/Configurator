package com.prudential.core.common.configuration.excel.bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prudential.core.common.configuration.excel.FeedConfigurator;
import com.prudential.core.common.configuration.excel.Sheet;
import com.prudential.core.common.configuration.excel.ValidationException;


/**
 * Configurator for Bank and Source system sheets
 * 
 * @author sajal.gupta
 *
 */
public final class BankFeedConfigurator extends FeedConfigurator{
	private static Logger logger = LoggerFactory.getLogger(BankFeedConfigurator.class);
	private Map<String,SourceSheet> sourceSheets;
	private Map<String,BankSheet> bankSheets;
		
	BankFeedConfigurator(XSSFWorkbook workbook) {
		super(workbook);
	}
	
	public static BankFeedConfigurator from(String fileName) throws IOException,ValidationException{
		return from(new FileInputStream(new File(fileName)));
	}
	
	public static BankFeedConfigurator from(InputStream is) throws IOException,ValidationException{
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		BankFeedConfigurator configurator =  new BankFeedConfigurator(workbook);
		configurator.load();
		return configurator;
	}
	
	public BankFeedConfig getConfig(){
		BankFeedConfig config = new BankFeedConfig();
		if(sourceSheets != null){
			for(Map.Entry<String,SourceSheet> entry : sourceSheets.entrySet()){
				config.addSource(entry.getKey(),entry.getValue().getConfig());
			}
		}
		if(bankSheets != null){
			for(Map.Entry<String,BankSheet> entry : bankSheets.entrySet()){
				config.addBank(entry.getKey(),entry.getValue().getConfig());
			}
		}
		return config;
	}
	
	public String getConfigJSON(){
		try{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(getConfig());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	protected void load(XSSFWorkbook workbook, FormulaEvaluator evaluator) throws ValidationException{
		int sheets = workbook.getNumberOfSheets();
		Map<String,List<String>> validationMessages = new HashMap<String, List<String>>();
		sourceSheets = new LinkedHashMap<String,SourceSheet>();
		bankSheets = new LinkedHashMap<String,BankSheet>();
		for(int i=0;i<sheets;i++){
			XSSFSheet sheet = workbook.getSheetAt(i);
			logger.debug("Processing sheet:" + sheet.getSheetName());
			if(SourceSheet.isSourceConfig(sheet)){
				SourceSheet srcSheet = new SourceSheet(workbook,evaluator,sheet);
				List<String> validationMsg = srcSheet.processConfig();
				if(validationMsg.size() > 0){
					validationMessages.put(sheet.getSheetName(),validationMsg);
				}else{
					if(srcSheet.isEnabled())
						sourceSheets.put(srcSheet.getName(),srcSheet);
					else{
						logger.debug("Source:" + sheet.getSheetName() + " is disabled");
					}
				}
			}else if(BankSheet.isBankConfig(sheet)){
				BankSheet bankSheet = new BankSheet(workbook,evaluator,sheet);
				List<String> validationMsg = bankSheet.processConfig();
				if(validationMsg.size() > 0){
					validationMessages.put(sheet.getSheetName(),validationMsg);
				}else{
					if(bankSheet.isEnabled())
						bankSheets.put(bankSheet.getName(),bankSheet);
					else{
						logger.debug("Bank:" + sheet.getSheetName() + " is disabled");
					}
				}
			}
		}
		/*if(validationMessages.size() > 0){
			throw new ValidationException(validationMessages);
		}*/
		if(sourceSheets.size() == 0)
			throw new ValidationException("No source sheets defined");
		if(bankSheets.size() == 0)
			throw new ValidationException("No bank sheets defined");
		logger.debug("No of sheets:" + sheets + " Source sheets:" + sourceSheets.size() + " Bank sheets:" + bankSheets.size());
		logger.debug("========================Configurator loaded successfully========================");
		logger.debug("");
	}
	
	public void initSource(String name, Map<String,Object> initVars,Map<String,Integer> destStartBatchNos){
		Sheet sheet = sourceSheets.get(name);
		if(sheet == null)
			throw new RuntimeException("Source not defined in the configurator:" + name);
		super.init(sheet,(Map)bankSheets,initVars,destStartBatchNos);
	}
	
	public void initBank(String bankCode, Map<String,Object> initVars,Map<String,Integer> destStartBatchNos){
		Sheet sheet = bankSheets.get(bankCode);
		if(sheet == null)
			throw new RuntimeException("Bank not defined in the configurator:" + bankCode);
		super.init(sheet,(Map)sourceSheets,initVars,destStartBatchNos);
	}	
	
	public static void main(String[] args){
		try{
			BankFeedConfigurator configurator = BankFeedConfigurator.from("D:\\Prudential\\billingsystemgit\\billingsystem\\core\\src\\main\\resources\\BankConfig_Collection.xlsx");
			
		
			
			//System.out.println(configurator.getConfigJSON());
			
			//configurator.initSource("IL_CC",null,null);			
			//System.out.println(configurator.process("5132439722877784    |0628    |00000000000100000|20006503|CMB1      |M1|20180821"));
			configurator.initBank("MBB_CC",null,null);			
			System.out.println(configurator.process("D1           2000650316513243972287778406280000100000       20006503          0627180301R01"));
			//System.out.println(configurator.process("1234567812345650|0820|000000180022|99999900|MBB|M1|20180619"));
			//System.out.println(configurator.process("6543217865432170|0820|10245|99999990|CIMB|CIMB|19042018"));
			
			System.out.println(configurator.processFinal());
			
			
			System.out.println(configurator.process("1234567812345651|0920|000000190022|99999901|CIMB|20000|20180619"));
			
			System.out.println(configurator.processFinal());
			
			
			/*System.out.println(configurator.process("H|20180407"));
			System.out.println(configurator.process("D|1234567812345678|MBB|0820|1023.25|RM|9999999|11111111|ABC|REF9999999|REF9999999"));
			System.out.println(configurator.process("D|6543217812345678|MBB|0820|1023.25|RM|9999999|11111111|ABC|REF9999999|REF9999999"));
			System.out.println(configurator.process("T|1|10.25"));
			System.out.println(configurator.processFinal());
			
			
			configurator.initBank("MBB_CC",null,null);
			configurator.process("HCRETAPSR01A       1  00147617500000000000000111240401");
			
			System.out.println(configurator.process("D1           9588926016555555555555555501270000068100       95889260          0401071219A00"));
			configurator.process("T00100000000681000000000000000000");
			
			System.out.println(configurator.processFinal());
			*/
			
			/*configurator.initBank("Biro_DD",null,null);
			
			List<String> lines = Files.readAllLines(Paths.get("C:/workspace/alpha/banks/BIROANGKASA_INT_20180701.txt"));
			
			for(int i=0;i<lines.size();i++){
				Response resp = configurator.process(lines.get(i));
				if(resp != null)
					System.out.println(resp.getOutput().getDetailRow());
			}*/
			
			
			//System.out.println(configurator.process("0C730210035530WL54095054081    201801000000100000010000JPM1110717  20152351   K486735C5226CA2598301 "));
			//System.out.println(configurator.process("1C730210035530WL54095054081    201801050100100000000000NORA'IDAH BINTI KASIM              CA2598301 "));
			//System.out.println(configurator.processFinal());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
