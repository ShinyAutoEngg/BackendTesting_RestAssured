package Auth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PreEmptiveAuth 
{
	@Test
	public void preEmptiveAuthMtd()
	{
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/login")
		.then().log().all();
		
		//From resp body : Authorization=Basic cm1neWFudHJhOnJtZ3lAOTk5OQ==
		//It is encrypted but visible. Can be decrypted
		//Hence less secure
	}
}
