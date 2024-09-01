package DataDrivenTesting_API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ExcelFileUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DataProvider_Excel 
{
	@DataProvider
	public Object[][] getDataFromDataProviderMtd() throws Throwable
	{
		ExcelFileUtility elib = new ExcelFileUtility();
		int lastRowNum=elib.getLastRowNumFromExcel("API_Data");
		
		Object[][] objArr = new Object[lastRowNum][3];
		for(int i=0;i<lastRowNum;i++)
		{
			objArr[i][0]=elib.getDataFromExcel("API_Data", i+1, 0);
			objArr[i][1]=elib.getDataFromExcel("API_Data", i+1, 1);
			objArr[i][2]=elib.getDataFromExcel("API_Data", i+1, 2);
			
		}
		return objArr;
	}
	
	@Test(dataProvider = "getDataFromDataProviderMtd")
	public void dataProvHrdCodeMtd(String projectNameDP,String statusDP,String teamSizeDP)
	{
		
		String projectNameValue=projectNameDP;
		String statusValue=statusDP;
		String teamSizeValue=teamSizeDP;
		System.out.println(projectNameDP+statusDP+teamSizeDP);
		
		String jsonBody ="{\r\n"
			+ "  \"createdBy\": \"ShinyIngrid\",\r\n"
				+ "  \"projectName\": \""+projectNameValue+"\",\r\n"
				+ "  \"status\": \""+statusValue+"\",\r\n"
				+ "  \"teamSize\": "+teamSizeValue+"\r\n"
				+ "}";
		Response resp = given()
		.contentType(ContentType.JSON).body(jsonBody)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/addProject");
		 resp.then().log().all();
		
		String projID = resp.jsonPath().get("projectId");
		System.out.println("Project ID ========>"+projID);
	}
}
