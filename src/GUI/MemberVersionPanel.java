package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class MemberVersionPanel extends JPanel {

	String vID;
	JLabel vIDLab;
	int index;
	
	
	/*public MemberVersionPanel(int index){
		getContentPane().setLayout(null);
		
		this.index = index;
		
		vIDLab = new JLabel("Version 00");
		vIDLab.setBounds(12, 10, 90, 15);
		getContentPane().add(vIDLab);
		
				
	}
	
	public MemberVersionPanel(String name, int num){
		getContentPane().setLayout(null);
		
		vIDLab = new JLabel("Version " + name);
		vIDLab.setBounds(12, 10, 90, 15);
		
		getContentPane().add(vIDLab);
		
//		feedBut = new JButton("Feedback : " + num);
//		feedBut.setBounds(197, 57, 111, 23);
//		feedBut.addActionListener(this);
//		add(feedBut);
		
				
	}*/
	
	public MemberVersionPanel(int vnum, int num){
		this.setLayout(null);
		this.setBackground(new Color(255,255,240));
		
		vIDLab = new JLabel("Version " + vnum);
		vIDLab.setBounds(12, 10, 90, 15);
		vIDLab.setBackground(new Color(245, 245, 220));
		vIDLab.setForeground(new Color(165, 42, 42));
		vIDLab.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		this.add(vIDLab);
		
		this.setBorder((new BevelBorder(BevelBorder.RAISED)));

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
