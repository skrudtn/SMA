package GUI;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		categoryNum = new JLabel("\uCE74\uD14C\uACE0\uB9AC \uAC1C\uC218");
		categoryNum.setBounds(84, 93, 95, 15);
		contentPane.add(categoryNum);
		
		categoryNumField = new JTextField();
		categoryNumField.setBounds(191, 90, 116, 21);
		contentPane.add(categoryNumField);
		categoryNumField.setColumns(10);
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(81, 111, 97, 23);
		nextBtn.addActionListener(this);
		contentPane.add(nextBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == nextBtn){
			int cNum = Integer.parseInt(categoryNumField.getText());
			MainSystem.gm.addVersionView2(cNum);//num은 카테고리개수
			this.setVisible(false);
			
			int num = Integer.parseInt(categoryNumField.getText());
			
			MainSystem.pm.reqAddVersion(num);
			
			
		}
		
	}

	
}
