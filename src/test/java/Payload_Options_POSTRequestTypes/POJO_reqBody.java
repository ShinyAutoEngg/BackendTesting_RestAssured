package Payload_Options_POSTRequestTypes;

public class POJO_reqBody 
{
	String createdBy;
	String projectName;
	int teamSize;
	String status;
	
	public POJO_reqBody()
	{
		
	}
	
	public POJO_reqBody(String createdBy,String projectName,int teamSize,String status)
	{
		this.createdBy=createdBy;
		this.projectName=projectName;
		this.teamSize=teamSize;
		this.status=status;
	}
	
	public String getCreatedBy()
	{
		return createdBy;
	}
	
	public String getProjectName()
	{
		return projectName;
	}
	
	public int getTeamSize()
	{
		return teamSize;
	}
	
	public String getStatus()
	{
		return status;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
