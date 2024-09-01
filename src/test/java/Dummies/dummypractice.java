package Dummies;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import ExcelUtility.ExcelFileUtility;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class dummypractice 
{
	@Test
	public void dum() throws Throwable
	{
		Response resp = given()
		.when().log().all()
		.get("https://reqres.in/api/users");
		resp.then().log().all();
		
		//Static data
		int page1 = resp.jsonPath().get("page");
		System.out.println(page1);
		
		//dynamic data reading
		List<String> FNames = JsonPath.read(resp.asString(),"data[*].first_name");
		//System.out.println(FNames);
		int l=FNames.size();
		HashMap<Object, Object> hs = new HashMap<Object, Object>();
		for(String s: FNames)
		{
			hs.put("first_name",s);
			System.out.println(hs.entrySet());
			
			
		}

		ExcelFileUtility elib = new ExcelFileUtility();
		for(int i=0;i<l;i++)
		{
				for(String s1 : FNames)
				{
				elib.setDataIntoExcel("NewSheet2", i, 0, s1);
				}
		}
		
		
	}
}
