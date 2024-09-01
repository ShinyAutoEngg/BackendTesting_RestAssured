package Encryption;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdatePayrollInfoViaAESEncryption 
{
	@Test
	public void payrollInfoViaAESMtd() throws Throwable
	{
		 String jsonBody = "{ \"employee\": { \"empId\": \"NH_PROJ_1444\", \"designation\": \"ArchitectSr\", \"dob\": \"01/01/1895\", \"email\": \"employee1234@example.com\", \"empName\": \"John_Doe\", \"experience\": 7, \"mobileNo\": \"1234567890\", \"project\": \"ProjectX\", \"role\": \"Developer\", \"username\": \"johndoe\" }, \"basicPlusVda\": 50000, \"hra\": 10000, \"insurance\": 5000, \"lta\": 10000, \"lwf\": 200, \"netPay\": 72000, \"payroll_id\": 101, \"pf\": 6000, \"pt\": 200, \"stat_bonus\": 3000, \"status\": \"Active\" }"; 
		/*
		 * If we pass this jsonBody as json object => given().body(jsonBody), we get 500 status code
		 * Internal server error : server is not accepting the data.Hence we try encryption
		 */
		
		//private key : Ac03tEam@j!tu_#1
		EncryptAndDecryptUtility enDeUtil = new EncryptAndDecryptUtility();
		String privatekey ="Ac03tEam@j!tu_#1";
		String encryptedBody=enDeUtil.encrypt(jsonBody, privatekey);
		Response resp = given()
		.body(encryptedBody) 
		.log().all()//body is taken from swagger : payroll controller = put() - update payroll via Encrypted data
		.when()
		.put("http://49.249.28.218:8091/payroll") ; //put() to modify
		resp.then().log().all();
		
		//String encryptedRespBody=encryptedBody;
		//String encryptedRespBody ="dK/1HK1CXpF7BtyThypbbiaiVjjX6/SdogNdXaVmfK2phqPpDKb3yR5T3f8VIcwV9NQRnaC5OkYVd++tCNHdjYB8lIzzOF2LhSlGh1d1FTj7TzwfuMVVBHqUSQyLEnHXoe5BbqwXYPrdp+8Va8nPYC30qVfQ5myWpEhuY/vDqHRs7vcNpAw2pFu7YxczBaf/DAjSTpWFvY59MTxL6HJusn6VpvdQmCXAi4vsKPJrjVQLtRlspgLqyhW4kisyCT+nso91y9CQrKQHT63KauIwe3OOVZVVaAoxJVpsAmjZfmMMDppax42A2NIUjhXv07A43F4gvEsR8BLjC6Ewo86+UkbdnyqSkCQfysAsTZXA3YRGdcQckRiDJAN33nvF+BEuHqZ4f1iW9t1KgM0H/RFlXQeDv6PCD7AUoc/uVWhciEwEsNuYPsf1e5sKtE+6Yk0saIgksCEtFdxkRQ4McCh8mZoxfaGaiiEYwT/KOPnnKr+VO9Or8OU7sAPw6Zn7vCoK4z5CKAgI+7BOFrE+uYrHr2ZKKTTE5Fd3+hm4siA6RpFDD5TO0RW/3hSjN5MqaE+sCpNc4z+AqJhalDjLMByZhg==";
		//System.out.println(enDeUtil.decrypt(encryptedRespBody, privatekey));
		
		String decryptedRespBody=enDeUtil.decrypt(resp.getBody().asString(), privatekey);
		System.out.println(decryptedRespBody);
	}
}
