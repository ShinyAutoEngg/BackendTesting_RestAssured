package Payload_Options_POSTRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import POJOClass_Utility.ProjectPOJO;
import io.restassured.http.ContentType;

public class PostReqVia_POJOClass 
{
	@Test
		public void postDataToServer()
		{
		/*Generate Random number or name using Faker class. This is why we prefer 
		 * using POJO class instead of JsonFile
		 */
		Faker fake = new Faker();
		String ProjName = fake.name().firstName();
		
		/*
		 Random ran = new Random();
		int ranNum = ran.nextInt();
		We can also concatenate the random number with the ProjectName to avoid duplicates
		 */
		
		//creating an object for POJO Utility
		ProjectPOJO prPojoObj = new ProjectPOJO(ProjName, "ShinyIngrid", "created", 20);
			
		
			given()
			.contentType(ContentType.JSON)
			.body(prPojoObj) //Once we pass the POJO obj, Rest Assured will take care of convertion of POJO to JSON before sending the request
			.when()
			.post("http://49.249.28.218:8091/addProject")
			.then()
			.assertThat().statusCode(201)
			.log().all();
		}
	
}
