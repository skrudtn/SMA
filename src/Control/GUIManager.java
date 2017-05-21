package Control;
import java.awt.EventQueue;
import java.util.ArrayList;

import GUI.AddVersionView1;
import GUI.AddVersionView2;
import GUI.AddVersionView3;
import GUI.AddVersionView4;
import GUI.FileChooser;
import GUI.LeaderFeedbackView;
import GUI.LeaderMainView;
import GUI.LoginView;
import GUI.MemberMainView;
import GUI.MemberVersionDisplay;
import GUI.NewProjectView1;
import GUI.NewProjectView2;
import GUI.NewProjectView3;
import GUI.NewProjectView4;
import GUI.VersionDisplay;

public class GUIManager{
	
	public MainSystem mainSystem;
	
	public LeaderMainView leaderMain;
	public MemberMainView memberMain;
	
	public NewProjectView1 newProjectFrame1;
	public NewProjectView2 newProjectFrame2;
	public NewProjectView3 newProjectFrame3;
	public NewProjectView4 newProjectFrame4;
	
	public AddVersionView1 addVersionFrame1;
	public AddVersionView2 addVersionFrame2;
	public AddVersionView3 addVersionFrame3;
	public AddVersionView4 addVersionFrame4;

	public LeaderFeedbackView leaderFeedbackView;
	
//	public static void main(String[] args){
//		MainSystem ms = new MainSystem();
//		
//		loginView();
//		
//	}
	
	public GUIManager() {
		
	}
	
	public void loginView(){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("로긴창 열림?");
	}
	
	public void leaderMainView(){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leaderMain = new LeaderMainView();
					leaderMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("main창 열림?");
		
	}

	public void memberMainView(){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memberMain = new MemberMainView();
					memberMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("main창 열림?");
		
	}
	
	public void newProjectView1(){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newProjectFrame1 = new NewProjectView1();
					newProjectFrame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("뉴프로젝트1창 열림?");
		
	}
	
	public void newProjectView2(int cNum){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(cNum);
					newProjectFrame2 = new NewProjectView2(cNum);
					newProjectFrame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("뉴프로젝트2창 열림?");
		
	}
	
	public void newProjectView3(ArrayList<String> cName, ArrayList<Integer> rvNum){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newProjectFrame3 = new NewProjectView3(cName, rvNum);
					newProjectFrame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("뉴프로젝트3창 열림?");
		
	}
	
	public void newProjectView4(ArrayList<String> rvName, ArrayList<Integer> constNum){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newProjectFrame4 = new NewProjectView4(rvName, constNum);
					newProjectFrame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("뉴프로젝트4창 열림?");
		
	}
	
	
	
	public void addVersionView1(){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addVersionFrame1 = new AddVersionView1();
					addVersionFrame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("에드버전1창 열림?");
		
	}

	public void addVersionView2(int cNum){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(cNum);
					addVersionFrame2 = new AddVersionView2(cNum);
					addVersionFrame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("에드버전2창 열림?");
		
	}
	
	public void addVersionView3(ArrayList<String> cName, ArrayList<Integer> rvNum){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addVersionFrame3 = new AddVersionView3(cName, rvNum);
					addVersionFrame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("에드버전3창 열림?");
		
	}
	
	public void addVersionView4(ArrayList<String> rvName, ArrayList<Integer> constNum){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addVersionFrame4 = new AddVersionView4(rvName, constNum);
					addVersionFrame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("뉴프로젝트4창 열림?");
		
	}

	public void openFileChooser(){
		FileChooser fc = new FileChooser(0);
		System.out.println("open 탐색기");
	}
	
	public void saveFileChooser(){
		FileChooser fc = new FileChooser(1);
		System.out.println("save 탐색기");
	}
	
	//버전패널 추가하는거
	public void addVerisonPanel(int vn, int fn){
		leaderMain.addVersionPanel(vn, fn);
	}
	
	public void addMemberVersionPanel(int vn, int fn){
		memberMain.addMemberVersionPanel(vn, fn);
	}
	
	public void versionDisplay(int index){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VersionDisplay vd = new VersionDisplay(index);
					vd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("버전디스플레이");
	}
	
	public void memberVersionDisplay(int index){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberVersionDisplay vd = new MemberVersionDisplay(index);
					vd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("멤버버전디스플레이");
	}
	
	public void leaderMainRepaint(){
		leaderMain.repaint();
	}
	
	public void memberMainRepaint(){
		memberMain.repaint();
	}
	
	public void setLeaderFeedNum(int num){
		leaderMain.setFeedbackNum(num);
	}
	
	public void leaderFeedbackNum(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leaderFeedbackView = new LeaderFeedbackView(MainSystem.pm.reqGetVersion().getAcceptNum(), MainSystem.pm.reqGetVersion().getFeedbackList().size());
					leaderFeedbackView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("뉴프로젝트4창 열림?");
	}
	
}
