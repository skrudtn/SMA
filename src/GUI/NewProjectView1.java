package GUI;

import java.awt.Dimension;
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

public class NewProjectView1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField projectNameField;
	private JTextField categoryNumField;
	JLabel categoryNum;
	JLabel projectName;
	JButton nextBtn;
	
	
	
	public NewProjectView1() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		categoryNum = new JLabel("\uCE74\uD14C\uACE0\uB9AC \uAC1C\uC218");
		categoryNum.setBounds(84, 93, 95, 15);
		contentPane.add(categoryNum);
		
		projectName = new JLabel("\uD504\uB85C\uC81D\uD2B8\uBA85");
		projectName.setBounds(84, 62, 95, 15);
		contentPane.add(projectName);
		
		projectNameField = new JTextField();
		projectNameField.setBounds(191, 59, 116, 21);
		contentPane.add(projectNameField);
		projectNameField.setColumns(10);
		
		categoryNumField = new JTextField();
		categoryNumField.setBounds(191, 90, 116, 21);
		contentPane.add(categoryNumField);
		categoryNumField.setColumns(10);
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(81, 111, 97, 23);
		nextBtn.addActionListener(this);
		contentPane.add(nextBtn);
		
		
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
		
		if(e.getSource() == nextBtn){
			int cNum = Integer.parseInt(categoryNumField.getText());
			MainSystem.gm.newProjectView2(cNum);//num�� ī�װ�����
			this.setVisible(false);
			
			String name = projectNameField.getText();
			int num = Integer.parseInt(categoryNumField.getText());
			
			MainSystem.reqCreateProject(name, num);

		}
		
	}

}