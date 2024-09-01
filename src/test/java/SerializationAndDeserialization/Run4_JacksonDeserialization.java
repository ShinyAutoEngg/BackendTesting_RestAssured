package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run4_JacksonDeserialization 
{
	public static void main(String[] args) throws Throwable, DatabindException, IOException 
	{
		ObjectMapper objMap = new ObjectMapper();
		demoProject objpojo=objMap.readValue(new File("./project.json"),demoProject.class ); 
		//returning the file back to pojo/java object and it is stored in an object of the pojo class
		
		//Using the obj we can display the data as java object
		System.out.println(objpojo.getProjectName());
		System.out.println(objpojo.getCreatedBy());
		System.out.println(objpojo.getStatus());
		System.out.println(objpojo.getTeamSize());
		System.out.println("======DESERIALIZAION DONE======");
	}
}


