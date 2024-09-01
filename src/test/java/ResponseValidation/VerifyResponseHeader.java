package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseHeader
{
	@Test
	public void verifyHeaderMtd()
	{
		//Capture the response using a variable|We can use this obj for multiple functions
		Response resp = given().get("http://49.249.28.218:8091/projects");
		
		//Using the response object display the result
		resp.then().log().all();
		
		//Validate content type
		resp.then().assertThat().contentType(ContentType.JSON);
		
		//Validate status line
		resp.then().assertThat().statusLine("HTTP/1.1 200 ");
		
		//Validate status code 
		resp.then().assertThat().statusCode(200);
		
		//Validate others contents in Header using header()
		resp.then().assertThat().header("Transfer-Encoding", "chunked");
		resp.then().assertThat().header("X-Frame-Options", "DENY");
	}
}
