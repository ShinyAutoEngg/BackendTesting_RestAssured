package CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demoForDeleteTest 
{
	@Test
	public void postDataToServer()
	{
		//Not using Request Specification because no body is needed
		
		//Displaying the response and validating
		 Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_359");
		 resp.then().log().all();
		 resp.then().statusCode(204);
		
	}
}
