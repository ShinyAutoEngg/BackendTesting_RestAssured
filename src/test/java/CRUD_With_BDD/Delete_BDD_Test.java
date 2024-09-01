package CRUD_With_BDD;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.base.Optional;

import static io.restassured.RestAssured.*;

import java.time.Duration;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class Delete_BDD_Test 
{
	@Test
	public void postDataToServer()
	{
		//Not using Request Specification because no body is needed
		
		//Displaying the response and validating
		
		given()
		.when()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_410")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}
