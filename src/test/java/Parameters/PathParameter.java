package Parameters;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PathParameter 
{
	@Test
	public void pathParamMtd()
	{
		Response resp = given()
		.pathParam("projectId","NH_PROJ_1209" ).log().all() //projectId taken from {} http://49.249.28.218:8091/project/{projectId}
		.when()
		.get("http://49.249.28.218:8091/project/{projectId}");
		resp.then().log().all();
		
		/*
		 * Path parameter can be used for a specific entity.
		 * If we need to perform filtering, then we go for QUERY PARAMETER
		 */
	}
}
