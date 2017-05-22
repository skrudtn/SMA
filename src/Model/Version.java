package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Version implements Serializable{
	Category category;
	private ArrayList<Category> categoryList;
	private ArrayList<String> feedbackList;
	private int categoryNum;
	private int rpCount;
	private int consCount;
	private int cateListIndex;
	private int cateListIndex2;
	private int acceptNum;
	private int testcaseNum;
	

	public Version(){
		categoryList = new ArrayList<Category>();
		feedbackList = new ArrayList<String>();
		categoryNum = 0;
		rpCount = 0;
		consCount = 0;
		cateListIndex = 0;
		cateListIndex2 = 0;
		acceptNum = 0;
		testcaseNum =0;
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
			if(category.getRPValueList().get(i).getConstraintsNum() ==0){
				consNumInCate++;
			}
			else{
			consNumInCate += category.getRPValueList().get(i).getConstraintsNum();
			}
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

	public int getTestcaseNum() {
		return testcaseNum;
	}

	public void setTestcaseNum(int testcaseNum) {
		this.testcaseNum = testcaseNum;
	}
	
	public Version cloneVersion() {
	      Version cv = new Version();
	      
	      cv.categoryList = new ArrayList<Category>();
	      cv.categoryNum = this.categoryNum;
	      
	      Iterator<Category> cati = this.categoryList.iterator();
	      while(cati.hasNext()) {
	         Category cat = (Category)cati.next();
	         Category cpcat = new Category(cat.getCategoryName());
	         cpcat.setRPValueList(new ArrayList<RepresentativeValue>());
	         cpcat.setRPValueNum(cat.getRPValueNum());
	         cv.categoryList.add(cpcat);
	         
	         Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
	         while(rpvi.hasNext()) {
	            RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
	            RepresentativeValue cprpv = new RepresentativeValue(rpv.getRPValueName());
	            cprpv.setConstraintsList(new ArrayList<String>());
	            cprpv.setConstraintsNum(rpv.getConstraintsNum());
	            cprpv.setPropertyNum(rpv.getPropertyNum());
	            cpcat.getRPValueList().add(cprpv);
	            
	            Iterator<String> coni = rpv.getConstraintsList().iterator();
	            while(coni.hasNext()) {
	               String con = (String)coni.next();
	               String cpcon = new String(con);
	               cprpv.getConstraintsList().add(cpcon);
	            }
	         }
	      }
	      
	      return cv;
	   }

}
