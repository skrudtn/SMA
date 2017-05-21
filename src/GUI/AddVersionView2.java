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

public class AddVersionView2 extends JFrame implements ActionListener {
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
	
	public AddVersionView2(int cNum) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.cNum = cNum;	//ȭ��1���� �Է¹��� ī�װ��� ����
		
		panel = new JPanel();
		panel.setBounds(0, 10, 600, 300);

		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(0, 10, 600, 337);
		contentPane.add(scrollPane);
		
		
		
		cLabels = new JLabel[cNum];
		for(int i=0;i<cNum;i++){
			cLabels[i] = new JLabel((i+1) + "�� ī�װ��� :");
			cLabels[i].setBounds(10,10+(i*20), 95, 15);
			//panel.add(cLabels[i]);
			
		}
		
		rvnLabels = new JLabel[cNum];
		for(int i=0;i<cNum;i++){
			rvnLabels[i] = new JLabel("Value ���� :");
			rvnLabels[i].setBounds(260,10+(i*20), 95, 15);
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
		
		ArrayList<String> cName = new ArrayList<String>();
		ArrayList<Integer> rvNum = new ArrayList<Integer>();
		
		
		
		if(e.getSource() == nextBtn){
			
			for(int i=0;i<cNum;i++){
				cName.add( cNameFields[i].getText() );
				rvNum.add( Integer.parseInt(rvnFields[i].getText()) );
			}
			
			MainSystem.gm.addVersionView3(cName,rvNum);
			this.setVisible(false);//��� ����ص���!!
			
			for(int i=0;i<cNum;i++){
				String name = cNameFields[i].getText();
				int num = Integer.parseInt(rvnFields[i].getText());
				MainSystem.pm.reqCreateCategory(name, num);
			
			}
			
		}else if(e.getSource() == prevBtn){
			this.dispose();
			MainSystem.gm.addVersionFrame1.setVisible(true);
		}
		
	}

}