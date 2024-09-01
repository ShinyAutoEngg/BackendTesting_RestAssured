package CRUD_With_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

//Step 1 : Perform static import
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_BDD_Test 
{
	@Test
	public void postDataToServer()
	{
		Faker fake = new Faker();
		String name=fake.name().fullName();
		//Creating a Json object : RequestPayload
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
		jsonObj.put("projectName",name);
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", "10");
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/addProject");
		
		resp.then().assertThat().statusCode(201).log().all();
		System.out.println("******Status code Verified*******");
		System.out.println(resp.getBody());
		System.out.println("================<>==================");
		System.out.println(resp.getHeader("Transfer-Encoding"));
	}
}
