package wiremock;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
public class demoForWiremock 
{
	@Test
	public void m1()
	{
		Response resp = given().get("http://localhost:8081/users/1");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}
	

	@Test
	public void m2()
	{
		Response resp = given().get("http://localhost:8081/users/2");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}
	
	
	@Test
	public void headerInfo()
	{
		given().when().get("http://localhost:8081/use/header").then().log().all();
	}
	
	//String new="{\"status\" : \"success\" , \"message\":\"card payment successful\"}"
	
	@Test
	public void m3()
	{
		String jbody ="{ \"creditcardNumber\" : 1234567892,\r\n"
				+ "   \"creditCardName\" : \"Shiny\",\r\n"
				+ "	\"cvv\" :123\r\n"
				+ "}";
		Response resp = given().contentType(ContentType.JSON).body(jbody).when().post("http://localhost:8081/payment");
		resp.then().log().all();
		//resp.then().assertThat().statusCode(201);
	}
	
	
	
	@Test
	public void m4()
	{
		String jbody ="{ \"panNumber\" : \"CDPLS6787L\",\r\n"
				+ "\"DOB\" : \"10/11/1988\",\r\n"
				+ "\"validity\" : \"2028\" }";
		
		Response resp=given().contentType(ContentType.JSON).body(jbody).when().post("http://localhost:8081/pan");
		resp.then().log().all();
	}
}
