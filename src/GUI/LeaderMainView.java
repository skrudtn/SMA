package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;

public class LeaderMainView extends JFrame implements ActionListener{

	private JPanel contentPane;
	JPanel menuPanel;
	JPanel projectPanel;
	JButton newProjectBtn;
	JButton openBtn;
	JButton sendBtn;
	JButton saveBtn;
	JButton addVersionBtn;
	JButton finalBtn;
	VersionPanel vp;
	
	
	public LeaderMainView() {
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(255, 255, 240));
		menuPanel.setBounds(0, 45, 149, 369);
		//menuPanel.setBorder((new BevelBorder(BevelBorder.RAISED)));
		contentPane.add(menuPanel);
		
		newProjectBtn = new JButton("New Project");
		newProjectBtn.setBackground(new Color(245, 245, 220));
		newProjectBtn.setForeground(new Color(165, 42, 42));
		newProjectBtn.addActionListener(this);
		newProjectBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		menuPanel.add(newProjectBtn);
		
		openBtn = new JButton("Open");
		openBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		openBtn.setForeground(new Color(165, 42, 42));
		openBtn.setBackground(new Color(245, 245, 220));
		openBtn.addActionListener(this);
		menuPanel.add(openBtn);
		
		sendBtn = new JButton("Send");
		sendBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		sendBtn.setForeground(new Color(165, 42, 42));
		sendBtn.setBackground(new Color(245, 245, 220));
		sendBtn.addActionListener(this);
		
		saveBtn = new JButton("Save");
		saveBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		saveBtn.setForeground(new Color(165, 42, 42));
		saveBtn.setBackground(new Color(245, 245, 220));
		saveBtn.addActionListener(this);
		menuPanel.add(saveBtn);
		menuPanel.add(sendBtn);
		
		addVersionBtn = new JButton("Add Version");
		addVersionBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		addVersionBtn.setBackground(new Color(245, 245, 220));
		addVersionBtn.setForeground(new Color(165, 42, 42));
		addVersionBtn.addActionListener(this);
		menuPanel.add(addVersionBtn);
		
		finalBtn = new JButton("Final");
		finalBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		finalBtn.setForeground(new Color(165, 42, 42));
		finalBtn.setBackground(new Color(245, 245, 220));
		finalBtn.addActionListener(this);
		menuPanel.add(finalBtn);
		
		
		projectPanel = new JPanel();
		projectPanel.setBackground(new Color(255, 255, 240));
		projectPanel.setBounds(149, 45, 481, 369);
		contentPane.add(projectPanel);
		projectPanel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(464, 0, 17, 404);
		projectPanel.add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("Feedback Category Partitioning Test");
		lblNewLabel.setForeground(new Color(255, 250, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 24));
		lblNewLabel.setBounds(0, 10, 630, 25);
		contentPane.add(lblNewLabel);
		
		
		// «¡∑π¿”¿« ªÁ¿Ã¡Ó∏¶ ±∏«’¥œ¥Ÿ.
		Dimension frameSize = this.getSize();
		System.out.println(frameSize.getWidth() +","+frameSize.getHeight());
		// ≥ª ∏¥œ≈Õ¿« ≈©±‚∏¶ ±∏«’¥œ¥Ÿ.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth()+","+screenSize.getHeight());
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
	}
	
	public void addVersionPanel(int vn, int fn){
		vp = new VersionPanel(vn, fn);
		
		//////////
		projectPanel.add(vp);
		vp.setBounds(0, 90*(vn-1), 481, 90);

		System.out.println("ø°µÂπˆ¿¸∆–≥Œ!");
	}
	
	public void resetProjectPanel(){
		contentPane.remove(projectPanel);
		projectPanel = new JPanel();
		projectPanel.setBackground(new Color(255, 255, 240));
		projectPanel.setBounds(149, 45, 481, 369);		
		contentPane.add(projectPanel);
		projectPanel.setLayout(null);
	}
	
	public void resetDisplayPanel(){
		MainSystem.gm.resetDisplayView();
	}
	
	public void setFeedbackNum(int num){
		vp.setfeedBut(num);
	}
	
	public void setCalNum(int num){
		vp.setTestCaseNum(num);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == newProjectBtn){
			MainSystem.gm.newProjectView1();
			//this.dispose();//√¢¥›±‚
		}else if(e.getSource() == openBtn){
			MainSystem.gm.openFileChooser();
		}else if(e.getSource() == sendBtn){
			MainSystem.reqSend();
		}else if(e.getSource() == saveBtn){
			MainSystem.gm.saveFileChooser();
		}else if(e.getSource() == addVersionBtn){
			MainSystem.gm.addVersionView1();
		}else if(e.getSource() == finalBtn){
			MainSystem.gm.finalView();
		}
		
	}
}
