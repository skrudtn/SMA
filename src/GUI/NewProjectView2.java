package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.MainSystem;

public class NewProjectView2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	JLabel[] cLabels;
	JLabel[] rvnLabels;
	JTextField[] cNameFields;
	JTextField[] rvnFields;
	JButton nextBtn;
	JButton prevBtn;
	JPanel[] container;
	int btnLoc;
	private JPanel panel;

	int cNum;
	
	public NewProjectView2(int cNum) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 622, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.cNum = cNum;	//화면1에서 입력받은 카테고리 개수
		
		panel = new JPanel();
		panel.setBounds(0, 10, 600, 337);
		panel.setBackground(new Color(255, 255, 240));

		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 10, 600, 337);
		scrollPane.getViewport().setBackground(new Color(255, 255, 240));
		scrollPane.setBackground(new Color(255, 255, 240));
		contentPane.add(scrollPane);
		
		
		
		cLabels = new JLabel[cNum];
		for(int i=0;i<cNum;i++){
			cLabels[i] = new JLabel((i+1) + "번 카테고리 :");
			cLabels[i].setBounds(10,10+(i*20), 95, 15);
			cLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			cLabels[i].setForeground(new Color(165, 42, 42));
			cLabels[i].setBackground(new Color(245, 245, 220));
			//panel.add(cLabels[i]);
			
		}
		
		rvnLabels = new JLabel[cNum];
		for(int i=0;i<cNum;i++){
			rvnLabels[i] = new JLabel("Value 개수 :");
			rvnLabels[i].setBounds(260,10+(i*20), 95, 15);
			rvnLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			rvnLabels[i].setForeground(new Color(165, 42, 42));
			rvnLabels[i].setBackground(new Color(245, 245, 220));
			//panel.add(rvnLabels[i]);
		}
		
		cNameFields = new JTextField[cNum];
		for(int i=0;i<cNum;i++){
			cNameFields[i] = new JTextField();
			cNameFields[i].getCursor();
			cNameFields[i].setColumns(15);
			cNameFields[i].setText("");
			//panel.add(cNameFields[i]);
		}
		
		
		rvnFields = new JTextField[cNum];
		
		for(int i=0;i<cNum;i++){
			rvnFields[i] = new JTextField();
			rvnFields[i].setColumns(15);
			rvnFields[i].setText("");
			panel.add(rvnFields[i]);
			//btnLoc = i;
		}
		
		container = new JPanel[cNum];
		for(int i=0;i<cNum;i++){
			container[i] = new JPanel();
			container[i].add(cLabels[i]);
			container[i].add(cNameFields[i]);
			container[i].add(rvnLabels[i]);
			container[i].add(rvnFields[i]);
			container[i].setBackground(new Color(255, 255, 240));
			panel.add(container[i]);
		}
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		prevBtn = new JButton("Prev");
		prevBtn.setBounds(0, 357, 200, 36);
		prevBtn.setBackground(new Color(245, 245, 220));
		prevBtn.setForeground(new Color(165, 42, 42));
		prevBtn.addActionListener(this);
		prevBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		contentPane.add(prevBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(399, 357, 200, 36);
		nextBtn.setBackground(new Color(245, 245, 220));
		nextBtn.setForeground(new Color(165, 42, 42));
		nextBtn.addActionListener(this);
		nextBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		contentPane.add(nextBtn);

		
		//////
		
		
		
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
		
		ArrayList<String> cName = new ArrayList<String>();
		ArrayList<Integer> rvNum = new ArrayList<Integer>();
		
		
		
		if(e.getSource() == nextBtn){
			
			for(int i=0;i<cNum;i++){
				cName.add( cNameFields[i].getText() );
				rvNum.add( Integer.parseInt(rvnFields[i].getText()) );
			}
			MainSystem.gm.newProjectView3(cName,rvNum);
			this.setVisible(false);//요거 기억해두자!!
			
			for(int i=0;i<cNum;i++){
				String name = cNameFields[i].getText();
				int num = Integer.parseInt(rvnFields[i].getText());
				MainSystem.reqCreateCategory(name, num);
			
			}
			
		}else if(e.getSource() == prevBtn){
			this.dispose();
			MainSystem.gm.newProjectFrame1.setVisible(true);
		}
		
	}
	
}