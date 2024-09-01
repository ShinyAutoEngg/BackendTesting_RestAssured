package CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demoForPutTest
{
	@Test
	public void updateDataInServer()
	{
		//Creating a Json object : RequestPayload
				JSONObject jsonObj= new JSONObject();
				jsonObj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
				jsonObj.put("projectName", "DiCaprio");
				jsonObj.put("status", "Created");
				jsonObj.put("teamSize", "10");
				
				//Using given() to perform CRUD operations
				RequestSpecification reqSpec = RestAssured.given();
				reqSpec.contentType(ContentType.JSON); 
				reqSpec.body(jsonObj.toJSONString()); //converting object to string
				
		
		    Response resp = reqSpec.put("http://49.249.28.218:8091/project/NH_PROJ_359"); //passing projectID
			resp.then().log().all();
			resp.then().assertThat().statusCode(200);
	}
}
