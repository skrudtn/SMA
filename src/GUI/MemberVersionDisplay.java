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

public class MemberVersionDisplay extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextArea textField;
	JButton acceptBtn;
	JButton ConfirmBtn;
	Version tVersion;
	JTextArea feedbackTextArea;
	JLabel feedbackLabel;
	JLabel versionLabel;
	
	int index;
	
	int flag = 0;//ø¢º¡¿ÃµÁ
	
	public MemberVersionDisplay(int index) {
		setBounds(100, 100, 500, 760);
		
		this.index = index-1;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		Version tVersion;

		
		textField = new JTextArea();
		textField.setBounds(12, 35, 460, 437);
		getContentPane().add(textField);
		tVersion = MainSystem.pm.getProject().getVersionList().get(this.index);
		for(int i=0;i<tVersion.getCategoryList().size();i++){
			textField.setText( textField.getText() + tVersion.getCategoryList().get(i).getCategoryName() + "\n" );
			for(int j=0;j<tVersion.getCategoryList().get(i).getRPValueList().size();j++){
				textField.setText( textField.getText() + "\t" + tVersion.getCategoryList().get(i).getRPValueList().get(j).getRPValueName() + "\t" );
				for(int k=0;k<tVersion.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size();k++){
					textField.setText( textField.getText() + "  " + tVersion.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k) );
				}
				textField.setText( textField.getText() + "\n");
			}
			textField.setText( textField.getText() + "\n");
		}
		
		JScrollPane scrollPane = new JScrollPane(textField);
		scrollPane.setBounds(12, 35, 460, 437);
		contentPane.add(scrollPane);
		
		acceptBtn = new JButton("Accept");
		acceptBtn.setBounds(12, 688, 97, 23);
		getContentPane().add(acceptBtn);
		acceptBtn.setBackground(new Color(245, 245, 220));
		acceptBtn.setForeground(new Color(165, 42, 42));
		acceptBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		acceptBtn.addActionListener(this);
		
		ConfirmBtn = new JButton("Confirm");
		ConfirmBtn.setBounds(375, 688, 97, 23);
		getContentPane().add(ConfirmBtn);
		ConfirmBtn.setBackground(new Color(245, 245, 220));
		ConfirmBtn.setForeground(new Color(165, 42, 42));
		ConfirmBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		ConfirmBtn.addActionListener(this);
		
		
		feedbackTextArea = new JTextArea();
		feedbackTextArea.setBounds(12, 507, 460, 171);
		contentPane.add(feedbackTextArea);
		
		JScrollPane scrollPane2 = new JScrollPane(feedbackTextArea);
		scrollPane2.setBounds(12, 507, 460, 171);
		contentPane.add(scrollPane2);
		
		feedbackLabel = new JLabel("FeedBack");
		feedbackLabel.setBounds(12, 482, 97, 15);
		feedbackLabel.setBackground(new Color(245, 245, 220));
		feedbackLabel.setForeground(new Color(165, 42, 42));
		feedbackLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		contentPane.add(feedbackLabel);
		
		
		versionLabel = new JLabel("Version");
		versionLabel.setBounds(12, 10, 57, 15);
		versionLabel.setBackground(new Color(245, 245, 220));
		versionLabel.setForeground(new Color(165, 42, 42));
		versionLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		contentPane.add(versionLabel);
		
		
		if(index != MainSystem.pm.reqGetVersionListSize()){
			acceptBtn.setEnabled(false);
			ConfirmBtn.setEnabled(false);
			feedbackTextArea.setEnabled(false);
			
		}
		
		
		// «¡∑π¿”¿« ªÁ¿Ã¡Ó∏¶ ±∏«’¥œ¥Ÿ.
		Dimension frameSize = this.getSize();
		System.out.println(frameSize.getWidth() +","+frameSize.getHeight());
		// ≥ª ∏¥œ≈Õ¿« ≈©±‚∏¶ ±∏«’¥œ¥Ÿ.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth()+","+screenSize.getHeight());
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("π€");
		if(e.getSource() == ConfirmBtn){
			System.out.println("ƒ¡∆ﬂ");
			String temp = feedbackTextArea.getText();
			//MainSystem.nm.sendFeedback(temp);
			MainSystem.reqSendFeedback(temp);
			this.dispose();
		}else if(e.getSource() == acceptBtn){
			System.out.println("ø¢º¡");
			MainSystem.nm.sendFeedback("accept");
			this.dispose();
		}
	}
}
