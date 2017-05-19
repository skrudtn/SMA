package Model;

import java.util.ArrayList;

public class RepresentativeValue {
	private ArrayList<String> constraintsList;
	private int constraintsNum;
	private String RPValueName;
	
	public RepresentativeValue(String RPValueName){
		constraintsList = new ArrayList<String>();
		constraintsNum = 0;
		this.RPValueName = RPValueName;
	}
	
	public void createConstraints(String constraintsName){
		constraintsList.add(constraintsName);
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
	
}
