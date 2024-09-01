package ShopperLogin_Noushad;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class login {
    
	public static String shopperId;
	public static String jwtToken;
	public static String productId;
	public static String itemId;
	@Test
	public void login() { 
		HashMap<String, String> map=new HashMap<>();
		map.put("email", "shinyingrid@gmail.com");
		map.put("password", "Shopper@123");
		map.put("role", "SHOPPER");
		
		Response res=RestAssured.given().contentType(ContentType.JSON).body(map).
		        when().post("https://www.shoppersstack.com/shopping/users/login");
		        
		shopperId=res.jsonPath().get("data.userId").toString();
		jwtToken=res.jsonPath().get("data.jwtToken").toString();
		
		            res.then().log().all();
		            System.out.println("login");
		            listproduct();
 	}
	
	public static void listproduct() {
		Response res=RestAssured.given().contentType(ContentType.JSON).
		        when().get("https://www.shoppersstack.com/shopping//products/alpha");
		        
		productId=res.jsonPath().get("data[0].productId").toString();
		
		            res.then().log().all();
		            System.out.println("list Product");
		            AddCart();
	}
	
	public static void AddCart() { 
		HashMap<Object, Object> map=new HashMap<>();
		map.put("productId",productId );
		map.put("quantity", 2);
		
		
		Response res=RestAssured.given().contentType(ContentType.JSON).headers("Authorization","Bearer "+jwtToken).body(map).
		        when().post("https://www.shoppersstack.com/shopping/shoppers/"+shopperId+"/carts");
		        
		itemId=res.jsonPath().get("data.itemId").toString();
//		jwtToken=res.jsonPath().get("data.jwtToken").toString();
//		
		            res.then().log().all();
		            getCart();
//		            
		            System.out.println("AddCart");
//		            listproduct();
 	}
	
	public static void getCart() {
		Response res=RestAssured.given().contentType(ContentType.JSON).
		        when().get("https://www.shoppersstack.com/shopping/shoppers/"+shopperId+"/carts");
		        
		//productId=res.jsonPath().get("data[0].productId").toString();
		
		            res.then().log().all();
		            System.out.println("getCart");
		            Update();
	}
	
	public static void Update() { 
		HashMap<String, Object> map=new HashMap<>();
		map.put("productId",productId );
		map.put("quantity", 4);
		
		Response res=RestAssured.given().contentType(ContentType.JSON).body(map).
		        when().put("https://www.shoppersstack.com/shopping/shoppers/"+shopperId+"/carts/"+itemId+"");
		        
//		shopperId=res.jsonPath().get("data.userId").toString();
//		jwtToken=res.jsonPath().get("data.jwtToken").toString();
		System.out.println("Update");
		            res.then().log().all();
		            
		            listproduct();
 	}
	
	
	public static void DeleteCart() {
		Response res=RestAssured.given().contentType(ContentType.JSON).
		        when().delete("https://www.shoppersstack.com/shopping/shoppers/"+shopperId+"/carts/"+productId+"");
		        
		System.out.println("Delete");
		            res.then().log().all();
		          
	}
	
	
}
