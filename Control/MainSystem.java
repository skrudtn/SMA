package Control;

public class MainSystem {
	private ProjectManager pm;
//	private NetworkManager nm;
//	private ResultManager rm;
	public MainSystem(){
		pm = new ProjectManager();
	}
	
	public void reqCreateProject(String projectName, int categoryNum){
		pm.reqCreateProject(projectName, categoryNum);
	}
	
	public void reqCreateCategory(String categoryName, int RPValueNum){
		pm.reqCreateCategory(categoryName, RPValueNum);
	}
	
	public void reqCreateRPValue(String RPValueName, int constraintsNum){
		pm.reqCreateRPValue(RPValueName, constraintsNum);
	}
	
	public void reqCreateConstraints(String constraintsName){
		pm.reqCreateConstraints(constraintsName);
	}
	
	public void reqAddVersion(int categoryNum){
		pm.reqAddVersion(categoryNum);
	}
	
	public void reqShowView(){
		//pm.reqGetVersion();
		System.out.println("projecName : "+pm.getProject().getProjectName());
		for(int i=0; i<pm.reqGetVersion().getCategoryList().size(); i++){
			System.out.println("cateName : "+pm.reqGetVersion().getCategoryList().get(i).getCategoryName());
			for(int j=0; j<pm.reqGetVersion().getCategoryList().get(i).getRPValueList().size(); j++){
				System.out.println("rpName : "+pm.reqGetVersion().getCategoryList().get(i).getRPValueList().get(j).getRPValueName());
				for(int k=0; k<pm.reqGetVersion().getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size(); k++){
					System.out.println("consName : "+pm.reqGetVersion().getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k));
				}
			}
		System.out.println();
		}
		
		System.out.println("==Feedback==");
		for(int i=0; i<pm.reqGetVersion().getFeedbackList().size(); i++){
			System.out.println(pm.reqGetVersion().getFeedbackList().get(i));
		}
		System.out.println();
		System.out.println("accept : "+pm.reqGetVersion().getAcceptNum());
		System.out.println("============");
	}
	
	public void reqOpen(){
		//pm.setProject(project);
	}
	
	public void reqSave(){
		pm.getProject();
	}
	
	public void reqSend(){
		//nm.sendProject(pm.getProject());
	}
	
	public void reqCombinatinoTestCase(){
		//rm.combinationTestCase(pm.reqGetVersion());
	}
	
	public void reqSetFeedback(String feedback){
		pm.reqSetFeedback(feedback);
	}
	
	
	public static void main(String[] args) {
		MainSystem m = new MainSystem();
		m.run();
	}
	
	public void run(){
		reqCreateProject("project1", 2);
		
		reqCreateCategory("category1",2);
		reqCreateCategory("category2",4);
		reqCreateCategory("category3",3);

		reqCreateRPValue("RPValue1.1",1);
		reqCreateRPValue("RPValue1.2",1);
		
		reqCreateRPValue("RPValue2.1",1);
		reqCreateRPValue("RPValue2.2",1);
		reqCreateRPValue("RPValue2.3",2);
		reqCreateRPValue("RPValue2.4",1);

		reqCreateRPValue("RPValue3.1",1);
		reqCreateRPValue("RPValue3.2",2);
		reqCreateRPValue("RPValue3.3",1);
		
		reqCreateConstraints("constraints1.1.1");
	    reqCreateConstraints("constraints1.2.1");
		reqCreateConstraints("constraints2.1.1");
		reqCreateConstraints("constraints2.2.1");
		reqCreateConstraints("constraints2.3.1");
		reqCreateConstraints("constraints2.3.2");
		reqCreateConstraints("constraints2.4.1");
		reqCreateConstraints("constraints3.1.1");
		reqCreateConstraints("constraints3.2.1");
		reqCreateConstraints("constraints3.2.2");
		reqCreateConstraints("constraints3.3.1");
		
		this.reqSetFeedback("ok");
		this.reqSetFeedback("good");
		this.reqSetFeedback("bye");
		this.reqSetFeedback("accept");
		this.reqSetFeedback("accept");
		
		reqShowView();
		System.out.println();
////////////////////////////////////////////////////		
		this.reqAddVersion(2);
		
		reqCreateCategory("category5",2);
		reqCreateCategory("category6",1);
		reqCreateRPValue("RPValue5.1",2);
		reqCreateRPValue("RPValue5.2",3);
		reqCreateRPValue("RPValue6.1",2);
		reqCreateConstraints("constraints5.1.1");
		reqCreateConstraints("constraints5.1.2");
		reqCreateConstraints("constraints5.2.1");
		reqCreateConstraints("constraints5.2.2");
		reqCreateConstraints("constraints5.2.3");
		reqCreateConstraints("constraints6.1.1");
		reqCreateConstraints("constraints6.1.2");
		
		this.reqSetFeedback("second version");
		this.reqSetFeedback("very good");
		this.reqSetFeedback("good night");
		this.reqSetFeedback("accept");

		reqShowView();
	}

}
