package Auth;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AuthorizationAndAuthentication_All 
{
	/*
	 * IGNORE 415 status code. Just use this for reference of credentials and token
	 */
	
	@Test
	public void m1()
	{
		//Basic Auth
		given().auth().basic("rmgyantra", "rmgy@9999")
		.log().all()
		.when().post("http://49.249.28.218:8091/login")
		.then().log().all();
		//encoded : hackable : not visible in console
	}
	
	@Test
	public void m2()
	{
		//Digestive
		given().auth().digest("rmgyantra", "rmgy@9999")
		.log().all()
		.when().post("http://49.249.28.218:8091/login")
		.then().log().all();
		/*encoded and encrypted(MD5 algorithm) : not visible in console
		 * Still it can be decoded and decrypted
		 */
	}
	
	@Test
	public void m3()
	{
		//PreEmptive
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.log().all()
		.when().post("http://49.249.28.218:8091/login")
		.then().log().all();
		/*
		 * Rest Assured encryption using Base64 : visible in console
		 * Less secure as it can be copied and decrypted
		 */
	}
	
	@Test
	public void bearerTokenAuthMtd()
	{
		given()
		.auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3MTkzMTk5NDUsImlhdCI6MTcxOTMxODE2MSwianRpIjoiOTYwM2JjMjAtNWQ4OS00ZDA4LWI2MDEtODU3YWIyNmY5MjgyIiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUxZi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiM2U2NjY0YmQtZmY3OC00N2I0LTkyMjItYzEzNWUxY2RhM2QzIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiM2U2NjY0YmQtZmY3OC00N2I0LTkyMjItYzEzNWUxY2RhM2QzIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.KgdsQsKV3di2OJANIo7ODwRgW3K8vCa9acHxUJ1ekWaq7K416xx2lpNrL8lKPha9P8yXLhVvEOX40O5kIxSGHmbmPArLDVChr-m6B-zd9sWfx_Jypc048siQu54Poh6klsN9FxcpmZ1IyNzin3_ei3iJ_KGo8JUT-E2qcLTOxt_LiAM0xjN2jrJMcoo9HuhldfSGTLqPOBD2HAZomzzJ48g-hH2cqcM58l4uljfCMbKh7IUh5EVGiJL9Wam8EvqiBoK9_1mfeyiFTGt-Jn08IeQhZRpCLzu8aCgJHgNqncPrqlLght1cvNATmLpG1-3JXVtltTGcas4IH8qNyDNSXA")
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then().log().all();
		//This token is directly passed and is handy.It can be shared with others until valid
		//Hence we use Auth2.0 protocol where two APIs need
		//to be executed to perform an action
	}
	
	@Test
	public void oAuth()
	{
		
		//Get the token first
		Response resp = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")  //obtained from developer
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then().log().all();
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//oAuth
		given()
		.auth().oauth2(token)
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then().log().all();
		System.out.println("======DONE=======");
		/*
		 * Two way authentication
		 * Use a set of confidential id to generate a token
		 * Use that token to perform a get or post action
		 * Mostly preferred by organizations
		 */
	}
}
