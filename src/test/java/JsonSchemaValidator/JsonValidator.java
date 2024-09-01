package JsonSchemaValidator;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonValidator {
   
	@Test
	public void sampletest() 
	{
		File f=new File("./jsonSchema.json");
		RestAssured.given().
		     when().get("https://reqres.in/api/users/2").
		     
		       then().body(JsonSchemaValidator.matchesJsonSchema(f)).
		       
		        log().all();
	}
	
	
}
