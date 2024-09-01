package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

//import org.json.simple.JSONObject;
//import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;

import POJOClass_Utility.ProjectPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Sc1_DeleteProject_RC 
{
	@Test
		public void postDataToServer()
		{
		/*Generate Random number or name using Faker class. This is why we prefer 
		 * using POJO class instead of JsonFile
		 */
		Faker fake = new Faker();
		String ProjName = fake.name().firstName();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		//We can also concatenate the random number with the ProjectName to avoid duplicates
		 
		//API -1
		//creating an object for POJO Utility
		ProjectPOJO prPojoObj = new ProjectPOJO(ProjName+"_"+ranNum, "ShinyIngrid", "created", 20);
			
			Response resp = given()
			.contentType(ContentType.JSON)
			.body(prPojoObj) //Once we pass the POJO obj, Rest Assured will take care of convertion of POJO to JSON before sending the request
			.when()
			.post("http://49.249.28.218:8091/addProject");
			
			resp.then().assertThat().statusCode(201).log().all();
			
			String projIDFrmRespBody=resp.jsonPath().get("projectId");
		//API-2	
			//Delete a product
			Response delFunc = given().delete("http://49.249.28.218:8091/project/"+projIDFrmRespBody);
			delFunc.then().assertThat().statusCode(204);
			delFunc.then().log().all();
									
		}
}
