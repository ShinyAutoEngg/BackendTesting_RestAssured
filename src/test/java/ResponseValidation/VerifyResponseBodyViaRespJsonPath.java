package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseBodyViaRespJsonPath 
{
	@Test
	public void verifyRespTimeViaJsonPathMtd()
	{
		//Capture the response in a variable
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		
		//Display all project data
		resp.then().log().all();
		
		//Capturing data from Response Body
		int noOfEle = resp.jsonPath().get("numberOfElements");
		System.out.println("No of ele captured from Resp Body :"+noOfEle);
		
		Boolean isSorted=resp.jsonPath().get("pageable.sort.unsorted");
		System.out.println("Pageable data captured from Resp Body :"+isSorted);
	
		String projName=resp.jsonPath().get("content[0].projectName");
		System.out.println("Content data captured from Resp Body :"+projName);
		
		//Using TestNG Assertion with captured data from above
		Assert.assertEquals(noOfEle, 20);
		//Assert.assertEquals(isSorted, true);
		Assert.assertEquals(projName, "Orange_013");
		
		/*
		 * Instead of using TestNG we are using the inbuilt Assertion functionality
		 * of Rest Assured
		 */
		
		//Validate Resp Body using Rest Assured inbuilt assertion
		resp.then().assertThat().body("numberOfElements", Matchers.equalTo(20));//pass jsonpath in the first argument
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectName", Matchers.equalTo("Orange_013"));
			
	}
}
