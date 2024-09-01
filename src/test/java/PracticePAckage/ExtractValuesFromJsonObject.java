package PracticePAckage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
public class ExtractValuesFromJsonObject 
{
	@Test
	public void extractValuesFromStringJBODY() throws JsonMappingException, JsonProcessingException
	{
		String jbody="{\r\n"
				+ "					\"name\" : \"Shiny\",\r\n"
				+ "					\"age\"  : 35,\r\n"
				+ "					\"city\" : \"Bangalore\"\r\n"
				+ "			}";
				
			ObjectMapper omap = new ObjectMapper();
			JsonNode node = omap.readTree(jbody);
			Iterator<Map.Entry<String,JsonNode>> fields=node.fields();
			while(fields.hasNext())
			{
				Map.Entry<String,JsonNode> field=fields.next();
				String key=field.getKey();
				JsonNode value=field.getValue();
				System.out.println("Key :"+key);
				System.out.println("value :"+value);
			}
			
			/*
			 *  Key :name
				value :"Shiny"
				Key :age
				value :35
				Key :city
				value :"Bangalore"
			 */
	}
	
	
	@Test
	public void extractValuesFromJsonObjectJBODY() throws JsonMappingException, JsonProcessingException
	{
		JSONObject jbody = new JSONObject();
		jbody.put("ProjName", "Apocalypse");
		jbody.put("ProjID", "NH_234");
		jbody.put("status", "created");
		
		ObjectMapper omap = new ObjectMapper();
		JsonNode node = omap.readTree(jbody.toString());
		Iterator<String> fieldNames = node.fieldNames();
		while(fieldNames.hasNext())
		{
			String eachFieldName = fieldNames.next();
			System.out.println(eachFieldName);
		}
		
		/*   Output: 
		 *      ProjName
				ProjID
				status
		 */
	}
	
	
	@Test
	public void extractValuesFromJBODYConvertToArray() throws JsonMappingException, JsonProcessingException
	{
		HashMap<String, Object> hmap = new HashMap<>();
		hmap.put("empName", "Ingrid");
		hmap.put("empID", "EM_345");
		hmap.put("designation", "trainer");
		System.out.println(hmap);
		
		ArrayList<String> alk=new ArrayList<>();
		ArrayList<JsonNode> alv=new ArrayList<>();
		ObjectMapper omap = new ObjectMapper();
		JsonNode node = omap.readTree(hmap.toString());
		Iterator<Map.Entry<String, JsonNode>> fields=node.fields();
		while(fields.hasNext())
		{   
		 Entry<String, JsonNode> field = fields.next();
			alk.add(field.getKey());
			alv.add(field.getValue());
		}
		System.out.println(alk.size());
		System.out.println(alv.size());
	}
	
	
	
}
