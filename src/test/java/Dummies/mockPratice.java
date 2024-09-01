package Dummies;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class mockPratice
{
	/*
	 * Base URL - https://www.shoppersstack.com/shopping
	 * username : shinyingrid@gmail.com
	 * password : Shopper@123
	 */
	
	
	@Test
	public void tryAll()
	{
		String jobj="{\r\n"
				+ "  \"email\": \"shinyingrid@gmail.com\",\r\n"
				+ "  \"password\": \"Shopper@123\",\r\n"
				+ "  \"role\": \"SHOPPER\"\r\n"
				+ "}";
	
		Response resp=given().contentType(ContentType.JSON).body(jobj).when().post("https://www.shoppersstack.com/shopping/users/login");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 ").time(Matchers.lessThan(4000L)).body("message",Matchers.equalTo("OK")).and().body("data.firstName",Matchers.equalTo("Shiny"));	
	}
}

