package Encryption;

import org.testng.annotations.Test;

public class AES_Encryption 
{
	//private key : Ac03tEam@j!tu_#1
	
	
	@Test
	public void aesEncryptMtd() throws Throwable
	{
		String privateKey = "Ac03tEam@j!tu_#1";
		String data ="ShinyIngrid";
	//	String jsonData="{\"name\":\"Shiny\",\"id\":\"Tp_01\"}";
		String jsonData = "{\r\n"
				+ "\"name\":\"Shiny\",\r\n"
				+ "\"id\":\"Tp_01\"\r\n"
				+ "}";
		
		//Create object for EncryptAndDecryptUtility
		EncryptAndDecryptUtility enDeUtil = new EncryptAndDecryptUtility();
		System.out.println(enDeUtil.encrypt(data, privateKey));
		System.out.println(enDeUtil.decrypt("idkdm+MoDPI5J/tnLldKBg==", privateKey));
		
		System.out.println(enDeUtil.encrypt(jsonData, privateKey));
		System.out.println(enDeUtil.decrypt("ZlhjufflUKNlOBTwXAh5DwBjbfvOXd+6v2agxndRsj8=", privateKey));
	}
}
