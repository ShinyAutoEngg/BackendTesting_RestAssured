package Dummies;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class pojo
{
	String name;
	String location;
	long id;
	String email;
	List<String> categories;
	Object product;
	List<Object> shipping;
	
	public pojo(String name ,String location,long id,String email,List<String> categories,Object product,List<Object> shipping) 
	{
		this.name =name;
		this.location=location;
		this.id=id;
		this.categories=categories;
		this.email=email;
		this.product=product;
		this.shipping=shipping;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object getProduct() {
		return product;
	}

	public void setProduct(Object product) {
		this.product = product;
	}

	public List<Object> getShipping() {
		return shipping;
	}

	public void setShipping(List<Object> shipping) {
		this.shipping = shipping;
	}
	
	
}



public class endToEndDemo
{
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException 
	{
		product pd = new product("Sofa", 20);
		shipping shp1=new shipping("cargo", 10);
		shipping shp2=new shipping("cargo", 10);
		ArrayList<Object> shipList=new ArrayList<>();
		shipList.add(shp1);
		shipList.add(shp2);
		ArrayList<String> categ= new ArrayList<>();
		categ.add("Living Room");
		categ.add("Kitchen");
		categ.add("Patio");
		pojo pobj= new pojo("Blue Elephant", "Antwerpen", 87334, "blueElephant@gmail.com", categ, pd, shipList);
		ObjectMapper obMap = new ObjectMapper();
		obMap.writeValue(new File("./manData.json"), pobj);
	}
}
