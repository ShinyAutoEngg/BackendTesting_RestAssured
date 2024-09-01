package HandlingJsonBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

public class jsonbodyToArray_getKeyAndValuesFromJsonBody 
{
	@Test
	public void m1() throws JsonMappingException, JsonProcessingException
	{
		JsonObject jbody = new JsonObject();
		jbody.addProperty("name", "Shiny");
		jbody.addProperty("age", 30);
		jbody.addProperty("city", "New-York");
		System.out.println(jbody);
		
		ArrayList<String> alKey=new ArrayList<>();
		ArrayList<Object> alValue=new ArrayList<>();
		ObjectMapper omap=new ObjectMapper();
		JsonNode node = omap.readTree(jbody.toString());
		Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
		while(fields.hasNext())
		{
			Map.Entry<String, JsonNode> field = fields.next();
//			System.out.println("key  :"+field.getKey());
//			System.out.println("value :"+field.getValue());
			alKey.add(field.getKey());
			alValue.add(field.getValue());
		}
		
		
		System.out.println(alKey);
		System.out.println(alValue);
	}  
}
