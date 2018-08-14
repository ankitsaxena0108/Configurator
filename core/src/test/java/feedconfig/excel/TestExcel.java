package feedconfig.excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
	public static void main(String[] args){
		try{
			FileInputStream excelFile = new FileInputStream(new File("D:\\Prudential\\test\\BankConfig.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	            
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			evaluator.clearAllCachedResultValues();
	          	 
	          	 
	          	XSSFSheet sheet = workbook.getSheetAt(0);
	          	XSSFSheet sheet1 = workbook.getSheetAt(1);
	          	XSSFTable table = sheet.getTables().get(0);
	          	 
	          	//System.out.println(table.getRowCount());
	          	
	          	CellReference cellReference = table.getCellReferences().getLastCell();
	          	System.out.println("CellRef:: " + cellReference);
	          	
	          	Row row = sheet.getRow(cellReference.getRow());
	          	Cell dataCell = row.getCell(cellReference.getCol()); 
	          	
	          	
	          	CellReference cardRef = new CellReference("C5"); 
	          	Row cardRow = sheet.getRow(cardRef.getRow());
	          	Cell cardcell = cardRow.getCell(cardRef.getCol()); 
	          	cardcell.setCellValue("134");
	          	
	          	System.out.println(dataCell.getAddress());
	          	
	          	CellReference funcRef1 = new CellReference("B5"); 
	          	Row funcRow1 = sheet.getRow(funcRef1.getRow());
	          	Cell funcCell1 = funcRow1.getCell(funcRef1.getCol()); 
	          	
	          	
	          		          	
	          	//CellReference funcRef = new CellReference("B13");
	          	CellReference funcRef = new CellReference("C13");
	          	Row funcRow = sheet1.getRow(funcRef.getRow());
	          	Cell funcCell = funcRow.getCell(funcRef.getCol()); 
	          	long s = System.currentTimeMillis();
	          	CellValue cellValue = null;
	          	for(int i=0;i<12;i++){
		          	dataCell.setCellValue(i+",2,11.3,10121976");
		          	evaluator.clearAllCachedResultValues();
		          	cellValue = evaluator.evaluate(funcCell1);
		          	System.out.println("Val::" + cellValue);
		          	 
		          	cellValue = evaluator.evaluate(funcCell);
	
			        System.out.println("Val::" + cellValue);  	
		        
	          	}
	          	//System.out.println("Val::" + cellValue);
	          	long s2 = System.currentTimeMillis();
	          	System.out.println("Time:" + (s2-s)/1000);
	            //Sheet datatypeSheet = workbook.getSheetAt(0);
	            //Iterator<Row> iterator = datatypeSheet.iterator();

			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
