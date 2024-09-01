package Dummies;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import ExcelUtility.ExcelFileUtility;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class pract 
{
	@Test
	public void m1() throws Throwable
	{
		Faker fake = new Faker();
		String name=fake.name().fullName();
		//Creating a Json object : RequestPayload
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
		jsonObj.put("projectName",name);
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", "10");
		
		Response resp = given().when().post("http://49.249.28.218:8091/addProject");
				resp.then().assertThat().statusCode(201).log().all();
				
	}
}
