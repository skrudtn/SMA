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

import javax.swing.JTextArea;

public class LeaderFeedbackView extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	JButton nextBtn;
	JLabel acceptNumLab;
	JLabel feedbackNumLab;
	JTextArea rcfeedback;
	
	
	public LeaderFeedbackView(int acceptNum, int feedbackNum){
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rcfeedback = new JTextArea();
		rcfeedback.setBounds(12, 60, 460, 441);
		for(int i=0;i<MainSystem.pm.reqGetVersion().getFeedbackList().size();i++){
			rcfeedback.setText( rcfeedback.getText() + MainSystem.pm.reqGetVersion().getFeedbackList().get(i) );
		}
		rcfeedback.setEnabled(false);
		contentPane.add(rcfeedback);
		
		acceptNumLab = new JLabel("Accept : " + acceptNum);
		acceptNumLab.setBounds(12, 10, 91, 15);
		contentPane.add(acceptNumLab);
		
		feedbackNumLab = new JLabel("FeedBack : " + feedbackNum);
		feedbackNumLab.setBounds(12, 35, 91, 15);
		contentPane.add(feedbackNumLab);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
