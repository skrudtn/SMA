package Control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Model.Project;

public class NetworkManager {
	private Socket socket;
	private String name = "";
	

	public boolean reqLogin(int id){
		try {
			this.socket = new Socket("127.0.0.1",7777);
			
			DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());
			DataInputStream in = new DataInputStream(this.socket.getInputStream());
			
			out.writeInt(id);
			
			int check = in.readInt();
			
			if(check == 0){
				System.out.println("로그인 실패입니다.");
				return false;
			}
			
			System.out.println("로그인 성공입니다.");
			new ReceiveThreadInNetworkManager( this.socket, id ).start();
			return true;
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void sendProject(Object project){
		try {
			ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
			out.writeObject(project);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendFeedback(String feedback){
		try {
			System.out.println("센센센");
			DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());
			out.writeUTF(feedback);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ReceiveThreadInNetworkManager extends Thread{
		
		private Socket rtSocket;
		private int clientId = 0;
		private MainSystem rtms;
		
		public ReceiveThreadInNetworkManager(Socket socket,int id) {//硫붿씤 �떆�뒪�뀥 媛앹껜 諛쏆븘�빞�맖.
			this.rtSocket = socket;
			this.clientId = id;
		}
		
		@Override
		public void run() {
				try {
					while(true){
						if(clientId == 0){
							DataInputStream in = new DataInputStream(this.rtSocket.getInputStream());
							String feedback = in.readUTF();
							// 메인 시스템에서 피드백 처리
							MainSystem.reqSetFeedback(feedback);
						}
						
						if(clientId == 1){//硫ㅻ쾭 
							ObjectInputStream in = new ObjectInputStream(this.rtSocket.getInputStream());
							Object project = in.readObject();
							// 메인 시스템에서 프로젝트 처리
							MainSystem.reqReceivedProject((Project)project);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
