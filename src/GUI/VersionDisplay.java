package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;
import Model.Version;
import java.awt.Color;

public class VersionDisplay extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextArea textArea;
	JLabel acceptNum;
	JButton btnConfirm;
	Version tVersion;
	
	
	public VersionDisplay(int index) {
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		Version tVersion;

		
		textArea = new JTextArea();
		textArea.setBounds(12, 10, 460, 462);
		textArea.setText("");
		getContentPane().add(textArea);
		tVersion = MainSystem.pm.getProject().getVersionList().get(index-1);
		for(int i=0;i<tVersion.getCategoryList().size();i++){
			textArea.setText( textArea.getText() + tVersion.getCategoryList().get(i).getCategoryName() + "\n" );
			for(int j=0;j<tVersion.getCategoryList().get(i).getRPValueList().size();j++){
				textArea.setText( textArea.getText() + "\t" + tVersion.getCategoryList().get(i).getRPValueList().get(j).getRPValueName() + "\t" );
				for(int k=0;k<tVersion.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size();k++){
					textArea.setText( textArea.getText() + "  " + tVersion.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k) );
				}
				textArea.setText( textArea.getText() + "\n");
			}
			textArea.setText( textArea.getText() + "\n");
		}
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(12, 10, 460, 462);
		contentPane.add(scrollPane);
		
		acceptNum = new JLabel("Accept :" + MainSystem.pm.reqGetVersion().getAcceptNum());
		acceptNum.setBounds(12, 482, 77, 15);
		acceptNum.setBackground(new Color(245, 245, 220));
		acceptNum.setForeground(new Color(165, 42, 42));
		acceptNum.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		getContentPane().add(acceptNum);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(375, 478, 97, 23);
		btnConfirm.setBackground(new Color(245, 245, 220));
		btnConfirm.setForeground(new Color(165, 42, 42));
		btnConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		
		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		System.out.println(frameSize.getWidth() +","+frameSize.getHeight());
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth()+","+screenSize.getHeight());
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
	}

	public void resetTextArea(){
		textArea.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnConfirm){
			this.dispose();
		}
	}
}
