package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;

public class MemberMainView extends JFrame implements ActionListener{

	private JPanel contentPane;
	JPanel menuPanel;
	JPanel projectPanel;
	JButton sendFeedbackBtn;
	
	public MemberMainView() {
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(12, 10, 125, 394);
		contentPane.add(menuPanel);
		
		sendFeedbackBtn = new JButton("Send Feedback");
		sendFeedbackBtn.addActionListener(this);
		menuPanel.add(sendFeedbackBtn);
		
		projectPanel = new JPanel();
		projectPanel.setBounds(149, 10, 469, 394);
		contentPane.add(projectPanel);
		projectPanel.setLayout(null);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == sendFeedbackBtn){
			//MainSystem.reqSetFeedback(feedback);
		}
	}
	
	public void addMemberVersionPanel(int vn, int fn){
		VersionPanel vp = new VersionPanel(vn, fn);
		
		vp.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				MainSystem.gm.memberVersionDisplay(vn);
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

		System.out.println("에드버전패널!");
	}

}
