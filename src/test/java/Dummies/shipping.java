package Dummies;

public class shipping 
{
	String mode;
	int days;
	
	public shipping(String mode,int days)
	{
		this.mode=mode;
		this.days=days;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	
}
