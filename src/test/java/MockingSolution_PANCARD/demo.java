package MockingSolution_PANCARD;

import org.mockito.Mockito;

class demopan 
{
	public String isValid(String pancard)
	{
		if(pancard.matches("[A-Z]{3}[0-9]{2}[a-z]{3}")==true)
		{
			return "Valid";
		}
		else
		{	
		return "Invalid";	
		}
	}
	
	
	public static demopan mockingSol()
	{
		demopan mObj=Mockito.mock(demopan.class);
		Mockito.when(mObj.isValid("ASD23sfg")).thenReturn("IS VALID");
		Mockito.when(mObj.isValid("Afgg3sfg")).thenReturn("IS NOT VALID");
		return mObj;
	}
}

public class demo
{
	public static void main(String[] args)
	{
		demopan obj=demopan.mockingSol();
		System.out.println(obj.isValid("ASD23sfg"));
		System.out.println(obj.isValid("Afgg3sfg"));
		System.out.println(obj.isValid("Adsfljffg"));
	}
}
