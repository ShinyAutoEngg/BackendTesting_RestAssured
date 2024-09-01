package UnderstandBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class executeGetMeth_RA 
{
	@Test
	public void restAssuredMethod()
	{
		Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.prettyPrint());
		
	
	}
}
