package FiterableReqSpecInterface;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.RequestSpecification;

public class FilterableReqSpec_Noushad 
{
	@Test
	public void m1()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="api/users";
		RequestSpecification Requ = RestAssured.given();
		Response res=RestAssured.post();
		
		FilterableRequestSpecification fil=   (FilterableRequestSpecification) Requ;
	
		System.out.println("Please check madi "+fil.getBaseUri());
		fil.getHeaders();
		
		
	}
	
	@Test
	public void m2()
	{
		
		RequestSpecification Requ = RestAssured.given();
		Requ.baseUri("https://reqres.in");
		Requ.basePath("/api/users");
		Requ.contentType(ContentType.JSON);
		Response resp=Requ.post();
	
		
		FilterableRequestSpecification fil=   (FilterableRequestSpecification) Requ;
		
		System.out.println("Please check madi "+fil.getBaseUri());
		System.out.println("Please check madi "+fil.getBasePath());
		System.out.println("Please check madi "+fil.getContentType());
		System.out.println("Please check madi "+fil.getMethod());
		
		FilterableResponseSpecification filResp= (FilterableResponseSpecification)resp;
		filResp.getStatusCode();
		filResp.getStatusLine();
		filResp.getResponseContentType();
		filResp.getLogDetail();
		//filResp.response().body("", Matchers.equalTo(""));
	}
}
