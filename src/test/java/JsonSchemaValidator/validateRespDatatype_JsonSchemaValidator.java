package JsonSchemaValidator;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import POJOClass_Utility.ProjectPOJO;
import io.restassured.http.ContentType;

public class validateRespDatatype_JsonSchemaValidator 
{
	@Test
	public void testJsonSchemaValidator()
	{
		Faker fake = new Faker();
		String projName = fake.name().name();
		
		String jsonVerification = "{\r\n"
				+ "    \"msg\": \"Successfully Added\",\r\n"
				+ "    \"createdBy\": \"ShinyIngrid\",\r\n"
				+ "    \"projectName\": \"Judson Lynch\",\r\n"
				+ "    \"projectId\": \"NH_PROJ_4772\",\r\n"
				+ "    \"createdOn\": \"05/07/2024\",\r\n"
				+ "    \"status\": \"created\"\r\n"
				+ "}"  ;
		
		ProjectPOJO pObj = new ProjectPOJO(projName,"ShinyIngrid","created",10);
		given().contentType(ContentType.JSON).body(pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}
}
