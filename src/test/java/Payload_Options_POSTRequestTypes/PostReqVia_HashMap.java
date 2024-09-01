package Payload_Options_POSTRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReqVia_HashMap 
{
	@Test
		public void postDataToServer()
		{
			HashMap<String, Object> map = new HashMap<>(); //key is String | value differs - so object -accepts all datatypes
			map.put("createdBy", "ShinyIngrid");
			map.put("status", "created");
			map.put("teamSize", "10");
			map.put("projectName", "Orange_33");
			
			given()
			.contentType(ContentType.JSON)
			.body(map)
			.when()
			.post("http://49.249.28.218:8091/addProject")
			.then()
			.assertThat().statusCode(201)
			.log().all();
		}
	
}
