package DataDrivenTesting_API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtility.ExcelFileUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DataProvider_HardCode3 
{
	@DataProvider(name="getDataFromDataProviderMtd")
	public Object[][] getDataFromDataProviderMtd() throws Throwable
	{
		ExcelFileUtility elib = new ExcelFileUtility();
		int lastRowNum=elib.getLastRowNumFromExcel("API_Data");
		
		Object[][] objArr = new Object[6][2];
		for(int i=1;i<=6;i++)
		{
			objArr[i][0]=elib.getDataFromExcel("API_Data", i, 0);
			objArr[i][1]=elib.getDataFromExcel("API_Data", i, 1);
			
			
		}
		return objArr;
		
		
	}
	
	@Test
	public void dataProvHrdCodeMtd(String projectNameDP,String statusDP)
	{
		
		String projectNameValue=projectNameDP;
		String statusValue=statusDP;
		
		System.out.println(projectNameDP+statusDP);
		
//		String jsonBody ="{\r\n"
//				+ "  \"createdBy\": \"ShinyIngrid\",\r\n"
//				+ "  \"projectName\": \""+projectNameValue+"\",\r\n"
//				+ "  \"status\": \""+statusValue+"\",\r\n"
//				+ "  \"teamSize\": "+teamSizeValue+"\r\n"
//				+ "}";
//		Response resp = given()
//		.contentType(ContentType.JSON).body(jsonBody)
//		.log().all()
//		.when()
//		.post("http://49.249.28.218:8091/addProject");
//		 resp.then().log().all();
//		
//		String projID = resp.jsonPath().get("projectId");
//		System.out.println(projID);
	}
}
