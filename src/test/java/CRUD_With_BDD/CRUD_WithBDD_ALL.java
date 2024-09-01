package CRUD_With_BDD;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.eclipse.jetty.websocket.client.masks.RandomMasker;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CRUD_WithBDD_ALL 
{
	String projID;
	
		
	
	@Test(priority =0)
	public void postMtd()
	{
		Random ran = new Random();
		int ranNum=ran.nextInt(100);
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("createdBy", "ShinyIngrid"); //Map Interface used internally=>key:value
		jsonObj.put("projectName", "HalabulahZoo_"+ranNum+"");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", "10");
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.post("http://49.249.28.218:8091/addProject");
		resp.then()
		.assertThat().statusCode(201)
		.log().all();
		
		projID=resp.jsonPath().get("projectId");
	}
	
	@Test(priority =1)
	public void putMtd()
	{
		Random ran = new Random();
		int ranNum=ran.nextInt(100);
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("createdBy", "ShinyIngrid"); 
		jsonObj.put("projectName", "Term_"+ranNum+"");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", "10");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.put("http://49.249.28.218:8091/project/"+projID+"")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	
	@Test(priority =2)
	public void patchMtd()
	{
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("createdBy", "ShinyIngridC");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/"+projID+"")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	

//	@Test(priority =3)
//	public void getMtd()
//	{
//		given().when().get("http://49.249.28.218:8091/projects").then().body("password", is(masked("sasas"))).log().all();
//	}
	
	@Test(priority =4)
	public void delMtd()
	{
		given().when().delete("http://49.249.28.218:8091/project/"+projID+"").then().log().all();
	}
}
