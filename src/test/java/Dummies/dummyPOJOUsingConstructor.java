package Dummies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

class dummy1
{
	String name;
	String designation;
	long PhNo;
	String organization;
	
	
	public dummy1(String name, String designation,long PhNo,String organization)
	{
		this.name=name;
		this.designation=designation;
		this.PhNo=PhNo;
		this.organization=organization;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		this.name=n;
	}
	
	public String getDesignation()
	{
		return designation;
	}
	
	public void setDesignation(String d)
	{
		this.designation=d;
	}
	
	public long getPhNo()
	{
		return PhNo;
	}
	
	public void setPhNo(long p)
	{
		this.PhNo=p;
	}
	
	public String getOrganization()
	{
		return organization;
	}
	
	public void setOrganization(String o)
	{
		this.organization=o;
	}
	
	
}

	
	public class dummyPOJOUsingConstructor 
	{
		public static void main(String[] args) throws Throwable 
		{
			dummy1 dObj = new dummy1("Shiny","Trainee",9765757567L,"TekPyramid");
			System.out.println(dObj.getName());
			dObj.setOrganization("TestYantra"); //modifying value using setter
			String nV = dObj.getOrganization(); //getting the value using getter
			System.out.println(nV);//value is stored in a variable to be printed
			
			//To convert this POJO to JSON
			 //Step 1: Create Object for ObjectMapper Class
			ObjectMapper objMap = new ObjectMapper();
			//Step 2: Use writeValue() to pass New FilePath and pojoClass object
			objMap.writeValue(new File("./pojoTojson.json"), dObj);
			System.out.println("SERIALIZATION DONE");
			
		}
	}
