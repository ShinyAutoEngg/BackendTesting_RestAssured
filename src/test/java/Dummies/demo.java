package Dummies;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test; 
public class demo 
{
	@Test
	public void demo1()
	{
		given().when().get("http://49.249.28.218:8091/projects-paginated").then().assertThat().statusCode(200);
	}
	
	
}
