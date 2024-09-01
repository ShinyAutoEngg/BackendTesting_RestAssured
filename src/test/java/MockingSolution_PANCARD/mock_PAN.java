package MockingSolution_PANCARD;

import org.mockito.Mockito;
import org.testng.Assert;

class PANCardClass
{
	public String isValid(String panCard) //removed static here. Else this method wont be called using mockobj
	{
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")==true)
		{
			return "Valid PAN";
		}
		else
		{
			return "Invalid PAN";
		}
	}
	
	/* Creating another method to develop mocking solution
	 */
	public static PANCardClass getMockObject()
	{
		PANCardClass mocKobj = Mockito.mock(PANCardClass.class); //returns class obj | which class I need to mock
		Mockito.when(mocKobj.isValid("ABCDS1234F")).thenReturn("Valid PAN");
		Mockito.when(mocKobj.isValid("SDDSFFJY344")).thenReturn("Invalid PAN");
		Mockito.when(mocKobj.isValid("FGVC3456F")).thenReturn("Valid PAN");
		return mocKobj;
	}
	 	
}
public class mock_PAN 
{
	public static void main(String[] args) 
	{
		//Approach 3: 
		PANCardClass Obj=PANCardClass.getMockObject();
		System.out.println(Obj.isValid("ABCDS1234F")); //valid
		System.out.println(Obj.isValid("SDDSFFJY344"));//invalid
		System.out.println(Obj.isValid("SADNSALDN3")); //null if not mentioned in the stub
		
		//using assertion to check if invalid data is valid  ==throws Assertion error : Expected valid actual null
		Assert.assertEquals(Obj.isValid("SDFCGFGHGFHGH"),"valid");  
		
		
		//Approach 1 to execute PANCardClass
//		PANCardClass obj = new PANCardClass();
//		obj.isValid("ABFC123S");
//		obj.isValid("CBFHL1236S");
		
		//Approach 2: Make the method static and call using classname
		//System.out.println(PANCardClass.isValid("ALPHA1234D")); //valid
		//System.out.println(PANCardClass.isValid("BETA3466")); //invalid
	
	/*
	 * During testing, they will provide dummy PANCARD details which is considered to be stubs. We need to use only
	 * those data to test (Rule of Mocking Solution/Stubs)
	 */
		
		
		
		
}
}
