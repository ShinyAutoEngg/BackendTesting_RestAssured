package ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_dummy 
{
	String path;
	
	public Excel_dummy(String pa)
	{
		this.path = pa;
	}
	
	public String getDataFromExcel(String sheetName,int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/API_TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
	public int getLastRowNumFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lrn=sheet.getLastRowNum();
		return lrn;
		
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String Data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\dummy.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cell = book.createSheet(sheetName).createRow(rowNum).createCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(Data);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\dummy.xlsx");
		book.write(fos);
		book.close();
		}
	
}
