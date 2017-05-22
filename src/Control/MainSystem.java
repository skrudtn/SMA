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
		rm = new ResultManager();
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
	
	public static void reqShowView(int vNum){
		gm.versionDisplay(vNum);
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
	
	public static void reqSendFeedback(String feedback){
		nm.sendFeedback(feedback);
	}
	
	public static void reqCombinatinoTestCase(){
		//rm.combinationTestCase(pm.reqGetVersion());
	}
	
	public static void reqSetFeedback(String feedback){
		pm.reqSetFeedback(feedback);
		int temp = pm.getProject().getLastVersion().getAcceptNum() +pm.getProject().getLastVersion().getFeedbackList().size();
		gm.setLeaderFeedNum(temp);
		
		
	}
	
	public static boolean reqLogin(int id){
		return nm.reqLogin(id);
		
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
