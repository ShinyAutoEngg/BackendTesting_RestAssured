package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class ParamParameter 
{
	@Test
	public void paramParamMtd()
	{
		given()
		.param("teamSize", 5) //passing the query instead of using query param
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/project")
		//.get("http://49.249.28.218:8091/project")
		.then().log().all();
		
		/*
		 * param()with get() =>query :reflects in url
		 * param() with post()=>form : doesnt reflect in url
		 */
	}
}
