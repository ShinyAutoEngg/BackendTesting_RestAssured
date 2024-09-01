package MockingSolution_CreditCard;
/*
 * Request body 
 * {  "creditcard" : "1234567891234",
 * 	  "cvv" : "123",
 * 	  "cardName":"deepak"
 * 
 * Response Body
 * { "status" : "success"
 */

import org.apache.poi.util.StringUtil;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;
import spark.utils.StringUtils;

public class Mock_CC 
{
	public static void main(String[] args) 
	{
		Spark.port(8889);   //choosing the port no to be 8889
		Spark.post("/credit-card", (req,res)->{  //if anyone sends the /cc end point, store in req variable
												//use the res to respond back				
			String response;
			String card = JsonPath.read(req.body().toString(),"$.creditcard");  //I want to capture creditcard from reqbody
			//if(StringUtil.)
			if(card.contains("1234567891234"))
			{
				response ="Status==>Payment Successful";
				res.status(200);
			}
			else 
			{
				response="Status==>Payment unsuccessful";
				res.status(404);
			}
			res.type("application/json");
			return response;
		});    ///credit-card ==>end point

	}
}
