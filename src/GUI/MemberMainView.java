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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class MemberMainView extends JFrame implements ActionListener{

	private JPanel contentPane;
	JPanel menuPanel;
	JPanel projectPanel;
	private JLabel lblMember;
	private JLabel label;
	private JLabel lblNewLabel;
	
	public MemberMainView() {
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
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("");
		menuPanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\clock\\workspace\\SMA\\src\\\uAE30\uB2E42.png"));
		
		lblMember = new JLabel("\uD504\uB85C\uC81D\uD2B8\uB97C");
		menuPanel.add(lblMember);
		lblMember.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblMember.setHorizontalAlignment(SwingConstants.CENTER);
		
		label = new JLabel("\uAE30\uB2E4\uB9AC\uB294");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		menuPanel.add(label);
		
		lblNewLabel = new JLabel("\uC911\uC785\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuPanel.add(lblNewLabel);
		
		projectPanel = new JPanel();
		projectPanel.setBackground(new Color(255, 255, 240));
		projectPanel.setBounds(149, 45, 481, 369);
		contentPane.add(projectPanel);
		projectPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Feedback Category Partitioning Tool");
		lblNewLabel_2.setForeground(new Color(255, 250, 240));
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 630, 47);
		contentPane.add(lblNewLabel_2);
		
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

		System.out.println("에드버전패널!");
	}
}
