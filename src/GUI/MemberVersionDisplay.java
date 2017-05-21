package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;
import Model.Version;

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
	
	public MemberVersionDisplay(int index) {
		setBounds(100, 100, 500, 760);
		
		this.index = index-1;
		
		contentPane = new JPanel();
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
		
		acceptBtn = new JButton("Accept");
		acceptBtn.setBounds(12, 688, 97, 23);
		getContentPane().add(acceptBtn);
		acceptBtn.addActionListener(this);
		
		ConfirmBtn = new JButton("Confirm");
		ConfirmBtn.setBounds(375, 688, 97, 23);
		getContentPane().add(ConfirmBtn);
		ConfirmBtn.addActionListener(this);
		
		
		feedbackTextArea = new JTextArea();
		feedbackTextArea.setBounds(12, 507, 460, 171);
		contentPane.add(feedbackTextArea);
		
		feedbackLabel = new JLabel("FeedBack");
		feedbackLabel.setBounds(12, 482, 57, 15);
		contentPane.add(feedbackLabel);
		
		
		versionLabel = new JLabel("Version");
		versionLabel.setBounds(12, 10, 57, 15);
		contentPane.add(versionLabel);
		
		
		if(index != MainSystem.pm.reqGetVersionListSize()){
			acceptBtn.setEnabled(false);
			ConfirmBtn.setEnabled(false);
			feedbackTextArea.setEnabled(false);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("¹Û");
		if(e.getSource() == ConfirmBtn){
			System.out.println("ÄÁÆß");
			String temp = feedbackTextArea.getText();
			MainSystem.nm.sendFeedback(temp);
			this.dispose();
		}else if(e.getSource() == acceptBtn){
			System.out.println("¿¢¼Á");
			MainSystem.nm.sendFeedback("accept");
			this.dispose();
		}
	}
}
