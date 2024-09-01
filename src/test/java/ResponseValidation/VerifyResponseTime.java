package ResponseValidation;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyResponseTime
{
	@Test
	public void verifyRespTimeMtd()
	{
				
		//Capture the response using a variable|We can use this obj for multiple functions
		  Response resp = given().get("http://49.249.28.218:8091/projects");
				
		//Using Response object get the log
		  resp.then().log().all();
		
		//Capture Response time from Header using time() based on milliseconds  
		  System.out.println(resp.getTime());
		  long respTime = resp.time();//returns time in milliSeconds
		  long respTimeInSec = resp.timeIn(TimeUnit.SECONDS);//returns time in Seconds
		  System.out.println("Response time in ms :"+respTime);
		  System.out.println("Response time in sec :"+respTimeInSec);
		  
		//Validate Response Time using Matchers class from org.hamcrest package
		  resp.then().assertThat().time(Matchers.lessThan(900L));
		  resp.then().assertThat().time(Matchers.greaterThan(300L));
		  resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
	}
}
