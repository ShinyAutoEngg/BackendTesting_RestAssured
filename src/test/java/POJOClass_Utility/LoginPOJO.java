package POJOClass_Utility;

public class LoginPOJO 
{
	String password;
	String username;
	
	//EMPTY CONSTRUCTOR FOR DESERIALIZATION
	private LoginPOJO()
	{
		
	}
	
	//CONSTRUCTOR
	public LoginPOJO(String pwd,String uname)
	{
		this.password=pwd;
		this.username=uname;
	}
	
	
	//GETTERS and SETTERS
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String un)
	{
		this.username=un;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String pwrd)
	{
		this.password=pwrd;
	}
}
