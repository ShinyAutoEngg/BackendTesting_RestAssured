package NoushadCheckMadi;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import io.restassured.http.ContentType;

public class RequestBodyClass {
   
	 public static void main(String[] args) {
		 Gulsan g=new Gulsan();
		 g.setName("Gulsan");
		 g.setId(1);
		 
		 Vivek v=new Vivek();
		 v.setName("Vivek");
		 v.setId(2);
		 ArrayList<Object> jsonbody=new ArrayList<>();
		 jsonbody.add(g);
		 jsonbody.add(v);
	   given().contentType(ContentType.JSON).body(jsonbody).
	   
	      when().post("https://reqres.in/api/users").
	      
	          then().log().all();
	}
}
