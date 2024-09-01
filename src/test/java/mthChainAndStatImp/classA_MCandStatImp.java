package mthChainAndStatImp;

public class classA_MCandStatImp
{
	public static classA_MCandStatImp m1()
	{
		System.out.println("Class A==>m1");
		return new classA_MCandStatImp();
	}
	
	public static classA_MCandStatImp m2()
	{
		System.out.println("Class A==>m1");
		return new classA_MCandStatImp();
	}
	
	public static classB_MCandStatImp m3()
	{
		System.out.println("Class A==>m3");
		return new classB_MCandStatImp();
	}
}
