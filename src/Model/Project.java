package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Project implements Serializable{
	private Version version;
	private ArrayList<Version> versionList;
	private String projectName;
	
	public Project(){
		version = new Version();
		versionList = new ArrayList<Version>();
		projectName = "";
		
		versionList.add(version);
	}
	
	public void reqSetCategoryNum(int categoryNum){
		version.setCategoryNum(categoryNum);
	}
	
	public void reqCreateCategory(String categoryName, int RPValueNum){
		version.createCategory(categoryName, RPValueNum);
	}
	
	public void reqCreateRPValue(String RPValueName, int constraintsNum){
		version.reqCreateRPValue(RPValueName, constraintsNum);
	}
	
	public void reqCreateConstraints(String constraintsName){
		version.reqCreateConstraints(constraintsName);
	}
	
	public void addVersion(){
		version = new Version();
		versionList.add(version);
	}

	public Version getLastVersion(){
		return versionList.get(versionList.size()-1);
	}
	
	public void reqSetFeedback(String feedback){
		version.addFeedback(feedback);
	}

	public ArrayList<Version> getVersionList() {
		return versionList;
	}

	public void setVersionList(ArrayList<Version> versionList) {
		this.versionList = versionList;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getVersionListSize(){
		return this.versionList.size();
	}
}
