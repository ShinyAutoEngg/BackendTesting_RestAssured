package Parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class FormParameter 
{
	@Test
	public void formParamMtd()
	{
		given()
		.formParam("teamSize", 10) //passing the query instead of using query param
		.log().all()
		.when()
		//.get("http://49.249.28.218:8091/project") //form param uses post() and not get()
		.post("http://49.249.28.218:8091/project") //gives 400 status code Only get() works
		.then().log().all();
		
		/*
		 * From Response body :
		 * Request URI:	http://49.249.28.218:8091/project
		 * Now the query is no longer visible
		 * It is within the body as Form params:	teamSize=10
		 */
	}
}
