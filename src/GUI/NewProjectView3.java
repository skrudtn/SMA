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

public class NewProjectView3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	JLabel[] rvLabels;
	JLabel[] constNumLabels;
	JTextField[] rvNameFields;
	JTextField[] constNumFields;
	JButton nextBtn;
	JButton prevBtn;
	JPanel[] container;
	int btnLoc;
	private JPanel panel;

	int temp = 0;//rvNum들의 총 합
	
	//NewProjectView2 에서 받은거
	ArrayList<String> cName;
	ArrayList<Integer> rvNum;
	
	public NewProjectView3(ArrayList<String> cName, ArrayList<Integer> rvNum) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.cName = cName;
		this.rvNum = rvNum;
		

		panel = new JPanel();
		panel.setBounds(0, 10, 800, 300);
		panel.setBackground(new Color(255, 255, 240));

		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 10, 800, 337);
		scrollPane.getViewport().setBackground(new Color(255, 255, 240));
		contentPane.add(scrollPane);
		
		
		temp = numCount(rvNum);
		rvLabels = new JLabel[temp];
//		for(int i=0;i<cName.size();i++){
//			int line = 0;
//			for(int j=0;j<rvNum.size();j++){//이거 좀 손보면 될듯
//				rvLabels[i] = new JLabel( cName.get(i) + " Category:");
//				rvLabels[i].setBounds(10,10+(line*20), 95, 15);	
//				line++;
//			}
//			//panel.add(cLabels[i]);
//			
//		}

		int line = 0;
		for(int i=0;i<cName.size();i++){
			for(int j=0;j<rvNum.get(i);j++){//이거 좀 손보면 될듯
				rvLabels[line] = new JLabel( cName.get(i) + " Category:" +(j+1) + "번");
				rvLabels[line].setBounds(10,10+(line*20), 95, 15);
				rvLabels[line].setFont(new Font("맑은 고딕", Font.BOLD, 15));
				rvLabels[line].setForeground(new Color(165, 42, 42));
				rvLabels[line].setBackground(new Color(245, 245, 220));
				line++;
			}
			//panel.add(cLabels[i]);
			
		}
		
		constNumLabels = new JLabel[temp];
		for(int i=0;i<temp;i++){
			constNumLabels[i] = new JLabel("constraints 개수 :");
			constNumLabels[i].setBounds(260,10+(i*20), 95, 15);
			constNumLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			constNumLabels[i].setForeground(new Color(165, 42, 42));
			constNumLabels[i].setBackground(new Color(245, 245, 220));
			//panel.add(rvnLabels[i]);
		}
		
		rvNameFields = new JTextField[temp];
		for(int i=0;i<temp;i++){
			rvNameFields[i] = new JTextField();
			rvNameFields[i].getCursor();
			rvNameFields[i].setColumns(15);
			rvNameFields[i].setText("");
			//panel.add(cNameFields[i]);
		}
		
		
		constNumFields = new JTextField[temp];
		
		for(int i=0;i<temp;i++){
			constNumFields[i] = new JTextField();
			constNumFields[i].setColumns(15);
			constNumFields[i].setText("");
			panel.add(constNumFields[i]);
			//btnLoc = i;
		}
		
		container = new JPanel[temp];
		for(int i=0;i<temp;i++){
			container[i] = new JPanel();
			container[i].add(rvLabels[i]);
			container[i].add(rvNameFields[i]);
			container[i].add(constNumLabels[i]);
			container[i].add(constNumFields[i]);
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
		nextBtn.setBounds(600, 357, 200, 36);
		nextBtn.setBackground(new Color(245, 245, 220));
		nextBtn.setForeground(new Color(165, 42, 42));
		nextBtn.addActionListener(this);
		nextBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		contentPane.add(nextBtn);

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
		
		//NewProjectView4에 보낼거
		ArrayList<String> rvName = new ArrayList<String>();
		ArrayList<Integer> constNum = new ArrayList<Integer>();

		
		if(e.getSource() == nextBtn){
			
			for(int i=0;i<temp;i++){
				int t = Integer.parseInt(constNumFields[i].getText());
				rvName.add( rvNameFields[i].getText() );
				if(t == 0){
					constNum.add(1);
				}
				else{
					constNum.add(t);
				}
			}
			MainSystem.gm.newProjectView4(rvName, constNum);
			this.setVisible(false);//요거 기억해두자!!
			
			for(int i=0;i<temp;i++){
				String name = rvNameFields[i].getText();
				int num = Integer.parseInt(constNumFields[i].getText());
//				if(num == 0) num=1;
//				System.out.println("n"+num);
				MainSystem.reqCreateRPValue(name, num);
				
			}			
			
		}else if(e.getSource() == prevBtn){
			this.dispose();
			MainSystem.gm.newProjectFrame2.setVisible(true);
		}
		
	}

	private int numCount(ArrayList<Integer> array){
		int sum = 0;
		for(int i=0;i<array.size();i++){
			sum += array.get(i);
		}
		return sum;
	}
	
}
