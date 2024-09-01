package ResponseValidation;

import static io.restassured.RestAssured.*;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

public class VerifyRespBodyData_ComplexJsonXPath
{
	@Test
	public void complexJsonXPathMtd()
	{
		//Capture the response in a variable
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
				
		//Display all project data
		resp.then().log().all();
		
		//Using JsonPath class from com.jayway.jsonpath
		//Project ID list
		List<String> projIDList = JsonPath.read(resp.asString(),"content[*].projectId");
		System.out.println(projIDList.size());
		for(String pil:projIDList)
		{
		System.out.println(pil);
		}
		
		//Project Name List
		List<String> projNameList = JsonPath.read(resp.asString(),"content[*].projectName");
		for(String pnl:projNameList)
		{
		System.out.println(pnl);
		}
		
		//Validate on condition
		List<String> onConditionProjID=JsonPath.read(resp.asString(),"content[*].[?(@.projectName=='Milaap')].projectId");
		String actProjID = onConditionProjID.get(0); //list returns an array even if it is one value. So we use get method to pick the index
		Assert.assertEquals(actProjID,"NH_PROJ_860" );
		/*
		 * The extracted data actProjID can be used for
		 * Assertion
		 * Request Chaining 
		 * DB Validation
		 */
	}
}
