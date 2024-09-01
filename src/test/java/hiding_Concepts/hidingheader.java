package hiding_Concepts;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.groovy.runtime.callsite.PojoMetaClassGetPropertySite;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.networknt.schema.JsonSchemaIdValidator;
import com.ninza.hrm.constants.endPoints.IEndPoints_pract;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;



public class hidingheader implements Filter

{
//	
//	@Test
//	public void hidingMtd()
//	{
//		resp = given().get("http://49.249.28.218:8091/projects-paginated");	
//		
//
//		
//	}
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) 
	{
		Response response = ctx.next(requestSpec, responseSpec);
		
		//Mark Sensitive data as hidden
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		//.replaceAll("abcd", "****");
		
		return null;
	}

}




