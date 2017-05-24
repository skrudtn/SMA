package GUI;

import java.awt.Color;
import java.awt.Font;
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

public class FinalView extends JFrame implements ActionListener{

	private JPanel contentPane;
	JTextArea finalView;
	JButton confirmBtn;
	JLabel testCaseNum;
	Version v;
	
	public FinalView(int num){
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MainSystem.reqCombinatinoTestCase();
		
		v = MainSystem.pm.reqGetLastVersion();
		
		finalView = new JTextArea();
		finalView.setBounds(12, 10, 460, 458);
		String[] temp = {"이진호","이원재","나경수","한석호"};//v.getResult();
		for(int i=0;i<temp.length;i++){
			finalView.setText(finalView.getText() + temp[i] + "\n");
		}
		
		contentPane.add(finalView);
		
		confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(375, 478, 97, 23);
		confirmBtn.setBackground(new Color(245, 245, 220));
		confirmBtn.setForeground(new Color(165, 42, 42));
		confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		contentPane.add(confirmBtn);
		
		testCaseNum = new JLabel("TestCase 개수 : " + num);
		testCaseNum.setBounds(22, 482, 141, 15);
		testCaseNum.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		testCaseNum.setForeground(new Color(165, 42, 42));
		testCaseNum.setBackground(new Color(245, 245, 220));
		contentPane.add(testCaseNum);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
