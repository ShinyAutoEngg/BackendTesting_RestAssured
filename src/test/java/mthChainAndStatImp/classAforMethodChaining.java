package mthChainAndStatImp;

import org.testng.annotations.Test;

public class classAforMethodChaining 
{
	//returns current class object
	public classAforMethodChaining m1()
	{
		System.out.println("m1() from classAforMethodChaining");
		return new classAforMethodChaining();
	}
	
	//returns current class object
	public classAforMethodChaining m2()
	{
		System.out.println("m2() from classAforMethodChaining");
		return new classAforMethodChaining();
	}
	
	//returns other class object
	public classBforMethodChaining m3()
	{
		System.out.println("m3() from classAforMethodChaining");
		return new classBforMethodChaining();
	}
	
}
