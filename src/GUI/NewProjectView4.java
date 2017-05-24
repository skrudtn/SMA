package GUI;

import java.awt.Dimension;
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

public class NewProjectView4 extends JFrame implements ActionListener{

	private JPanel contentPane;
	JLabel[] rvLabels;
	JTextField[] constNameFields;
	JButton confirmBtn;
	JButton prevBtn;
	JPanel[] container;
	int btnLoc;
	private JPanel panel;


	//NewProjectView3 에서 받은거
	ArrayList<String> rvName;
	ArrayList<Integer> constNum;
	ArrayList<Integer> zeroCheck;
	int temp = 0;

	public NewProjectView4(ArrayList<String> rvName, ArrayList<Integer> constNum) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.rvName = rvName;
		this.constNum = constNum;
		this.zeroCheck = new ArrayList<Integer>();


		panel = new JPanel();
		panel.setBounds(0, 10, 800, 300);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 10, 800, 337);
		contentPane.add(scrollPane);

		temp = numCount(constNum);
		rvLabels = new JLabel[temp];


		int line = 0;
		for(int i=0;i<rvName.size();i++){
			for(int j=0;j<constNum.get(i);j++){//이거 좀 손보면 될듯
				rvLabels[line] = new JLabel("RepreValue:" + (j+1) + " " + rvName.get(i) + "번");
				rvLabels[line].setBounds(10,10+(line*20), 95, 15);	
				line++;
			}
			//panel.add(cLabels[i]);

		}


		constNameFields = new JTextField[temp];
		for(int i=0;i<temp;i++){
			constNameFields[i] = new JTextField();
			constNameFields[i].getCursor();
			constNameFields[i].setColumns(15);
			constNameFields[i].setText("");
			//panel.add(cNameFields[i]);
		}



		container = new JPanel[temp];
		for(int i=0;i<temp;i++){
			container[i] = new JPanel();
			container[i].add(rvLabels[i]);
			container[i].add(constNameFields[i]);
			panel.add(container[i]);
		}
		panel.setLayout(new GridLayout(0, 1, 0, 0));


		prevBtn = new JButton("Prev");
		prevBtn.setBounds(0, 357, 200, 36);
		contentPane.add(prevBtn);
		prevBtn.addActionListener(this);

		confirmBtn = new JButton("OK!!!!");
		confirmBtn.setBounds(399, 357, 200, 36);
		contentPane.add(confirmBtn);
		confirmBtn.addActionListener(this);


		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		System.out.println(frameSize.getWidth() +","+frameSize.getHeight());
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth()+","+screenSize.getHeight());
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);

	}

	//확인버튼 처리해줘야함 이전이랑
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == confirmBtn){

			for(int i=0;i<temp;i++){
				String name = constNameFields[i].getText();
				System.out.println(name);
				MainSystem.reqCreateConstraints(name);

			}
			//MainSystem.gm.resetDisplayView();
			
			MainSystem.gm.leaderMain.resetProjectPanel();
			/*RM에서 계산과정 진행해야함*/	//그리고
			int temp = MainSystem.rm.calculateTestCaseNum(MainSystem.pm.reqGetLastVersion());
			MainSystem.pm.reqGetLastVersion().setTestcaseNum(temp);
			MainSystem.gm.addVerisonPanel(1, 0);
			MainSystem.gm.leaderMain.setCalNum( MainSystem.pm.reqGetVersion().getTestcaseNum() );


			MainSystem.gm.newProjectFrame1.dispose();
			MainSystem.gm.newProjectFrame2.dispose();
			MainSystem.gm.newProjectFrame3.dispose();
			MainSystem.gm.newProjectFrame4.dispose();

			MainSystem.gm.leaderMainRepaint();

		}else if(e.getSource() == prevBtn){
			this.setVisible(false);
			MainSystem.gm.newProjectFrame3.setVisible(true);
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
