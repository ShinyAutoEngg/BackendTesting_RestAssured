package MockingSolution_PANCARD;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.lang3.StringUtils;
import spark.Spark;

public class mock_CreditCard 
{
	public static void main(String[] args) 
	{
		Spark.port(8889); //once portNo is set we can run the developed mocking solution using this port no
		
		
		//to provide mocking solution to post()
		Spark.post("/credit-card", (req,res)->    //First arg : end point Second arg: Req,resp     
		{
			String response ="";
			String card = JsonPath.read(req.body().toString(),"$.creditcard");
		//	if(card.equals("1234567891234"))
			if(StringUtils.equalsAny(card, "1234567891234","233434545657876","1234567891234"))
			{
				response ="{\"status\":\"Payment success\"}";
				res.status(200);
			}
			else
			{
				response ="{\"status\":\"Payment failed\"}";
				res.status(404);
			}
			return response;
		}
		
		); 
		System.out.println("===========RUNNING===========");
	}
}
