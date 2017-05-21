package Control;

import Model.Project;

public class MainSystem {
	public static ProjectManager pm;
	public static NetworkManager nm;
	public static ResultManager rm;
	public static GUIManager gm;
	
	
	public static void main(String[] args){
		
		MainSystem m = new MainSystem();
		m.run();
		
	}
	
	
	public MainSystem(){
		pm = new ProjectManager();
		gm = new GUIManager();
		nm = new NetworkManager();
	}
	
	public static void reqCreateProject(String projectName, int categoryNum){
		pm.reqCreateProject(projectName, categoryNum);
	}
	
	public static void reqCreateCategory(String categoryName, int RPValueNum){
		pm.reqCreateCategory(categoryName, RPValueNum);
	}
	
	public static void reqCreateRPValue(String RPValueName, int constraintsNum){
		pm.reqCreateRPValue(RPValueName, constraintsNum);
	}
	
	public static void reqCreateConstraints(String constraintsName){
		pm.reqCreateConstraints(constraintsName);
	}
	
	public static void reqAddVersion(int categoryNum){
		pm.reqAddVersion(categoryNum);
	}
	
	public static void reqShowView(){
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
	
	public static void reqOpen(){
		//pm.setProject(project);
	}
	
	public static void reqSave(){
		pm.getProject();
	}
	
	public static void reqSend(){
		nm.sendProject(pm.getProject());
	}
	
	public static void reqReceivedFeedback(String feedback){
		pm.reqSetFeedback(feedback);
	}
	
	public static void reqCombinatinoTestCase(){
		//rm.combinationTestCase(pm.reqGetVersion());
	}
	
	public static void reqSetFeedback(String feedback){
		pm.reqSetFeedback(feedback);
		int temp = pm.getProject().getLastVersion().getAcceptNum() +pm.getProject().getLastVersion().getFeedbackList().size();
		gm.setLeaderFeedNum(temp);
		
		
	}
	
	public static void reqLogin(int id){
		nm.reqLogin(id);
	}
	
	public static void reqReceivedProject(Project project){
		pm.setProject(project);
		//System.out.println(pm.reqGetVersionListSize());
		
		for(int i=0;i<project.getVersionListSize();i++){
			gm.addMemberVersionPanel(i+1, 0);
		}
		gm.memberMainRepaint();
	}
	
	
	public void run(){
		//GUI
		gm.loginView();
		
	}

}
