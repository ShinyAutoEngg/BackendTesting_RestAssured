package ResponseValidation;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.JSONParser;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class child
{
	@Test
	public void demo() throws StreamWriteException, DatabindException, IOException
	{
		//Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		Response resp = given().get("https://reqres.in/api/users");
		resp.then().log().all();
		//resp.getBody().toString();
		ResponseBody rbs = resp.body();  //address |so use asString()
		
		
		//Object path = rbs.path("numberOfElements", "20");
		//JSONObject jobj = new JSONObject();
		File f=new File("./filenoushad1.josn");
		ObjectMapper map=new ObjectMapper();
		map.writeValue(f, rbs);
	}
	
	
	@Test
	public void sampletest() throws Throwable {
		
		FileReader f1=new FileReader("C:\\Users\\Shiny Ingrid C\\eclipse-workspace1\\BackEndTestingProject\\folder\\filenoushad.josn");
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(f1);
		Map map=(Map) obj;
		System.out.println(map.get("logRepository"));
		
		
	}
}
	
