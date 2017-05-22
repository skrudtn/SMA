package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;
import javax.swing.JLabel;

public class MemberMainView extends JFrame implements ActionListener{

	private JPanel contentPane;
	JPanel menuPanel;
	JPanel projectPanel;
	private JLabel lblMember;
	
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
		
		lblMember = new JLabel("Member�� ���� Leader�� ���� ������Ʈ�� �޴� ���Ҹ� �����մϴ�.");
		menuPanel.add(lblMember);
		
		projectPanel = new JPanel();
		projectPanel.setBounds(149, 10, 469, 394);
		contentPane.add(projectPanel);
		projectPanel.setLayout(null);
		
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
	}
	
	public void addMemberVersionPanel(int vn, int fn){
		MemberVersionPanel vp = new MemberVersionPanel(vn, fn);
		
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

		System.out.println("��������г�!");
	}

}
