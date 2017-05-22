package GUI;

import java.awt.GridLayout;
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
		setBounds(100, 100, 822, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.cName = cName;
		this.rvNum = rvNum;
		

		panel = new JPanel();
		panel.setBounds(0, 10, 800, 300);

		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 10, 800, 337);
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
				rvLabels[line] = new JLabel( cName.get(i) + " Category의 RPValue" +(j+1) + "번");
				rvLabels[line].setBounds(10,10+(line*20), 95, 15);	
				line++;
			}
			//panel.add(cLabels[i]);
			
		}
		
		constNumLabels = new JLabel[temp];
		for(int i=0;i<temp;i++){
			constNumLabels[i] = new JLabel("constraints 개수 :");
			constNumLabels[i].setBounds(260,10+(i*20), 95, 15);
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
			panel.add(container[i]);
		}
		panel.setLayout(new GridLayout(0, 1, 0, 0));


		prevBtn = new JButton("Prev");
		prevBtn.setBounds(0, 357, 200, 36);
		contentPane.add(prevBtn);
		prevBtn.addActionListener(this);
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(399, 357, 200, 36);
		contentPane.add(nextBtn);
		nextBtn.addActionListener(this);

		
		
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
				MainSystem.pm.reqCreateRPValue(name, num);
				
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
