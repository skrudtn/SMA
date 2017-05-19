package Model;

import java.util.ArrayList;

public class Version {
	Category category;
	private ArrayList<Category> categoryList;
	private ArrayList<String> feedbackList;
	private int categoryNum;
	private int rpCount;
	private int consCount;
	private int cateListIndex;
	private int cateListIndex2;
	private int acceptNum;
	//private int testcaseNum;
	

	public Version(){
		categoryList = new ArrayList<Category>();
		feedbackList = new ArrayList<String>();
		categoryNum = 0;
		rpCount = 0;
		consCount = 0;
		cateListIndex = 0;
		cateListIndex2 = 0;
		setAcceptNum(0);
		//testcaseNum =0;
	}

	public void createCategory(String categoryName, int RPValueNum){
		this.category = new Category(categoryName);
		category.setRPValueNum(RPValueNum);
		categoryList.add(category);
	}

	public void reqCreateRPValue(String RPValueName, int constraintsNum){
		category = categoryList.get(cateListIndex);

		rpCount++;
		if(rpCount == category.getRPValueNum()){
			cateListIndex++;
			rpCount =0;
		}
		category.createRPValue(RPValueName, constraintsNum);
	}

	public void reqCreateConstraints(String constraintsName){
		category = categoryList.get(cateListIndex2);
		int consNumInCate = 0;
		for(int i=0; i<category.getRPValueList().size();i++){
			consNumInCate += category.getRPValueList().get(i).getConstraintsNum();
		}
		consCount++;
		if(consCount == consNumInCate){
			consCount=0;
			consNumInCate = 0;
			cateListIndex2++;
		}
		category.reqCreateConstraints(constraintsName);
	}

	public void addFeedback(String feedback){
		if(feedback.equals("accept"))
			setAcceptNum(getAcceptNum() + 1);
		else
			feedbackList.add(feedback);
	}

	public ArrayList<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public ArrayList<String> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(ArrayList<String> feeback) {
		this.feedbackList = feeback;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public int getAcceptNum() {
		return acceptNum;
	}

	public void setAcceptNum(int acceptNum) {
		this.acceptNum = acceptNum;
	}

	//	public int getTestcaseNum() {
	//		return testcaseNum;
	//	}
	//
	//	public void setTestcaseNum(int testcaseNum) {
	//		this.testcaseNum = testcaseNum;
	//	}
	//
	//	public int getAcceptNum() {
	//		return acceptNum;
	//	}
	//
	//	public void setAcceptNum(int acceptNum) {
	//		this.acceptNum = acceptNum;
	//	}

}
