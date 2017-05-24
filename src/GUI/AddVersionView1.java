package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;

public class AddVersionView1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField categoryNumField;
	JLabel categoryNum;
	JButton nextBtn;
	
	public AddVersionView1() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setTitle("Feedback CPT");

		setBounds(100, 100, 360, 240);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		categoryNum = new JLabel("\uCE74\uD14C\uACE0\uB9AC \uAC1C\uC218");
		categoryNum.setBounds(40, 91, 95, 15);
		categoryNum.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		categoryNum.setForeground(new Color(165, 42, 42));
		categoryNum.setBackground(new Color(245, 245, 220));
		contentPane.add(categoryNum);
		
		categoryNumField = new JTextField();
		categoryNumField.setBounds(168, 90, 116, 21);
		contentPane.add(categoryNumField);
		categoryNumField.setColumns(10);
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(235, 168, 97, 23);
		nextBtn.setBackground(new Color(245, 245, 220));
		nextBtn.setForeground(new Color(165, 42, 42));
		nextBtn.addActionListener(this);
		nextBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		contentPane.add(nextBtn);
		
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
		
		if(e.getSource() == nextBtn){
			int cNum = Integer.parseInt(categoryNumField.getText());
			MainSystem.gm.addVersionView2(cNum);//num은 카테고리개수
			this.setVisible(false);
			
			int num = Integer.parseInt(categoryNumField.getText());
			
			//MainSystem.pm.reqAddVersion(num);
			MainSystem.reqAddVersion(num);
			
		}
		
	}

	
}
