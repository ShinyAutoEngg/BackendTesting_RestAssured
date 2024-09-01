package CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demoForPostTest 
{
	@Test
	public void postDataToServer()
	{
		//Creating a Json object : RequestPayload
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
		jsonObj.put("projectName", "Apocalypse");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", "10");
		
		//Using given() to perform CRUD operations
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON); 
		reqSpec.body(jsonObj.toJSONString()); //converting object to string
		
		//Displaying the response and validating
		 Response resp = reqSpec.post("http://49.249.28.218:8091/addProject");
		 resp.then().log().all();
		 resp.then().assertThat().statusCode(201);
		
	}
}
