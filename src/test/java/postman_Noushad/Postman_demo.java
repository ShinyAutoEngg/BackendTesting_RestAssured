package postman_Noushad;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Postman_demo {
   String token;
   String userId;
   String productId;
	@SuppressWarnings("unchecked")
	@Test
	public void sample1() {
		JSONObject json=new JSONObject();
		json.put("email", "shinyingrid@gmail.com");
		json.put("password", "Shopper@123");
		json.put("role", "SHOPPER");
		
		
		Response res = given().contentType(ContentType.JSON).body(json).
		
		   when().post("https://www.shoppersstack.com/shoppingj");
		   
		     res. then().log().all();
		     
		     token=res.jsonPath().get("data.jwtToken").toString();
		     userId=res.jsonPath().get("data.userId").toString();
	}
	
	@Test
	public void sample2() {
		
		Response res = given().contentType(ContentType.JSON).
		
		   when().get("https://www.shoppersstack.com/shopping/products/alpha");
		   
		     res. then().log().all();
		     productId=res.jsonPath().get("data.productId").toString();
		     
		    
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void sample3() {
		JSONObject json=new JSONObject();
		json.put("productId", 16);
		json.put("quantity", 2);
		
		System.out.println(token);
		
		System.out.println(userId);
		
		Response res = given().auth().oauth2(token).body(json).contentType(ContentType.JSON).
		
		   when().post("https://www.shoppersstack.com/shopping/shoppers/"+userId+"/carts");
		   
		     res. then().log().all();
		     
		  
	}
}
