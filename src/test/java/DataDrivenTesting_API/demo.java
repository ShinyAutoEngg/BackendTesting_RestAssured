package DataDrivenTesting_API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ExcelFileUtility;

public class demo 
{
	@Test(dataProvider = "getDataFromDataProviderMtd")
	public void demo1(String a,String b,String c)
	{
		System.out.println(a+b+c);
	}
	
	@DataProvider
	//(name="getDataFromDataProviderMtd")
	public Object[][] getDataFromDataProviderMtd() throws Throwable
	{
		ExcelFileUtility elib = new ExcelFileUtility();
		int lastRowNum=elib.getLastRowNumFromExcel("API_Data");
		
		Object[][] objArr = new Object[lastRowNum][3];
		for(int i=1;i<lastRowNum;i++)
		{
			objArr[i][0]=elib.getDataFromExcel("API_Data", i, 0);
			objArr[i][1]=elib.getDataFromExcel("API_Data", i, 1);
			objArr[i][2]=elib.getDataFromExcel("API_Data", i, 2);
			
		}
		return objArr;
	}
}
