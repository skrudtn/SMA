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

public class VersionDisplay extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextArea textArea;
	JLabel acceptNum;
	JButton btnConfirm;
	Version tVersion;
	
	
	public VersionDisplay(int index) {
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
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
		
		acceptNum = new JLabel("Accept :" + MainSystem.pm.reqGetVersion().getAcceptNum());
		acceptNum.setBounds(12, 482, 77, 15);
		getContentPane().add(acceptNum);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(375, 478, 97, 23);
		getContentPane().add(btnConfirm);
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
