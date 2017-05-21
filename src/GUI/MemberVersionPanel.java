package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MemberVersionPanel extends JFrame {

	String vID;
	JLabel vIDLab;
	int index;
	
	public MemberVersionPanel(int index){
		setLayout(null);
		
		this.index = index;
		
		vIDLab = new JLabel("Version 00");
		vIDLab.setBounds(12, 10, 90, 15);
		add(vIDLab);
		
				
	}
	
	public MemberVersionPanel(String name, int num){
		setLayout(null);
		
		vIDLab = new JLabel("Version " + name);
		vIDLab.setBounds(12, 10, 90, 15);
		
		add(vIDLab);
		
//		feedBut = new JButton("Feedback : " + num);
//		feedBut.setBounds(197, 57, 111, 23);
//		feedBut.addActionListener(this);
//		add(feedBut);
		
				
	}
	
	public MemberVersionPanel(int vnum, int num){
		setLayout(null);
		
		vIDLab = new JLabel("Version " + vnum);
		vIDLab.setBounds(12, 10, 90, 15);
		add(vIDLab);
		
//		feedBut = new JButton("Feedback : " + num);
//		feedBut.setBounds(197, 57, 111, 23);
//		feedBut.addActionListener(this);
//		add(feedBut);
		
				
	}
	
	public void setVIDLabel(String vid){
		vIDLab.setText("Version " + vid);
	}
	
//	public void setfeedBut(int num){
//		feedBut.setText("Feedback : " + num);
//	}

	
	
}
