package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class RepresentativeValue implements Serializable{
	private ArrayList<String> constraintsList;
	private int constraintsNum;
	private String RPValueName;
	private int propertyNum;

	public RepresentativeValue(String RPValueName){
		constraintsList = new ArrayList<String>();
		constraintsNum = 0;
		this.RPValueName = RPValueName;
		propertyNum = 0;
	}

	public void createConstraints(String constraintsName){
		System.out.println("Âï±â: "+ constraintsNum);
		System.out.println("Âï±â: "+ constraintsName);
		if(this.constraintsNum ==0){
			constraintsList.add(" ");
		}
		else{
			constraintsList.add(constraintsName);
		}
	}

	public int getConstraintsNum() {
		return constraintsNum;
	}

	public void setConstraintsNum(int constraintsNum) {
		this.constraintsNum = constraintsNum;
	}

	public String getRPValueName() {
		return RPValueName;
	}

	public void setRPValueName(String rPValueName) {
		RPValueName = rPValueName;
	}
	public ArrayList<String> getConstraintsList(){
		return constraintsList;
	}
	
	public void setConstraintsList(ArrayList<String> constraintsList){
		this.constraintsList = constraintsList;
	}
	
	public int getPropertyNum() {
		return propertyNum;
	}
	
	public void setPropertyNum(int propertyNum) {
		this.propertyNum = propertyNum;
	}
}
