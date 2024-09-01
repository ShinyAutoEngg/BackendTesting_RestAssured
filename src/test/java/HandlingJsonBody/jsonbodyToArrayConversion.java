package HandlingJsonBody;

public class jsonbodyToArrayConversion
{
	//Declaring the variables as private
	private String name;
	private int age;
	
	//Getters and Setters
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	@Override
	public String toString()
	{
		 return "jsonbodyToArrayConversion{name='"+name+"',age="+age+"}";   //className{name='',city='',age=int}
	}
	
	
}
