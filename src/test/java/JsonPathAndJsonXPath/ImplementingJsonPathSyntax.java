package JsonPathAndJsonXPath;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class ImplementingJsonPathSyntax
{
	@Test
	public void jsonPathSyntaxMtd()
	{
		 Response resp = given()
		.when().get("http://49.249.28.218:8091/projects"); 
		 resp.then().log().all();
		 String pName=resp.jsonPath().get("[1].projectName");	
		 System.out.println(pName);
		 
		String hanumanList=JsonPath.read(resp.asString(), "[*].[?(@.createdBy=='Hanuman')]").toString();
		 
		 {
			 System.out.println(hanumanList);
		 }
		 
		/*  =====>Printing NULL Array<=======
		Object pNameForPID = JsonPath.read(resp.asString(),"[*].projectName[?(@.projectId=='NH_PROJ_328')]");
		System.out.println(pNameForPID);
		
		System.out.println("*********************************************************");
		List<Object> projCBPranav = JsonPath.read(resp.asString(),"[*].projectName[?(@.createdBy=='Pranav')]");
		System.out.println(projCBPranav);
		
		System.out.println("*********************************************************");
		
		*/
		List<String> ids=JsonPath.read(resp.asString(),"[*].[?(@.createdBy=='Rajesh')].projectId");
		for(String id : ids)
		{
			System.out.println(id);
		}
	}
}
