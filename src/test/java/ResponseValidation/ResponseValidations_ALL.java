package ResponseValidation;

import static io.restassured.RestAssured.given;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ResponseValidations_ALL 
{
	@Test
	public void verifyRespTimeMtd()
	{
		String data="NH_PROJ_104";
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		resp.then().assertThat().contentType(ContentType.JSON);
		resp.then().assertThat().time(Matchers.lessThan(2000L));
		resp.then().assertThat().statusCode(Matchers.equalTo(200));
		resp.then().assertThat().statusLine(Matchers.equalTo("HTTP/1.1 200 "));
		resp.then().assertThat().header("Pragma", "no-cache");
		resp.then().assertThat().body("content[0].projectId",Matchers.equalTo(data));
		//resp.then().body("content[0].projectId", Matchers.equalTo(data));
		resp.then().assertThat().body("content[0].projectId",Matchers.equalTo(data)).and().body("content[0].createdBy",Matchers.equalTo("Me"));

		//resp.then().assertThat().body("content[0].hobbies", Matchers.hasItem("null"));
		//used in case of collection= array of values
	}	
		@Test
		public void getFromResponseHeader()
		{
		String data="NH_PROJ_5219";
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		System.out.println("Status code from respHeader :"+resp.getStatusCode());
		System.out.println("Status line from respHeader :"+resp.getStatusLine());
		System.out.println("get value of something from respHeader :"+resp.getHeader("Connection"));
		System.out.println("get content type of resp :"+resp.getContentType());
		System.out.println(resp.getDetailedCookie(""));
		System.out.println("get class name from resp :"+resp.getClass());
		System.out.println("get time in seconds :"+resp.getTimeIn(TimeUnit.SECONDS));
		System.out.println("get time in milliseconds :"+resp.getTime());
		System.out.println("get session ID :"+resp.getSessionId());
		List<Header> listHeaders = resp.getHeaders().asList();
		for(Header h:listHeaders)
		{
			System.out.println("HeaderInfo==>"+h);
		}
		int pathValue = resp.path("numberOfElements");
		System.out.println(pathValue);
		}	
		
		
		@Test
		public void getFromResponseBody()
		{
			String data="NH_PROJ_5219";
			Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
			resp.then().log().all();
			String name=resp.jsonPath().get("content[0].projectName");
		
			
			System.out.println(name);
			List<String> values=JsonPath.read(resp.asString(),"content[*].[?(@.projectName=='"+data+"')].createdOn");
			for(String v : values)
			{
			System.out.println(v);
			}
			List<String> co=JsonPath.read(resp.asString(),"content[*].projectName");
			for(String c : co)
			{
			System.out.println(c);
			}
		}
		
		

//		//System.out.println(resp.getHeaders());
//		System.out.println(resp.getHeaders().getValues("keep-Alive"));
//		//resp.prettyPrint();//similar to log().all();
//		System.out.println(resp.asString());//body looks like jsonformat but is in string
//		System.out.println("Noushad => "+resp.jsonPath().get("content[0].projectName").toString());
//		Object uure = resp.jsonPath().get("content[0].projectName");
//		String str=(String)uure;
//		System.out.println(str);
	

}
	
