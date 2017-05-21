package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Control.MainSystem;

public class VersionPanel extends JPanel implements ActionListener{

	String vID;
	JLabel vIDLab;
	JButton feedBut;
	JLabel testcaseNum;
	
	public VersionPanel(){
		setLayout(null);
		
		vIDLab = new JLabel("Version 00");
		vIDLab.setBounds(12, 10, 90, 15);
		add(vIDLab);
		
		feedBut = new JButton("Feedback : 00");
		feedBut.setBounds(288, 57, 169, 23);
		feedBut.addActionListener(this);
		add(feedBut);
		
		testcaseNum = new JLabel("TestCaseNumber : 00");
		testcaseNum.setBounds(288, 32, 169, 15);
		add(testcaseNum);
		
				
	}
	
	public VersionPanel(String name, int num){
		setLayout(null);
		
		vIDLab = new JLabel("Version " + name);
		vIDLab.setBounds(12, 10, 90, 15);
		
		add(vIDLab);
		
		feedBut = new JButton("Feedback : " + num);
		feedBut.setBounds(197, 57, 111, 23);
		feedBut.addActionListener(this);
		add(feedBut);
		
		testcaseNum = new JLabel("TestCaseNumber : 00");
		testcaseNum.setBounds(288, 32, 169, 15);
		add(testcaseNum);
		
				
	}
	
	public VersionPanel(int vnum, int num){
		setLayout(null);
		
		vIDLab = new JLabel("Version " + vnum);
		vIDLab.setBounds(12, 10, 90, 15);
		add(vIDLab);
		
		feedBut = new JButton("Feedback : " + num);
		feedBut.setBounds(197, 57, 111, 23);
		feedBut.addActionListener(this);
		add(feedBut);
		
		testcaseNum = new JLabel("TestCaseNumber : 00");
		testcaseNum.setBounds(288, 32, 169, 15);
		add(testcaseNum);
		
				
	}
	
	public void setVIDLabel(String vid){
		vIDLab.setText("Version " + vid);
	}
	
	public void setfeedBut(int num){
		feedBut.setText("Feedback : " + num);
	}

	public void setTestCaseNum(int num){
		testcaseNum.setText("TestCaseNum : " + num);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this){
			System.out.println("!!!!!");
		}else if(e.getSource() == feedBut){
			System.out.println("@@@@@");
			MainSystem.gm.leaderFeedbackNum();
		}
		
	}
}
