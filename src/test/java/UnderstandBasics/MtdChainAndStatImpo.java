package UnderstandBasics;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class MtdChainAndStatImpo 
{
	@Test
	public void getRequestTest()
	{
		
		
		/**
		 * Method Chaining achieved below : get method returns the object of 
		 * Response Interface and the prettyPrint() can be chained
		 */
		
		//RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
		
		
		
		
		/**
		 * Static Import achieved: importing RestAssured class
		 */
		
		//get("https://reqres.in/api/users?page=2").prettyPrint();
		
		get("https://reqres.in/api/users?page=2").then().log().all();
		//then().log().all() - returns the complete details of the response body
	}
}
