package SerializationAndDeserialization;

import com.google.gson.Gson;

public class Gson_SerializationAndDeserialization
{
	public static void main(String[] args)
	{
		demo dobj= new demo("Shiny",35);
		Gson gson = new Gson();
		String json=gson.toJson(dobj);
		System.out.println("Serialization :"+json.toString());
		
		demo newObj=gson.fromJson(json,demo.class);
		System.out.println("Deserialization :"+newObj.toString());
	}
	
	
}


class demo
{
	String name;
	int age;
	
	public demo(String name,int age)
	{
		this.name=name;
		this.age=age;
	}

	@Override
	public String toString()
	{
		return "Name: "+name+",Age: "+age;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}