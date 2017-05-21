package Control;

import Model.*;

public class ProjectManager {
	private Project project;
	
	ProjectManager(){
		project = new Project();
	}
	
	public void reqCreateProject(String projectName, int categoryNum){
		project.setProjectName(projectName);
		project.reqSetCategoryNum(categoryNum);
	}
	
	public void reqCreateCategory(String categoryName, int RPValueNum){
		project.reqCreateCategory(categoryName, RPValueNum);
	}
	
	public void reqCreateRPValue(String RPValueName, int constraintsNum){
		project.reqCreateRPValue(RPValueName, constraintsNum);
	}
	
	public void reqCreateConstraints(String constraintsName){ 
		project.reqCreateConstraints(constraintsName);
	}
	
	public void reqAddVersion(int categoryNum){
		project.addVersion();
		project.reqSetCategoryNum(categoryNum);
	}
	
	public Version reqGetVersion(){
		return project.getLastVersion();
	}
	
	public void reqSetFeedback(String feedback){
		project.reqSetFeedback(feedback);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	public int reqGetVersionListSize(){
		return this.project.getVersionListSize();
	}
	public Version reqGetLastVersion(){
		return project.getLastVersion();
	}
}
