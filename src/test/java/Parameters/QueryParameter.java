package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter 
{
	@Test
	public void queryParamMtd()
	{
		given()
		//.queryParam("projectId","NH_PROJ_1209")  :For specific project ID
		.queryParam("teamSize","15")
		.log().all() //to get the request body
		.when()
		.get("http://49.249.28.218:8091/project")
		.then().log().all(); //to get the response body
		
		/*.get("http://49.249.28.218:8091/project?projectId=NH_PROJ_1209")
		 * Here, if you want to display the data with project id specified,
		 * we can use this.
		 * 
		 * Both param Parameter and Query Parameter serve the same purpose
		 * then why do we use query param?
		 * It is used for filtering ->Ref pgm teamSize=10
		 * 
		 * In the console - Request Body
		 * Request URI:	http://49.249.28.218:8091/project?teamSize=10
		 * Url is denoted with the query. It could be hacked or viewed by others.
		 * So we need to include it within the body and not in the url.
		 * Hence we go for FORM PARAMTER
		*/
	}
}
