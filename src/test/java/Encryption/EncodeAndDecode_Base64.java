package Encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodeAndDecode_Base64 
{
	@Test
	public void enAndDeMtd()
	{
		String encodedData = new String(Base64.getEncoder().encode("ABC".getBytes()));
		System.out.println(encodedData);
		
		String decodedData =new String(Base64.getDecoder().decode(encodedData.getBytes()));
		System.out.println(decodedData);
		
		//Encode and Decode username/password
		String en = new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(en);
		
		String de= new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
		System.out.println(de);
	}
}
