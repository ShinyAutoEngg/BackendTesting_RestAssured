package RequestChaining;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import POJOClass_Utility.LoginPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.List;

public class Sc3_getPayrollInfoViaAuthToken 
{
	@Test
	public void getPayrollViaAuthTokenMtd()
	{
		/*
		 * GENERIC WAY
		 * API 1 - Get Authentication
		LoginPOJO logPojoObj = new LoginPOJO("rmgyantra", "rmgy@9999");
		Response resp1 = given().contentType(ContentType.JSON).body(logPojoObj)
		.when().post("http://49.249.28.218:8091/login");
		resp1.then().log().all();
		
		But for this application there is a Authentication protocol that needs to be used. Hence the 
		following method
		*/
		
		// API 1 - Get Authentication
		Response resp1 = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp1.then().log().all();
		//Capture token from response
		String authToken = resp1.jsonPath().get("access_token");//auth token changes for every execution
		System.out.println(authToken); 
		
		//API 2 - Get Payroll Info
		Response resp2 = given()
				.auth().oauth2(authToken)  //auth() is used | method depends on developer
				.get("http://49.249.28.218:8091/admin/payrolls");
		resp2.then().log().all();
		List<String> empStatus=JsonPath.read(resp2.asString(),"[*].[?(@.payroll_id=='99')].status");
		String empStData=empStatus.get(0);
		System.out.println(empStData);		
	}
}
