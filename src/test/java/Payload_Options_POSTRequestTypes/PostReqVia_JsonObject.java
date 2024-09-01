package Payload_Options_POSTRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReqVia_JsonObject 
{
	@Test
		public void postDataToServer()
		{
			JSONObject jObj = new JSONObject();
			jObj.put("createdBy", "ShinyIngrid");
			jObj.put("status", "created");
			jObj.put("teamSize", "10");
			jObj.put("projectName", "Orange_new");
			
			given()
			.contentType(ContentType.JSON)
			.body(jObj.toJSONString())
			.when()
			.post("http://49.249.28.218:8091/addProject")
			.then()
			.assertThat().statusCode(201)
			.log().all();
		}
	
}
