package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Control.MainSystem;
import Model.Project;

public class FileChooser{
	
    JFrame frm = new JFrame();
    private JFileChooser fileChooser = new JFileChooser();              
    
	public FileChooser(int flag)//flag 0이면 오픈 1이면 저장
    {
		
		fileChooser.setFileFilter(new FileNameExtensionFilter(".dat", ".dat"));
		
		if(flag == 0){//open
			int returnVal = fileChooser.showOpenDialog(frm);
	        if( returnVal == JFileChooser.APPROVE_OPTION)
	        {
	        	FileInputStream fis;
				try {
					fis = new FileInputStream(fileChooser.getSelectedFile().toString());
					ObjectInputStream ois = new ObjectInputStream(fis);
					
					Project project = (Project)ois.readObject();
					MainSystem.pm.setProject(project);
					
					MainSystem.gm.leaderMain.resetProjectPanel();
					for(int i=0;i<project.getVersionListSize();i++){
						MainSystem.gm.addVerisonPanel(i+1, 0);
					}
					MainSystem.gm.leaderMainRepaint();
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	            File file = fileChooser.getSelectedFile();
	        }
	        else
	        {
	            System.out.println("취소합니다");
	        }
		}else if(flag == 1){//save
			int returnVal = fileChooser.showSaveDialog(frm);
	        if( returnVal == JFileChooser.APPROVE_OPTION)
	        {
	            //File file = fileChooser.getSelectedFile();
	        	Project project = MainSystem.pm.getProject();
	        	
	        	
	        	try {
					FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile().toString()+fileChooser.getFileFilter().getDescription() );
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(project);
					oos.close();
	        	} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else
	        {
	            System.out.println("취소합니다");
	        }
		}
		
    }

    
}