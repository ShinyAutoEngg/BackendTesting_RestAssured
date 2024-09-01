package Auth;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth 
{
	@Test
	public void basicAuthMtd()
	{
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/login")
		.then().log().all();
		
		// 	 From resp body : Headers: Accept=*/*
		 //  Here the credentials are not visible, still
		// in the backend the credentials are stored in 
		//plain text. Anyone can decode the password.
		//Hence we go for Digestive auth.
		
		
	}
}
