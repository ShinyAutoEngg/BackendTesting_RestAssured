package CRUD_With_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_BDD_Test
{
	@Test
	public void updateDataInServer()
	{
		//Creating a Json object : RequestPayload
				JSONObject jsonObj= new JSONObject();
				jsonObj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
				jsonObj.put("projectName", "Dianaw3");
				jsonObj.put("status", "Created");
				jsonObj.put("teamSize", "10");
				
				
				given()
				.contentType(ContentType.JSON)
				.body(jsonObj.toJSONString())
				.when()
				.put("http://49.249.28.218:8091/project/NH_PROJ_4687")
				.then()
				.assertThat().statusCode(200)
				.log().all();
				
	}			
}
