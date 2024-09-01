package JacksonNotations;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


	@JsonPropertyOrder
	(
		value= { 
				"teamSize",							//order has to be as follows
				"createdBy",    
				"projectName",
				"status"
		}
	)
	
	
	@JsonIgnoreProperties
	(
		value= {              //this value needs to be ignored
				"teamSize"
		       },
		allowSetters = true       //modification is being done, so we need to allow setters
	)
	
	
		
class demoProject //POJO class - Plain Old Java Object
{
	private String projectName;
	@JsonProperty(value="created By") //trying to include space in between
	private String createdBy;
	private int teamSize;
	private String status;
	
	//Empty constructor - for deserialization purpose
	public demoProject()  
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
public class demoForJacksonNotations
{
	public static void main(String[] args) throws Throwable, DatabindException, IOException 
	{
		demoProject dpObj = new demoProject("Charlie","ShinyIngrid",17,"created");
		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File("./project.json"), dpObj);
		System.out.println("========SERIALIZATION DONE==========");
	}
}
