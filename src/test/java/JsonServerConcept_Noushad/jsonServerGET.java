package JsonServerConcept_Noushad;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class jsonServerGET {
   
	@Test
	public void sampleTest() {
		given().
		   when().get("http://localhost:3000/users").then().log().all();
		
		    
	}
}
