package mthChainAndStatImp;
import static mthChainAndStatImp.classA_MCandStatImp.*;

import org.testng.annotations.Test;

public class classB_MCandStatImp 
{
	@Test
	public void execMethod()
	{
		m1().m2().m3().m4();
	}
	
	public void m4()
	{
		System.out.println("Class B==>m4");
	}
}
