package RequestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import POJOClass_Utility.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Sc2_AddEmpToProject_RC 
{
	@Test
	public void addEmpToProjMtd()
	{
			/*Generate Random number or name using Faker class. This is why we prefer 
			 * using POJO class instead of JsonFile
			 */
			Faker fake = new Faker();
			String ProjName = fake.name().firstName();
			String EmpName =fake.name().fullName();
			System.out.println("Emp name generated======>"+EmpName);
			
			
			Random ran = new Random();
			int ranNum = ran.nextInt(100);
			//We can also concatenate the random number with the ProjectName to avoid duplicates
		
		//API 1- create a new project to add Employee 	
			//creating an object for POJO Utility
			ProjectPOJO prPojoObj = new ProjectPOJO(ProjName+"_"+ranNum, "ShinyIngrid", "created", 20);
				
				Response resp = given()
				.contentType(ContentType.JSON)
				.body(prPojoObj) //Once we pass the POJO obj, Rest Assured will take care of convertion of POJO to JSON before sending the request
				.when()
				.post("http://49.249.28.218:8091/addProject");
				
				resp.then().assertThat().statusCode(201).log().all();
				
				//Capture project Name from Response Body
				String projNameFrmRespBody=resp.jsonPath().get("projectName");
				System.out.println("Project Name from Resp Body :"+projNameFrmRespBody);
		
		//API 2 - Add Employee to the same Project		
				//Create an Object for EmployeePOJO class
					EmployeePOJO empPojoObj= new EmployeePOJO("TeamLead", "10/11/1988","abd@gmail.com" ,EmpName, 11, "9786678555",
							projNameFrmRespBody, "ROLE_EMPLOYEE", EmpName+"_123");	
				given().contentType(ContentType.JSON).body(empPojoObj)
				.when()
				.post("http://49.249.28.218:8091/employees")
				.then().assertThat().statusCode(201)
				.log().all();
					
		}
}
