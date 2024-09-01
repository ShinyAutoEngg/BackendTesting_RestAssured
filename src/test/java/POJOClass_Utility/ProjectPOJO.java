package POJOClass_Utility;

public class ProjectPOJO
{
	/*Looking at the swagger document (body) that will be in JSON, we are creating the POJO class
	variables here below
	{
		"createdBy":"string",
		"projectName":"String",
		"status":"String",
		"teamSize":0
	}  	*/
	
	String projectName;
	String createdBy;
	String status;
	int teamSize;
	
	//Constructor
	public ProjectPOJO(String projectName, String createdBy, String status, int teamSize) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	//Getters and Setters
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	
	
}
