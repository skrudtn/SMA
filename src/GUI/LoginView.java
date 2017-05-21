package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import Control.MainSystem;
import Control.GUIManager;

public class LoginView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private LeaderMainView LMV;
	private MemberMainView MMV;
	
	JButton MemberButton;
	JButton LeaderButton;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MemberButton = new JButton("Member");
		MemberButton.setBounds(239, 114, 97, 23);
		MemberButton.addActionListener(this);
		contentPane.add(MemberButton);
		
		LeaderButton = new JButton("Leader");
		LeaderButton.setBounds(81, 111, 97, 23);
		LeaderButton.addActionListener(this);
		contentPane.add(LeaderButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == LeaderButton){
			MainSystem.gm.leaderMainView();
			MainSystem.reqLogin(0);
			//GUIManager.mainView();
			this.dispose();//Ã¢´Ý±â
		}else if(e.getSource() == MemberButton){
			MainSystem.gm.memberMainView();
			MainSystem.reqLogin(1);
			this.dispose();//Ã¢´Ý±â
		}
		
	}
	
	
}
