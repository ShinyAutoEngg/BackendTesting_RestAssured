package Payload_Options_POSTRequestTypes;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReqVia_JsonFile 
{
	@Test
		public void postDataToServer()
		{
		File fileobj = new File("./src/test/resources/project_JSON.json");
					
			given()
			.contentType(ContentType.JSON)
			.body(fileobj)  ///Jackson supports fileObj
			.when()
			.post("http://49.249.28.218:8091/addProject")
			.then()
			//.assertThat().statusCode(201)
			.log().all();
		}
	
}
