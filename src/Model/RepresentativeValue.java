package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class RepresentativeValue implements Serializable{
	private ArrayList<String> constraintsList;
	private int constraintsNum;
	private String RPValueName;

	public RepresentativeValue(String RPValueName){
		constraintsList = new ArrayList<String>();
		constraintsNum = 0;
		constraintsList.add(" ");
		this.RPValueName = RPValueName;
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

}
