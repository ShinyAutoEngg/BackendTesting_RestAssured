package Payload_Options_POSTRequestTypes;

import java.io.File;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PayloadTypes_ALL
{
	//Using JsonObject Class from json.simple
	@Test
	public void JSONOBJECTMtd()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "ShinyIngrid");
		jObj.put("status", "created");
		jObj.put("teamSize", 16);
		jObj.put("projectName", "Godzilla_1234");
		
		given().contentType(ContentType.JSON).body(jObj).log().all().when().post("http://49.249.28.218:8091/addProject").then().log().all();
	}
	

	@Test
	public void HASHMAPMtd()
	{
		HashMap<Object, Object> hmap = new HashMap<>();
		hmap.put("createdBy", "ShinyIngrid");
		hmap.put("status", "created");
		hmap.put("teamSize", 16);
		hmap.put("projectName", "Orangutan_4359");
		
		given().contentType(ContentType.JSON).body(hmap).when().post("http://49.249.28.218:8091/addProject").then().log().all();
	}
	

	@Test
	public void JSONFILEMtd()
	{
		File fpath = new File("./src/test/resources/reqBody.json");
		given().contentType(ContentType.JSON).body(fpath).when().post("http://49.249.28.218:8091/addProject").then().log().all();
	}
	

	@Test
	public void POJOCLASSMtd()
	{
		POJO_reqBody pjObj = new POJO_reqBody("Shiny","Rhinocerus",10,"created");
		given().contentType(ContentType.JSON).body(pjObj).when().post("http://49.249.28.218:8091/addProject").then().log().all();
	}
}
