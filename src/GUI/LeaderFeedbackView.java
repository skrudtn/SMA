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
		
	}
}
