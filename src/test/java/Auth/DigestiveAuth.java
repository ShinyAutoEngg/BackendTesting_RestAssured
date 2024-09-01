package Auth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DigestiveAuth 
{
	@Test
	public void digestiveAuthMtd()
	{
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/login")
		.then().log().all();
		
		//From Resp body : Accept=*/*
		//data is encoded and encrypted using MD5 algorithm
   }
}
	
