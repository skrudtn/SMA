package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable{
	private RepresentativeValue RPValue;
	private ArrayList<RepresentativeValue> RPValueList;
	private String categoryName;
	private int RPValueNum;
	private int consCount;
	private int rpListIndex;

	public Category(String categoryName){
		RPValueList = new ArrayList<RepresentativeValue>();
		this.categoryName = categoryName;
		RPValueNum = 0;
		consCount = 0;
		rpListIndex = 0;
	}

	public void createRPValue(String RPValueName, int constraintsNum){
		//System.out.println(this.categoryName);
		RPValue = new RepresentativeValue(RPValueName);
		if(constraintsNum == 0) constraintsNum = 1;
		RPValue.setConstraintsNum(constraintsNum);
		RPValueList.add(RPValue);
	}

	public void reqCreateConstraints(String constraintsName){
		//System.out.println(this.categoryName + " "+RPValue.getRPValueName()+" "+rpListIndex );
		RPValue = RPValueList.get(rpListIndex);
		
		consCount++;
		if(consCount == RPValue.getConstraintsNum()){
			consCount =0;
			rpListIndex++;
		}
		RPValue.createConstraints(constraintsName);
		/*
		//System.out.println("i`m "+this.categoryName);
		System.out.println(this.categoryName+" "+consCount+" "+RPValue.getRPValueName());
		if(consCount < RPValue.getConstraintsNum()){
			//System.out.println(this.categoryName);
			//System.out.println(RPValue.getRPValueName());
			//System.out.println("cateÀÇ reqCons: "+"listIndex "+listIndex+" "+count+" "+RPValue.getConstraintsNum());
			RPValue.createConstraints(constraintsName);	
			consCount++;
		}
		else{
			consCount=0;
			rpListIndex++;
			if(rpListIndex == RPValueList.size()) return;
			RPValue = RPValueList.get(rpListIndex);
			reqCreateConstraints(constraintsName);
		}
		*/
	}

	public RepresentativeValue getRpValue() {
		return RPValue;
	}

	public void setRpValue(RepresentativeValue rpValue) {
		this.RPValue = rpValue;
	}

	public ArrayList<RepresentativeValue> getRPValueList() {
		return RPValueList;
	}

	public void setRPValueList(ArrayList<RepresentativeValue> rPValueList) {
		RPValueList = rPValueList;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getRPValueNum() {
		return RPValueNum;
	}

	public void setRPValueNum(int rPValueNum) {
		RPValueNum = rPValueNum;
	}
}
