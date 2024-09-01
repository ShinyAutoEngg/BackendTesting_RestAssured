package wiremock;

import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;

public class wiremock_script 
{
	@Test
	public void demo()
	{
		WireMockServer ws = new WireMockServer(8081);
		ws.start();
	
		
		
		ws.stop();
	}
}
