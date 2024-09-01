package PojoPractice;

public class pojoChild 
{
	String Designation;
	String Company;
	
	public pojoChild()
	{
		
	}
	
	public pojoChild(String Designation,String Company)
	{
		this.Designation=Designation;
		this.Company=Company;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getDesignation() {
		return Designation;
	}

	public String getCompany() {
		return Company;
	}

}
