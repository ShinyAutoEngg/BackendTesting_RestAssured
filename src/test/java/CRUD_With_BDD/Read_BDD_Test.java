package CRUD_With_BDD;

import org.testng.annotations.Test;

//Step 1: Static Import
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class Read_BDD_Test 
{
	@Test
	public void getDataFromServer()
	{
		//Using given() from RestAssured class directly after stat imp
		//Request chaining and Method chaining are achieved
		given()  //returns obj of RequestSpecification using which we access get() & so on
		.get("http://49.249.28.218:8091/projects") 
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
}
