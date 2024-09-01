package Dummies;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import Auth.BasicAuth;


public class dummytoken 
{
	@Test
	public void d2()
	{
		
		
		
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.post("http://49.249.28.218:8091/login")
		.then().log().all();
	}
}
