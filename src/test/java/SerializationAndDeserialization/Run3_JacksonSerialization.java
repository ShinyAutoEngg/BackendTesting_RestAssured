package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class demoProject //POJO class - Plain Old Java Object
{
	private String projectName;
	private String createdBy;
	private int teamSize;
	private String status;
	
	public demoProject()  //Empty constructor
	{
		
	}
	//Constructor
	public demoProject(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

	public class Run3_JacksonSerialization 
	{
		public static void main(String[] args) throws Throwable, DatabindException, IOException 
		{
			demoProject dpObj = new demoProject("Charlie","ShinyIngrid",17,"created");
			ObjectMapper objMap = new ObjectMapper();
			objMap.writeValue(new File("./project.json"), dpObj);
			System.out.println("========SERIALIZATION DONE==========");
		}
	}
