package DataDrivenTesting_API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ExcelFileUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DataProvider_HardCode2 
{
	
	@Test(dataProvider = "getDataFromDataProviderMtd1")
	public void dataProvHrdCodeMtd1(String projectNameDP,String statusDP,int size)
	{
		

		System.out.println(projectNameDP+statusDP+size);
		

	}
	
	@DataProvider(name="dataProvider")
	public Object[][] getDataFromDataProviderMtd1() throws Throwable
	{
		ExcelFileUtility elib = new ExcelFileUtility();
		int lastRowNum=elib.getLastRowNumFromExcel("API_Data");
		
		Object[][] objArr = new Object[lastRowNum][3];
		for(int i=1;i<lastRowNum;i++)
		{
			objArr[i][0]=elib.getDataFromExcel("API_Data", i, 0);
			objArr[i][1]=elib.getDataFromExcel("API_Data", i, 1);
			objArr[i][2]=elib.getDataFromExcel("API_Data", i, 2);
			
			System.out.println(objArr[i][0]);
		}
		return objArr;
	}
	
	
}
