package HandlingJsonBody;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class getValueFromJsonFile
{
	@Test
	public void getUrlFromJsonBodyDemoFile() throws IOException
	{
		File f = new File("./src/test/resources/JsonBodyDemo.json");
		
		ObjectMapper omap = new ObjectMapper();
		JsonNode node = omap.readTree(f);
		String url=node.get("url").toString();
		String username=node.get("username").asText();
		System.out.println(url);
		System.out.println(username);
	}
}
