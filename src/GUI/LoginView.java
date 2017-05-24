package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Screen;

import Control.MainSystem;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class LoginView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private LeaderMainView LMV;
	private MemberMainView MMV;
	
	JButton MemberButton;
	JButton LeaderButton;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		setBounds( 100, 100, 360, 240 );
		this.setResizable(false);
		this.setTitle("Feedback CPT");
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		MemberButton = new JButton("Member");
		MemberButton.setBounds(100, 120, 156, 70);
		MemberButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		MemberButton.setForeground(new Color(165, 42, 42));
		MemberButton.setBackground(new Color(245, 245, 220));
		MemberButton.addActionListener(this);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(89, 24, 0, 0);
		contentPane.add(label);
		contentPane.add(MemberButton);
		
		LeaderButton = new JButton("Leader");
		LeaderButton.setBounds(100, 24, 156, 70);
		LeaderButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		LeaderButton.setForeground(new Color(165, 42, 42));
		LeaderButton.setBackground(new Color(245, 245, 220));
		LeaderButton.addActionListener(this);
		contentPane.add(LeaderButton);
		
		// 창 화면 중간에 띄우기
		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		System.out.println(frameSize.getWidth() +","+frameSize.getHeight());
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth()+","+screenSize.getHeight());
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == LeaderButton){
			if(MainSystem.reqLogin(0)){//리더로 접속
				MainSystem.gm.leaderMainView();
				this.dispose();//창닫기
			}else{//리더가 이미있다
				
			}
			//GUIManager.mainView();
		}else if(e.getSource() == MemberButton){
			MainSystem.gm.memberMainView();
			MainSystem.reqLogin(1);
			this.dispose();//창닫기
		}
		
	}
	
	
}
