package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Screen;

import Control.MainSystem;

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
		
		setBounds( 100, 100, 450, 300 );
		this.setResizable(false);
		
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
		
		// â ȭ�� �߰��� ����
		// �������� ����� ���մϴ�.
		Dimension frameSize = this.getSize();
		System.out.println(frameSize.getWidth() +","+frameSize.getHeight());
		// �� ������� ũ�⸦ ���մϴ�.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth()+","+screenSize.getHeight());
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == LeaderButton){
			if(MainSystem.reqLogin(0)){//������ ����
				MainSystem.gm.leaderMainView();
				this.dispose();//â�ݱ�
			}else{//������ �̹��ִ�
				
			}
			//GUIManager.mainView();
		}else if(e.getSource() == MemberButton){
			MainSystem.gm.memberMainView();
			MainSystem.reqLogin(1);
			this.dispose();//â�ݱ�
		}
		
	}
	
	
}
