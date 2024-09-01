package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class TypesOfResponseHandling 
{
	@Test
	public void responseHandlingMtd()
	{
		filters(new ResponseLoggingFilter());
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
	}
}
