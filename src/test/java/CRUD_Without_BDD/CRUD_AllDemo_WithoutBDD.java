package CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Job;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CRUD_AllDemo_WithoutBDD 
{
	String projID;
	@Test
	public void forGET()
	{
		Response resp = RestAssured.get("http://106.51.90.215:8084/dashboard/projects");
		resp.then().assertThat().statusCode(200).log().all();
	}
	
	
	@Test
	public void forPOST()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
		jobj.put("projectName", "Moonlight35e");
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);
		
		RequestSpecification reqSpec = RestAssured.given();
		Response resp = reqSpec.contentType(ContentType.JSON).body(jobj).post("http://49.249.28.218:8091/addProject");
		resp.then().assertThat().statusCode(201).log().all();
		projID=resp.jsonPath().get("projectId");
	}	
	
	
	@Test
	public void forPUT()
	{

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
		jobj.put("projectName", "Sunshine398");
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);
		
			RequestSpecification reqSpec = RestAssured.given().contentType(ContentType.JSON).body(jobj);
			Response resp = reqSpec.put("http://49.249.28.218:8091/project/NH_PROJ_4698");
			resp.then().assertThat().statusCode(200);
	}
	
	
	@Test
	public void forPATCH()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("teamSize", "22");
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON).body(jobj.toJSONString()).log().all();
		Response resp = reqSpec.patch("http://49.249.28.218:8091/project/NH_PROJ_4698");
		resp.then().log().all().assertThat().statusCode(200);
	}
	
	
	@Test
	public void forDELETE()
	{
		Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_4698");
		resp.then().assertThat().statusCode(204).log().all();
	}
}
