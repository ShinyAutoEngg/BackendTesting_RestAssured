package CRUD_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class demoForReadTest 
{
	@Test
	public void getDataFromServer()
	{
		 Response resp = RestAssured.get("http://106.51.90.215:8084/dashboard/projects");
		 resp.then().log().all();//gives the complete Response body
		 resp.then().assertThat().statusCode(201);//intentionally failing with wrong statuscode
	}
}
