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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;

public class LeaderFeedbackView extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	JButton nextBtn;
	JLabel acceptNumLab;
	JLabel feedbackNumLab;
	JTextArea rcfeedback;
	
	
	public LeaderFeedbackView(int acceptNum, int feedbackNum){
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rcfeedback = new JTextArea();
		rcfeedback.setForeground(new Color(0, 0, 0));
		rcfeedback.setAutoscrolls(true);
		rcfeedback.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		rcfeedback.setBounds(12, 60, 460, 441);
		for(int i=0;i<MainSystem.pm.reqGetVersion().getFeedbackList().size();i++){
			rcfeedback.setText( rcfeedback.getText() + MainSystem.pm.reqGetVersion().getFeedbackList().get(i) );
		}
		//contentPane.add(rcfeedback);

		JScrollPane scrollPane = new JScrollPane(rcfeedback);
		scrollPane.setBounds(12, 60, 460, 441);
		contentPane.add(scrollPane);


		
		acceptNumLab = new JLabel("Accept : " + acceptNum);
		acceptNumLab.setBounds(12, 10, 91, 15);
		acceptNumLab.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		acceptNumLab.setForeground(new Color(165, 42, 42));
		acceptNumLab.setBackground(new Color(245, 245, 220));
		contentPane.add(acceptNumLab);
		
		feedbackNumLab = new JLabel("FeedBack : " + feedbackNum);
		feedbackNumLab.setBounds(12, 35, 91, 15);
		feedbackNumLab.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		feedbackNumLab.setForeground(new Color(165, 42, 42));
		feedbackNumLab.setBackground(new Color(245, 245, 220));
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
