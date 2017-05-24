package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JScrollBar;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(12, 10, 125, 394);
		menuPanel.setBorder((new BevelBorder(BevelBorder.RAISED)));
		contentPane.add(menuPanel);
		
		newProjectBtn = new JButton("New Project");
		newProjectBtn.addActionListener(this);
		menuPanel.add(newProjectBtn);
		
		openBtn = new JButton("Open");
		openBtn.addActionListener(this);
		menuPanel.add(openBtn);
		
		sendBtn = new JButton("Send");
		sendBtn.addActionListener(this);
		menuPanel.add(sendBtn);
		
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(this);
		menuPanel.add(saveBtn);
		
		addVersionBtn = new JButton("Add Version");
		addVersionBtn.addActionListener(this);
		menuPanel.add(addVersionBtn);
		
		finalBtn = new JButton("Final");
		finalBtn.addActionListener(this);
		menuPanel.add(finalBtn);
		
		
		projectPanel = new JPanel();
		projectPanel.setBounds(149, 10, 469, 394);
		//projectPanel.setBorder((new BevelBorder(BevelBorder.LOWERED)));
		contentPane.add(projectPanel);
		projectPanel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(452, 0, 17, 394);
		projectPanel.add(scrollBar);
		
		
		// �������� ����� ���մϴ�.
		Dimension frameSize = this.getSize();
		System.out.println(frameSize.getWidth() +","+frameSize.getHeight());
		// �� ������� ũ�⸦ ���մϴ�.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth()+","+screenSize.getHeight());
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
	}

	/*public void addVersionPanel(int vn, int fn){
		vp = new VersionPanel(vn, fn);
		
		vp.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				MainSystem.gm.versionDisplay(vn);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		projectPanel.add(vp);
		vp.setBounds(0, 90*(vn-1), 469, 90);

		System.out.println("��������г�!");
	}*/
	
	public void addVersionPanel(int vn, int fn){
		vp = new VersionPanel(vn, fn);
		
		//////////
		projectPanel.add(vp);
		vp.setBounds(0, 90*(vn-1), 469, 90);

		System.out.println("��������г�!");
	}
	
	public void resetProjectPanel(){
		contentPane.remove(projectPanel);
		projectPanel = new JPanel();
		projectPanel.setBounds(149, 10, 469, 394);
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
			//this.dispose();//â�ݱ�
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
