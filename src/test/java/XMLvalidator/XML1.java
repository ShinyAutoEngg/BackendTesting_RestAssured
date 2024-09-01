package XMLvalidator;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers;

public class XML1 {
	  @Test
      public void test01() {
   	   given().when().get("https://reqres.in/api/users?page=2").
		      
		           then()
		           .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("X1.xsd")).
		                log().all();
      }
	  
	  
	  
	  @Test
      public void test02() {
   	   given().when().get("https://reqres.in/api/users?page=2").
		      
		           then()
		           .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xml.xsd")).
		                log().all();
      }
	  
	  ///
	  
	  
}
