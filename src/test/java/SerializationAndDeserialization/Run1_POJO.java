package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ProjectNew
{	   
	   String projectName;
	   String projectStatus;
	   int teamSize;
	   List<String> teamMember;
	   ProjectManager pmObj;
	 	   
	//CONSTRUCTOR
	   public ProjectNew(String projectName,String projectStatus,int teamSize,List<String> teamMember,ProjectManager pmObj )
	   {
		   this.projectName=projectName;
		   this.projectStatus=projectStatus;
		   this.teamSize=teamSize;
		   this.teamMember=teamMember;
		   this.pmObj=pmObj;
		   
	   }
	   //GETTERS AND SETTERS
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public List<String> getTeamMember() {
		return teamMember;
	}
	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}
	public ProjectManager getProjectManager() {
		return pmObj;
	}
	public void setProjectManager(ProjectManager projectManager) {
		this.pmObj = projectManager;
	}

}


class ProjectManager
{
	String name;
	String empID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	
	public ProjectManager(String name, String empID)
	{
		super();
		this.name=name;
		this.empID=empID;
	}
	
}



public class Run1_POJO
{
	public static void main(String[] args) throws Throwable, DatabindException, IOException 
	{
		List<String> lst = new ArrayList<String>();
		lst.add("John");
		lst.add("Steve");
		lst.add("David");
		ProjectManager pmanObj=new ProjectManager("Deepak", "tp05");
		
		ProjectNew pnewObj = new ProjectNew("Orange","created",10,lst,pmanObj);
		System.out.println(pnewObj.getProjectName()+"\t"+pnewObj.getProjectStatus()+"\t"+pnewObj.getTeamSize()+"\t"+pnewObj.getTeamMember()+"\t"+pnewObj.getProjectManager());
		
		
		//SERIALIZATION - converting POJO to JSON
		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File("./ProjectNew.json"), pnewObj);
		System.out.println("======SERIALIZATION DONE===========");
	}
}
