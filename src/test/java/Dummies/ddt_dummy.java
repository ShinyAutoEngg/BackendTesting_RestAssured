package Dummies;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ExcelUtility.ExcelFileUtility;
import ExcelUtility.Excel_dummy;

public class ddt_dummy
{
	@Test
	 public void dp() throws Throwable, IOException
	{
		Excel_dummy elib = new Excel_dummy("./src/test/resources/API_TestData.xlsx");
		int lrn =elib.getLastRowNumFromExcel("API_Data");
		
		System.out.println(lrn);
		
		
		//Object[][] obArr = new Object[2][2];
		
	}
}
