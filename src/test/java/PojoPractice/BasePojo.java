package PojoPractice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BasePojo
{
	String name;
	int teamSize;
	List<String> hobbies;
	List<Object> pojoChild;
	
	
	public BasePojo()
	{
		
	}
	
	public BasePojo(String name,int teamSize,List<String> hobList,List<Object> pojoChild)
	{
		this.name=name;
		this.teamSize=teamSize;
		this.hobbies=hobList;
		this.pojoChild=pojoChild;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<Object> getPojoChild() {
		return pojoChild;
	}

	public void setPojoChild(List<Object> pojoChild) {
		this.pojoChild = pojoChild;
	}
	
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException
	{
		pojoChild obj1 = new pojoChild("TeamLead","CTS");
		pojoChild obj2 = new pojoChild("Manager","TCS");
		
		List<String> hobList = new ArrayList<String>();
		hobList.add("Cooking");
		hobList.add("Reading");
		
		List<Object> PojList = new ArrayList<Object>();
		PojList.add(obj1);
		PojList.add(obj2);
		
		BasePojo bpj = new BasePojo("ShinyIngrid",10,hobList,PojList);
		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File("./file.json"), bpj);
		
		System.out.println(" =============== END ==============");
		
		
	}
}
