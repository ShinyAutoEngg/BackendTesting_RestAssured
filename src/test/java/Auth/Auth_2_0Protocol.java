package Auth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Auth_2_0Protocol 
{
	@Test
	public void auth2_0ProtocolMtd()
	{
		//API 1
		Response resp = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")  //obtained from developer
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then().log().all();
		//Run this alone -Token is generated in resp body
		//The URI used for post() is obtained from developer 
		//By posting this URI the app verifies and generates the token
		
		//Capturing token from resp body
		String token=resp.jsonPath().get("access_token");
		
		
		//API 2
		 given()
		.auth().oauth2(token)
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then().log().all();
	}
}
