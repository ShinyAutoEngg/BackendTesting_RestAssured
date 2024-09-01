package Dummies;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class dummypostdel 
{
	@Test
	public void d1()
	{
		
		String jbody = "{\r\n"
				+ "    \"name\": \"morpheus_"+new Random().nextInt(100)+"\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		//Create
		Response resp = given().contentType(ContentType.JSON).body(jbody)
		.when()
		.log().all()
		.post("https://reqres.in/api/users");
		resp.then();//.log().all();
		
		String idCreated=resp.jsonPath().get("id").toString();
		System.out.println(idCreated);
		
		//Delete
				Response resp2=given()
				.when()
				.delete("https://reqres.in/api/users/"+idCreated+"");
				resp2.then().log().all();
				int statusc=204;
				resp2.then().assertThat().statusCode(statusc);
				//int statCode=resp.jsonPath().getInt("code");
			// Headers head = resp.getHeaders();
			 
			 //for(Header h:head) {
				//System.out.println(" Please  ===>"+h);
			 }
				
	}

