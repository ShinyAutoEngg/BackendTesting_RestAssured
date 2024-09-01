package mthChainAndStatImp;

import org.testng.annotations.Test;

public class classBforMethodChaining 
{
	@Test
	public void sample()
	{
		classAforMethodChaining obj = new classAforMethodChaining();
		obj.m1().m2().m3().m4();
	}
	
	public void m4()
	{
		System.out.println("m4() from classBforMethodChaining");
		
	}
}
